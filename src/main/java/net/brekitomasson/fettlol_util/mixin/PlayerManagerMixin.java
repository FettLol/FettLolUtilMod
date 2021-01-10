package net.brekitomasson.fettlol_util.mixin;

import net.brekitomasson.fettlol_util.module.UnlockAllRecipes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.WorldSaveHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {
    @Shadow
    @Final
    private WorldSaveHandler saveHandler;

    // ==== Hook on Player connect ====
    @Inject(method = "onPlayerConnect", at = @At("RETURN"))
    private void hookOnPlayerConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
        UnlockAllRecipes.unlockRecipes(player);
    }

    // ==== Hook on loading Player data ====
    @Inject(method = "loadPlayerData", at = @At("HEAD"))
    private void hookLoadPlayerData(ServerPlayerEntity player, CallbackInfoReturnable<CompoundTag> cir) {
        // Nothing here yet.
    }

    // ==== Hook on saving Player data ====
    @Inject(method = "savePlayerData", at = @At("RETURN"))
    private void hookSavePlayerData(ServerPlayerEntity player, CallbackInfo ci) {
        // Nothing here yet.
    }

}
