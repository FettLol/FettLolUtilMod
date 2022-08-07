package net.fettlol.utilmod.util;

import net.minecraft.loot.LootTables;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

public class LootTableHelper {

    public static List<String> CAT_MORNING_GIFT;
    public static List<String> FISHING_JUNK;
    public static List<String> FISHING_TREASURES;
    public static List<String> PIGLIN_BARTERING;
    public static List<String> VILLAGER_HERO_ARMORER_GIFT;
    public static List<String> VILLAGER_HERO_BUTCHER_GIFT;
    public static List<String> VILLAGER_HERO_CARTOGRAPHER_GIFT;
    public static List<String> VILLAGER_HERO_CLERIC_GIFT;
    public static List<String> VILLAGER_HERO_FARMER_GIFT;
    public static List<String> VILLAGER_HERO_FISHERMAN_GIFT;
    public static List<String> VILLAGER_HERO_FLETCHER_GIFT;
    public static List<String> VILLAGER_HERO_LEATHERWORKER_GIFT;
    public static List<String> VILLAGER_HERO_LIBRARIAN_GIFT;
    public static List<String> VILLAGER_HERO_MASON_GIFT;
    public static List<String> VILLAGER_HERO_SHEPHERD_GIFT;
    public static List<String> VILLAGER_HERO_TOOLSMITH_GIFT;
    public static List<String> VILLAGER_HERO_WEAPONSMITH_GIFT;
    public static final List<String> ABANDONED_MINESHAFT_CHESTS;
    public static final List<String> BURIED_TREASURE_CHESTS;
    public static final List<String> COPPER_ORES;
    public static final List<String> DESERT_PYRAMID_CHESTS;
    public static final List<String> DIAMOND_ORES;
    public static final List<String> DROWNED;
    public static final List<String> ENDERMAN;
    public static final List<String> ENDER_DRAGON;
    public static final List<String> END_ENDGAME_CHESTS;
    public static final List<String> EVOKER;
    public static final List<String> GOLD_ORES;
    public static final List<String> GUARDIAN;
    public static final List<String> HUSK;
    public static final List<String> IRON_ORES;
    public static final List<String> LAPIS_ORES;
    public static final List<String> MANSION_CHESTS;
    public static final List<String> NETHER_ENDGAME_CHESTS;
    public static final List<String> NETHER_TEMPLE_CHESTS;
    public static final List<String> PHANTOM;
    public static final List<String> RUINED_PORTAL_CHESTS;
    public static final List<String> SHIPWRECK_CHESTS;
    public static final List<String> SHULKER;
    public static final List<String> SIMPLE_DUNGEON_CHESTS;
    public static final List<String> SKELETON;
    public static final List<String> SPAWNERS;
    public static final List<String> STRAY;
    public static final List<String> STRONGHOLD_CHESTS;
    public static final List<String> UNDERWATER_RUIN_CHESTS;
    public static final List<String> VILLAGE_HOUSE_CHESTS;
    public static final List<String> WITCH;
    public static final List<String> WITHER;
    public static final List<String> WITHER_SKELETON;
    public static final List<String> ZOMBIE;

