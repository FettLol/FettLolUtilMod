package net.fettlol.util;

import net.fettlol.UtilMod;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Locale;

public class RegistryHelper {

    @SafeVarargs
    public static <T> void register(Registry<T> registry, Class typeClass, Class from, RegistryCallBack<T>... callbacks) {
        try {
            Field[] fields = from.getDeclaredFields();

            for (Field field : fields) {
                if (
                    typeClass.isAssignableFrom(field.getType())
                        && Modifier.isStatic(field.getModifiers())
                        && Modifier.isFinal(field.getModifiers())
                ) {
                    T value = (T)field.get(from);
                    String registryName = field.getName().toLowerCase(Locale.ENGLISH);
                    Identifier id = RegistryHelper.makeId(registryName);

                    Registry.register(registry, id, value);

                    for (RegistryCallBack<T> registryCallback : callbacks) {
                        registryCallback.callback(registry, value, id);
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static Identifier makeId(String name) {
        return new Identifier(UtilMod.MOD_ID, name);
    }

    public static void makeCompostable(Item item, float value) {
        CompostingChanceRegistry.INSTANCE.add(item, value);
    }

    public static void makeCompostable(Identifier identifier, float value) {
        makeCompostable(Registry.ITEM.getOrEmpty(identifier).get(), value);
    }

    public static void makeCompostable(String namespace, String itemName, float value) {
        makeCompostable(Registry.ITEM.getOrEmpty(new Identifier(namespace, itemName)).get(), value);
    }

    public interface RegistryCallBack<T> {
        void callback(Registry<T> registry, T registryObject, Identifier identifier);
    }

    private RegistryHelper() {}

}
