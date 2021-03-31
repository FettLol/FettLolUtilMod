package net.fettlol.util;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.minecraft.loot.BinomialLootTableRange;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LootTableHelper {

    // A couple of class constants to speed things up.
    static final Identifier ENDERMAN = new Identifier("minecraft", "entities/enderman");
    static final Identifier SHULKER = new Identifier("minecraft", "entities/shulker");
    static final Identifier ENDER_DRAGON = new Identifier("minecraft", "entities/ender_dragon");
    static final Identifier DROWNED = new Identifier("minecraft", "entities/drowned");
    static final Identifier HUSK = new Identifier("minecraft", "entities/husk");
    static final Identifier STRAY = new Identifier("minecraft", "entities/stray");
    static final Identifier ZOMBIE = new Identifier("minecraft", "entities/zombie");

    // = Chests =

    public static boolean isVillageHouseChest(Identifier identifier) {
        switch (identifier.toString()) {
            case "minecraft:chests/village/village_desert_house":
            case "minecraft:chests/village/village_plains_house":
            case "minecraft:chests/village/village_savanna_house":
            case "minecraft:chests/village/village_snowy_house":
            case "minecraft:chests/village/village_taiga_house":
            case "repurposed_structures:chests/village/village_badlands_house":
            case "repurposed_structures:chests/village/village_birch_house":
            case "repurposed_structures:chests/village/village_crimson_house":
            case "repurposed_structures:chests/village/village_dark_forest_house":
            case "repurposed_structures:chests/village/village_giant_taiga_house":
            case "repurposed_structures:chests/village/village_jungle_house":
            case "repurposed_structures:chests/village/village_mountains_house":
            case "repurposed_structures:chests/village/village_oak_house":
            case "repurposed_structures:chests/village/village_swamp_house":
                return true;

            default:
                return false;
        }
    }

    public static boolean isNetherEndgame(Identifier identifier) {
        switch (identifier.toString()) {
            case "minecraft:chests/bastion_bridge":
            case "minecraft:chests/bastion_treasure":
            case "minecraft:chests/bastion_hoglin_stable":
            case "minecraft:chests/bastion_other":
            case "minecraft:chests/nether_bridge":
            case "byg:chest/nether_bridge":
                return true;

            default:
                return false;
        }
    }

    public static boolean isEndEndgame(Identifier identifier) {
        switch (identifier.toString()) {
            case "minecraft:chests/end_city_treasure":
            case "byg:chests/end_city_treasure":
                return true;

            default:
                return false;
        }
    }

    public static boolean isStronghold(Identifier identifier) {
        switch (identifier.toString()) {
            case "minecraft:chests/stronghold_library":
            case "minecraft:chests/stronghold_corridor":
            case "minecraft:chests/stronghold_crossing":
            case "byg:chests/stronghold_library":
            case "byg:chests/stronghold_corridor":
            case "byg:chests/stronghold_crossing":
                return true;

            default:
                return false;
        }
    }

    public static boolean isBuriedTreasure(Identifier identifier) {
        switch (identifier.toString()) {
            case "minecraft:chests/buried_treasure":
            case "byg:chests/buried_treasure":
                return true;

            default:
                return false;
        }
    }

    public static boolean isUnderwaterRuin(Identifier identifier) {
        switch (identifier.toString()) {
            case "byg:chests/underwater_ruin_small":
            case "byg:chests/underwater_ruin_big":
                return true;

            default:
                return false;
        }
    }

    public static boolean isAbandonedMineshaft(Identifier identifier) {
        switch (identifier.toString()) {
            case "minecraft:chests/abandoned_mineshaft":
            case "byg:chests/abandoned_mineshaft":
            case "repurposed_structures:chests/mineshaft/birch":
            case "repurposed_structures:chests/mineshaft/desert":
            case "repurposed_structures:chests/mineshaft/icy":
            case "repurposed_structures:chests/mineshaft/jungle":
            case "repurposed_structures:chests/mineshaft/ocean":
            case "repurposed_structures:chests/mineshaft/savanna":
            case "repurposed_structures:chests/mineshaft/stone":
            case "repurposed_structures:chests/mineshaft/swamp_dark_forest":
            case "repurposed_structures:chests/mineshaft/taiga":
                return true;

            default:
                return false;
        }
    }

    public static boolean isShipwreckTreasure(Identifier identifier) {
        switch (identifier.toString()) {
            case "minecraft:chests/shipwreck_treasure":
            case "byg:chests/shipwreck_treasure":
                return true;

            default:
                return false;
        }
    }

    public static boolean isDesertPyramid(Identifier identifier) {
        switch (identifier.toString()) {
            case "minecraft:chests/desert_pyramid":
            case "byg:chests/desert_pyramid":
                return true;

            default:
                return false;
        }
    }

    public static boolean isSimpleDungeonChest(Identifier identifier) {
        switch (identifier.toString()) {
            case "minecraft:chests/simple_dungeon":
            case "byg:chests/simple_dungeon":
            case "repurposed_structures:chests/dungeon/badlands":
            case "repurposed_structures:chests/dungeon/dark_forest":
            case "repurposed_structures:chests/dungeon/desert":
            case "repurposed_structures:chests/dungeon/jungle":
            case "repurposed_structures:chests/dungeon/mushroom":
            case "repurposed_structures:chests/dungeon/ocean":
            case "repurposed_structures:chests/dungeon/snow":
            case "repurposed_structures:chests/dungeon/swamp":
                return true;

            default:
                return false;
        }
    }

    // = Blocks =

    public static boolean isDiamondOre(Identifier identifier) {
        return identifier.toString().equals("minecraft:blocks/diamond_ore");
    }

    public static boolean isLapisOre(Identifier identifier) {
        return identifier.toString().equals("minecraft:blocks/lapis_ore");
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
        switch (identifier.toString()) {
            case "minecraft:entities/drowned":
            case "minecraft:entities/guardian":
            case "minecraft:entities/elder_guardian":
            case "biomemakeover:entities/decayed":
                return true;

            default:
                return false;
        }
    }

    /**
     * Helper method to add things to a loot table.
     *
     * This should be called from within a LootTableLoadingCallback.EVENT.register callback method.
     * Uses the Binomial Loot Table Range method, as this seems to be the most appropriate in most cases.
     *
     * @param supplier    The Supplier field from LootTableLoadingCallback.EVENT.register.
     * @param count       How many times to try to add this item to the loot table.
     * @param probability How large probability that the item is added per try.
     * @param identifier  The Minecraft Registry Identifier of the item to add.
     */
    public static void addToLootTable(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(new BinomialLootTableRange(count, probability))
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));
        supplier.withPool(poolBuilder.build());
    }

    public static void addToLootTableWithRandomEnchantment(FabricLootSupplierBuilder supplier, int count, float probability, Identifier identifier) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(new BinomialLootTableRange(count, probability))
            .withFunction(EnchantWithLevelsLootFunction.builder(UniformLootTableRange.between(20.0f, 39.0f)).allowTreasureEnchantments().build())
            .with(ItemEntry.builder(Registry.ITEM.get(identifier).asItem()));
        supplier.withPool(poolBuilder.build());
    }

    // Same method as above, but called using two Strings for namespace and item name instead of an Identifier.
    // For example: "minecraft", "poisonous_potato"
    public static void addToLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String namespace, String item) {
        addToLootTable(supplier, count, probability, new Identifier(namespace, item));
    }

    public static void addToLootTableWithRandomEnchantment(FabricLootSupplierBuilder supplier, int count, float probability, String namespace, String item) {
        addToLootTableWithRandomEnchantment(supplier, count, probability, new Identifier(namespace, item));
    }

    // Same method as above, but using one String to identify the item instead of using an Identifier.
    public static void addToLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToLootTable(supplier, count, probability, new Identifier(item));
    }

    public static void addToLootTableWithRandomEnchantment(FabricLootSupplierBuilder supplier, int count, float probability, String item) {
        addToLootTableWithRandomEnchantment(supplier, count, probability, new Identifier(item));
    }

}
