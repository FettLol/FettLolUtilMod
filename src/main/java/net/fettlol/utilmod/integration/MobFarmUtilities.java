package net.fettlol.utilmod.integration;

import com.google.common.collect.Lists;
import net.fettlol.lib.registry.RecipeApi;
import net.fettlol.utilmod.UtilMod;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.RecipeHelper;
import net.fettlol.utilmod.util.RegistryHelper;
import net.minecraft.util.Identifier;

public class MobFarmUtilities {

    public static void init() {
        if (FettlolModIntegrations.isMobFarmUtilitiesLoaded) {
            LogHelper.log("Mob Farm Utilities detected! Applying integrations!");

            if (FettlolModIntegrations.isTechRebornLoaded) {
                replaceExperienceCollectorRecipe();
                replaceFanBladeRecipe();
                replaceFanRecipe();
                replaceItemCollectorRecipe();
            }

        }
    }

    private static void replaceFanBladeRecipe() {
        RecipeApi.remove(Mods.MOB_FARM_UTILITIES, "fan_blade");

        RecipeApi.add(
            RegistryHelper.fettlolId("mobfarmutilities/fan_blade"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S', 'B'),
                Lists.newArrayList(
                    new Identifier(Mods.TECH_REBORN, "iron_plate"),
                    new Identifier("minecraft", "iron_bars")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" S ", "SBS", " S "),
                new Identifier(Mods.MOB_FARM_UTILITIES, "fan_blade")
            )
        );
    }

    private static void replaceFanRecipe() {
        RecipeApi.remove(Mods.MOB_FARM_UTILITIES, "fan");

        RecipeApi.add(
            RegistryHelper.fettlolId("mobfarmutilities/fan"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('B', 'C', 'S', 'R'),
                Lists.newArrayList(
                    new Identifier(Mods.MOB_FARM_UTILITIES, "fan_blade"),
                    new Identifier(Mods.TECH_REBORN, "advanced_machine_casing"),
                    new Identifier(Mods.TECH_REBORN, "steel_plate"),
                    new Identifier("minecraft", "redstone")
                ),
                Lists.newArrayList("item", "item", "item", "item"),
                Lists.newArrayList("SBS", "SRS", "SCS"),
                new Identifier(Mods.MOB_FARM_UTILITIES, "fan")
            )
        );
    }

    private static void replaceItemCollectorRecipe() {
        RecipeApi.remove(Mods.MOB_FARM_UTILITIES, "item_collector");

        RecipeApi.add(
            RegistryHelper.fettlolId("mobfarmutilities/item_collector"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('J', 'H', 'M', 'R'),
                Lists.newArrayList(
                    new Identifier(UtilMod.MOD_ID, "jade_gem"),
                    new Identifier("minecraft", "hopper"),
                    new Identifier(Mods.TECH_REBORN, "industrial_machine_frame"),
                    new Identifier(Mods.RING_OF_ATTRACTION, "ring_of_attraction")
                ),
                Lists.newArrayList("item", "item", "item", "item"),
                Lists.newArrayList("JRJ", "HMH", "   "),
                new Identifier(Mods.MOB_FARM_UTILITIES, "item_collector")
            )
        );
    }

    private static void replaceExperienceCollectorRecipe() {
        RecipeApi.remove(Mods.MOB_FARM_UTILITIES, "experience_collector");

        RecipeApi.add(
            RegistryHelper.fettlolId("mobfarmutilities/experience_collector"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('B', 'S', 'M'),
                Lists.newArrayList(
                    new Identifier("minecraft", "iron_bars"),
                    new Identifier(UtilMod.MOD_ID, "soul_shard"),
                    new Identifier(Mods.TECH_REBORN, "industrial_machine_frame")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("BBB", "SMS", "BBB"),
                new Identifier(Mods.MOB_FARM_UTILITIES, "experience_collector")
            )
        );
    }

}
