package net.fettlol.worldgen.biome;

import net.fettlol.UtilMod;
import net.fettlol.init.ModIntegrations;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class Fettlands {

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> FETTLAND_SURFACE_BUILDER = SurfaceBuilder.DEFAULT
        .withConfig(new TernarySurfaceConfig(
            Blocks.GRASS_BLOCK.getDefaultState(),
            Blocks.DIRT.getDefaultState(),
            Blocks.COARSE_DIRT.getDefaultState()
        ));

    public static final RegistryKey<Biome> FETTLAND_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(UtilMod.MOD_ID, "fettland"));

    public static final Biome FETTLAND = createFettland();

    private static Biome createFettland() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder().playerSpawnFriendly();
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder().surfaceBuilder(FETTLAND_SURFACE_BUILDER);

        // Carve
        generationSettings.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE);

        // Feature
        generationSettings.feature(GenerationStep.Feature.LAKES, ConfiguredFeatures.LAKE_WATER);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.VINES);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PILE_SNOW);
        generationSettings.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, ConfiguredFeatures.BASALT_PILLAR);
        generationSettings.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, ConfiguredFeatures.ICE_PATCH);
        generationSettings.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, ConfiguredFeatures.ICE_SPIKE);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_GRASS_TAIGA);

        // Structure
        generationSettings.structureFeature(ConfiguredStructureFeatures.PILLAGER_OUTPOST);
        generationSettings.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL);

        if (ModIntegrations.isBetterNetherLoaded) {
            spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(
                Registry.ENTITY_TYPE.get(new Identifier("betternether:jungle_skeleton")),
                4, 1, 1
            ));
        }

        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 2, 1, 1));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITHER_SKELETON, 1, 1, 1));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.STRAY, 2, 1, 1));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 3, 1, 3));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 1, 1, 2));

        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addDefaultVegetation(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addExtraGoldOre(generationSettings);
        DefaultBiomeFeatures.addForestGrass(generationSettings);
        DefaultBiomeFeatures.addFossils(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addMossyRocks(generationSettings);
        DefaultBiomeFeatures.addSweetBerryBushesSnowy(generationSettings);

        return (new Biome.Builder())
            .precipitation(Biome.Precipitation.SNOW)
            .category(Biome.Category.TAIGA)
            .depth(2F)
            .scale(0.25F)
            .temperature(0.15F)
            .downfall(0.65F)
            .effects((new BiomeEffects.Builder())
                .skyColor(0x333399)
                .fogColor(0x333366)
                .waterFogColor(0xe1e1e1)
                .grassColor(0x009933)
                .foliageColor(0x336600)
                .waterColor(0x666699)
                .build()
            )
            .spawnSettings(spawnSettings.build())
            .generationSettings(generationSettings.build())
            .build();
    }
}
