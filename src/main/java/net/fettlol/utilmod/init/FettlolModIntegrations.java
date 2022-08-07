package net.fettlol.utilmod.init;

import net.fabricmc.loader.api.FabricLoader;
import net.fettlol.utilmod.integration.*;

public class FettlolModIntegrations {

    private static boolean isModLoaded(String adorn) {
        return FabricLoader.getInstance().isModLoaded(adorn);
    }

    final public static String ADDITIONAL_ADDITIONS = "additionaladditions";
    final public static String CROPTOPIA = "croptopia";
    final public static String DANKSTORAGE = "dankstorage";
    final public static String MIDAS_HUNGER = "midashunger";
    final public static String MOB_FARM_UTILITIES = "mobfarmutilities";
    final public static String RING_OF_ATTRACTION = "ring_of_attraction";
    final public static String TECH_REBORN = "techreborn";
    final public static String WAYSTONES = "waystones";
    final public static String WINGED = "winged";
    public static boolean isAdditionalAdditionsLoaded = isModLoaded(ADDITIONAL_ADDITIONS);
    public static boolean isCroptopiaLoaded = isModLoaded(CROPTOPIA);
    public static boolean isDankStorageLoaded = isModLoaded(DANKSTORAGE);
    public static boolean isMidasHungerLoaded = isModLoaded(MIDAS_HUNGER);
    public static boolean isMobFarmUtilitiesLoaded = isModLoaded(MOB_FARM_UTILITIES);
    public static boolean isRingOfAttractionLoaded = isModLoaded(RING_OF_ATTRACTION);
    public static boolean isTechRebornLoaded = isModLoaded(TECH_REBORN);
    public static boolean isWaystonesLoaded = isModLoaded(WAYSTONES);
    public static boolean isWingedLoaded = isModLoaded(WINGED);

    public static void init() {
        AdditionalAdditions.init();
        Croptopia.init();
        DankStorage.init();
        MidasHunger.init();
        MobFarmUtilities.init();
        RingOfAttraction.init();
        Winged.init();
        Waystones.init();
    }

}
