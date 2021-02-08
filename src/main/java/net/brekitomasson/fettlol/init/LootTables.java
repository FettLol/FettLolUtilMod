package net.brekitomasson.fettlol.init;

import net.brekitomasson.fettlol.util.LootTableHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;

public class LootTables {

    // Note: More loot table manipulation is done in "module/ManageModInteractions.java"

    public static void init() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Add Knightfall to various Nether locations. (7%)
            if (LootTableHelper.isNetherEndgame(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.07F, "fettlol", "knightfall");
            }

            // Add Peacekeeper to various End locations. (8%)
            if (LootTableHelper.isEndEndgame(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.08F, "fettlol", "peacekeeper");
            }

            // Add Soul Shards to Diamond Ore (2 separate 3% rolls)
            if (LootTableHelper.isDiamondOre(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.03F, "fettlol", "soul_shard");
            }

            // Add Soul Shards to Stronghold chests (3 separate 2% rolls)
            if (LootTableHelper.isStronghold(identifier)) {
                LootTableHelper.addToLootTable(supplier, 3, 0.2F, "fettlol", "soul_shard");
            }

            // Shulkers have a guaranteed drop of at least one Shulker Shell in addition to what they drop randomly.
            if (LootTableHelper.isShulker(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 1, "minecraft", "shulker_shell");
            }

            // Ender Dragon has a guaranteed drop of one Dragon Egg and one Elytra.
            if (LootTableHelper.isEnderDragon(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 1, "minecraft", "elytra");
                LootTableHelper.addToLootTable(supplier, 1, 1, "minecraft", "dragon_egg");
            }

        });
    }
}
