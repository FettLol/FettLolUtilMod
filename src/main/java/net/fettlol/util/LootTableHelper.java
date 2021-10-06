package net.fettlol.util;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * This class contains a number of helper methods relating to loot tables. Several of these methods are of the type
 * "isBuriedTreasure(identifier)", to be used when modifying loot tables in other places.
 *
 * The class also contains a couple of methods that act as wrappers around FabricLootPoolBuilder for simplicity's sake,
 * such as addToOreLootTable, addToMobLootTable (Affected by Looting), addToOreLootTable (Affected by Fortune), etc.
 *
 * @todo Update these to include the chests added by the "Dungeons Arise" mod.
 * @todo Update these to include the chests added by the "Graveyard" mod.
 * @todo Update the custom "Eldritch Mobs" loot tables.
 * @todo Update Cat Morning Gift?
 * @todo Update fishing junk?
 * @todo Update any of the Hero of the Village gifts?
 * @todo Update the Piglin Bartering list?
 *
 * @see net.fettlol.init.FettlolLootTables
 */
public class LootTableHelper {

    public static final LootCondition NOT_WITH_SILK_TOUCH = MatchToolLootCondition.builder(
        ItemPredicate
            .Builder
            .create()
            .tag(FabricToolTags.PICKAXES)
            .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1)))
        ).invert().build();

    public static final LootFunction HIGH_LEVEL_TREASURE_ENCHANTMENT = EnchantWithLevelsLootFunction
        .builder(UniformLootNumberProvider.create(20.0f, 40.0f))
        .allowTreasureEnchantments()
        .build();

    // Identifies chests in villager houses. This does **not** include the job-specific chests.
    public static boolean isVillageHouseChest(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/village/village_desert_house",
                "minecraft:chests/village/village_plains_house",
                "minecraft:chests/village/village_savanna_house",
                "minecraft:chests/village/village_snowy_house",
                "minecraft:chests/village/village_taiga_house",
                "byg:chests/village/village_tropics_house",
                "byg:chests/village/village_skyris_house",
                "stoneholm:bedroom",
                "repurposed_structures:chests/villages/badlands_house",
                "repurposed_structures:chests/villages/birch_house",
                "repurposed_structures:chests/villages/crimson_house",
                "repurposed_structures:chests/villages/dark_forest_house",
                "repurposed_structures:chests/villages/giant_taiga_house",
                "repurposed_structures:chests/villages/jungle_house",
                "repurposed_structures:chests/villages/mountains_house",
                "repurposed_structures:chests/villages/oak_house",
                "repurposed_structures:chests/villages/swamp_house",
                "repurposed_structures:chests/villages/warped_house" -> true;
            default -> false;
        };
    }

    // Various "endgame" treasure sources in the nether. Includes the "Nether Bridge" chest added by BYG.
    public static boolean isNetherEndgame(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/bastion_bridge",
                "minecraft:chests/bastion_treasure",
                "minecraft:chests/bastion_hoglin_stable",
                "minecraft:chests/bastion_other",
                "minecraft:chests/nether_bridge",
                "byg:chest/nether_bridge" -> true;
            default -> false;
        };
    }

    // Various "endgame" treasure sources in the End. Includes "End City treasure" chest added by BYG.
    public static boolean isEndEndgame(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/end_city_treasure",
                "byg:chests/end_city_treasure" -> true;
            default -> false;
        };
    }

    // Chests found in strongholds. Includes the loot tables added by BYG and Repurposed Structures.
    public static boolean isStronghold(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/stronghold_library",
                "minecraft:chests/stronghold_corridor",
                "minecraft:chests/stronghold_crossing",
                "repurposed_structures:chests/strongholds/nether_hallway",
                "repurposed_structures:chests/strongholds/nether_library",
                "repurposed_structures:chests/strongholds/nether_storage_room",
                "byg:chests/stronghold_library",
                "byg:chests/stronghold_corridor",
                "byg:chests/stronghold_crossing" -> true;
            default -> false;
        };
    }

    public static boolean isRuinedPortal(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/ruined_portal" -> true;
            default -> false;
        };
    }

    // Buried Treasure. Includes the BYG version of the loot table.
    public static boolean isBuriedTreasure(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/buried_treasure",
                "byg:chests/buried_treasure" -> true;
            default -> false;
        };
    }

    // Mansions. Includes the Repurposed Structures versions as well.
    // For Repurposed Structures chests, these are the 'normal' chests, not the Storage chests.
    public static boolean isMansion(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/woodland_mansion",
                "repurposed_structures:chests/mansions/birch",
                "repurposed_structures:chests/mansions/desert",
                "repurposed_structures:chests/mansions/jungle",
                "repurposed_structures:chests/mansions/oak",
                "repurposed_structures:chests/mansions/savanna",
                "repurposed_structures:chests/mansions/snowy",
                "repurposed_structures:chests/mansions/taiga" -> true;
            default -> false;
        };
    }

    // Underwater Ruins. These are BYG-specific, it seems.
    public static boolean isUnderwaterRuin(Identifier identifier) {
        return switch (identifier.toString()) {
            case "byg:chests/underwater_ruin_small",
                "byg:chests/underwater_ruin_big" -> true;
            default -> false;
        };
    }

    // Chests found in Abandoned Mineshafts. Includes the Repurposed Structures versions as well.
    public static boolean isAbandonedMineshaft(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/abandoned_mineshaft",
                "byg:chests/abandoned_mineshaft",
                "repurposed_structures:chests/mineshafts/birch",
                "repurposed_structures:chests/mineshafts/crimson",
                "repurposed_structures:chests/mineshafts/dark_forest",
                "repurposed_structures:chests/mineshafts/desert",
                "repurposed_structures:chests/mineshafts/end",
                "repurposed_structures:chests/mineshafts/icy",
                "repurposed_structures:chests/mineshafts/jungle",
                "repurposed_structures:chests/mineshafts/nether",
                "repurposed_structures:chests/mineshafts/ocean",
                "repurposed_structures:chests/mineshafts/savanna",
                "repurposed_structures:chests/mineshafts/stone",
                "repurposed_structures:chests/mineshafts/swamp",
                "repurposed_structures:chests/mineshafts/taiga",
                "repurposed_structures:chests/mineshafts/warped"-> true;
            default -> false;
        };
    }

    // Chests found in Repurposed Structures Nether Temples as well.
    public static boolean isNetherTemple(Identifier identifier) {
        return switch (identifier.toString()) {
            case "repurposed_structures:chests/temples/nether_basalt",
                "repurposed_structures:chests/temples/nether_crimson",
                "repurposed_structures:chests/temples/nether_soul",
                "repurposed_structures:chests/temples/nether_warped",
                "repurposed_structures:chests/temples/nether_wasteland" -> true;
            default -> false;
        };
    }

    // Shipwreck treasure chests. Includes BYG and Repurposed Structures shipwreck treasure.
    public static boolean isShipwreckTreasure(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/shipwreck_treasure",
                "repurposed_structures:chests/shipwrecks/crimson/treasure",
                "repurposed_structures:chests/shipwrecks/end/treasure",
                "repurposed_structures:chests/shipwrecks/nether_bricks/treasure",
                "repurposed_structures:chests/shipwrecks/warped/treasure",
                "byg:chests/shipwreck_treasure" -> true;
            default -> false;
        };
    }

    // Graveyards (From the Graveyards mod)
    public static boolean isGraveyardLootChest(Identifier identifier) {
        return switch (identifier.toString()) {
            case "graveyard:chests/small_loot",
                "graveyard:chests/medium_loot",
                "graveyard:chests/large_loot" -> true;
            default -> false;
        };
    }

    // Desert Pyramids.
    public static boolean isDesertPyramid(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/desert_pyramid",
                "byg:chests/desert_pyramid" -> true;
            default -> false;
        };
    }

    // "Simple" Dungeon chests, the chests found around mob spawners.
    public static boolean isSimpleDungeonChest(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:chests/simple_dungeon",
                "byg:chests/simple_dungeon",
                "repurposed_structures:chests/dungeons/badlands",
                "repurposed_structures:chests/dungeons/dark_forest",
                "repurposed_structures:chests/dungeons/desert",
                "repurposed_structures:chests/dungeons/icy",
                "repurposed_structures:chests/dungeons/jungle",
                "repurposed_structures:chests/dungeons/mushroom",
                "repurposed_structures:chests/dungeons/nether",
                "repurposed_structures:chests/dungeons/ocean",
                "repurposed_structures:chests/dungeons/snow",
                "repurposed_structures:chests/dungeons/swamp" -> true;
            default -> false;
        };
    }

    // Is this a Diamond ore? This includes diamond ores added by the Dense Ores mod.
    public static boolean isDiamondOre(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:blocks/diamond_ore",
                "minecraft:blocks/deepslate_diamond_ore",
                "denseores:blocks/dense_deepslate_diamond_ore",
                "denseores:blocks/dense_diamond_ore" -> true;
            default -> false;
        };
    }

    // Is this a Lapis ore? This includes Lapis ores added by the Dense Ores mod.
    public static boolean isLapisOre(Identifier identifier) {
        return switch (identifier.toString()) {
            case "minecraft:blocks/lapis_ore",
                "minecraft:blocks/deepslate_lapis_ore",
                "denseores:blocks/dense_deepslate_lapis_ore",
                "denseores:blocks/dense_lapis_ore" -> true;
            default -> false;
        };
    }

    public static boolean isSpawner(Identifier identifier) {
        return identifier.toString().equals("minecraft:blocks/spawner");
    }

    public static boolean isFishingTreasure(Identifier identifier) {
        return identifier.toString().equals("minecraft:gameplay/fishing/treasure");
    }

    public static boolean isEnderman(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/enderman");
    }

    public static boolean isWitch(Identifier identifier) {
        return identifier.toString().equals("minecraft:entities/witch");
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

    public static boolean isHostileWaterMob(Identifier identifier) {
        return isDrowned(identifier)
            || isGuardian(identifier)
            || identifier.toString().equals("biomemakeover:entities/decayed");
    }

    // = Chests =

    public static boolean isBattleTowerChest(Identifier identifier) {
        return identifier.toString().equals("battletowers:default");
    }

    public static boolean isBlacksmithBattleTowerChest(Identifier identifier) {
        return identifier.toString().equals("battletowers:stone/blacksmith");
    }

    public static boolean isJungleBattleTowerChest(Identifier identifier) {
        return identifier.toString().equals("battletowers:stone/jungle");
    }

    public static boolean isLakeBattleTowerChest(Identifier identifier) {
        return identifier.toString().equals("battletowers:stone/lake");
    }

    public static boolean isLibraryBattleTowerChest(Identifier identifier) {
        return identifier.toString().equals("battletowers:stone/library");
    }

    public static boolean isMineshaftBattleTowerChest(Identifier identifier) {
        return identifier.toString().equals("battletowers:stone/mineshaft");
    }

    // ===========
    // = METHODS =
    // ===========

    public static void addToOreLootTable(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
            .withCondition(NOT_WITH_SILK_TOUCH)
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));

        supplier.withPool(poolBuilder.build());
    }

    public static void addToOreLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToOreLootTable(supplier, count, probability, new Identifier(item));
    }

    // == Add to Loot tables with Fortune modifier (Mobs only) ==

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

    // == Add to Loot tables (Chests or Mobs) ==

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

    // == Add to Loot tables and add a random enchantment ==

    public static void addToLootTableWithRandomEnchantment(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(BinomialLootNumberProvider.create(count, probability))
            .withFunction(HIGH_LEVEL_TREASURE_ENCHANTMENT)
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));
        supplier.withPool(poolBuilder.build());
    }

    public static void addToLootTableWithRandomEnchantment(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToLootTableWithRandomEnchantment(supplier, count, probability, new Identifier(item));
    }

}
