package net.fettlol.utilmod.integration;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.lib.helper.LootTableHelper;
import net.fettlol.lib.registry.LootApi;
import net.fettlol.lib.registry.RecipeApi;
import net.fettlol.utilmod.UtilMod;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.RecipeHelper;
import net.fettlol.utilmod.util.RegistryHelper;
import net.minecraft.util.Identifier;

public class Winged {

    public static void init() {
        if (FettlolModIntegrations.isWingedLoaded) {
            LogHelper.log("Winged detected! Applying integrations!");

            removeRecipes();

            replaceCoreOfFlightRecipe();

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // "End" Endgame: Add Random Wings (1%).
                if (LootTableHelper.isEndEndgameChest(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.01F, Mods.WINGED, "wing_random");
                }

            });
        }
    }

    /**
     * Remove basically all of the recipes that Winged adds since we don't want the boosters, we don't want
     * to build wings using the new Crafting bench, etc, etc.
     */
    public static void removeRecipes() {

        RecipeApi.remove(Mods.WINGED, "booster_empty_left");
        RecipeApi.remove(Mods.WINGED, "booster_empty_right");
        RecipeApi.remove(Mods.WINGED, "booster_fast");
        RecipeApi.remove(Mods.WINGED, "booster_slow");
        RecipeApi.remove(Mods.WINGED, "booster_standard");
        RecipeApi.remove(Mods.WINGED, "forward_launcher");
        RecipeApi.remove(Mods.WINGED, "fuel_pellet_fast");
        RecipeApi.remove(Mods.WINGED, "fuel_pellet_slow");
        RecipeApi.remove(Mods.WINGED, "fuel_pellet_standard");
        RecipeApi.remove(Mods.WINGED, "heart_of_the_sky");
        RecipeApi.remove(Mods.WINGED, "heart_of_the_sky_25");
        RecipeApi.remove(Mods.WINGED, "heart_of_the_sky_50");
        RecipeApi.remove(Mods.WINGED, "wing_angel");
        RecipeApi.remove(Mods.WINGED, "wing_angel_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_bat");
        RecipeApi.remove(Mods.WINGED, "wing_bat_alt");
        RecipeApi.remove(Mods.WINGED, "wing_bat_alt_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_bat_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_brazil");
        RecipeApi.remove(Mods.WINGED, "wing_brazil_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_cobalt_cape");
        RecipeApi.remove(Mods.WINGED, "wing_cobalt_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_creamy_white");
        RecipeApi.remove(Mods.WINGED, "wing_creamy_white_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_crowdin_cape");
        RecipeApi.remove(Mods.WINGED, "wing_crowdin_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_dannybstyle_cape");
        RecipeApi.remove(Mods.WINGED, "wing_dannybstyle_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_demon");
        RecipeApi.remove(Mods.WINGED, "wing_demon_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_dragonfly");
        RecipeApi.remove(Mods.WINGED, "wing_dragonfly_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_eagle");
        RecipeApi.remove(Mods.WINGED, "wing_eagle_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_earth");
        RecipeApi.remove(Mods.WINGED, "wing_earth_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_black");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_black_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_blue");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_blue_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_brown");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_brown_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_cyan");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_cyan_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_gray");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_gray_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_green");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_green_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_light_blue");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_light_blue_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_light_gray");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_light_gray_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_lime");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_lime_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_magenta");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_magenta_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_orange");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_orange_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_pink");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_pink_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_purple");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_purple_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_red");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_red_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_white");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_white_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_yellow");
        RecipeApi.remove(Mods.WINGED, "wing_elytra_yellow_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_fairyonline");
        RecipeApi.remove(Mods.WINGED, "wing_fairyonline_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_fire_dragon");
        RecipeApi.remove(Mods.WINGED, "wing_fire_dragon_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_fried_chicken");
        RecipeApi.remove(Mods.WINGED, "wing_fried_chicken_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_glass");
        RecipeApi.remove(Mods.WINGED, "wing_glass_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_glider");
        RecipeApi.remove(Mods.WINGED, "wing_glider_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_golden_beetle");
        RecipeApi.remove(Mods.WINGED, "wing_golden_beetle_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_green_beetle");
        RecipeApi.remove(Mods.WINGED, "wing_green_beetle_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_green_dragon");
        RecipeApi.remove(Mods.WINGED, "wing_green_dragon_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_greenwing_macaw");
        RecipeApi.remove(Mods.WINGED, "wing_greenwing_macaw_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_irreality");
        RecipeApi.remove(Mods.WINGED, "wing_irreality_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_julianclark_cape");
        RecipeApi.remove(Mods.WINGED, "wing_julianclark_cape_alt");
        RecipeApi.remove(Mods.WINGED, "wing_julianclark_cape_alt_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_julianclark_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_mapmaker_cape");
        RecipeApi.remove(Mods.WINGED, "wing_mapmaker_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_mech_dragon");
        RecipeApi.remove(Mods.WINGED, "wing_mech_dragon_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_millionth_cape");
        RecipeApi.remove(Mods.WINGED, "wing_millionth_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2011_cape");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2011_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2012_cape");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2012_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2013_cape");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2013_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2015_cape");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2015_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2016_cape");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2016_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2019_cape");
        RecipeApi.remove(Mods.WINGED, "wing_minecon_2019_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_mojang_cape");
        RecipeApi.remove(Mods.WINGED, "wing_mojang_cape_alt");
        RecipeApi.remove(Mods.WINGED, "wing_mojang_cape_alt_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_mojang_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_mojira_mod_cape");
        RecipeApi.remove(Mods.WINGED, "wing_mojira_mod_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_mrmessiah_cape");
        RecipeApi.remove(Mods.WINGED, "wing_mrmessiah_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_phantom");
        RecipeApi.remove(Mods.WINGED, "wing_phantom_alt");
        RecipeApi.remove(Mods.WINGED, "wing_phantom_alt_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_phantom_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_phantom_membrane");
        RecipeApi.remove(Mods.WINGED, "wing_phantom_membrane_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_phoenix");
        RecipeApi.remove(Mods.WINGED, "wing_phoenix_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_prismarine_cape");
        RecipeApi.remove(Mods.WINGED, "wing_prismarine_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_purple_beetle");
        RecipeApi.remove(Mods.WINGED, "wing_purple_beetle_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_rainbow");
        RecipeApi.remove(Mods.WINGED, "wing_rainbow_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_random_1");
        RecipeApi.remove(Mods.WINGED, "wing_random_1_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_random_2");
        RecipeApi.remove(Mods.WINGED, "wing_random_2_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_red_dragon");
        RecipeApi.remove(Mods.WINGED, "wing_red_dragon_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_redstone");
        RecipeApi.remove(Mods.WINGED, "wing_redstone_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_scrolls_cape");
        RecipeApi.remove(Mods.WINGED, "wing_scrolls_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_shulker");
        RecipeApi.remove(Mods.WINGED, "wing_shulker_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_spooky");
        RecipeApi.remove(Mods.WINGED, "wing_spooky_alt");
        RecipeApi.remove(Mods.WINGED, "wing_spooky_alt_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_spooky_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_tiny_bird");
        RecipeApi.remove(Mods.WINGED, "wing_tiny_bird_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_tnt");
        RecipeApi.remove(Mods.WINGED, "wing_tnt_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_turtle_cape");
        RecipeApi.remove(Mods.WINGED, "wing_turtle_cape_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_usa_1");
        RecipeApi.remove(Mods.WINGED, "wing_usa_1_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_usa_2");
        RecipeApi.remove(Mods.WINGED, "wing_usa_2_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_vex");
        RecipeApi.remove(Mods.WINGED, "wing_vex_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_xmas_star");
        RecipeApi.remove(Mods.WINGED, "wing_xmas_star_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wing_xmas_tree");
        RecipeApi.remove(Mods.WINGED, "wing_xmas_tree_creative_flight");
        RecipeApi.remove(Mods.WINGED, "wingbench");
    }

    /**
     * The Core of Flight recipe is too easy to get in early game. This makes for a significantly
     * harder time to get your wings up and running. First you need to repair a Broken Core of Flight
     * down to level 25, then fix it with this more complex recipe:
     */
    private static void replaceCoreOfFlightRecipe() {
        RecipeApi.remove(Mods.WINGED, "core_of_flight");

        RecipeApi.add(
            RegistryHelper.fettlolId("winged/core_of_flight"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('A','B','E','S','P'),
                Lists.newArrayList(
                    new Identifier(UtilMod.MOD_ID, "aquamarine_gem"),
                    new Identifier(Mods.WINGED, "broken_core_of_flight_25"),
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
