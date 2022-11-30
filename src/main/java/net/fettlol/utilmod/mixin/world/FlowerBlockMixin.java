package net.fettlol.utilmod.mixin.world;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

/** Make (most) small flowers dupeable as well */
@Mixin(FlowerBlock.class)
public abstract class FlowerBlockMixin implements Fertilizable {
    private static boolean isDupeable(Block block) {
        if (block == Blocks.WITHER_ROSE)
            return false;
        if (Registry.BLOCK.getId(block).equals(new Identifier("spectrum", "blood_orchid")))
            return false;
        return true;
    }

    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return isDupeable(state.getBlock());
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return isDupeable(state.getBlock());
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        Block.dropStack(world, pos, new ItemStack((FlowerBlock) (Object) this));
    }
}
