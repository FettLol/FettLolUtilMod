package net.fettlol.util;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.WitherRoseBlock;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

/**
 * This file contains various helper methods related to blocks and block entities.
 */
public class BlockHelper {

    static Tag<Block> SMALL_FLOWERS = TagRegistry.block(new Identifier("minecraft", "small_flowers"));
    static Tag<Block> TALL_FLOWERS = TagRegistry.block(new Identifier("minecraft", "tall_flowers"));

    public static boolean isFlower(Block block) {
        return block.getClass() != WitherRoseBlock.class && (SMALL_FLOWERS.contains(block) || TALL_FLOWERS.contains(block));
    }


}
