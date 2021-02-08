package net.brekitomasson.fettlol.integration;

import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.init.ModIntegrations;
import net.brekitomasson.fettlol.util.LootTableHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;

public class RingOfAttraction {

    public static void init() {
        if (ModIntegrations.isRingOfAttractionLoaded) {
            UtilMod.LOGGER.info("Ring of Attraction detected! Modifying loot tables.");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // The Ring of Attraction has a tiny chance to appear in End City chests.
                if (LootTableHelper.isEndEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.01F, ModIntegrations.RING_OF_ATTRACTION, "ring_of_attraction");
                }
            });

        } else {
            UtilMod.LOGGER.info("Ring of Attraction not detected! Not adding mod interactions.");
        }
    }

}
