package net.fettlol.utilmod.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.server.integrated.IntegratedServerLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * Disable the experimental settings warning.
 */
@Environment(EnvType.CLIENT)
@Mixin(IntegratedServerLoader.class)
public abstract class IntegratedServerLoaderMixin {

    @ModifyVariable(
        method = "start(Lnet/minecraft/client/gui/screen/Screen;Ljava/lang/String;ZZ)V",
        at = @At("STORE"),
        ordinal = 3 // includes safeMode and canShowBackupPrompt parameter
    )
    private boolean skipExperimentalSettingsWarning(boolean isExperimentalLifecycle) {
        return false;
    }

}
