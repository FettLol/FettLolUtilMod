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
     * This includes all of the boosters, fuel pellets, Heart of the Sky and the Creative Flight Wings.
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
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_angel_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_bat_alt_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_bat_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_brazil_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_cobalt_cape_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_creamy_white_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_crowdin_cape_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_dannybstyle_cape_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_demon_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_dragonfly_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_eagle_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_earth_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_black_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_blue_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_brown_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_cyan_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_gray_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_green_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_light_blue_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_light_gray_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_lime_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_elytra_orange_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_pink_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_purple_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_red_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_white_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_yellow_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_fairyonline_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_fire_dragon_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_fried_chicken_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_glass_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_glider_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_golden_beetle_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_green_beetle_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_green_dragon_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_greenwing_macaw_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_irreality_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_julianclark_cape_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_julianclark_cape_alt_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_mapmaker_cape_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_mech_dragon_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_millionth_cape_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_minecon_2011_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_minecon_2012_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_minecon_2013_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_minecon_2015_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_minecon_2016_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_minecon_2019_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_mojang_cape_alt_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_mojang_cape_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_mojira_mod_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_mrmessiah_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_phantom_alt_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_phantom_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_phantom_membrane_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_phoenix_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_prismarine_cape_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_purple_beetle_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_rainbow_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_random_1_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_random_2_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_red_dragon_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_redstone_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_scrolls_cape_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_shulker_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_spooky_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_spooky_alt_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_tiny_bird_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_tnt_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_turtle_cape_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_usa_1_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_usa_2_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_vex_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_xmas_star_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wing_xmas_tree_creative_flight");
        RecipeHelper.removeRecipe(Mods.WINGED, "wingbench");
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
