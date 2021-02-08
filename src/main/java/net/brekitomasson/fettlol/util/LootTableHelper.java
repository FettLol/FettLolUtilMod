package net.brekitomasson.fettlol.util;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.minecraft.loot.BinomialLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LootTableHelper {

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
        return "minecraft:blocks/diamond_ore".equals(identifier.toString());
    }

    public static boolean isAncientDebris(Identifier identifier) {
        return "minecraft:blocks/ancient_debris".equals(identifier.toString());
    }

    // = Mobs and Entities =

    public static boolean isEnderman(Identifier identifier) {
        return "minecraft:entities/enderman".equals(identifier.toString());
    }

    public static boolean isShulker(Identifier identifier) {
        return "minecraft:entities/shulker".equals(identifier.toString());
    }

    public static boolean isEnderDragon(Identifier identifier) {
        return "minecraft:entities/ender_dragon".equals(identifier.toString());
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
     * @param namespace   The namespace of the item in the registry.
     * @param item        The name of the item in the registry without the namespace portion.
     */
    public static void addToLootTable(FabricLootSupplierBuilder supplier, int count, float probability, String namespace, String item) {
        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .rolls(new BinomialLootTableRange(count, probability))
            .with(ItemEntry.builder(Registry.ITEM.get(new Identifier(namespace, item)).asItem()));
        supplier.withPool(poolBuilder.build());
    }
}
