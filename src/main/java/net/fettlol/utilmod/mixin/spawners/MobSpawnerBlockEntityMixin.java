package net.fettlol.utilmod.mixin.spawners;

import net.fettlol.utilmod.api.SpawnerInterface;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobSpawnerBlockEntity.class)
public class MobSpawnerBlockEntityMixin implements SpawnerInterface {

    private boolean isPlayerPlaced = false;

    @Inject(method = "writeNbt", at = @At("HEAD"))
    private void writeNbt(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        nbt.putBoolean("IsPlayerPlaced", isPlayerPlaced);
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    private void readNbt(NbtCompound nbt, CallbackInfo ci) {
        this.isPlayerPlaced = nbt.getBoolean("IsPlayerPlaced");
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
