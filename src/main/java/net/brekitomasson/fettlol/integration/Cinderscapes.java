package net.brekitomasson.fettlol.integration;

import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.init.ModIntegrations;

public class Cinderscapes {
    public static void init() {
        if (ModIntegrations.isCinderscapesLoaded) {
            UtilMod.LOGGER.info("Cinderscapes detected! Modifying loot tables.");
        } else {
            UtilMod.LOGGER.info("Cinderscapes not detected! Not adding mod interactions.");
        }
    }
}
