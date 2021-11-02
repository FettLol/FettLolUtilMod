package net.fettlol.utilmod.mixin.world;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(SpreadableBlock.class)
public abstract class GrassGrowthMixin {

    @Inject(
        method = "randomTick",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;getLightLevel(Lnet/minecraft/util/math/BlockPos;)I", ordinal = 0)
    )
    public void growGrass(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if (state.getBlock() != Blocks.GRASS_BLOCK) return;

        BlockPos up = pos.up();

        // try to grow grass under the sun with a very small chance
        if (world.isAir(up) && world.isSkyVisible(up) && random.nextFloat() < 1 / 10000F) {

            // try to grow tall grass with a small chance
            if (world.isAir(up.up()) && random.nextFloat() < 1 / 20F) {
                TallPlantBlock.placeAt(world, Blocks.TALL_GRASS.getDefaultState(), up, Block.NOTIFY_LISTENERS);
            } else {
                world.setBlockState(up, Blocks.GRASS.getDefaultState(), Block.NOTIFY_LISTENERS);
            }
        }
    }

}