package net.fettlol_util.base.Handler;

import net.fettlol_util.UtilMod;
import net.fettlol_util.base.Event.LoadWorldCallback;
import net.fettlol_util.base.Helper.StringHelper;
import net.fettlol_util.base.Interface.Module;
import net.fettlol_util.base.UtilModule;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Consumer;

public class ModuleHandler
{
    public static Map<String, UtilModule> LOADED_MODULES = new TreeMap<>();
    public static final Map<String, List<Class<? extends UtilModule>>> AVAILABLE_MODULES = new HashMap<>();
    private static final List<Class<? extends UtilModule>> ENABLED_MODULES = new ArrayList<>();

    private boolean hasInit = false;

    public static ModuleHandler INSTANCE = new ModuleHandler();

    private ModuleHandler() {
        // Nothing here right now, but reserved for possible future needs.
    }

    public void init() {
        if (hasInit) {
            return;
        }

        eachModule(module -> module.enabled = module.enabled && module.depends());

        // init() all enabled modules.
        eachEnabledModule(module -> {
            ENABLED_MODULES.add(module.getClass());
            module.init();
        });

        // World loading events, wherever needed.
        LoadWorldCallback.EVENT.register(server -> {
           eachEnabledModule(module -> module.loadWorld(server));
        });

        hasInit = true;
    }

    public void registerFabricMod(String modId, List<Class<? extends UtilModule>> modules) {
        AVAILABLE_MODULES.put(modId, modules);

        instantiateModules(modId);
    }

    @Nullable
    public static UtilModule getModule(String moduleName) {
        return LOADED_MODULES.getOrDefault(StringHelper.snakeToUpperCamel(moduleName), null);
    }

    public static Map<String, UtilModule> getLoadedModules() {
        return LOADED_MODULES;
    }

    public static boolean enabled(Class<? extends UtilModule> enabledModule) {
        return ENABLED_MODULES.contains(enabledModule);
    }

    public static boolean enabled(String moduleName) {
        String[] split = moduleName.split(":");
        String modName = split[0];
        String modModule = split[1];

        UtilModule module = getModule(modModule);

        return module != null && module.enabled;
    }

    private static void instantiateModules(String modId) {
        if (!AVAILABLE_MODULES.containsKey(modId)) {
            throw new RuntimeException("Could not load modules for " + modId + ".");
        }

        Map<String, UtilModule> loaded = new TreeMap<>();

        AVAILABLE_MODULES.get(modId).forEach(availableModule -> {
            try {
                UtilModule module = availableModule.getDeclaredConstructor().newInstance();

                if (availableModule.isAnnotationPresent(Module.class)) {
                    Module annotation = availableModule.getAnnotation(Module.class);

                    if (annotation.mod().isEmpty()) {
                        throw new Exception("Mod name must be defined!");
                    }

                    module.mod = annotation.mod();
                    module.alwaysEnabled = annotation.alwaysEnabled();
                    module.enabledByDefault = annotation.enabledByDefault();
                    module.enabled = module.enabledByDefault;
                    module.description = annotation.description();
                    module.client = annotation.client();

                    String moduleName = module.getName();

                    loaded.put(moduleName, module);
                } else {
                    throw new RuntimeException("No module annotation for " + availableModule.toString() + ".");
                }

            } catch (Exception e) {
                throw new RuntimeException("Could not initialize module: " + availableModule.toString() + ".", e);
            }
        });

        ConfigHandler.createConfig(modId, loaded);

        loaded.forEach((moduleName, module) -> {
            LOADED_MODULES.put(moduleName, module);
            UtilMod.LOG.info("Loaded module: " + moduleName + ". Enabled: " + (module.enabled ? "true" : "false"));
            module.register();
        });

    }

    private static void eachModule(Consumer<UtilModule> consumer) {
        LOADED_MODULES.values().forEach(consumer);
    }

    private static void eachEnabledModule(Consumer<UtilModule> consumer) {
        LOADED_MODULES.values().stream().filter(module -> module.enabled).forEach(consumer);
    }

}
