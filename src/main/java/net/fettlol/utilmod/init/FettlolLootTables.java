package net.fettlol.utilmod.init;

import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.lib.helper.LootTableHelper;
import net.fettlol.lib.registry.LootApi;
import net.fettlol.utilmod.concerns.PlayerPlacedLootCondition;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.CopyNbtLootFunction;
import net.minecraft.loot.provider.nbt.ContextLootNbtProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.fettlol.utilmod.mixin.spawners.MobSpawnerBlockEntityMixin;
import net.fettlol.utilmod.mixin.spawners.SpawnerBlockMixin;

/**
 * Initialize global loot tables by adding Vanilla Minecraft items and Fettlol items to them.
 *
 * Note: Any third party mod added to a loot table must be added by its corresponding file in net.fettlol.integration.
 *
 * @see LootTableHelper for loot table helper methods.
 */
public class FettlolLootTables {

    public static void init() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
            // customSpawnerBlockHandling(identifier, setter);
            updateOreLootTables(identifier, supplier);
            updateChestLootTables(identifier, supplier);
            updateMobLootTables(identifier, supplier);
        });
    }

    /**
     * Updates the loot tables of mined ores. These are always affected by the Fortune enchant and require the
     * block to be broken with an item identified as a pickaxe. Unless otherwise stated, these changes apply to
     * all types of this ore, for example Diamond Ore, Deepslate Diamond Ore and the modded "Dense" versions of
     * each of the two.
     *
     * Changes made:
     *
     * - Diamond Ore: Add Soul Shards (2 separate 3% rolls).
     * - Lapis Lazuli Ore: Add Aquamarine Gem (6%).
     */
    private static void updateOreLootTables(Identifier identifier, FabricLootSupplierBuilder supplier) {
        if (LootTableHelper.isLapisOre(identifier)) {
            LootApi.addToOreLootTable(supplier, 1, 0.06F, "fettlol:aquamarine_gem");
        }

        if (LootTableHelper.isDiamondOre(identifier)) {
            LootApi.addToOreLootTable(supplier, 2, 0.03F, "fettlol:soul_shard");
        }
    }

    /**
     * Updates the loot tables of killed mobs. These are sometimes affected by Fortune.
     *
     * @todo Figure out how to add drops to a loot table that requires a player kill to drop.
     *
     * Changes made:
     *
     * - Drowned: Add Clay (2 separate 10% rolls). Affected by Looting.
     * - Ender Dragon: Add Aquamarine Gem (4 separate 50% rolls each).
     * - Ender Dragon: Add Dragon Egg (100%).
     * - Ender Dragon: Add Elytra (100%).
     * - Ender Dragon: Add Jade Gem (4 separate 50% rolls each).
     * - Endermen: Add Soul Shards (2%). Affected by Looting.
     * - Evoker: Add Jade Gem (25%).
     * - Guardians: Add Lapis Lazuli (2 separate 6% rolls). Affected by Looting.
     * - Hostile Underwater Mobs: Add Aquamarine Gem (3%). Affected by Looting.
     * - Husk: Add Sand (2 separate 10% rolls). Affected by Looting.
     * - Phantoms: Add Soul Shards (5%). Affected by Looting.
     * - Shulkers: Add Jade Gem (3%).
     * - Shulkers: Add Shulker shell (100%).
     * - Stray: Add Blue Ice (2 separate 10% rolls). Affected by Looting.
     * - Witch: Add Jade Gem (10%).
     * - Wither Skeleton: Add Wither bones (3 separate 10% rolls). Affected by Looting.
     * - Zombies: Add Gravel (2 separate 10% rolls). Affected by Looting.
     */
    private static void updateMobLootTables(Identifier identifier, FabricLootSupplierBuilder supplier) {
        if (LootTableHelper.isEnderman(identifier)) {
            LootApi.addToMobLootTable(supplier, 1, 0.02F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isPhantom(identifier)) {
            LootApi.addToMobLootTable(supplier, 1, 0.05F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isShulker(identifier)) {
            LootApi.addToLootTable(supplier, 1, 1, "minecraft:shulker_shell");
            LootApi.addToLootTable(supplier, 1, 0.02F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isEnderDragon(identifier)) {
            LootApi.addToLootTable(supplier, 4, 0.5F, "fettlol:jade_gem");
            LootApi.addToLootTable(supplier, 4, 0.5F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(supplier, 1, 1, "minecraft:elytra");
            LootApi.addToLootTable(supplier, 1, 1, "minecraft:dragon_egg");
        }

        if (LootTableHelper.isDrowned(identifier)) {
            LootApi.addToMobLootTable(supplier, 2, 0.10F, "minecraft:clay");
        }

        if (LootTableHelper.isHusk(identifier)) {
            LootApi.addToMobLootTable(supplier, 2, 0.10F, "minecraft:sand");
        }

        if (LootTableHelper.isStray(identifier)) {
            LootApi.addToMobLootTable(supplier, 2, 0.10F, "minecraft:blue_ice");
        }

        if (LootTableHelper.isZombie(identifier)) {
            LootApi.addToMobLootTable(supplier, 2, 0.10F, "minecraft:gravel");
        }

        if (LootTableHelper.isGuardian(identifier)) {
            LootApi.addToMobLootTable(supplier, 2, 0.06F, "minecraft:lapis_lazuli");
        }

        if (LootTableHelper.isWitherSkeleton(identifier)) {
            LootApi.addToMobLootTable(supplier, 3, 0.1F, "fettlol:wither_bone");
        }

        if (LootTableHelper.isHostileWaterMob(identifier)) {
            LootApi.addToMobLootTable(supplier, 1, 0.03F, "fettlol:aquamarine_gem");
        }

        if (LootTableHelper.isWitch(identifier)) {
            LootApi.addToLootTable(supplier, 1, 0.1F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isEvoker(identifier)) {
            LootApi.addToLootTable(supplier, 1, 0.25F, "fettlol:jade_gem");
        }
    }

    /**
     * Updates the loot table of various chests found around the world.
     *
     * Changes made:
     *
     * - Abandoned Mineshafts: Add Aquamarine Gem (4%).
     * - Abandoned Mineshafts: Add Jade Gem (4%).
     * - Abandoned Mineshafts: Add Soul Shard (2 separate 3% rolls).
     * - Buried Treasure: Add Aquamarine Gem (2 separate 4% rolls).
     * - Buried Treasure: Add Jade Gem (2 separate 4% rolls).
     * - Desert Pyramids: Add Jade Gem (2 separate 3% rolls).
     * - Desert Pyramids: Add Soul Shard (2 separate 3% rolls).
     * - Dungeon Chests: Add Aquamarine Gem (8%).
     * - Dungeon Chests: Add Jade Gem (8%).
     * - Dungeon Chests: Add Soul Shard (3 separate 5% rolls).
     * - End Endgame: Add Peacekeeper (4%). Includes randomly picked enchantment(s).
     * - Fishing Treasure: Add Aquamarine Gem and Jade Gem (5%).
     * - Graveyard Chests: Add Aquamarine Gem (4%).
     * - Graveyard Chests: Add Jade Gem (4%).
     * - Graveyard Chests: Add Soul Shard (3 separate 8% rolls).
     * - Mansions: Add Jade Gen (2 separate 5% rolls).
     * - Mansions: Add Soul Shard (2 separate 5% rolls).
     * - Nether Endgame: Add Knightfall (3%). Includes randomly picked enchantment(s).
     * - Nether Temples: Add Knightfall (2%). Includes randomly picked enchantment(s).
     * - Shipwreck Treasure: Add Jade Gem (2 separate 6% rolls).
     * - Shipwreck Treasure: Add Soul Shard (2 separate 6% rolls).
     * - Stronghold Chests: Add Aquamarine Gem (2 separate 6% rolls).
     * - Stronghold Chests: Add Jade Gem (2 separate 6% rolls).
     * - Stronghold Chests: Add Soul Shard (3 separate 12% rolls).
     */
    private static void updateChestLootTables(Identifier identifier, FabricLootSupplierBuilder supplier) {
        if (LootTableHelper.isNetherEndgameChest(identifier)) {
            LootApi.addToLootTableWithRandomEnchantment(supplier, 1, 0.03F, "fettlol:knightfall");
        }

        if (LootTableHelper.isNetherTempleChest(identifier)) {
            LootApi.addToLootTableWithRandomEnchantment(supplier, 1, 0.02F, "fettlol:knightfall");
        }

        if (LootTableHelper.isEndEndgameChest(identifier)) {
            LootApi.addToLootTableWithRandomEnchantment(supplier, 1, 0.04F, "fettlol:peacekeeper");
        }

        if (LootTableHelper.isGraveyardLootChest(identifier)) {
            LootApi.addToLootTable(supplier, 1, 0.04F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(supplier, 1, 0.04F, "fettlol:jade_gem");
            LootApi.addToLootTable(supplier, 3, 0.08F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isDesertPyramid(identifier)) {
            LootApi.addToLootTable(supplier, 2, 0.03F, "fettlol:soul_shard");
            LootApi.addToLootTable(supplier, 2, 0.03F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isShipwreckTreasure(identifier)) {
            LootApi.addToLootTable(supplier, 2, 0.06F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(supplier, 2, 0.06F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isMansionChest(identifier)) {
            LootApi.addToLootTable(supplier, 2, 0.05F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(supplier, 2, 0.05F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isFishingTreasure(identifier)) {
            LootApi.addToLootTable(supplier, 1, 0.05F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(supplier, 1, 0.05F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isAbandonedMineshaftChest(identifier)) {
            LootApi.addToLootTable(supplier, 1, 0.04F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(supplier, 1, 0.04F, "fettlol:jade_gem");
            LootApi.addToLootTable(supplier, 2, 0.03F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isSimpleDungeonChest(identifier)) {
            LootApi.addToLootTable(supplier, 1, 0.08F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(supplier, 1, 0.08F, "fettlol:jade_gem");
            LootApi.addToLootTable(supplier, 3, 0.05F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isBuriedTreasureChest(identifier)) {
            LootApi.addToLootTable(supplier, 2, 0.04F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(supplier, 2, 0.04F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isStrongholdChest(identifier)) {
            LootApi.addToLootTable(supplier, 3, 0.12F, "fettlol:soul_shard");
            LootApi.addToLootTable(supplier, 2, 0.06F, "fettlol:jade_gem");
            LootApi.addToLootTable(supplier, 2, 0.06F, "fettlol:aquamarine_gem");
        }
    }

    /**
     * Spawners placed by players should drop themselves when broken, but spawners placed by mods and as part of
     * world generation should not. This requires some tricky handling, but is quite straight-forward in the end.
     *
     * @see SpawnerBlockMixin
     * @see MobSpawnerBlockEntityMixin
     */
    private static void customSpawnerBlockHandling(Identifier identifier, LootTableLoadingCallback.LootTableSetter setter) {
        if (LootTableHelper.isSpawner(identifier)) {
            setter.set(LootTable.builder().pool(
                LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(PlayerPlacedLootCondition::new)
                    .with(ItemEntry.builder(Items.SPAWNER)
                        .apply(CopyNbtLootFunction.builder(ContextLootNbtProvider.BLOCK_ENTITY)
                            .withOperation("SpawnPotentials", "SpawnPotentials")
                            .withOperation("SpawnData", "SpawnData")
                            .withOperation("IsPlayerPlaced", "IsPlayerPlaced")
                        )
                    )
                ).build()
            );
        }

    }
}
