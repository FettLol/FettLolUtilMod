package net.fettlol.integration;

import com.google.common.collect.Lists;
import net.fettlol.UtilMod;
import net.fettlol.init.FettlolRecipes;
import net.fettlol.init.ModIntegrations;
import net.fettlol.lists.Integrations;
import net.fettlol.util.RecipeHelper;
import net.minecraft.util.Identifier;

public class MobFarmUtilities {

    public static void init() {
        if (ModIntegrations.isMobFarmUtilitiesLoaded) {
            UtilMod.LOGGER.info("Mob Farm Utilities detected! Applying integrations!");

            if (ModIntegrations.isTechRebornLoaded) {
                replaceExperienceCollectorRecipe();
                replaceFanBladeRecipe();
                replaceFanRecipe();
                replaceItemCollectorRecipe();
            }

        }
    }

    private static void replaceFanBladeRecipe() {
        RecipeHelper.removeRecipe(Integrations.MOB_FARM_UTILITIES, "fan_blade");

        FettlolRecipes.CUSTOM_RECIPES.put(
            "mobfarmutilities/fan_blade",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S', 'B'),
                Lists.newArrayList(
                    new Identifier(Integrations.TECH_REBORN, "iron_plate"),
                    new Identifier("minecraft", "iron_bars")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" S ", "SBS", " S "),
                new Identifier(Integrations.MOB_FARM_UTILITIES, "fan_blade")
            )
        );
    }

    private static void replaceFanRecipe() {
        RecipeHelper.removeRecipe(Integrations.MOB_FARM_UTILITIES, "fan");

        FettlolRecipes.CUSTOM_RECIPES.put(
            "mobfarmutilities/fan",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('B', 'C', 'S', 'R'),
                Lists.newArrayList(
                    new Identifier(Integrations.MOB_FARM_UTILITIES, "fan_blade"),
                    new Identifier(Integrations.TECH_REBORN, "advanced_machine_casing"),
                    new Identifier(Integrations.TECH_REBORN, "steel_plate"),
                    new Identifier("minecraft", "redstone")
                ),
                Lists.newArrayList("item", "item", "item", "item"),
                Lists.newArrayList("SBS", "SRS", "SCS"),
                new Identifier(Integrations.MOB_FARM_UTILITIES, "fan")
            )
        );
    }

    private static void replaceItemCollectorRecipe() {
        RecipeHelper.removeRecipe(Integrations.MOB_FARM_UTILITIES, "item_collector");

        FettlolRecipes.CUSTOM_RECIPES.put(
            "mobfarmutilities/item_collector",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('J', 'H', 'M', 'R'),
                Lists.newArrayList(
                    new Identifier(UtilMod.MOD_ID, "jade_gem"),
                    new Identifier("minecraft", "hopper"),
                    new Identifier(Integrations.TECH_REBORN, "industrial_machine_frame"),
                    new Identifier(Integrations.RING_OF_ATTRACTION, "ring_of_attraction")
                ),
                Lists.newArrayList("item", "item", "item", "item"),
                Lists.newArrayList("JRJ", "HMH", "   "),
                new Identifier(Integrations.MOB_FARM_UTILITIES, "item_collector")
            )
        );
    }

    private static void replaceExperienceCollectorRecipe() {
        RecipeHelper.removeRecipe(Integrations.MOB_FARM_UTILITIES, "experience_collector");

        FettlolRecipes.CUSTOM_RECIPES.put(
            "mobfarmutilities/experience_collector",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('B', 'S', 'M'),
                Lists.newArrayList(
                    new Identifier("minecraft", "iron_bars"),
                    new Identifier(UtilMod.MOD_ID, "soul_shard"),
                    new Identifier(Integrations.TECH_REBORN, "industrial_machine_frame")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("BBB", "SMS", "BBB"),
                new Identifier(Integrations.MOB_FARM_UTILITIES, "experience_collector")
            )
        );
    }

}
