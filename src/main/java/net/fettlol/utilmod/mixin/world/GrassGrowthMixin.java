package net.fettlol.utilmod.mixin.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Random;

@Mixin(SpreadableBlock.class)
public abstract class GrassGrowthMixin {

    @Inject(
        method = "randomTick",
        at = @At(value = "INVOKE", target = "net/minecraft/block/SpreadableBlock.getDefaultState()Lnet/minecraft/block/BlockState;"),
        cancellable = true,
        locals = LocalCapture.CAPTURE_FAILHARD
    )
    public void growGrass(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if (state.getBlock() == Blocks.GRASS_BLOCK) {
            if (grassSpawnCriteriaAreMet(world, pos, random)) {
                world.setBlockState(pos.up(), Blocks.GRASS.getDefaultState());
                ci.cancel();
            }
        }
    }

    private boolean grassSpawnCriteriaAreMet(ServerWorld world, BlockPos pos, Random random) {
        // Spawn criteria: Grass block has sky access and a random roll of one in ten thousand.
        return world.isSkyVisible(pos.up()) && random.nextFloat() < 0.0001F;
    }

}