package net.fettlol.init;

import net.fettlol.integration.*;
import net.fabricmc.loader.api.FabricLoader;
import net.fettlol.lists.Mods;

public class FettlolModIntegrations {

    private static boolean isModLoaded(String adorn) {
        return FabricLoader.getInstance().isModLoaded(adorn);
    }

    public static boolean isAdditionalAdditionsLoaded = isModLoaded(Mods.ADDITIONAL_ADDITIONS);
    public static boolean isAdornLoaded = isModLoaded(Mods.ADORN);
    public static boolean isAppliedEnergisticsLoaded = isModLoaded(Mods.APPLIED_ENERGISTICS);
    public static boolean isBattletowersLoaded = isModLoaded(Mods.BATTLETOWERS);
    public static boolean isBetterEndLoaded = isModLoaded(Mods.BETTER_END);
    public static boolean isBetterNetherLoaded = isModLoaded(Mods.BETTER_NETHER);
    public static boolean isBygLoaded = isModLoaded(Mods.BYG);
    public static boolean isCinderscapesLoaded = isModLoaded(Mods.CINDERSCAPES);
    public static boolean isCrimsonMoonLoaded = isModLoaded(Mods.CRIMSON_MOON);
    public static boolean isCroptopiaLoaded = isModLoaded(Mods.CROPTOPIA);
    public static boolean isDankStorageLoaded = isModLoaded(Mods.DANKSTORAGE);
    public static boolean isEarth2JavaLoaded = isModLoaded(Mods.EARTH2JAVA);
    public static boolean isExpandedStorageLoaded = isModLoaded(Mods.EXPANDEDSTORAGE);
    public static boolean isGildedNetheriteLoaded = isModLoaded(Mods.GILDEDNETHERITE);
    public static boolean isMcdaLoaded = isModLoaded(Mods.MCDA);
    public static boolean isMcdwLoaded = isModLoaded(Mods.MCDW);
    public static boolean isTraverseLoaded = isModLoaded(Mods.TRAVERSE);
    public static boolean isMidasHungerLoaded = isModLoaded(Mods.MIDAS_HUNGER);
    public static boolean isMobFarmUtilitiesLoaded = isModLoaded(Mods.MOB_FARM_UTILITIES);
    public static boolean isRingOfAttractionLoaded = isModLoaded(Mods.RING_OF_ATTRACTION);
    public static boolean isTechRebornLoaded = isModLoaded(Mods.TECH_REBORN);
    public static boolean isTerrestriaLoaded = isModLoaded(Mods.TERRESTRIA);
    public static boolean isTinyTweaksLoaded = isModLoaded(Mods.TINY_TWEAKS);
    public static boolean isWingedLoaded = isModLoaded(Mods.WINGED);

    public static void init() {
        AdditionalAdditions.init();
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
