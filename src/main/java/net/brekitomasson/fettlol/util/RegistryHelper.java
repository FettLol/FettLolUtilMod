package net.brekitomasson.fettlol.util;

import net.brekitomasson.fettlol.UtilMod;
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

    public interface RegistryCallBack<T> {
        void callback(Registry<T> registry, T registryObject, Identifier identifier);
    }

    private RegistryHelper() {}

}
