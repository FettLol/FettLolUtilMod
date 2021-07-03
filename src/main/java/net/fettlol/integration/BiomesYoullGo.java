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

public class BiomesYoullGo {

    public static void init() {
        if (FettlolModIntegrations.isBygLoaded) {
            UtilMod.LOGGER.info("Biomes You'll Go detected! Applying integrations.");

            updateLootTablesForByg();
            defineRecipesForByg();
        }
    }

    private static void defineRecipesForByg() {
        addTheriumCrystalRecipe();

        if (FettlolModIntegrations.isGildedNetheriteLoaded) {
            addGildedToAmetrineUpgrade("boots");
            addGildedToAmetrineUpgrade("chestplate");
            addGildedToAmetrineUpgrade("helmet");
            addGildedToAmetrineUpgrade("leggings");
            addGildedToPendoriteUpgrade("axe");
            addGildedToPendoriteUpgrade("hoe");
            addGildedToPendoriteUpgrade("pickaxe");
            addGildedToPendoriteUpgrade("shovel");
            addGildedToPendoriteUpgrade("sword");
        }
    }

    private static void addTheriumCrystalRecipe() {
        FettlolRecipes.CUSTOM_RECIPES.put(
            Mods.BYG + "/therium_shard",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('T'),
                Lists.newArrayList(
                    new Identifier(Mods.BYG, "therium_shard")
                ),
                Lists.newArrayList("item"),
                Lists.newArrayList("TT ", "TT ", "   "),
                new Identifier(Mods.BYG, "therium_crystal")
            )
        );
    }

    private static void addGildedToAmetrineUpgrade(String item) {
        FettlolRecipes.CUSTOM_RECIPES.put(
            Mods.BYG + "/ametrine_" + item + "_gilded",
            RecipeHelper.createSmithingRecipe(
                Mods.GILDEDNETHERITE + ":gilded_" + item,
                Mods.BYG + ":ametrine_gems",
                Mods.BYG + ":ametrine_" + item
            )
        );
    }

    private static void addGildedToPendoriteUpgrade(String item) {
        FettlolRecipes.CUSTOM_RECIPES.put(
            Mods.BYG + "/pendorite_" + item + "_gilded",
            RecipeHelper.createSmithingRecipe(
                Mods.GILDEDNETHERITE + ":gilded_" + item,
                Mods.BYG + ":pendorite_scraps",
                Mods.BYG + ":pendorite_" + item
            )
        );
    }

    /**
     * Biomes You'll Go has a number of interesting items and blocks that we want to make available in other
     * parts of the game so as to make everything feel a little bit more connected.
     */
    private static void updateLootTablesForByg() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Ametrine gems can drop when mining Diamond Ore.
            if (LootTableHelper.isDiamondOre(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.02F, Mods.BYG, "ametrine_gems");
            }

            // Ametrine gems have a 3% chance of appearing in normal dungeon chests.
            if (LootTableHelper.isSimpleDungeonChest(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.03F, Mods.BYG, "ametrine_gems");
            }

            // Ametrine gems can be found in End Cities.
            if (LootTableHelper.isEndEndgame(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.1F, Mods.BYG, "ametrine_gems");
            }

            // Pendorite scraps can be found in various Nether chests (Bastions, mainly).
            if (LootTableHelper.isNetherEndgame(identifier)) {
                LootTableHelper.addToLootTable(supplier, 4, 0.02F, Mods.BYG, "pendorite_scraps");
            }

        });
    }
}
