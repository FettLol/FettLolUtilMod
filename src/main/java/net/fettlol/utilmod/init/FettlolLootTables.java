package net.fettlol.utilmod.init;

import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.utilmod.concerns.PlayerPlacedLootCondition;
import net.fettlol.utilmod.registry.LootApi;
import net.fettlol.utilmod.util.LootTableHelper;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.CopyNbtLootFunction;
import net.minecraft.loot.provider.nbt.ContextLootNbtProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class FettlolLootTables {

    public static void init() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
            // customSpawnerBlockHandling(identifier, setter);
            updateOreLootTables(identifier, supplier);
            updateChestLootTables(identifier, supplier);
            updateMobLootTables(identifier, supplier);
        });
    }

    private static void updateOreLootTables(Identifier identifier, FabricLootSupplierBuilder supplier) {
        if (LootTableHelper.isLapisOre(identifier)) {
            LootApi.addToOreLootTable(supplier, 1, 0.06F, "fettlol:aquamarine_gem");
        }

        if (LootTableHelper.isDiamondOre(identifier)) {
            LootApi.addToOreLootTable(supplier, 2, 0.03F, "fettlol:soul_shard");
        }
    }

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
            LootApi.addToMobLootTable(supplier, 2, 0.1F, "minecraft:clay");
        }

        if (LootTableHelper.isHusk(identifier)) {
            LootApi.addToMobLootTable(supplier, 2, 0.1F, "minecraft:sand");
        }

        if (LootTableHelper.isStray(identifier)) {
            LootApi.addToMobLootTable(supplier, 2, 0.1F, "minecraft:blue_ice");
        }

        if (LootTableHelper.isZombie(identifier)) {
            LootApi.addToMobLootTable(supplier, 2, 0.1F, "minecraft:gravel");
        }

        if (LootTableHelper.isGuardian(identifier)) {
            LootApi.addToMobLootTable(supplier, 2, 0.05F, "minecraft:lapis_lazuli");
        }

        if (LootTableHelper.isWitherSkeleton(identifier)) {
            LootApi.addToMobLootTable(supplier, 3, 0.1F, "fettlol:wither_bone");
            LootApi.addToMobLootTable(supplier,1, 0.05F, "fettlol:soul_shard");
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
