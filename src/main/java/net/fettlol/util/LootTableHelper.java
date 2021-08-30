package net.fettlol.util;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LootTableHelper {

    public static final LootCondition NOT_WITH_SILK_TOUCH = MatchToolLootCondition.builder(
        ItemPredicate.Builder.create()
            .tag(FabricToolTags.PICKAXES)
            .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1)))
    ).invert().build();

    public static final ConditionalLootFunction.Builder<?> FORTUNE = ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE);

    public static final LootFunction HIGH_LEVEL_TREASURE_ENCHANTMENT = EnchantWithLevelsLootFunction.builder(UniformLootNumberProvider.create(20.0f, 39.0f))
        .allowTreasureEnchantments()
        .build();

    // = Chests =

    public static boolean isVillageHouseChest(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/village/village_desert_house", "minecraft:chests/village/village_plains_house", "minecraft:chests/village/village_savanna_house", "minecraft:chests/village/village_snowy_house", "minecraft:chests/village/village_taiga_house", "repurposed_structures:chests/village/village_badlands_house", "repurposed_structures:chests/village/village_birch_house", "repurposed_structures:chests/village/village_crimson_house", "repurposed_structures:chests/village/village_dark_forest_house", "repurposed_structures:chests/village/village_giant_taiga_house", "repurposed_structures:chests/village/village_jungle_house", "repurposed_structures:chests/village/village_mountains_house", "repurposed_structures:chests/village/village_oak_house", "repurposed_structures:chests/village/village_swamp_house" -> true;
            default -> false;
        };
    }

    public static boolean isNetherEndgame(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/bastion_bridge", "minecraft:chests/bastion_treasure", "minecraft:chests/bastion_hoglin_stable", "minecraft:chests/bastion_other", "minecraft:chests/nether_bridge", "byg:chest/nether_bridge" -> true;
            default -> false;
        };
    }

    public static boolean isEndEndgame(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/end_city_treasure", "byg:chests/end_city_treasure" -> true;
            default -> false;
        };
    }

    public static boolean isStronghold(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/stronghold_library", "minecraft:chests/stronghold_corridor", "minecraft:chests/stronghold_crossing", "byg:chests/stronghold_library", "byg:chests/stronghold_corridor", "byg:chests/stronghold_crossing" -> true;
            default -> false;
        };
    }

    public static boolean isBuriedTreasure(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/buried_treasure", "byg:chests/buried_treasure" -> true;
            default -> false;
        };
    }

    public static boolean isUnderwaterRuin(Identifier identifier) {
        return switch (identifier.toString()) {
            case "byg:chests/underwater_ruin_small", "byg:chests/underwater_ruin_big" -> true;
            default -> false;
        };
    }

    public static boolean isAbandonedMineshaft(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/abandoned_mineshaft", "byg:chests/abandoned_mineshaft", "repurposed_structures:chests/mineshaft/birch", "repurposed_structures:chests/mineshaft/desert", "repurposed_structures:chests/mineshaft/icy", "repurposed_structures:chests/mineshaft/jungle", "repurposed_structures:chests/mineshaft/ocean", "repurposed_structures:chests/mineshaft/savanna", "repurposed_structures:chests/mineshaft/stone", "repurposed_structures:chests/mineshaft/swamp_dark_forest", "repurposed_structures:chests/mineshaft/taiga" -> true;
            default -> false;
        };
    }

    public static boolean isShipwreckTreasure(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/shipwreck_treasure", "byg:chests/shipwreck_treasure" -> true;
            default -> false;
        };
    }

    public static boolean isDesertPyramid(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/desert_pyramid", "byg:chests/desert_pyramid" -> true;
            default -> false;
        };
    }

    public static boolean isSimpleDungeonChest(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/simple_dungeon", "byg:chests/simple_dungeon", "repurposed_structures:chests/dungeon/badlands", "repurposed_structures:chests/dungeon/dark_forest", "repurposed_structures:chests/dungeon/desert", "repurposed_structures:chests/dungeon/jungle", "repurposed_structures:chests/dungeon/mushroom", "repurposed_structures:chests/dungeon/ocean", "repurposed_structures:chests/dungeon/snow", "repurposed_structures:chests/dungeon/swamp" -> true;
            default -> false;
        };
    }

    // = Blocks =

    public static boolean isDiamondOre(Identifier identifier) {
        return identifier.toString().equals("minecraft:blocks/diamond_ore")
            || identifier.toString().equals("minecraft:blocks/deepslate_diamond_ore");
    }

    public static boolean isLapisOre(Identifier identifier) {
        return identifier.toString().equals("minecraft:blocks/lapis_ore")
            || identifier.toString().equals("minecraft:blocks/deepslate_lapis_ore");
    }

    public static boolean isSpawner(Identifier identifier) {
        return identifier.toString().equals("minecraft:blocks/spawner");
    }

    // = Gameplay =

    public static boolean isFishingTreasure(Identifier identifier) {
        return identifier.toString().equals("minecraft:gameplay/fishing/treasure");
    }

    // = Mobs and Entities =

    public static boolean isEnderman(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/enderman");
    }

    public static boolean isEvoker(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/evoker");
    }

    public static boolean isShulker(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/shulker");
    }

    public static boolean isEnderDragon(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/ender_dragon");
    }

    public static boolean isGuardian(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/guardian")
            || identifier.toString().equals("minecraft:entities/elder_guardian");
    }

    public static boolean isHusk(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/husk");
    }

    public static boolean isWitherSkeleton(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/wither_skeleton");
    }

    public static boolean isStray(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/stray");
    }

    public static boolean isDrowned(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/drowned");
    }

    public static boolean isZombie(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/zombie");
    }

    public static boolean isPhantom(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/phantom");
    }

    public static boolean isTowerChest(Identifier identifier) {
        return identifier.toString().equals("battletowers:default");
    }

    public static boolean isHostileWaterMob(Identifier identifier) {
        return isDrowned(identifier)
            || isGuardian(identifier)
            || identifier.toString().equals("biomemakeover:entities/decayed");
    }

    // == Add to Ore Loot table - affected by Fortune ==

    public static void addToOreLootTable(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .apply(FORTUNE)
            .withCondition(NOT_WITH_SILK_TOUCH)
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));

        supplier.withPool(poolBuilder.build());
    }

    public static void addToOreLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String namespace, String item) {
        addToOreLootTable(supplier, count, probability, new Identifier(namespace, item));
    }

    public static void addToOreLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToOreLootTable(supplier, count, probability, new Identifier(item));
    }

    // == Add to Loot tables - of mobs, generally ==

    public static void addToLootTable(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));
        supplier.withPool(poolBuilder.build());
    }

    public static void addToLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String namespace, String item) {
        addToLootTable(supplier, count, probability, new Identifier(namespace, item));
    }

    public static void addToLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToLootTable(supplier, count, probability, new Identifier(item));
    }

    // == Add to Loot tables and add a random enchantment - armor and weapons, generally ==

    public static void addToLootTableWithRandomEnchantment(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .withFunction(HIGH_LEVEL_TREASURE_ENCHANTMENT)
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));
        supplier.withPool(poolBuilder.build());
    }

    public static void addToLootTableWithRandomEnchantment(FabricLootSupplierBuilder supplier, int count, float probability, String namespace, String item) {
        addToLootTableWithRandomEnchantment(supplier, count, probability, new Identifier(namespace, item));
    }

    public static void addToLootTableWithRandomEnchantment(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToLootTableWithRandomEnchantment(supplier, count, probability, new Identifier(item));
    }

}
