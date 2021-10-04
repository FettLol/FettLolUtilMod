package net.fettlol.mixin.core;

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

/**
 * This file is required to make sure the various tags defined and used all over the place are actually loaded and/or
 * generated and applied to the various blocks and items they should be applied to. See net.fettlol.init.FettlolTags for
 * more details.
 */
@Mixin(TagGroupLoader.class)
public class TagGroupLoaderMixin {

    @Final
    @Shadow
    private String dataType;

    @Inject(method = "loadTags", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void loadTags(ResourceManager rm, CallbackInfoReturnable<Map<Identifier, Tag.Builder>> ci, Map<Identifier, Tag.Builder> map) {
        FettlolTags.apply(dataType, map);
    }

}