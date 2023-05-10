package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fettlol.utilmod.UtilMod;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.registry.LootApi;
import net.fettlol.utilmod.util.LootTableHelper;

public class MidasHunger {
    public static void init() {
        if (FettlolModIntegrations.isMidasHungerLoaded) {
            UtilMod.LOGGER.info("Midas Hunger detected! Applying integrations!");
            LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, tableBuilder, source) -> {

                // Golden food can appear in villager houses, but rarely.
                if (LootTableHelper.isVillageHouseChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 2, 0.01F, FettlolModIntegrations.MIDAS_HUNGER, "baked_golden_potato");
                    LootApi.addToLootTable(tableBuilder, 2, 0.01F, FettlolModIntegrations.MIDAS_HUNGER, "cooked_golden_beef");
                    LootApi.addToLootTable(tableBuilder, 2, 0.01F, FettlolModIntegrations.MIDAS_HUNGER, "cooked_golden_mutton");
                    LootApi.addToLootTable(tableBuilder, 2, 0.01F, FettlolModIntegrations.MIDAS_HUNGER, "cooked_golden_porkchop");
                    LootApi.addToLootTable(tableBuilder, 2, 0.01F, FettlolModIntegrations.MIDAS_HUNGER, "cooked_golden_rabbit");
                }

                // Underwater ruins have a chance of containing "Golden" food relevant to underwater areas.
                if (LootTableHelper.isUnderwaterRuinChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 1, 0.05F, FettlolModIntegrations.MIDAS_HUNGER, "dried_golden_kelp");
                    LootApi.addToLootTable(tableBuilder, 1, 0.05F, FettlolModIntegrations.MIDAS_HUNGER, "golden_turtle_egg");
                }

                // Buried treasure often contains Cooked Golden Cod.
                if (LootTableHelper.isBuriedTreasureChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 3, 0.2F, FettlolModIntegrations.MIDAS_HUNGER, "cooked_golden_cod");
                }

                // Cooked Cod can also show up in shipwreck treasure chests.
                if (LootTableHelper.isShipwreckTreasure(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 5, 0.1F, FettlolModIntegrations.MIDAS_HUNGER, "cooked_golden_cod");
                }

                // Nether chests can contain the Golden Beetroot.
                if (LootTableHelper.isNetherEndgameChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 5, 0.05F, FettlolModIntegrations.MIDAS_HUNGER, "golden_beetroot");
                }
            });
        }
    }
}
