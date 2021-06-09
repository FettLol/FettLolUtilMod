package net.fettlol.init;

import net.fettlol.util.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;

public class FettlolBlocks {

    // Init & Settings
    public static void init() {
        RegistryHelper.register(Registry.BLOCK, Block.class, Blocks.class);
    }

}