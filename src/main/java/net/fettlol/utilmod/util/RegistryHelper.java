package net.fettlol.utilmod.util;

import net.fettlol.utilmod.UtilMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Locale;

public class RegistryHelper {

    private RegistryHelper() {}

    @SafeVarargs
    @SuppressWarnings("unchecked")
    public static <T> void register(Registry<T> registry, Class<T> typeClass, Class<?> from, RegistryCallBack<T>... callbacks) {
        try {
            for (Field field : from.getDeclaredFields()) {
                if (
                    typeClass.isAssignableFrom(field.getType())
                        && Modifier.isStatic(field.getModifiers())
                        && Modifier.isFinal(field.getModifiers())
                ) {
                    T value = (T) field.get(from);
                    String registryName = field.getName().toLowerCase(Locale.ENGLISH);
                    Identifier id = RegistryHelper.fettlolId(registryName);

                    Registry.register(registry, id, value);

                    for (RegistryCallBack<T> registryCallback : callbacks) {
                        registryCallback.callback(registry, value, id);
                    }
                }
            }
        } catch (Exception e) {
            LogHelper.log("ERROR: " + e);
        }
    }

    // Return an Identifier for an item/entity/whatever in a given namespace.
    public static Identifier modId(String namespace, String name) {
        return new Identifier(namespace, name);
    }

    // Returns an Identifier in the "fettlol" namespace.
    public static Identifier fettlolId(String name) {
        return modId(UtilMod.MOD_ID, name);
    }


    public static Item getItemFromRegistry(String itemName) {
        return Registry.ITEM.get(new Identifier(itemName)).asItem();
    }

    public interface RegistryCallBack<T> {
        void callback(Registry<T> registry, T registryObject, Identifier identifier);
    }

}
