package net.fettlol.mixin;

import net.fettlol.util.RecipeHelper;
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

    @Inject(method = "onPlayerConnect", at = @At("RETURN"))
    private void hookOnPlayerConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
        RecipeHelper.unlockAllRecipes(player);
    }

    @Inject(method = "loadPlayerData", at = @At("HEAD"))
    private void hookLoadPlayerData(ServerPlayerEntity player, CallbackInfoReturnable<CompoundTag> cir) {
        // Nothing here yet.
    }

    @Inject(method = "savePlayerData", at = @At("RETURN"))
    private void hookSavePlayerData(ServerPlayerEntity player, CallbackInfo ci) {
        // Nothing here yet.
    }

}
