package net.fettlol.utilmod.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * Disable the experimental settings warning.
 *
 * @todo reenable this for 1.18.2
 */
@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

    @ModifyVariable(
        method = "startIntegratedServer(Ljava/lang/String;Lnet/minecraft/util/registry/DynamicRegistryManager$Impl;Ljava/util/function/Function;Lcom/mojang/datafixers/util/Function4;ZLnet/minecraft/client/MinecraftClient$WorldLoadAction;)V",
        at = @At("STORE"),
        ordinal = 2 // includes safeMode parameter
    )
    private boolean skipExperimentalSettingsWarning(boolean isExperimentalLifecycle) {
        return false;
    }

}
