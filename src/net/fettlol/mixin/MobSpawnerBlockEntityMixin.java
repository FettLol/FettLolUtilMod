package net.fettlol.mixin;

import net.fettlol.api.SpawnerInterface;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobSpawnerBlockEntity.class)
public class MobSpawnerBlockEntityMixin implements SpawnerInterface {

    private boolean isPlayerPlaced = false;

    @Inject(method = "toTag", at = @At("HEAD"))
    private void toTag(CompoundTag tag, CallbackInfoReturnable<CompoundTag> cir) {
        tag.putBoolean("IsPlayerPlaced", isPlayerPlaced);
    }

    @Inject(method = "fromTag", at = @At("HEAD"))
    private void fromTag(BlockState state, CompoundTag tag, CallbackInfo ci) {
        this.isPlayerPlaced = tag.getBoolean("IsPlayerPlaced");
    }

    @Override
    public void setPlayerPlaced(boolean value) {
        this.isPlayerPlaced = value;
    }

    @Override
    public boolean isPlayerPlaced() {
        return isPlayerPlaced;
    }
}
