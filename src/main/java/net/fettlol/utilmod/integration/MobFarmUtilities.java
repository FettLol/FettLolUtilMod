package net.fettlol.utilmod.integration;

import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.registry.RecipeApi;
import net.fettlol.utilmod.util.LogHelper;

public class MobFarmUtilities {

    public static void init() {
        if (FettlolModIntegrations.isMobFarmUtilitiesLoaded) {
            LogHelper.log("Mob Farm Utilities detected! Applying integrations!");

            if (FettlolModIntegrations.isTechRebornLoaded) {
                RecipeApi.remove(Mods.MOB_FARM_UTILITIES, "experience_collector");
                RecipeApi.remove(Mods.MOB_FARM_UTILITIES, "fan_blade");
                RecipeApi.remove(Mods.MOB_FARM_UTILITIES, "fan");
                RecipeApi.remove(Mods.MOB_FARM_UTILITIES, "item_collector");
            }

        }
    }

}
