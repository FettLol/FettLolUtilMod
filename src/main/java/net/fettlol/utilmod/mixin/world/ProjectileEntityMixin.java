package net.fettlol.utilmod.mixin.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ProjectileEntity.class)
public abstract class ProjectileEntityMixin extends Entity {
    public ProjectileEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "onBlockHit(Lnet/minecraft/util/hit/BlockHitResult;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;onProjectileHit(Lnet/minecraft/world/World;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/hit/BlockHitResult;Lnet/minecraft/entity/projectile/ProjectileEntity;)V"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void sandComicallyRealizesTheresNoFloor(BlockHitResult hitResult, CallbackInfo ci, BlockState state) {
        BlockPos pos = hitResult.getBlockPos();
        Block block = state.getBlock();

        if (scheduleFall(pos, block, 1)) {
            BlockPos.Mutable neighborPos = new BlockPos.Mutable();

            // schedule all neighbors too
            for (var dir : Direction.values()) {
                neighborPos.set(pos, dir);
                Block neighborBlock = world.getBlockState(neighborPos).getBlock();

                scheduleFall(neighborPos, neighborBlock, 2);
            }
        }
    }

    /** Wile E. Coyote's Gravity Lessons */
    @Unique
    private boolean scheduleFall(BlockPos pos, Block block, int delay) {
        if (!(block instanceof FallingBlock)) return false;

        world.getBlockTickScheduler().schedule(pos, block, delay);
        return true;
    }
}
