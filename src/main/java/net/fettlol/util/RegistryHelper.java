package net.fettlol.util;

import net.fettlol.UtilMod;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Locale;
import java.util.Optional;

import static net.fettlol.UtilMod.LOGGER;

public class RegistryHelper {

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
                    T value = (T)field.get(from);
                    String registryName = field.getName().toLowerCase(Locale.ENGLISH);
                    Identifier id = RegistryHelper.makeId(registryName);

                    Registry.register(registry, id, value);

                    for (RegistryCallBack<T> registryCallback : callbacks) {
                        registryCallback.callback(registry, value, id);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static Identifier makeId(String name) {
        return new Identifier(UtilMod.MOD_ID, name);
    }

    public static void makeCompostable(Item item, float value) {
        CompostingChanceRegistry.INSTANCE.add(item, value);
    }

    public static void makeCompostable(Identifier identifier, float value) {
        Optional<Item> maybeItem = Registry.ITEM.getOrEmpty(identifier);
        if (!maybeItem.isPresent()) {
            LOGGER.warn("couldn't make {} compostable", identifier);
        } else {
            makeCompostable(maybeItem.get(), value);
        }
    }

    public static void makeCompostable(String namespace, String itemName, float value) {
        makeCompostable(new Identifier(namespace, itemName), value);
    }

    public interface RegistryCallBack<T> {
        void callback(Registry<T> registry, T registryObject, Identifier identifier);
    }

    private RegistryHelper() {}

}
