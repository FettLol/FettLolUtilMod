package net.fettlol.utilmod.init;

import net.fabricmc.loader.api.FabricLoader;
import net.fettlol.utilmod.integration.*;
import net.fettlol.utilmod.lists.Mods;

public class FettlolModIntegrations {

    private static boolean isModLoaded(String adorn) {
        return FabricLoader.getInstance().isModLoaded(adorn);
    }

    public static boolean isAdditionalAdditionsLoaded = isModLoaded(Mods.ADDITIONAL_ADDITIONS);
    public static boolean isCroptopiaLoaded = isModLoaded(Mods.CROPTOPIA);
    public static boolean isDankStorageLoaded = isModLoaded(Mods.DANKSTORAGE);
    public static boolean isMidasHungerLoaded = isModLoaded(Mods.MIDAS_HUNGER);
    public static boolean isMobFarmUtilitiesLoaded = isModLoaded(Mods.MOB_FARM_UTILITIES);
    public static boolean isRingOfAttractionLoaded = isModLoaded(Mods.RING_OF_ATTRACTION);
    public static boolean isTechRebornLoaded = isModLoaded(Mods.TECH_REBORN);
    public static boolean isWingedLoaded = isModLoaded(Mods.WINGED);

    public static void init() {
        AdditionalAdditions.init();
        Croptopia.init();
        DankStorage.init();
        MidasHunger.init();
        MobFarmUtilities.init();
        RingOfAttraction.init();
        Winged.init();
    }

}
