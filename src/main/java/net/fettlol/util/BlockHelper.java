package net.fettlol.util;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.WitherRoseBlock;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class BlockHelper {

    // Small and tall flower tags.
    static Tag<Block> SMALL_FLOWERS = TagRegistry.block(new Identifier("minecraft", "small_flowers"));
    static Tag<Block> TALL_FLOWERS = TagRegistry.block(new Identifier("minecraft", "tall_flowers"));

    // Is this block a flower? (Wither Rose is not considered a flower)
    public static boolean isFlower(Block block) {
        return blockIsNotWitherRose(block) && (SMALL_FLOWERS.contains(block) || TALL_FLOWERS.contains(block));
    }

    private static boolean blockIsNotWitherRose(Block block) {
        return block.getClass() != WitherRoseBlock.class;
    }


}
