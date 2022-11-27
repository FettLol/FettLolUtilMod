package net.fettlol.utilmod.mixin.world;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

/** Make small flowers ('cept Wither Roses) dupeable as well */
@Mixin(FlowerBlock.class)
public abstract class FlowerBlockMixin implements Fertilizable {
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return state.getBlock() != Blocks.WITHER_ROSE;
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return state.getBlock() != Blocks.WITHER_ROSE;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        Block.dropStack(world, pos, new ItemStack((FlowerBlock) (Object) this));
    }
}
