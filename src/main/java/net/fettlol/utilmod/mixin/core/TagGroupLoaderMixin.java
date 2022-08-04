package net.fettlol.utilmod.mixin.core;

import net.fettlol.utilmod.registry.TagApi;
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
import java.util.Set;

@Mixin(TagGroupLoader.class)
public class TagGroupLoaderMixin {

    @Final
    @Shadow
    private String dataType;

    @Inject(method = "loadTags", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void loadTags(ResourceManager rm, CallbackInfoReturnable<Map<Identifier, Tag.Builder>> ci, Map<Identifier, Tag.Builder> map) {
        apply(dataType, map);
    }

    private static void apply(String entry, Map<Identifier, Tag.Builder> tagsMap) {
        Map<Identifier, Set<Identifier>> fettlolTags = null;

        if (entry.equals("tags/items")) {
            fettlolTags = TagApi.buildItemTags();
        }

        if (fettlolTags != null) {
            fettlolTags.forEach((id, ids) ->
                tagsMap.compute(id, (k, v) ->
                    v == null
                        ? apply(Tag.Builder.create(), ids)
                        : apply(v, ids)));
        }
    }

    private static Tag.Builder apply(Tag.Builder builder, Set<Identifier> ids) {
        ids.forEach((value) -> builder.add(value, "Fettlol Library"));
        return builder;
    }


}