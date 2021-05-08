package net.fettlol.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fettlol.UtilMod;
import net.fettlol.worldgen.biome.Fettlands;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;

public class FettlolBiomes {

    public static void init() {
        if (UtilMod.CONFIG.generateFettlandsBiome()) {
            Registry.register(
                BuiltinRegistries.CONFIGURED_SURFACE_BUILDER,
                new Identifier(UtilMod.MOD_ID, "fettland_surface_builder"),
                Fettlands.FETTLAND_SURFACE_BUILDER
            );

            Registry.register(BuiltinRegistries.BIOME, Fettlands.FETTLAND_KEY.getValue(), Fettlands.FETTLAND);

            OverworldBiomes.addContinentalBiome(Fettlands.FETTLAND_KEY, OverworldClimate.TEMPERATE, 0.05D);

            modifyFettlandsBiome();
        }
    }

    /**
     * This method takes the now-registered Fettlands biome and modifies it by adding a number of
     * configured features from external mods, if they are detected. This is done here to separate
     * it from the "base" configuration done in worldgen.biome.Fettlands.
     */
    private static void modifyFettlandsBiome() {
        if (ModIntegrations.isTraverseLoaded) {
            BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Fettlands.FETTLAND_KEY),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("traverse", "lush_flowers"))
            );
        }

        if (ModIntegrations.isBygLoaded) {
            BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Fettlands.FETTLAND_KEY),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("byg", "white_sage"))
            );

            BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Fettlands.FETTLAND_KEY),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("byg", "blue_berry_bush"))
            );

            BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Fettlands.FETTLAND_KEY),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("byg", "cryptic_caves"))
            );
        }
    }

}
