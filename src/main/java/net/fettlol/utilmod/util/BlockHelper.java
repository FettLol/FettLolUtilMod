package net.fettlol.utilmod.util;

import net.minecraft.block.Block;
import net.minecraft.block.WitherRoseBlock;
import net.minecraft.tag.BlockTags;

public class BlockHelper {
    public static boolean isFlower(Block block) {
        return blockIsNotWitherRose(block)
            && (block.getDefaultState().isIn(BlockTags.SMALL_FLOWERS) || block.getDefaultState().isIn(BlockTags.TALL_FLOWERS));
    }

    private static boolean blockIsNotWitherRose(Block block) {
        return block.getClass() != WitherRoseBlock.class;
    }
}
