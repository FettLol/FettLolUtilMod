package net.fettlol.integration;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.UtilMod;
import net.fettlol.init.FettlolRecipes;
import net.fettlol.init.FettlolModIntegrations;
import net.fettlol.lists.Mods;
import net.fettlol.util.LootTableHelper;
import net.fettlol.util.RecipeHelper;
import net.minecraft.util.Identifier;

public class Winged {

    public static void init() {
        if (FettlolModIntegrations.isWingedLoaded) {
            UtilMod.LOGGER.info("Winged detected! Applying integrations!");

            removeRecipes();

            replaceCoreOfFlightRecipe();

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // 1% Chance of finding a random set of Wings in End City chests
                if (LootTableHelper.isEndEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.01F, Mods.WINGED, "wing_random");
                }
            });
        }
    }

    /**
     * Winged adds a bunch of items we are not interested in. This removes the recipes for those items.
     */
    public static void removeRecipes() {
        RecipeHelper.removeRecipe(Mods.WINGED, "booster_empty_left");
        RecipeHelper.removeRecipe(Mods.WINGED, "booster_empty_right");
        RecipeHelper.removeRecipe(Mods.WINGED, "booster_fast");
        RecipeHelper.removeRecipe(Mods.WINGED, "booster_slow");
        RecipeHelper.removeRecipe(Mods.WINGED, "booster_standard");
        RecipeHelper.removeRecipe(Mods.WINGED, "forward_launcher");
        RecipeHelper.removeRecipe(Mods.WINGED, "fuel_pellet_fast");
        RecipeHelper.removeRecipe(Mods.WINGED, "fuel_pellet_slow");
        RecipeHelper.removeRecipe(Mods.WINGED, "fuel_pellet_standard");
        RecipeHelper.removeRecipe(Mods.WINGED, "glue_broken_heart_of_the_sky");
        RecipeHelper.removeRecipe(Mods.WINGED, "heart_of_the_sky");
        RecipeHelper.removeRecipe(Mods.WINGED, "speedometer");
    }

    /**
     * The Core of Flight recipe is too easy to get in early game. This makes for a significantly
     * harder time to get your wings up and running.
     */
    private static void replaceCoreOfFlightRecipe() {
        // Remove existing recipe.
        RecipeHelper.removeRecipe(Mods.WINGED, "glue_broken_core_of_flight");

        // Add new recipe.
        FettlolRecipes.CUSTOM_RECIPES.put(
            "winged/core_of_flight",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('A','B','E','S','P'),
                Lists.newArrayList(
                    new Identifier(UtilMod.MOD_ID, "aquamarine_gem"),
                    new Identifier(Mods.WINGED, "broken_core_of_flight"),
                    new Identifier("minecraft", "ender_eye"),
                    new Identifier("minecraft", "shulker_shell"),
                    new Identifier("minecraft", "phantom_membrane")
                ),
                Lists.newArrayList("item", "item", "item", "item", "item"),
                Lists.newArrayList("PSP", "EBE", "ASA"),
                new Identifier(Mods.WINGED, "core_of_flight")
            )
        );
    }
}
