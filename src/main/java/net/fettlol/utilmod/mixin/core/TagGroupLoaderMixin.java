package net.fettlol.utilmod.mixin.core;

import net.fettlol.utilmod.registry.TagApi;
import net.minecraft.resource.ResourceManager;
import net.minecraft.tag.TagEntry;
import net.minecraft.tag.TagGroupLoader;
import net.minecraft.tag.TagGroupLoader.TrackedEntry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Mixin(TagGroupLoader.class)
public class TagGroupLoaderMixin {

    @Final
    @Shadow
    private String dataType;

    @Inject(method = "loadTags", at = @At("RETURN"))
    public void loadTags(ResourceManager rm, CallbackInfoReturnable<Map<Identifier, List<TrackedEntry>>> ci) {
        Map<Identifier, List<TrackedEntry>> map = ci.getReturnValue();

        if (dataType.equals("tags/items")) {
            TagApi.buildItemTags().forEach((tagId, itemIds) ->
                map.compute(tagId, (k, entryList) ->
                    addIdsToEntryList(entryList == null ? new ArrayList<>(itemIds.size()) : entryList, itemIds)));
        }
    }

    private static List<TrackedEntry> addIdsToEntryList(List<TrackedEntry> entryList, Set<Identifier> ids) {
        ids.forEach((value) -> entryList.add(new TrackedEntry(TagEntry.create(value), "Fettlol Library")));
        return entryList;
    }

}