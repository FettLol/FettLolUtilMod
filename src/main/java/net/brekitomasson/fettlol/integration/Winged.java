package net.brekitomasson.fettlol.integration;

import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.init.ModIntegrations;
import net.brekitomasson.fettlol.util.LootTableHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;

public class Winged {
    public static void init() {
        if (ModIntegrations.isWingedLoaded) {
            UtilMod.LOGGER.info("Winged detected! Modifying loot tables.");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

                // 2% Chance of finding a random set of Wings in End City chests
                if (LootTableHelper.isEndEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.02F, ModIntegrations.WINGED, "wing_random");
                }

            });

        } else {
            UtilMod.LOGGER.info("Winged not detected! Not adding mod interactions.");
        }
    }
}
