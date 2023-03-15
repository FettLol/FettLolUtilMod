package net.fettlol.utilmod.registry;

import net.fettlol.utilmod.lists.LootConditions;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LootApi {

    public static void addToOreLootTable(LootTable.Builder tableBuilder, int count, float probability, Identifier identifier) {
        LootPool.Builder poolBuilder = LootPool.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
            .conditionally(LootConditions.WITHOUT_SILK_TOUCH.build())
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));

        tableBuilder.pool(poolBuilder.build());
    }

    public static void addToOreLootTable(LootTable.Builder tableBuilder, int count, float probability, String item) {
        addToOreLootTable(tableBuilder, count, probability, new Identifier(item));
    }

    public static void addToMobLootTable(LootTable.Builder tableBuilder, int count, float probability, Identifier identifier) {
        LootPool.Builder poolBuilder = LootPool.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.LOOTING))
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));

        tableBuilder.pool(poolBuilder.build());
    }

    public static void addToMobLootTable(LootTable.Builder tableBuilder, int count, float probability, String item) {
        addToMobLootTable(tableBuilder, count, probability, new Identifier(item));
    }

    public static void addToLootTable(LootTable.Builder tableBuilder, int count, float probability, Identifier identifier) {
        LootPool.Builder poolBuilder = LootPool.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));

        tableBuilder.pool(poolBuilder.build());
    }

    public static void addToLootTable(LootTable.Builder tableBuilder, int count, float probability, String item) {
        addToLootTable(tableBuilder, count, probability, new Identifier(item));
    }

    public static void addToLootTable(LootTable.Builder tableBuilder, int count, float probability, String namespace, String item) {
        addToLootTable(tableBuilder, count, probability, new Identifier(namespace, item));
    }

    public static void addToLootTableWithRandomEnchantment(LootTable.Builder tableBuilder, int count, float probability, Identifier identifier) {
        LootPool.Builder poolBuilder = LootPool.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .apply(LootConditions.HIGH_LEVEL_TREASURE_ENCHANTMENT.build()) // TODO test
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));
        tableBuilder.pool(poolBuilder.build());
    }

    public static void addToLootTableWithRandomEnchantment(LootTable.Builder tableBuilder, int count, float probability, String item) {
        addToLootTableWithRandomEnchantment(tableBuilder, count, probability, new Identifier(item));
    }
}

