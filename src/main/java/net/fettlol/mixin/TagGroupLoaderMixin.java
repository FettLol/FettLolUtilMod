package net.fettlol.mixin;

import net.fettlol.init.FettlolTags;
import net.minecraft.resource.ResourceManager;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagGroupLoader;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(TagGroupLoader.class)
public class TagGroupLoaderMixin {

    @Final @Shadow
    private String entryType;

    @Inject(
        method = "method_18243", // lambda inside prepareReload
        at = @At("RETURN"),
        locals = LocalCapture.CAPTURE_FAILHARD,
        remap = false
    )
    public void prepareReload(ResourceManager rm, CallbackInfoReturnable<Map<Identifier, Tag.Builder>> ci, Map<Identifier, Tag.Builder> map) {
        FettlolTags.apply(entryType, map);
    }

}