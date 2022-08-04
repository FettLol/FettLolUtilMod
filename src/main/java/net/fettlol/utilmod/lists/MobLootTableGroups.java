package net.fettlol.utilmod.lists;

import java.util.Arrays;
import java.util.List;

public class MobLootTableGroups {
    public static final List<String> DROWNED;
    public static final List<String> ENDERMAN;
    public static final List<String> ENDER_DRAGON;
    public static final List<String> EVOKER;
    public static final List<String> GUARDIAN;
    public static final List<String> HUSK;
    public static final List<String> PHANTOM;
    public static final List<String> SHULKER;
    public static final List<String> SKELETON;
    public static final List<String> STRAY;
    public static final List<String> WITCH;
    public static final List<String> WITHER_SKELETON;
    public static final List<String> ZOMBIE;

    static {
        DROWNED = Arrays.asList("minecraft:entities/drowned");
        ENDERMAN = Arrays.asList("minecraft:entities/enderman");
        ENDER_DRAGON = Arrays.asList("minecraft:entities/ender_dragon");
        EVOKER = Arrays.asList("minecraft:entities/evoker");
        GUARDIAN = Arrays.asList("minecraft:entities/guardian", "minecraft:entities/elder_guardian");
        HUSK = Arrays.asList("minecraft:entities/husk");
        PHANTOM = Arrays.asList("minecraft:entities/phantom");
        SHULKER = Arrays.asList("minecraft:entities/shulker");
        SKELETON = Arrays.asList("minecraft:entities/skeleton");
        STRAY = Arrays.asList("minecraft:entities/stray");
        WITCH = Arrays.asList("minecraft:entities/witch");
        WITHER_SKELETON = Arrays.asList("minecraft:entities/wither_skeleton");
        ZOMBIE = Arrays.asList("minecraft:entities/zombie");
    }
}
