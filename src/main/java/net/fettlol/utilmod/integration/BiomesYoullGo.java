package net.fettlol.utilmod.integration;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.init.FettlolRecipes;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.LootTableHelper;
import net.fettlol.utilmod.util.RecipeHelper;
import net.fettlol.utilmod.util.RegistryHelper;
import org.jetbrains.annotations.NotNull;

public class BiomesYoullGo {

    public static void init() {
        if (FettlolModIntegrations.isBygLoaded) {
            LogHelper.log("Biomes You'll Go detected! Applying integrations.");

            updateLootTablesForByg();
            defineRecipesForByg();
        }
    }

    private static void defineRecipesForByg() {
        // Add a recipe for Therium Crystals, which seems to be missing in BYG.
        FettlolRecipes.CUSTOM_RECIPES.put(
            Mods.BYG + "/therium_shard",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('T'),
                Lists.newArrayList(
                    RegistryHelper.modId(Mods.BYG, "therium_shard")
                ),
                Lists.newArrayList("item"),
                Lists.newArrayList("TT ", "TT ", "   "),
                RegistryHelper.modId(Mods.BYG, "therium_crystal")
            )
        );

        // Gilded Netherite has been moved from its own dedicated mod to Additional Additions.
        if (FettlolModIntegrations.isAdditionalAdditionsLoaded) {
            // Gilded Netherite armor to Ametrine.
            addGildedToAmetrineUpgrade("boots");
            addGildedToAmetrineUpgrade("chestplate");
            addGildedToAmetrineUpgrade("helmet");
            addGildedToAmetrineUpgrade("leggings");

            // Gilded Netherite tools to Pendorite.
            addGildedToPendoriteUpgrade("axe");
            addGildedToPendoriteUpgrade("hoe");
            addGildedToPendoriteUpgrade("pickaxe");
            addGildedToPendoriteUpgrade("shovel");
            addGildedToPendoriteUpgrade("sword");
        }
    }

    private static void addGildedToAmetrineUpgrade(String item) {
        FettlolRecipes.CUSTOM_RECIPES.put(
            Mods.BYG + "/ametrine_" + item + "_gilded",
            RecipeHelper.createSmithingRecipe(
                Mods.ADDITIONAL_ADDITIONS + ":gilded_netherite_" + item,
                bygItem("ametrine_gems"),
                bygItem("ametrine_" + item)
            )
        );
    }

    private static void addGildedToPendoriteUpgrade(String item) {
        FettlolRecipes.CUSTOM_RECIPES.put(
            Mods.BYG + "/pendorite_" + item + "_gilded",
            RecipeHelper.createSmithingRecipe(
                Mods.ADDITIONAL_ADDITIONS + ":gilded_netherite_" + item,
                bygItem("pendorite_scraps"),
                bygItem("pendorite_" + item)
            )
        );
    }

    /**
     * Biomes You'll Go has a number of interesting items and blocks that we want to make available in other
     * parts of the game so as to make everything feel a little bit more connected.
     */
    private static void updateLootTablesForByg() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Diamond Ore: Add Ametrine Gems (2%)
            if (LootTableHelper.isDiamondOre(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.02F, Mods.BYG, "ametrine_gems");
            }

            // Dungeon Chests: Add Ametrine Gems (3%).
            if (LootTableHelper.isSimpleDungeonChest(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.03F, Mods.BYG, "ametrine_gems");
            }

            // End Endgame: Add Ametrinie Gems (2 separate 1% rolls).
            if (LootTableHelper.isEndEndgame(identifier)) {
                LootTableHelper.addToLootTable(supplier, 2, 0.1F, Mods.BYG, "ametrine_gems");
            }

            // Nether Endgame: Add Pendorite scraps (4 separate 2% rolls).
            if (LootTableHelper.isNetherEndgame(identifier)) {
                LootTableHelper.addToLootTable(supplier, 4, 0.02F, Mods.BYG, "pendorite_scraps");
            }

        });
    }

    @NotNull
    private static String bygItem(String item) {
        return Mods.BYG + ":" + item;
    }

}
