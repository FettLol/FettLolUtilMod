package net.fettlol.utilmod.integration;

import net.fettlol.utilmod.UtilMod;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.registry.RecipeApi;

public class MobFarmUtilities {

    public static void init() {
        if (FettlolModIntegrations.isMobFarmUtilitiesLoaded) {
            UtilMod.LOGGER.info("Mob Farm Utilities detected! Applying integrations!");

            if (FettlolModIntegrations.isTechRebornLoaded) {
                RecipeApi.remove(FettlolModIntegrations.MOB_FARM_UTILITIES, "experience_collector");
                RecipeApi.remove(FettlolModIntegrations.MOB_FARM_UTILITIES, "fan_blade");
                RecipeApi.remove(FettlolModIntegrations.MOB_FARM_UTILITIES, "fan");
                RecipeApi.remove(FettlolModIntegrations.MOB_FARM_UTILITIES, "item_collector");
            }

        }
    }

}
