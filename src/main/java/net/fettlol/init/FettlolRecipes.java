package net.fettlol.init;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.fettlol.util.RecipeHelper;
import net.minecraft.util.Identifier;

public class FettlolRecipes {

    public static JsonObject PISTON_RECIPE = null;
    public static JsonObject DROPPER_RECIPE = null;
    public static JsonObject DISPENSER_RECIPE = null;
    public static JsonObject FURNACE_RECIPE = null;
    public static JsonObject OBSERVER_RECIPE = null;
    public static JsonObject REPEATER = null;
    public static JsonObject CHEST_MINECART = null;

    public static void init() {
        reduceCobblestoneDependency();

        addSimplifiedRecipes();
    }


    /**
     * Add recipes using the `minecraft:stone_crafting_materials` in place of Cobblestone
     */
    public static void reduceCobblestoneDependency() {

        PISTON_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('P', 'S', 'R', 'I'),
            Lists.newArrayList(
                new Identifier("minecraft", "planks"),
                new Identifier("minecraft", "stone_crafting_materials"),
                new Identifier("minecraft", "redstone"),
                new Identifier("c", "iron_ingots")
            ),
            Lists.newArrayList("tag", "tag", "item", "tag"),
            Lists.newArrayList("PPP", "SIS", "SRS"),
            new Identifier("minecraft", "piston")
        );

        DROPPER_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('S', 'R'),
            Lists.newArrayList(
                new Identifier("minecraft", "stone_crafting_materials"),
                new Identifier("minecraft", "redstone")
            ),
            Lists.newArrayList("tag", "item"),
            Lists.newArrayList("SSS", "S S", "SRS"),
            new Identifier("minecraft", "dropper")
        );

        DISPENSER_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('S', 'R', 'B'),
            Lists.newArrayList(
                new Identifier("minecraft", "stone_crafting_materials"),
                new Identifier("minecraft", "redstone"),
                new Identifier("c", "bows")
            ),
            Lists.newArrayList("tag", "item", "tag"),
            Lists.newArrayList("SSS", "SBS", "SRS"),
            new Identifier("minecraft", "dispenser")
        );

        OBSERVER_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('S', 'R', 'Q'),
            Lists.newArrayList(
                new Identifier("minecraft", "stone_crafting_materials"),
                new Identifier("minecraft", "redstone"),
                new Identifier("c", "quartz")
            ),
            Lists.newArrayList("tag", "item", "tag"),
            Lists.newArrayList("SSS", "RRQ", "SSS"),
            new Identifier("minecraft", "observer")
        );

        FURNACE_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('S'),
            Lists.newArrayList(
                new Identifier("minecraft", "stone_crafting_materials")
            ),
            Lists.newArrayList("tag"),
            Lists.newArrayList("SSS", "S S", "SSS"),
            new Identifier("minecraft", "furnace")
        );

    }

    /**
     * Simpler versions of recipes, allowing you to skip a step.
     */
    public static void addSimplifiedRecipes() {
        // Craft repeaters without redstone torches.
        REPEATER = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('S', 'R', 'T'),
            Lists.newArrayList(
                new Identifier("minecraft", "stone_crafting_materials"),
                new Identifier("minecraft", "redstone"),
                new Identifier("minecraft", "stick")
            ),
            Lists.newArrayList("tag", "item", "tag"),
            Lists.newArrayList("R R", "TRT", "SSS"),
            new Identifier("minecraft", "repeater")
        );

        // Craft Chest Minecarts without having to build the minecarts first.
        CHEST_MINECART = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('C', 'I'),
            Lists.newArrayList(
                new Identifier("c", "wooden_chests"),
                new Identifier("c", "iron_ingots")
            ),
            Lists.newArrayList("tag", "tag"),
            Lists.newArrayList("   ", "ICI", "III"),
            new Identifier("minecraft", "chest_minecart")
        );
    }

}
