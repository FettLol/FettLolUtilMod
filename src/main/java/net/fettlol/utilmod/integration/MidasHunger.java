package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.LootTableHelper;

public class MidasHunger {
    public static void init() {
        if (FettlolModIntegrations.isMidasHungerLoaded) {
            LogHelper.log("Midas Hunger detected! Applying integrations!");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

                // Golden food can appear in villager houses, but rarely.
                if (LootTableHelper.isVillageHouseChest(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 2, 0.01F, Mods.MIDAS_HUNGER, "baked_golden_potato");
                    LootTableHelper.addToLootTable(supplier, 2, 0.01F, Mods.MIDAS_HUNGER, "cooked_golden_beef");
                    LootTableHelper.addToLootTable(supplier, 2, 0.01F, Mods.MIDAS_HUNGER, "cooked_golden_mutton");
                    LootTableHelper.addToLootTable(supplier, 2, 0.01F, Mods.MIDAS_HUNGER, "cooked_golden_porkchop");
                    LootTableHelper.addToLootTable(supplier, 2, 0.01F, Mods.MIDAS_HUNGER, "cooked_golden_rabbit");
                }

                // Underwater ruins have a chance of containing "Golden" food relevant to underwater areas.
                if (LootTableHelper.isUnderwaterRuin(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.05F, Mods.MIDAS_HUNGER, "dried_golden_kelp");
                    LootTableHelper.addToLootTable(supplier, 1, 0.05F, Mods.MIDAS_HUNGER, "golden_turtle_egg");
                }

                // Buried treasure often contains Cooked Golden Cod.
                if (LootTableHelper.isBuriedTreasure(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 3, 0.2F, Mods.MIDAS_HUNGER, "cooked_golden_cod");
                }

                // Cooked Cod can also show up in shipwreck treasure chests.
                if (LootTableHelper.isShipwreckTreasure(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 5, 0.1F, Mods.MIDAS_HUNGER, "cooked_golden_cod");
                }

                // Nether chests can contain the Golden Beetroot.
                if (LootTableHelper.isNetherEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 5, 0.05F, Mods.MIDAS_HUNGER, "golden_beetroot");
                }
            });
        }
    }
}