    static {
        ABANDONED_MINESHAFT_CHESTS = Arrays.asList(
            LootTables.ABANDONED_MINESHAFT_CHEST.toString(),
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
            "repurposed_structures:chests/mineshafts/warped"
        );

        BURIED_TREASURE_CHESTS = Arrays.asList(
            LootTables.BURIED_TREASURE_CHEST.toString(),
            "biomemakeover:mansion/dungeon_good"
        );

        DESERT_PYRAMID_CHESTS = Arrays.asList(
            LootTables.DESERT_PYRAMID_CHEST.toString()
        );

        END_ENDGAME_CHESTS = Arrays.asList(
            LootTables.END_CITY_TREASURE_CHEST.toString(),
            "spectrum:ancient_ruins_main"
        );

        MANSION_CHESTS = Arrays.asList(
            LootTables.WOODLAND_MANSION_CHEST.toString(),
            "repurposed_structures:chests/mansions/birch",
            "repurposed_structures:chests/mansions/desert",
            "repurposed_structures:chests/mansions/jungle",
            "repurposed_structures:chests/mansions/oak",
            "repurposed_structures:chests/mansions/savanna",
            "repurposed_structures:chests/mansions/snowy",
            "repurposed_structures:chests/mansions/taiga"
        );

        NETHER_ENDGAME_CHESTS = Arrays.asList(
            LootTables.BASTION_BRIDGE_CHEST.toString(),
            LootTables.BASTION_TREASURE_CHEST.toString(),
            LootTables.BASTION_HOGLIN_STABLE_CHEST.toString(),
            LootTables.BASTION_OTHER_CHEST.toString(),
            LootTables.NETHER_BRIDGE_CHEST.toString(),
            "repurposed_structures:chests/bastions/underground/bridge",
            "repurposed_structures:chests/bastions/underground/other",
            "repurposed_structures:chests/bastions/underground/skeleton_horse_stable",
            "repurposed_structures:chests/bastions/underground/treasure",
            "repurposed_structures:chests/cities/nether"
        );

        NETHER_TEMPLE_CHESTS = Arrays.asList(
            "repurposed_structures:chests/temples/nether_basalt",
            "repurposed_structures:chests/temples/nether_crimson",
            "repurposed_structures:chests/temples/nether_soul",
            "repurposed_structures:chests/temples/nether_warped",
            "repurposed_structures:chests/temples/nether_wasteland"
        );

        RUINED_PORTAL_CHESTS = Arrays.asList(
            LootTables.RUINED_PORTAL_CHEST.toString(),
            "repurposed_structures:chests/ruined_portals/end/large_portal",
            "repurposed_structures:chests/ruined_portals/end/small_portal"
        );

        SHIPWRECK_CHESTS = Arrays.asList(
            LootTables.SHIPWRECK_SUPPLY_CHEST.toString(),
            LootTables.SHIPWRECK_TREASURE_CHEST.toString(),
            "biomemakeover:sunken_ruin",
            "repurposed_structures:chests/shipwrecks/crimson/treasure",
            "repurposed_structures:chests/shipwrecks/end/treasure",
            "repurposed_structures:chests/shipwrecks/nether_bricks/treasure",
            "repurposed_structures:chests/shipwrecks/warped/treasure"
        );

        SIMPLE_DUNGEON_CHESTS = Arrays.asList(
            LootTables.SIMPLE_DUNGEON_CHEST.toString(),
            "spectrum:chests/ancient_ruins_small",
            "repurposed_structures:chests/dungeons/badlands",
            "repurposed_structures:chests/dungeons/dark_forest",
            "repurposed_structures:chests/dungeons/deep",
            "repurposed_structures:chests/dungeons/desert",
            "repurposed_structures:chests/dungeons/icy",
            "repurposed_structures:chests/dungeons/jungle",
            "repurposed_structures:chests/dungeons/mushroom",
            "repurposed_structures:chests/dungeons/nether",
            "repurposed_structures:chests/dungeons/ocean",
            "repurposed_structures:chests/dungeons/snow",
            "repurposed_structures:chests/dungeons/swamp"
        );

        STRONGHOLD_CHESTS = Arrays.asList(
            LootTables.STRONGHOLD_CORRIDOR_CHEST.toString(),
            LootTables.STRONGHOLD_CROSSING_CHEST.toString(),
            LootTables.STRONGHOLD_LIBRARY_CHEST.toString(),
            "repurposed_structures:chests/strongholds/nether_hallway",
            "repurposed_structures:chests/strongholds/nether_library",
            "repurposed_structures:chests/strongholds/nether_storage_room"
        );


        UNDERWATER_RUIN_CHESTS = Arrays.asList(
            LootTables.UNDERWATER_RUIN_BIG_CHEST.toString(),
            LootTables.UNDERWATER_RUIN_SMALL_CHEST.toString()
        );

        VILLAGE_HOUSE_CHESTS = Arrays.asList(
            LootTables.VILLAGE_DESERT_HOUSE_CHEST.toString(),
            LootTables.VILLAGE_PLAINS_CHEST.toString(),
            LootTables.VILLAGE_SAVANNA_HOUSE_CHEST.toString(),
            LootTables.VILLAGE_SNOWY_HOUSE_CHEST.toString(),
            LootTables.VILLAGE_TAIGA_HOUSE_CHEST.toString(),
            "repurposed_structures:chests/villages/badlands_house",
            "repurposed_structures:chests/villages/birch_house",
            "repurposed_structures:chests/villages/crimson_house",
            "repurposed_structures:chests/villages/dark_forest_house",
            "repurposed_structures:chests/villages/giant_taiga_house",
            "repurposed_structures:chests/villages/jungle_house",
            "repurposed_structures:chests/villages/mountains_house",
            "repurposed_structures:chests/villages/oak_house",
            "repurposed_structures:chests/villages/swamp_house",
            "repurposed_structures:chests/villages/warped_house"
        );

        CAT_MORNING_GIFT = Arrays.asList(LootTables.CAT_MORNING_GIFT_GAMEPLAY.toString());
        FISHING_JUNK = Arrays.asList(LootTables.FISHING_JUNK_GAMEPLAY.toString());
        FISHING_TREASURES = Arrays.asList(LootTables.FISHING_TREASURE_GAMEPLAY.toString());
        PIGLIN_BARTERING = Arrays.asList(LootTables.PIGLIN_BARTERING_GAMEPLAY.toString());
        VILLAGER_HERO_ARMORER_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_ARMORER_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_BUTCHER_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_BUTCHER_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_CARTOGRAPHER_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_CARTOGRAPHER_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_CLERIC_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_CLERIC_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_FARMER_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_FARMER_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_FISHERMAN_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_FISHERMAN_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_FLETCHER_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_FLETCHER_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_LEATHERWORKER_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_LEATHERWORKER_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_LIBRARIAN_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_LIBRARIAN_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_MASON_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_MASON_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_SHEPHERD_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_SHEPHERD_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_TOOLSMITH_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_TOOLSMITH_GIFT_GAMEPLAY.toString());
        VILLAGER_HERO_WEAPONSMITH_GIFT = Arrays.asList(LootTables.HERO_OF_THE_VILLAGE_WEAPONSMITH_GIFT_GAMEPLAY.toString());

