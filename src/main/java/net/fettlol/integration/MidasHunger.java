package net.fettlol.integration;

import net.fettlol.UtilMod;
import net.fettlol.init.ModIntegrations;
import net.fettlol.util.LootTableHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;

public class MidasHunger {
    public static void init() {
        if (ModIntegrations.isMidasHungerLoaded) {
            UtilMod.LOGGER.info("Midas Hunger detected! Applying integrations!");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

                // Golden food can appear in villager houses, but rarely.
                if (LootTableHelper.isVillageHouseChest(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 2, 0.01F, ModIntegrations.MIDAS_HUNGER, "baked_golden_potato");
                    LootTableHelper.addToLootTable(supplier, 2, 0.01F, ModIntegrations.MIDAS_HUNGER, "cooked_golden_beef");
                    LootTableHelper.addToLootTable(supplier, 2, 0.01F, ModIntegrations.MIDAS_HUNGER, "cooked_golden_mutton");
                    LootTableHelper.addToLootTable(supplier, 2, 0.01F, ModIntegrations.MIDAS_HUNGER, "cooked_golden_porkchop");
                    LootTableHelper.addToLootTable(supplier, 2, 0.01F, ModIntegrations.MIDAS_HUNGER, "cooked_golden_rabbit");
                }

                // Underwater ruins have a chance of containing "Golden" food relevant to underwater areas.
                if (LootTableHelper.isUnderwaterRuin(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.05F, ModIntegrations.MIDAS_HUNGER, "dried_golden_kelp");
                    LootTableHelper.addToLootTable(supplier, 1, 0.05F, ModIntegrations.MIDAS_HUNGER, "golden_turtle_egg");
                }

                // Buried treasure often contains Cooked Golden Cod.
                if (LootTableHelper.isBuriedTreasure(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 3, 0.2F, ModIntegrations.MIDAS_HUNGER, "cooked_golden_cod");
                }

                // Cooked Cod can also show up in shipwreck treasure chests.
                if (LootTableHelper.isShipwreckTreasure(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 5, 0.1F, ModIntegrations.MIDAS_HUNGER, "cooked_golden_cod");
                }

                // Nether chests can contain the Golden Beetroot.
                if (LootTableHelper.isNetherEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 5, 0.05F, ModIntegrations.MIDAS_HUNGER, "golden_beetroot");
                }

                // cooked_golden_chicken    - slow falling              - villager butcher chests?
                // sweet_golden_berries     - speed                     - add to berry loot tables?

            });
        }
    }
}
