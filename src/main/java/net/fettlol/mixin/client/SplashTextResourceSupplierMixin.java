package net.fettlol.mixin.client;

import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SplashTextResourceSupplier.class)
abstract public class SplashTextResourceSupplierMixin {

    @Final @Shadow private List<String> splashTexts;

    @Inject(at = @At("TAIL"), method = "apply(Ljava/util/List;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V")
    private void apply(List<String> list, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci) {
        splashTexts.add("WOW! SUCH FETT! MUCH LOL! VERY MODPACK");
        splashTexts.add("Brought to you by Breki!");
        splashTexts.add("Fett.lol is dairy-free!");
        splashTexts.add("Fett.lol is grain-free!");
        splashTexts.add("Fett.lol has no artificial additives or preservatives!");
        splashTexts.add("Who's a good boy?");
    }

}
