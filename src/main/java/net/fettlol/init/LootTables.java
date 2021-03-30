package net.fettlol.init;

import net.fettlol.util.LootTableHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;

/**
 * Far more modifications of the loot tables are performed as part of the integrations we set up with other mods.
 * More details on those integrations can be found in init/ModIntegrations.java.
 */
public class LootTables {

    public static void init() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Add Knightfall to various Nether locations. (3%)
            if (LootTableHelper.isNetherEndgame(identifier)) {
                LootTableHelper.addToLootTableWithRandomEnchantment(supplier, 1, 0.03F, "fettlol", "knightfall");
            }

            // Add Peacekeeper to various End locations. (4%)
            if (LootTableHelper.isEndEndgame(identifier)) {
                LootTableHelper.addToLootTableWithRandomEnchantment(supplier, 1, 0.04F, "fettlol", "peacekeeper");
            }

            // Add Aquamarine Gem to hostile underwater mobs (2%)
            if (LootTableHelper.isHostileWaterMob(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.02F, "fettlol", "aquamarine_gem");
            }

            // Add Aquamarine Gem and Jade Gem to shipwreck (2 separate 1% rolls each)
            if (LootTableHelper.isShipwreckTreasure(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.01F, "fettlol", "aquamarine_gem");
                LootTableHelper.addToLootTable(supplier, 2, 0.01F, "fettlol", "jade_gem");
            }

            // Add Aquamarine Gem and Jade Gem to buried treasure (2 separate 2% rolls each)
            if (LootTableHelper.isBuriedTreasure(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.02F, "fettlol", "aquamarine_gem");
                LootTableHelper.addToLootTable(supplier, 2, 0.02F, "fettlol", "jade_gem");
            }

            // Add Aquamarine Gem to Lapis Lazuli ore (2%)
            if (LootTableHelper.isLapisOre(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.02F, "fettlol", "aquamarine_gem");
            }

            // Add Soul Shards to Diamond Ore (2 separate 3% rolls)
            if (LootTableHelper.isDiamondOre(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.03F, "fettlol", "soul_shard");
            }

            // Add Soul Shards to Stronghold chests (3 separate 12% rolls)
            if (LootTableHelper.isStronghold(identifier)) {
                LootTableHelper.addToLootTable(supplier, 3, 0.12F, "fettlol", "soul_shard");
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

            // Drowned can drop Clay (2 separate 6% rolls)
            if (LootTableHelper.isDrowned(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.06F, "minecraft", "clay");
            }

            // Husk can drop Sand (2 separate 5% rolls)
            if (LootTableHelper.isHusk(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.05F, "minecraft", "sand");
            }

            // Stray can drop Blue Ice (2 separate 9% rolls)
            if (LootTableHelper.isStray(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.09F, "minecraft", "blue_ice");
            }

            // Zombies can drop Gravel (2 separate 8% rolls)
            if (LootTableHelper.isZombie(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.08F, "minecraft", "gravel");
            }

            // Guardians can drop Lapis Lazuli (2 separate 8% rolls)
            if (LootTableHelper.isGuardian(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.08F, "minecraft", "lapis_lazuli");
            }
        });
    }
}
