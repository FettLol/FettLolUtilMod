package net.fettlol.mixin.world;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Random;

@Mixin(SpreadableBlock.class)
public class GrassSpreadMixin {
    @Inject(method = "randomTick", at = @At(value = "INVOKE", target = "net/minecraft/block/SpreadableBlock.getDefaultState()Lnet/minecraft/block/BlockState;"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    public void growGrass(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if (state.getBlock() == Blocks.GRASS_BLOCK) {
            Block above = world.getBlockState(pos.up()).getBlock();
            int friends = 1;

            for (int x = -1; x <= 1; x++) {
                for (int y = 0; y <= 1; y++) {
                    for (int z = -1; z <= 1; z++) {
                        Block friend = world.getBlockState(pos.add(x, y, z)).getBlock();
                        if (friend instanceof FernBlock || friend instanceof TallPlantBlock) {
                            friends++;
                            friends *= 1.75;
                        }
                    }
                }
            }

            if (above == Blocks.AIR && random.nextFloat() < 0.001D * friends) {
                world.setBlockState(pos.up(), Blocks.GRASS.getDefaultState());
                ci.cancel();
            }

        }
    }
}