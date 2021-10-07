package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.lib.helper.LootTableHelper;
import net.fettlol.lib.registry.LootApi;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;

public class Battletowers {

    public static void init() {
        if (FettlolModIntegrations.isBattletowersLoaded) {
            LogHelper.log("Draylar's Battle Towers detected! Applying integrations.");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                if (LootTableHelper.isBattleTowerDefaultChest(identifier)) {
                    if (FettlolModIntegrations.isDankStorageLoaded) {
                        LootApi.addToLootTable(supplier, 1, 0.05F, Mods.DANKSTORAGE, "dank_3");
                    }

                    if (FettlolModIntegrations.isMidasHungerLoaded) {
                        LootApi.addToLootTable(supplier, 6, 0.02F, Mods.MIDAS_HUNGER, "baked_golden_potato");
                        LootApi.addToLootTable(supplier, 6, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_beef");
                        LootApi.addToLootTable(supplier, 6, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_mutton");
                        LootApi.addToLootTable(supplier, 6, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_porkchop");
                        LootApi.addToLootTable(supplier, 6, 0.02F, Mods.MIDAS_HUNGER, "cooked_golden_rabbit");
                    }

                    if (FettlolModIntegrations.isBygLoaded) {
                        LootApi.addToLootTable(supplier, 2, 0.05F, Mods.BYG, "pendorite_scraps");
                        LootApi.addToLootTable(supplier, 2, 0.05F, Mods.BYG, "ametrine_gems");
                    }

                    if (FettlolModIntegrations.isRingOfAttractionLoaded) {
                        LootApi.addToLootTable(supplier, 1, 0.03F, Mods.RING_OF_ATTRACTION, "ring_of_attraction");
                    }

                    if (FettlolModIntegrations.isWingedLoaded) {
                        LootApi.addToLootTable(supplier, 1, 0.01F, Mods.WINGED, "wing_random");
                        LootApi.addToLootTable(supplier, 1, 0.03F, Mods.WINGED, "broken_core_of_flight_50");
                        LootApi.addToLootTable(supplier, 1, 0.08F, Mods.WINGED, "shard_of_zephyr");
                    }
                }

                if (LootTableHelper.isBattleTowerLakeChest(identifier)) {
                    LootApi.addToLootTable(supplier, 3, 0.05F, "fettlol:aquamarine_gem");
                    LootApi.addToLootTable(supplier, 3, 0.05F, "fettlol:jade_gem");
                }

                if (LootTableHelper.isBattleTowerBlacksmithChest(identifier)) {
                    if (FettlolModIntegrations.isBetterEndLoaded) {
                        LootApi.addToLootTable(supplier, 1, 0.02F, Mods.BETTER_END, "aeternium_ingot");
                        LootApi.addToLootTable(supplier, 5, 0.02F, Mods.BETTER_END, "ender_dust");
                    }
                }


            });
        }
    }

}
