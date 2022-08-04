package net.fettlol.utilmod.util;

import net.fettlol.utilmod.lists.*;
import net.minecraft.util.Identifier;

public class LootTableHelper {

    // == CHESTS ==

    public static boolean isVillageHouseChest(Identifier identifier) {
        return ChestLootTableGroups.VILLAGE_HOUSE_CHESTS.contains(identifier.toString());
    }

    public static boolean isNetherEndgameChest(Identifier identifier) {
        return ChestLootTableGroups.NETHER_ENDGAME_CHESTS.contains(identifier.toString());
    }

    public static boolean isEndEndgameChest(Identifier identifier) {
        return ChestLootTableGroups.END_ENDGAME_CHESTS.contains(identifier.toString());
    }

    public static boolean isStrongholdChest(Identifier identifier) {
        return ChestLootTableGroups.STRONGHOLD_CHESTS.contains(identifier.toString());
    }

    public static boolean isRuinedPortalChest(Identifier identifier) {
        return ChestLootTableGroups.RUINED_PORTAL_CHESTS.contains(identifier.toString());
    }

    public static boolean isBuriedTreasureChest(Identifier identifier) {
        return ChestLootTableGroups.BURIED_TREASURE_CHESTS.contains(identifier.toString());
    }

    public static boolean isMansionChest(Identifier identifier) {
        return ChestLootTableGroups.MANSION_CHESTS.contains(identifier.toString());
    }

    public static boolean isUnderwaterRuinChest(Identifier identifier) {
        return ChestLootTableGroups.UNDERWATER_RUIN_CHESTS.contains(identifier.toString());
    }

    public static boolean isAbandonedMineshaftChest(Identifier identifier) {
        return ChestLootTableGroups.ABANDONED_MINESHAFT_CHESTS.contains(identifier.toString());
    }

    public static boolean isNetherTempleChest(Identifier identifier) {
        return ChestLootTableGroups.NETHER_TEMPLE_CHESTS.contains(identifier.toString());
    }

    public static boolean isShipwreckTreasure(Identifier identifier) {
        return ChestLootTableGroups.SHIPWRECK_CHESTS.contains(identifier.toString());
    }

    public static boolean isGraveyardLootChest(Identifier identifier) {
        return ChestLootTableGroups.GRAVEYARD_LOOT_CHESTS.contains(identifier.toString());
    }

    public static boolean isDesertPyramid(Identifier identifier) {
        return ChestLootTableGroups.DESERT_PYRAMID_CHESTS.contains(identifier.toString());
    }

    public static boolean isSimpleDungeonChest(Identifier identifier) {
        return ChestLootTableGroups.SIMPLE_DUNGEON_CHESTS.contains(identifier.toString());
    }

    public static boolean isBattleTowerDefaultChest(Identifier identifier) {
        return identifier.toString().equals("battletowers:default");
    }

    public static boolean isBattleTowerBlacksmithChest(Identifier identifier) {
        return identifier.toString().equals("battletowers:stone/blacksmith");
    }

    public static boolean isBattleTowerLakeChest(Identifier identifier) {
        return identifier.toString().equals("battletowers:stone/lake");
    }

    // == ORES AND BLOCKS ==

    public static boolean isDiamondOre(Identifier identifier) {
        return OreLootTableGroups.DIAMOND_ORES.contains(identifier.toString());
    }

    public static boolean isLapisOre(Identifier identifier) {
        return OreLootTableGroups.LAPIS_ORES.contains(identifier.toString());
    }

    public static boolean isSpawner(Identifier identifier) {
        return BlockLootTableGroups.SPAWNERS.contains(identifier.toString());
    }

    // == GAMEPLAY ==

    public static boolean isFishingTreasure(Identifier identifier) {
        return GameplayLootTableGroups.FISHING_TREASURES.contains(identifier.toString());
    }

    // == MOBS ==

    public static boolean isEnderman(Identifier identifier) {
        return MobLootTableGroups.ENDERMAN.contains(identifier.toString());
    }

    public static boolean isWitch(Identifier identifier) {
        return MobLootTableGroups.WITCH.contains(identifier.toString());
    }

    public static boolean isEvoker(Identifier identifier) {
        return MobLootTableGroups.EVOKER.contains(identifier.toString());
    }

    public static boolean isShulker(Identifier identifier) {
        return MobLootTableGroups.SHULKER.contains(identifier.toString());
    }

    public static boolean isEnderDragon(Identifier identifier) {
        return MobLootTableGroups.ENDER_DRAGON.contains(identifier.toString());
    }

    public static boolean isGuardian(Identifier identifier) {
        return MobLootTableGroups.GUARDIAN.contains(identifier.toString());
    }

    public static boolean isHusk(Identifier identifier) {
        return MobLootTableGroups.HUSK.contains(identifier.toString());
    }

    public static boolean isWitherSkeleton(Identifier identifier) {
        return MobLootTableGroups.WITHER_SKELETON.contains(identifier.toString());
    }

    public static boolean isStray(Identifier identifier) {
        return MobLootTableGroups.STRAY.contains(identifier.toString());
    }

    public static boolean isDrowned(Identifier identifier) {
        return MobLootTableGroups.DROWNED.contains(identifier.toString());
    }

    public static boolean isZombie(Identifier identifier) {
        return MobLootTableGroups.ZOMBIE.contains(identifier.toString());
    }

    public static boolean isPhantom(Identifier identifier) {
        return MobLootTableGroups.PHANTOM.contains(identifier.toString());
    }

    public static boolean isHostileWaterMob(Identifier identifier) {
        return MobLootTableGroups.WITCH.contains(identifier.toString())
            || MobLootTableGroups.GUARDIAN.contains(identifier.toString());
    }
}