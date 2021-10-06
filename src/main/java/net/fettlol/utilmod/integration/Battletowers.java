package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.LootTableHelper;

public class Battletowers {

    public static void init() {
        if (FettlolModIntegrations.isBattletowersLoaded) {
            LogHelper.log("Draylar's Battle Towers detected! Applying integrations.");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // Add some additional treasures to "default" Battletower Chests.
                // More specific chests defined below.
                if (LootTableHelper.isBattleTowerChest(identifier)) {
                    // Add items from Dank Storage.
                    if (FettlolModIntegrations.isDankStorageLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.05F, Mods.DANKSTORAGE, "dank_3");
                    }

                    // Add items from Midas Hunger.
                    if (FettlolModIntegrations.isMidasHungerLoaded) {
                        LootTableHelper.addToLootTable(supplier, 6, 0.02F, Mods.MIDAS_HUNGER, "baked_golden_potato");
                        LootTableHelper.addToLootTable(supplier, 6, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_beef");
                        LootTableHelper.addToLootTable(supplier, 6, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_mutton");
                        LootTableHelper.addToLootTable(supplier, 6, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_porkchop");
                        LootTableHelper.addToLootTable(supplier, 6, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_rabbit");
                    }

                    // Add items from BYG.
                    if (FettlolModIntegrations.isBygLoaded) {
                        LootTableHelper.addToLootTable(supplier, 2, 0.05F, Mods.BYG, "pendorite_scraps");
                        LootTableHelper.addToLootTable(supplier, 2, 0.05F, Mods.BYG, "ametrine_gems");
                    }

                    // Add items from Ring of Attraction.
                    if (FettlolModIntegrations.isRingOfAttractionLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.03F, Mods.RING_OF_ATTRACTION, "ring_of_attraction");
                    }

                    // Add items from Winged.
                    if (FettlolModIntegrations.isWingedLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.01F, Mods.WINGED, "wing_random");
                        LootTableHelper.addToLootTable(supplier, 1, 0.03F, Mods.WINGED, "broken_core_of_flight_50");
                        LootTableHelper.addToLootTable(supplier, 1, 0.08F, Mods.WINGED, "shard_of_zephyr");
                    }
                }

                // Only add to the "Lake" battletower chests.
                if (LootTableHelper.isLakeBattleTowerChest(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 3, 0.05F, "fettlol:aquamarine_gem");
                    LootTableHelper.addToLootTable(supplier, 3, 0.05F, "fettlol:jade_gem");
                }

                // Only add to the "Blacksmith" battletower chests.
                if (LootTableHelper.isBlacksmithBattleTowerChest(identifier)) {
                    // Add items from Better End.
                    if (FettlolModIntegrations.isBetterEndLoaded) {
                        LootTableHelper.addToLootTable(supplier, 1, 0.02F, Mods.BETTER_END, "aeternium_ingot");
                        LootTableHelper.addToLootTable(supplier, 5, 0.02F, Mods.BETTER_END, "ender_dust");
                    }
                }


            });
        }
    }

}
