package net.fettlol.util;

import net.fabricmc.loader.api.FabricLoader;

/**
 * This file contains various minor helper methods relevant to the game
 * environment.
 */
public class EnvironmentHelper {

    public static boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
