package net.fettlol.init;

import net.fettlol.integration.*;
import net.fabricmc.loader.api.FabricLoader;

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

    // Namespaces used by various mods.
    final public static String APPLIED_ENERGISTICS = "appliedenergistics2";
    final public static String BETTER_END = "betterend";
    final public static String BYG = "byg";
    final public static String BATTLETOWERS = "battletowers";
    final public static String CINDERSCAPES = "cinderscapes";
    final public static String CRIMSON_MOON = "crimsonmoon";
    final public static String CROPTOPIA = "croptopia";
    final public static String DANKSTORAGE = "dankstorage";
    final public static String GILDEDNETHERITE = "gildednetherite";
    final public static String MCDA = "mcda";
    final public static String MCDW = "mcdw";
    final public static String TECH_REBORN = "techreborn";
    final public static String MIDAS_HUNGER = "midashunger";
    final public static String RING_OF_ATTRACTION = "ring_of_attraction";
    final public static String TINY_TWEAKS = "tinytweaks";
    final public static String WINGED = "winged";

    // Helper methods to test if specific mods are loaded.
    public static boolean isAppliedEnergisticsLoaded = FabricLoader.getInstance().isModLoaded(APPLIED_ENERGISTICS);
    public static boolean isBattletowersLoaded = FabricLoader.getInstance().isModLoaded(BATTLETOWERS);
    public static boolean isBetterEndLoaded = FabricLoader.getInstance().isModLoaded(BETTER_END);
    public static boolean isBygLoaded = FabricLoader.getInstance().isModLoaded(BYG);
    public static boolean isCinderscapesLoaded = FabricLoader.getInstance().isModLoaded(CINDERSCAPES);
    public static boolean isCrimsonMoonLoaded = FabricLoader.getInstance().isModLoaded(CRIMSON_MOON);
    public static boolean isTechRebornLoaded = FabricLoader.getInstance().isModLoaded(TECH_REBORN);
    public static boolean isCroptopiaLoaded = FabricLoader.getInstance().isModLoaded(CROPTOPIA);
    public static boolean isDankStorageLoaded = FabricLoader.getInstance().isModLoaded(DANKSTORAGE);
    public static boolean isGildedNetheriteLoaded = FabricLoader.getInstance().isModLoaded(GILDEDNETHERITE);
    public static boolean isMcdaLoaded = FabricLoader.getInstance().isModLoaded(MCDA);
    public static boolean isMcdwLoaded = FabricLoader.getInstance().isModLoaded(MCDW);
    public static boolean isMidasHungerLoaded = FabricLoader.getInstance().isModLoaded(MIDAS_HUNGER);
    public static boolean isRingOfAttractionLoaded = FabricLoader.getInstance().isModLoaded(RING_OF_ATTRACTION);
    public static boolean isTinyTweaksLoaded = FabricLoader.getInstance().isModLoaded(TINY_TWEAKS);
    public static boolean isWingedLoaded = FabricLoader.getInstance().isModLoaded(WINGED);

    public static void init() {
        Battletowers.init();
        BetterEnd.init();
        BiomesYoullGo.init();
        Cinderscapes.init();
        Croptopia.init();
        DankStorage.init();
        MidasHunger.init();
        RingOfAttraction.init();
        Winged.init();
    }

}
