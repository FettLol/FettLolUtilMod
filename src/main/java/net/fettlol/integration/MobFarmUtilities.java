package net.fettlol.integration;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.fettlol.UtilMod;
import net.fettlol.init.ModIntegrations;
import net.fettlol.util.RecipeHelper;
import net.minecraft.util.Identifier;

public class MobFarmUtilities {

    public static JsonObject EXPERIENCE_COLLECTOR = null;

    public static void init() {
        if (ModIntegrations.isMobFarmUtilitiesLoaded) {
            UtilMod.LOGGER.info("Mob Farm Utilities detected! Applying integrations!");


            if (ModIntegrations.isTechRebornLoaded) {
                RecipeHelper.removeRecipe(ModIntegrations.MOB_FARM_UTILITIES, "experience_collector");

                EXPERIENCE_COLLECTOR = RecipeHelper.createShapedRecipe(
                    Lists.newArrayList('B', 'S', 'M'),
                    Lists.newArrayList(
                        new Identifier("minecraft", "iron_bars"),
                        new Identifier(UtilMod.MOD_ID, "soul_shard"),
                        new Identifier(ModIntegrations.TECH_REBORN, "industrial_machine_frame")
                    ),
                    Lists.newArrayList("item", "item", "item"),
                    Lists.newArrayList("BBB", "SMS", "BBB"),
                    new Identifier(ModIntegrations.MOB_FARM_UTILITIES, "experience_collector")
                );
            }

        }
    }

}
