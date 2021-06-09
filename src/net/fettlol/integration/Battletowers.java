package net.fettlol.integration;

import net.fettlol.UtilMod;
import net.fettlol.init.ModIntegrations;
import net.fettlol.util.LootTableHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;

public class Battletowers {

    public static void init() {
        if (ModIntegrations.isBattletowersLoaded) {
            UtilMod.LOGGER.info("Draylar's Battle Towers detected! Applying integrations.");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // Add some additional treasures to Battletower Chests
                if (LootTableHelper.isTowerChest(identifier)) {
                    if (ModIntegrations.isBetterEndLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.02F, ModIntegrations.BETTER_END, "aeternium_ingot");
                        LootTableHelper.addToLootTable(supplier, 5, 0.02F, ModIntegrations.BETTER_END, "ender_dust");
                    }

                    if (ModIntegrations.isDankStorageLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.05F, ModIntegrations.DANKSTORAGE, "dank_3");
                    }

                    if (ModIntegrations.isMidasHungerLoaded) {
                        LootTableHelper.addToLootTable(supplier, 8, 0.03F, ModIntegrations.MIDAS_HUNGER, "baked_golden_potato");
                        LootTableHelper.addToLootTable(supplier, 8, 0.03F, ModIntegrations.MIDAS_HUNGER, "cooked_golden_beef");
                        LootTableHelper.addToLootTable(supplier, 8, 0.03F, ModIntegrations.MIDAS_HUNGER, "cooked_golden_mutton");
                        LootTableHelper.addToLootTable(supplier, 8, 0.03F, ModIntegrations.MIDAS_HUNGER, "cooked_golden_porkchop");
                        LootTableHelper.addToLootTable(supplier, 8, 0.03F, ModIntegrations.MIDAS_HUNGER, "cooked_golden_rabbit");
                    }

                    if (ModIntegrations.isBygLoaded) {
                        LootTableHelper.addToLootTable(supplier, 2, 0.05F, ModIntegrations.BYG, "pendorite_scraps");
                        LootTableHelper.addToLootTable(supplier, 2, 0.05F, ModIntegrations.BYG, "ametrine_gems");
                    }

                    if (ModIntegrations.isRingOfAttractionLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.03F, ModIntegrations.RING_OF_ATTRACTION, "ring_of_attraction");
                    }

                    if (ModIntegrations.isWingedLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.02F, ModIntegrations.WINGED, "wing_random");
                    }
                }
            });
        }
    }

}
