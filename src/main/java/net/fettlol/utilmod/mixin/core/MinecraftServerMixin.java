package net.fettlol.utilmod.mixin.core;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Like PlayerManagerMixin, this file hooks into a number of core features
 * of the game so that we can add things to them when the need arises.
 */
@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

    @Inject(method = "loadWorld", at = @At("HEAD"))
    protected void hookBeforeLoadWorld(CallbackInfo ci) {
        // Nothing here right now.
    }

    @Inject(method = "loadWorld", at = @At("RETURN"))
    protected void hookAfterLoadWorld(CallbackInfo ci) {
        // Nothing here right now.
    }

    @Inject(method = "save", at = @At("HEAD"))
    protected void hookBeforeSaveWorld(boolean suppressLogs, boolean flush, boolean force, CallbackInfoReturnable<Boolean> cir) {
        // Nothing here right now.
    }

    @Inject(method = "save", at = @At("RETURN"))
    protected void hookAfterSaveWorld(boolean suppressLogs, boolean flush, boolean force, CallbackInfoReturnable<Boolean> cir) {
        // Nothing here right now.
    }

}
