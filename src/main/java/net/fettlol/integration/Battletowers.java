package net.fettlol.integration;

import net.fettlol.UtilMod;
import net.fettlol.init.FettlolModIntegrations;
import net.fettlol.lists.Mods;
import net.fettlol.util.LootTableHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;

public class Battletowers {

    public static void init() {
        if (FettlolModIntegrations.isBattletowersLoaded) {
            UtilMod.LOGGER.info("Draylar's Battle Towers detected! Applying integrations.");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // Add some additional treasures to Battletower Chests
                if (LootTableHelper.isTowerChest(identifier)) {
                    if (FettlolModIntegrations.isBetterEndLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.02F, Mods.BETTER_END, "aeternium_ingot");
                        LootTableHelper.addToLootTable(supplier, 5, 0.02F, Mods.BETTER_END, "ender_dust");
                    }

                    if (FettlolModIntegrations.isDankStorageLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.05F, Mods.DANKSTORAGE, "dank_3");
                    }

                    if (FettlolModIntegrations.isMidasHungerLoaded) {
                        LootTableHelper.addToLootTable(supplier, 8, 0.02F, Mods.MIDAS_HUNGER, "baked_golden_potato");
                        LootTableHelper.addToLootTable(supplier, 8, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_beef");
                        LootTableHelper.addToLootTable(supplier, 8, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_mutton");
                        LootTableHelper.addToLootTable(supplier, 8, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_porkchop");
                        LootTableHelper.addToLootTable(supplier, 8, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_rabbit");
                    }

                    if (FettlolModIntegrations.isBygLoaded) {
                        LootTableHelper.addToLootTable(supplier, 2, 0.05F, Mods.BYG, "pendorite_scraps");
                        LootTableHelper.addToLootTable(supplier, 2, 0.05F, Mods.BYG, "ametrine_gems");
                    }

                    if (FettlolModIntegrations.isRingOfAttractionLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.03F, Mods.RING_OF_ATTRACTION, "ring_of_attraction");
                    }

                    if (FettlolModIntegrations.isWingedLoaded) {
                        // Low chance of finding a random wing in Battle Towers.
                        LootTableHelper.addToLootTable(supplier, 1, 0.01F, Mods.WINGED, "wing_random");

                        // 3% Chance of finding a broken core
                        LootTableHelper.addToLootTable(supplier, 1, 0.03F, Mods.WINGED, "broken_core_of_flight_50");

                        // 8% Chance of finding Shards of Zephyr
                        LootTableHelper.addToLootTable(supplier, 1, 0.08F, Mods.WINGED, "shard_of_zephyr");
                    }
                }
            });
        }
    }

}
