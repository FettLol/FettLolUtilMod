package net.fettlol.utilmod.lists;

import java.util.Arrays;
import java.util.List;

public class OreLootTableGroups {

    public static final List<String> IRON_ORES;
    public static final List<String> GOLD_ORES;
    public static final List<String> COPPER_ORES;
    public static final List<String> DIAMOND_ORES;
    public static final List<String> LAPIS_ORES;

    static {
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

}