        DROWNED = Arrays.asList("minecraft:entities/drowned");
        ENDERMAN = Arrays.asList("minecraft:entities/enderman");
        SPAWNERS = Arrays.asList("minecraft:blocks/spawner");
        ENDER_DRAGON = Arrays.asList("minecraft:entities/ender_dragon");
        EVOKER = Arrays.asList("minecraft:entities/evoker");
        GUARDIAN = Arrays.asList("minecraft:entities/guardian", "minecraft:entities/elder_guardian");
        HUSK = Arrays.asList("minecraft:entities/husk");
        PHANTOM = Arrays.asList("minecraft:entities/phantom");
        SHULKER = Arrays.asList("minecraft:entities/shulker");
        SKELETON = Arrays.asList("minecraft:entities/skeleton");
        STRAY = Arrays.asList("minecraft:entities/stray");
        WITCH = Arrays.asList("minecraft:entities/witch");
        WITHER = Arrays.asList("minecraft:entities/wither");
        WITHER_SKELETON = Arrays.asList("minecraft:entities/wither_skeleton");
        ZOMBIE = Arrays.asList("minecraft:entities/zombie");

        IRON_ORES = Arrays.asList(
            "minecraft:blocks/iron_ore",
            "minecraft:blocks/deepslate_iron_ore",
            "denseores:blocks/dense_deepslate_iron_ore",
            "denseores:blocks/dense_iron_ore"
        );

        COPPER_ORES = Arrays.asList(
            "minecraft:blocks/copper_ore",
            "minecraft:blocks/deepslate_copper_ore",
            "denseores:blocks/dense_deepslate_copper_ore",
            "denseores:blocks/dense_copper_ore"
        );

        GOLD_ORES = Arrays.asList(
            "minecraft:blocks/gold_ore",
            "minecraft:blocks/deepslate_gold_ore",
            "denseores:blocks/dense_deepslate_gold_ore",
            "denseores:blocks/dense_gold_ore"
        );

        DIAMOND_ORES = Arrays.asList(
            "minecraft:blocks/diamond_ore",
            "minecraft:blocks/deepslate_diamond_ore",
            "denseores:blocks/dense_deepslate_diamond_ore",
            "denseores:blocks/dense_diamond_ore"
        );

