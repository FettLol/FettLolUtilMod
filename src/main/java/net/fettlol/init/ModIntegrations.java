package net.fettlol.init;

import net.fettlol.integration.*;
import net.fabricmc.loader.api.FabricLoader;
import net.fettlol.lists.Integrations;

/**
 * This class is responsible for creating all the integrations between the mods in the modpack.
 * Mostly, this has to do with adding things from the mods to various loot tables or altering
 * their functionality in one way or another. Unfortunately, some of this is still done through
 * the JSON files that define recipes and item/block tags, but this will be moved into the code
 * once I figure out a good way to do so.
 *
 * The individual integration files are stored in the "integration" folder, but all are called
 * from here.
 */
public class ModIntegrations {

    // Helper methods to test if specific mods are loaded.
    public static boolean isAdornLoaded = FabricLoader.getInstance().isModLoaded(Integrations.ADORN);
    public static boolean isAppliedEnergisticsLoaded = FabricLoader.getInstance().isModLoaded(Integrations.APPLIED_ENERGISTICS);
    public static boolean isBattletowersLoaded = FabricLoader.getInstance().isModLoaded(Integrations.BATTLETOWERS);
    public static boolean isBetterEndLoaded = FabricLoader.getInstance().isModLoaded(Integrations.BETTER_END);
    public static boolean isBetterNetherLoaded = FabricLoader.getInstance().isModLoaded(Integrations.BETTER_NETHER);
    public static boolean isBygLoaded = FabricLoader.getInstance().isModLoaded(Integrations.BYG);
    public static boolean isCinderscapesLoaded = FabricLoader.getInstance().isModLoaded(Integrations.CINDERSCAPES);
    public static boolean isCrimsonMoonLoaded = FabricLoader.getInstance().isModLoaded(Integrations.CRIMSON_MOON);
    public static boolean isCroptopiaLoaded = FabricLoader.getInstance().isModLoaded(Integrations.CROPTOPIA);
    public static boolean isDankStorageLoaded = FabricLoader.getInstance().isModLoaded(Integrations.DANKSTORAGE);
    public static boolean isEarth2JavaLoaded = FabricLoader.getInstance().isModLoaded(Integrations.EARTH2JAVA);
    public static boolean isExpandedStorageLoaded = FabricLoader.getInstance().isModLoaded(Integrations.EXPANDEDSTORAGE);
    public static boolean isGildedNetheriteLoaded = FabricLoader.getInstance().isModLoaded(Integrations.GILDEDNETHERITE);
    public static boolean isMcdaLoaded = FabricLoader.getInstance().isModLoaded(Integrations.MCDA);
    public static boolean isMcdwLoaded = FabricLoader.getInstance().isModLoaded(Integrations.MCDW);
    public static boolean isTraverseLoaded = FabricLoader.getInstance().isModLoaded(Integrations.TRAVERSE);
    public static boolean isMidasHungerLoaded = FabricLoader.getInstance().isModLoaded(Integrations.MIDAS_HUNGER);
    public static boolean isMobFarmUtilitiesLoaded = FabricLoader.getInstance().isModLoaded(Integrations.MOB_FARM_UTILITIES);
    public static boolean isRingOfAttractionLoaded = FabricLoader.getInstance().isModLoaded(Integrations.RING_OF_ATTRACTION);
    public static boolean isTechRebornLoaded = FabricLoader.getInstance().isModLoaded(Integrations.TECH_REBORN);
    public static boolean isTerrestriaLoaded = FabricLoader.getInstance().isModLoaded(Integrations.TERRESTRIA);
    public static boolean isTinyTweaksLoaded = FabricLoader.getInstance().isModLoaded(Integrations.TINY_TWEAKS);
    public static boolean isWingedLoaded = FabricLoader.getInstance().isModLoaded(Integrations.WINGED);

    public static void init() {
        Battletowers.init();
        BetterEnd.init();
        BiomesYoullGo.init();
        Cinderscapes.init();
        Croptopia.init();
        DankStorage.init();
        MidasHunger.init();
        MobFarmUtilities.init();
        RingOfAttraction.init();
        Winged.init();
    }

}
