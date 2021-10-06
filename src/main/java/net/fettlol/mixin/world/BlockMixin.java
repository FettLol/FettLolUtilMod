package net.fettlol.mixin.world;

import net.fettlol.api.SpawnerInterface;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin implements SpawnerInterface {

    @Unique
    boolean fettlol$playerPlaced;

    @Inject(method = "onBreak", at = @At("HEAD"))
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfo ci) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        fettlol$playerPlaced = blockEntity instanceof SpawnerInterface spawnerInterface && spawnerInterface.isPlayerPlaced();
    }

    @Override
    public void setPlayerPlaced(boolean value) {
        fettlol$playerPlaced = value;
    }

    @Override
    public boolean isPlayerPlaced() {
        return fettlol$playerPlaced;
    }
}
