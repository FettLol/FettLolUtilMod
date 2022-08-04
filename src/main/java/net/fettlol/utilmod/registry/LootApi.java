package net.fettlol.utilmod.registry;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fettlol.utilmod.lists.LootConditions;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LootApi {

    public static void addToOreLootTable(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
            .withCondition(LootConditions.WITHOUT_SILK_TOUCH.build())
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));

        supplier.withPool(poolBuilder.build());
    }

    public static void addToOreLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToOreLootTable(supplier, count, probability, new Identifier(item));
    }

    public static void addToMobLootTable(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.LOOTING))
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));

        supplier.withPool(poolBuilder.build());
    }

    public static void addToMobLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToMobLootTable(supplier, count, probability, new Identifier(item));
    }

    public static void addToLootTable(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));

        supplier.withPool(poolBuilder.build());
    }

    public static void addToLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToLootTable(supplier, count, probability, new Identifier(item));
    }

    public static void addToLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String namespace, String item) {
        addToLootTable(supplier, count, probability, new Identifier(namespace, item));
    }

    public static void addToLootTableWithRandomEnchantment(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .withFunction(LootConditions.HIGH_LEVEL_TREASURE_ENCHANTMENT.build())
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));
        supplier.withPool(poolBuilder.build());
    }

    public static void addToLootTableWithRandomEnchantment(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToLootTableWithRandomEnchantment(supplier, count, probability, new Identifier(item));
    }
}