        LAPIS_ORES = Arrays.asList(
            "minecraft:blocks/lapis_ore",
            "minecraft:blocks/deepslate_lapis_ore",
            "denseores:blocks/dense_deepslate_lapis_ore",
            "denseores:blocks/dense_lapis_ore"
        );

    }

    public static boolean isVillageHouseChest(Identifier identifier) {
        return VILLAGE_HOUSE_CHESTS.contains(identifier.toString());
    }

    public static boolean isNetherEndgameChest(Identifier identifier) {
        return NETHER_ENDGAME_CHESTS.contains(identifier.toString());
    }

    public static boolean isEndEndgameChest(Identifier identifier) {
        return END_ENDGAME_CHESTS.contains(identifier.toString());
    }

    public static boolean isStrongholdChest(Identifier identifier) {
        return STRONGHOLD_CHESTS.contains(identifier.toString());
    }

    public static boolean isRuinedPortalChest(Identifier identifier) {
        return RUINED_PORTAL_CHESTS.contains(identifier.toString());
    }

    public static boolean isBuriedTreasureChest(Identifier identifier) {
        return BURIED_TREASURE_CHESTS.contains(identifier.toString());
    }

    public static boolean isMansionChest(Identifier identifier) {
        return MANSION_CHESTS.contains(identifier.toString());
    }

    public static boolean isUnderwaterRuinChest(Identifier identifier) {
        return UNDERWATER_RUIN_CHESTS.contains(identifier.toString());
    }

    public static boolean isAbandonedMineshaftChest(Identifier identifier) {
        return ABANDONED_MINESHAFT_CHESTS.contains(identifier.toString());
    }

    public static boolean isNetherTempleChest(Identifier identifier) {
        return NETHER_TEMPLE_CHESTS.contains(identifier.toString());
    }

    public static boolean isShipwreckTreasure(Identifier identifier) {
        return SHIPWRECK_CHESTS.contains(identifier.toString());
    }

    public static boolean isDesertPyramid(Identifier identifier) {
        return DESERT_PYRAMID_CHESTS.contains(identifier.toString());
    }

    public static boolean isSimpleDungeonChest(Identifier identifier) {
        return SIMPLE_DUNGEON_CHESTS.contains(identifier.toString());
    }

    public static boolean isDiamondOre(Identifier identifier) {
        return DIAMOND_ORES.contains(identifier.toString());
    }

    public static boolean isLapisOre(Identifier identifier) {
        return LAPIS_ORES.contains(identifier.toString());
    }

    public static boolean isSpawner(Identifier identifier) {
        return SPAWNERS.contains(identifier.toString());
    }

    public static boolean isFishingTreasure(Identifier identifier) {
        return FISHING_TREASURES.contains(identifier.toString());
    }

    public static boolean isEnderman(Identifier identifier) {
        return ENDERMAN.contains(identifier.toString());
    }

    public static boolean isWitch(Identifier identifier) {
        return WITCH.contains(identifier.toString());
    }

    public static boolean isEvoker(Identifier identifier) {
        return EVOKER.contains(identifier.toString());
    }

    public static boolean isShulker(Identifier identifier) {
        return SHULKER.contains(identifier.toString());
    }

    public static boolean isEnderDragon(Identifier identifier) {
        return ENDER_DRAGON.contains(identifier.toString());
    }

    public static boolean isGuardian(Identifier identifier) {
        return GUARDIAN.contains(identifier.toString());
    }

    public static boolean isHusk(Identifier identifier) {
        return HUSK.contains(identifier.toString());
    }

    public static boolean isWitherSkeleton(Identifier identifier) {
        return WITHER_SKELETON.contains(identifier.toString());
    }

    public static boolean isWither(Identifier identifier) {
        return WITHER.contains(identifier.toString());
    }

    public static boolean isStray(Identifier identifier) {
        return STRAY.contains(identifier.toString());
    }

    public static boolean isDrowned(Identifier identifier) {
        return DROWNED.contains(identifier.toString());
    }

    public static boolean isZombie(Identifier identifier) {
        return ZOMBIE.contains(identifier.toString());
    }

    public static boolean isPhantom(Identifier identifier) {
        return PHANTOM.contains(identifier.toString());
    }

    public static boolean isHostileWaterMob(Identifier identifier) {
        return DROWNED.contains(identifier.toString()) || GUARDIAN.contains(identifier.toString());
    }
}