package net.fettlol_util.base.Handler;

import com.electronwill.nightconfig.toml.TomlFormat;
import com.moandjiezana.toml.Toml;
import net.fettlol_util.UtilMod;
import net.fettlol_util.base.Interface.Config;
import net.fettlol_util.base.UtilModule;
import com.electronwill.nightconfig.core.CommentedConfig;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ConfigHandler {
    public static void createConfig(String mod, Map<String, UtilModule> modules) {
        String configName = mod.equals(UtilMod.MOD_ID) ? UtilMod.MOD_ID : UtilMod.MOD_ID + "-" + mod;
        String configPath = "./config/" + configName + ".toml";

        CommentedConfig writeConfig = TomlFormat.newConfig(LinkedHashMap::new);
        Path path = Paths.get(configPath);
        File file = path.toFile();
        Toml readConfig = file.exists() ? new Toml().read(path.toFile()) : new Toml();

        List<String> moduleNames = new ArrayList<>(modules.keySet());
        Collections.sort(moduleNames);

        for (String moduleName : moduleNames) {
            UtilModule module = modules.get(moduleName);

            String moduleEnabled = moduleName + " Enabled";
            String moduleEnabledQuoted = "\"" + moduleEnabled + "\"";
            module.enabled = readConfig.contains(moduleEnabledQuoted) ? readConfig.getBoolean(moduleEnabledQuoted) : module.enabledByDefault;

            if (!module.alwaysEnabled) {
                writeConfig.setComment(moduleEnabled, module.description);
                writeConfig.add(moduleEnabled, module.enabled);
            }

            ArrayList<Field> classFields = new ArrayList<>(Arrays.asList(module.getClass().getDeclaredFields()));

            classFields.forEach(classField -> {
                try {
                    Config annotation = classField.getDeclaredAnnotation(Config.class);
                    if (annotation == null) {
                        return;
                    }

                    classField.setAccessible(true);
                    String name = annotation.name();
                    String description = annotation.description();

                    if (name.isEmpty()) {
                        name = classField.getName();
                    }

                    Object classValue = classField.get(null);
                    Object configValue = null;

                    if (readConfig.contains(moduleName)) {
                        Toml moduleKeys = readConfig.getTable(moduleName);
                        Map<String, Object> mappedKeys = new HashMap<>();

                        moduleKeys.toMap().forEach((key, value) -> mappedKeys.put(key.replace("\"", ""), value));
                        configValue = mappedKeys.get(name);

                        if (configValue != null) {
                            if (classValue instanceof Integer && configValue instanceof Double) {
                                configValue = (int)(double) configValue;
                            }

                            if (classValue instanceof Integer && configValue instanceof Long) {
                                configValue = (int)(long) configValue;
                            }

                            classField.set(null, configValue);
                        }
                    }

                    if (configValue == null) {
                        configValue = classValue;
                    }

                    String moduleConfigName = moduleName + "." + name;

                    writeConfig.setComment(moduleConfigName, description);
                    writeConfig.add(moduleConfigName, configValue);
                } catch (Exception e) {
                    UtilMod.LOG.error("Failed to set configuration for " + moduleName + ": " + e.getMessage());
                }
            });
        }
    }
}
