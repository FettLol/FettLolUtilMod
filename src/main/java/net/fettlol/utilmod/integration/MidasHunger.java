package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.lib.helper.LootTableHelper;
import net.fettlol.lib.registry.LootApi;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;

public class MidasHunger {
    public static void init() {
        if (FettlolModIntegrations.isMidasHungerLoaded) {
            LogHelper.log("Midas Hunger detected! Applying integrations!");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

                // Golden food can appear in villager houses, but rarely.
                if (LootTableHelper.isVillageHouseChest(identifier)) {
                    LootApi.addToLootTable(supplier, 2, 0.01F, Mods.MIDAS_HUNGER, "baked_golden_potato");
                    LootApi.addToLootTable(supplier, 2, 0.01F, Mods.MIDAS_HUNGER, "cooked_golden_beef");
                    LootApi.addToLootTable(supplier, 2, 0.01F, Mods.MIDAS_HUNGER, "cooked_golden_mutton");
                    LootApi.addToLootTable(supplier, 2, 0.01F, Mods.MIDAS_HUNGER, "cooked_golden_porkchop");
                    LootApi.addToLootTable(supplier, 2, 0.01F, Mods.MIDAS_HUNGER, "cooked_golden_rabbit");
                }

                // Underwater ruins have a chance of containing "Golden" food relevant to underwater areas.
                if (LootTableHelper.isUnderwaterRuinChest(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.05F, Mods.MIDAS_HUNGER, "dried_golden_kelp");
                    LootApi.addToLootTable(supplier, 1, 0.05F, Mods.MIDAS_HUNGER, "golden_turtle_egg");
                }

                // Buried treasure often contains Cooked Golden Cod.
                if (LootTableHelper.isBuriedTreasureChest(identifier)) {
                    LootApi.addToLootTable(supplier, 3, 0.2F, Mods.MIDAS_HUNGER, "cooked_golden_cod");
                }

                // Cooked Cod can also show up in shipwreck treasure chests.
                if (LootTableHelper.isShipwreckTreasure(identifier)) {
                    LootApi.addToLootTable(supplier, 5, 0.1F, Mods.MIDAS_HUNGER, "cooked_golden_cod");
                }

                // Nether chests can contain the Golden Beetroot.
                if (LootTableHelper.isNetherEndgameChest(identifier)) {
                    LootApi.addToLootTable(supplier, 5, 0.05F, Mods.MIDAS_HUNGER, "golden_beetroot");
                }
            });
        }
    }
}
