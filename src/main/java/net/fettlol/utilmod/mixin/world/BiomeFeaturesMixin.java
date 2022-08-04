package net.fettlol.utilmod.mixin.world;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public abstract class BiomeFeaturesMixin {

    // Add Guardians in all Oceans.
    @Inject(method = "addWarmOceanMobs", at = @At("TAIL"))
    private static void spawnGuardiansInWarmOceans(SpawnSettings.Builder builder, int squidWeight, int squidMinGroupSize, CallbackInfo ci) {
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.GUARDIAN, 1, 1, 1));
    }

}
