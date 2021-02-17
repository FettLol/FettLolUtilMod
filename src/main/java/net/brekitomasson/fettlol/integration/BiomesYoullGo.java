package net.brekitomasson.fettlol.integration;

import com.google.gson.JsonObject;
import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.init.ModIntegrations;
import net.brekitomasson.fettlol.util.LootTableHelper;
import net.brekitomasson.fettlol.util.RecipeHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;

public class BiomesYoullGo {

    // Null definitions for custom recipes that may be applied.
    public static JsonObject AMETRINE_BOOTS_RECIPE = null;
    public static JsonObject AMETRINE_LEGGINGS_RECIPE = null;
    public static JsonObject AMETRINE_HELMET_RECIPE = null;
    public static JsonObject AMETRINE_CHESTPLATE_RECIPE = null;
    public static JsonObject PENDORITE_AXE_RECIPE = null;
    public static JsonObject PENDORITE_HOE_RECIPE = null;
    public static JsonObject PENDORITE_PICKAXE_RECIPE = null;
    public static JsonObject PENDORITE_SHOVEL_RECIPE = null;
    public static JsonObject PENDORITE_SWORD_RECIPE = null;

    /**
     * Initialize the Biomes You'll Go mod integrations!
     */
    public static void init() {
        if (ModIntegrations.isBygLoaded) {
            UtilMod.LOGGER.info("Biomes You'll Go detected! Applying integrations.");

            updateLootTablesForByg();
            defineRecipesForByg();

        }
    }

    /**
     * Biomes You'll Go have a couple of recipes we want to change/update. While defined here, the
     * injection is done in the
     */
    private static void defineRecipesForByg() {
        // The "Gilded Netherite" mod adds an additional tier of Netherite gear. We want to make it available for
        // upgrades to Ametrine and Pendorite, just like the normal Netherite gear.
        if (ModIntegrations.isGildedNetheriteLoaded) {
            // Ametrine Armor Smithing Table Upgrades
            AMETRINE_BOOTS_RECIPE = RecipeHelper.createSmithingRecipe("gildednetherite:gilded_boots", "byg:ametrine_gems", "byg:ametrine_boots");
            AMETRINE_LEGGINGS_RECIPE = RecipeHelper.createSmithingRecipe("gildednetherite:gilded_leggings", "byg:ametrine_gems", "byg:ametrine_leggings");
            AMETRINE_HELMET_RECIPE = RecipeHelper.createSmithingRecipe("gildednetherite:gilded_helmet", "byg:ametrine_gems", "byg:ametrine_helmet");
            AMETRINE_CHESTPLATE_RECIPE = RecipeHelper.createSmithingRecipe("gildednetherite:gilded_chestplate", "byg:ametrine_gems", "byg:ametrine_chestplate");

            // Pendorite Tool Smithing Table Upgrades
            PENDORITE_AXE_RECIPE = RecipeHelper.createSmithingRecipe("gildednetherite:gilded_axe", "byg:pendorite_scraps", "byg:pendorite_axe");
            PENDORITE_HOE_RECIPE = RecipeHelper.createSmithingRecipe("gildednetherite:gilded_hoe", "byg:pendorite_scraps", "byg:pendorite_hoe");
            PENDORITE_PICKAXE_RECIPE = RecipeHelper.createSmithingRecipe("gildednetherite:gilded_pickaxe", "byg:pendorite_scraps", "byg:pendorite_pickaxe");
            PENDORITE_SHOVEL_RECIPE = RecipeHelper.createSmithingRecipe("gildednetherite:gilded_shovel", "byg:pendorite_scraps", "byg:pendorite_shovel");
            PENDORITE_SWORD_RECIPE = RecipeHelper.createSmithingRecipe("gildednetherite:gilded_sword", "byg:pendorite_scraps", "byg:pendorite_sword");

        }

    }

    /**
     * Biomes You'll Go has a number of interesting items and blocks that we want to make available in other
     * parts of the game so as to make everything feel a little bit more connected.
     */
    private static void updateLootTablesForByg() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Ametrine gems can drop when mining Diamond Ore.
            if (LootTableHelper.isDiamondOre(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.02F, ModIntegrations.BYG, "ametrine_gems");
            }

            // Ametrine gems have a 3% chance of appearing in normal dungeon chests.
            if (LootTableHelper.isSimpleDungeonChest(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.03F, ModIntegrations.BYG, "ametrine_gems");
            }

            // Ametrine gems can be found in End Cities.
            if (LootTableHelper.isEndEndgame(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.1F, ModIntegrations.BYG, "ametrine_gems");
            }

            // Pendorite scraps can be found in various Nether chests (Bastions, mainly).
            if (LootTableHelper.isNetherEndgame(identifier)) {
                LootTableHelper.addToLootTable(supplier, 4, 0.02F, ModIntegrations.BYG, "pendorite_scraps");
            }

        });
    }
}
