package net.fettlol.integration;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.UtilMod;
import net.fettlol.init.FettlolRecipes;
import net.fettlol.init.ModIntegrations;
import net.fettlol.util.LootTableHelper;
import net.fettlol.util.RecipeHelper;
import net.minecraft.util.Identifier;

public class BetterEnd {

    public static void init() {
        if (ModIntegrations.isBetterEndLoaded) {
            UtilMod.LOGGER.info("Better End detected! Applying integrations.");

            defineLootTablesForBetterEnd();

            defineRecipesForBetterEnd();
        }
    }

    /**
     * There are a lot of weird recipes introduced in Better End, many of which introduce new ways of
     * crafting armor and tools. Since we want to have consistency in how these are made, these recipes
     * add the "normal" way of crafting armor and tools back for Aeternium, Thallasium and Terminite.
     */
    public static void defineRecipesForBetterEnd() {
        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/aeternium_boots",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I'),
                Lists.newArrayList(new Identifier(ModIntegrations.BETTER_END, "aeternium_ingot")),
                Lists.newArrayList("item"),
                Lists.newArrayList("   ", "I I", "I I"),
                new Identifier(ModIntegrations.BETTER_END, "aeternium_boots")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/aeternium_chestplate",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I'),
                Lists.newArrayList(new Identifier(ModIntegrations.BETTER_END, "aeternium_ingot")),
                Lists.newArrayList("item"),
                Lists.newArrayList("I I", "III", "III"),
                new Identifier(ModIntegrations.BETTER_END, "aeternium_chestplate")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/aeternium_helmet",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I'),
                Lists.newArrayList(new Identifier(ModIntegrations.BETTER_END, "aeternium_ingot")),
                Lists.newArrayList("item"),
                Lists.newArrayList("   ", "III", "I I"),
                new Identifier(ModIntegrations.BETTER_END, "aeternium_helmet")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/aeternium_leggings",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I'),
                Lists.newArrayList(new Identifier(ModIntegrations.BETTER_END, "aeternium_ingot")),
                Lists.newArrayList("item"),
                Lists.newArrayList("III", "I I", "I I"),
                new Identifier(ModIntegrations.BETTER_END, "aeternium_leggings")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/aeternium_axe",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "aeternium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " SI", " S "),
                new Identifier(ModIntegrations.BETTER_END, "aeternium_axe")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/aeternium_hoe",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "aeternium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " S ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "aeternium_hoe")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/aeternium_pickaxe",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "aeternium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList("III", " S ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "aeternium_pickaxe")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/aeternium_shovel",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "aeternium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " S ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "aeternium_shovel")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/aeternium_sword",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "aeternium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " I ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "aeternium_sword")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/terminite_axe",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " SI", " S "),
                new Identifier(ModIntegrations.BETTER_END, "terminite_axe")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/terminite_hoe",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " S ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "terminite_hoe")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/terminite_pickaxe",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList("III", " S ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "terminite_pickaxe")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/terminite_shovel",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " S ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "terminite_shovel")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/thallasium_axe",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "thallasium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " SI", " S "),
                new Identifier(ModIntegrations.BETTER_END, "thallasium_axe")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/thallasium_hoe",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "thallasium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " S ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "thallasium_hoe")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/thallasium_pickaxe",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "thallasium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList("III", " S ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "thallasium_pickaxe")
            )
        );


        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/thallasium_shovel",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "thallasium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " S ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "thallasium_shovel")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/thallasium_sword",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "thallasium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " I ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "thallasium_sword")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/terminite_sword",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " I ", " S "),
                new Identifier(ModIntegrations.BETTER_END, "terminite_sword")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/aeternium_ingot",
            RecipeHelper.createShapelessRecipe(
                Lists.newArrayList(
                    new Identifier(ModIntegrations.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "netherite_ingot")
                ),
                Lists.newArrayList("item", "item"),
                new Identifier(ModIntegrations.BETTER_END, "aeternium_ingot")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put(
            "betterend/terminite_ingot",
            RecipeHelper.createShapelessRecipe(
                Lists.newArrayList(
                    new Identifier("c", "ender_pearl_dusts"),
                    new Identifier("minecraft", "iron_ingot")
                ),
                Lists.newArrayList("tag", "item"),
                new Identifier(ModIntegrations.BETTER_END, "terminite_ingot")
            )
        );
    }

    /**
     * Better End has a number of interesting items and blocks that we want to make available in other
     * parts of the game so as to make everything feel a little bit more connected.
     */
    private static void defineLootTablesForBetterEnd() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Endermen drop one Ender Dust 5% of the time.
            // TODO - Consider changing this to the Ender Dust from Applied Energistics?
            if (LootTableHelper.isEnderman(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.05F, ModIntegrations.BETTER_END, "ender_dust");
            }

            // Buried treasure has a 10% chance of containing one Raw Amber.
            if (LootTableHelper.isBuriedTreasure(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.1F, ModIntegrations.BETTER_END, "raw_amber");
            }

        });
    }
}
