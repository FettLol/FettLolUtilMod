package net.fettlol.init;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.fettlol.util.RecipeHelper;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class FettlolRecipes {

    public static HashMap<String, JsonObject> CUSTOM_RECIPES = new HashMap<>();

    public static void init() {
        addSimplifiedChestMinecartRecipe();
        addSimplifiedDispenserRecipe();
        addSimplifiedDropperRecipe();
        addSimplifiedFurnaceRecipe();
        addSimplifiedObserverRecipe();
        addSimplifiedPistonRecipe();
        addSimplifiedRepeaterRecipe();
    }

    private static void addSimplifiedDispenserRecipe() {
        CUSTOM_RECIPES.put(
            "cobblestone/dispenser",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S', 'R', 'B'),
                Lists.newArrayList(
                    new Identifier("minecraft", "stone_crafting_materials"),
                    new Identifier("minecraft", "redstone"),
                    new Identifier("fabric", "bows")
                ),
                Lists.newArrayList("tag", "item", "tag"),
                Lists.newArrayList("SSS", "SBS", "SRS"),
                new Identifier("minecraft", "dispenser")
            )
        );
    }

    private static void addSimplifiedDropperRecipe() {
        CUSTOM_RECIPES.put(
            "cobblestone/dropper",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S', 'R'),
                Lists.newArrayList(
                    new Identifier("minecraft", "stone_crafting_materials"),
                    new Identifier("minecraft", "redstone")
                ),
                Lists.newArrayList("tag", "item"),
                Lists.newArrayList("SSS", "S S", "SRS"),
                new Identifier("minecraft", "dropper")
            )
        );
    }

    private static void addSimplifiedObserverRecipe() {
        CUSTOM_RECIPES.put(
            "cobblestone/observer",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S', 'R', 'Q'),
                Lists.newArrayList(
                    new Identifier("minecraft", "stone_crafting_materials"),
                    new Identifier("minecraft", "redstone"),
                    new Identifier("c", "quartz")
                ),
                Lists.newArrayList("tag", "item", "tag"),
                Lists.newArrayList("SSS", "RRQ", "SSS"),
                new Identifier("minecraft", "observer")
            )
        );
    }

    private static void addSimplifiedFurnaceRecipe() {
        CUSTOM_RECIPES.put(
            "cobblestone/furnace",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S'),
                Lists.newArrayList(
                    new Identifier("minecraft", "stone_crafting_materials")
                ),
                Lists.newArrayList("tag"),
                Lists.newArrayList("SSS", "S S", "SSS"),
                new Identifier("minecraft", "furnace")
            )
        );
    }

    private static void addSimplifiedPistonRecipe() {
        CUSTOM_RECIPES.put(
            "cobblestone/piston",
            RecipeHelper.createShapedRecipe(
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
            )
        );
    }

    public static void addSimplifiedRepeaterRecipe() {
        CUSTOM_RECIPES.put(
            "simplified/repeater",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S', 'R', 'T'),
                Lists.newArrayList(
                    new Identifier("minecraft", "stone_crafting_materials"),
                    new Identifier("minecraft", "redstone"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("tag", "item", "item"),
                Lists.newArrayList("R R", "TRT", "SSS"),
                new Identifier("minecraft", "repeater")
            )
        );
    }

    public static void addSimplifiedChestMinecartRecipe() {
        CUSTOM_RECIPES.put(
            "simplified/chestminecart",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('C', 'I'),
                Lists.newArrayList(
                    new Identifier("c", "wooden_chests"),
                    new Identifier("c", "iron_ingots")
                ),
                Lists.newArrayList("tag", "tag"),
                Lists.newArrayList("   ", "ICI", "III"),
                new Identifier("minecraft", "chest_minecart")
            )
        );
    }

}
