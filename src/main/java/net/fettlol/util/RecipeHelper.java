package net.fettlol.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.cottonmc.cotton.datapack.recipe.RecipeUtil;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collection;

/**
 * These methods help us create various types of crafting recipes via code.
 * Down the line, this file will need to be expanded in multiple ways, including:
 *
 * - Allowing multiple outputs in recipes.
 * - Adding support for recipes for some of the specialized recipe types in the modpack.
 */
public class RecipeHelper {

    public static void removeRecipe(String recipe) {
        RecipeUtil.removeRecipe(recipe);
    }

    public static void removeRecipe(String namespace, String recipe) {
        removeRecipe(namespace + ":" + recipe);
    }

    public static void removeRecipe(Identifier recipe) {
        RecipeUtil.removeRecipe(recipe);
    }

    public static void unlockAllRecipes(ServerPlayerEntity serverPlayerEntity) {
        if (serverPlayerEntity != null) {
            RecipeManager recipeManager = serverPlayerEntity.world.getRecipeManager();
            Collection<Recipe<?>> allRecipes = recipeManager.values();

            serverPlayerEntity.unlockRecipes(allRecipes);
        }
    }
    public static JsonObject createSmithingRecipe(String baseItem, String additionItem, String resultItem) {
        return createSmithingRecipe(new Identifier(baseItem), new Identifier(additionItem), new Identifier(resultItem));
    }

    public static JsonObject createSmithingRecipe(Identifier baseItem, Identifier additionItem, Identifier resultItem) {
        JsonObject base = new JsonObject();
        base.addProperty("item", baseItem.toString());

        JsonObject addition = new JsonObject();
        addition.addProperty("item", additionItem.toString());

        JsonObject result = new JsonObject();
        result.addProperty("item", resultItem.toString());

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "minecraft:smithing");
        jsonObject.add("base", base);
        jsonObject.add("addition", addition);
        jsonObject.add("result", result);

        return jsonObject;
    }

    public static JsonObject createSmeltingRecipe(Identifier inputIdentifier, String inputType, Identifier output, Float experience, int time) {
        JsonObject ingredientObject = new JsonObject();
        JsonArray ingredientArray = new JsonArray();
        ingredientObject.addProperty(inputType, inputIdentifier.toString());
        ingredientArray.add(ingredientObject);

        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", 1);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "minecraft:smelting");
        jsonObject.add("ingredient", ingredientArray);
        jsonObject.add("result", result);
        jsonObject.addProperty("cookingTime", time);
        jsonObject.addProperty("experience", experience);

        return jsonObject;
    }

    public static JsonObject createShapelessRecipe(ArrayList<Identifier> items, ArrayList<String> type, Identifier output) {
        JsonObject individualIngredient;
        JsonArray ingredientArray = new JsonArray();
        for (int i = 0; i < items.size(); ++i) {
            individualIngredient = new JsonObject();
            individualIngredient.addProperty(type.get(i), items.get(i).toString());

            ingredientArray.add(individualIngredient);
        }

        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", 1);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "minecraft:crafting_shapeless");
        jsonObject.add("ingredients", ingredientArray);
        jsonObject.add("result", result);

        return jsonObject;
    }

    public static JsonObject createShapedRecipe(ArrayList<Character> keys, ArrayList<Identifier> items, ArrayList<String> type, ArrayList<String> pattern, Identifier output) {
        return createShapedRecipeOfType("minecraft:shaped_recipe", keys, items, type, pattern, output);
    }

    public static JsonObject createShapedRecipeOfType(String recipeType, ArrayList<Character> keys, ArrayList<Identifier> items, ArrayList<String> type, ArrayList<String> pattern, Identifier output) {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(pattern.get(0));
        jsonArray.add(pattern.get(1));
        jsonArray.add(pattern.get(2));

        JsonObject individualKey;
        JsonObject keyList = new JsonObject();
        for (int i = 0; i < keys.size(); ++i) {
            individualKey = new JsonObject();
            individualKey.addProperty(type.get(i), items.get(i).toString());
            keyList.add(keys.get(i) + "", individualKey);
        }

        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", 1);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", recipeType);
        jsonObject.add("pattern", jsonArray);
        jsonObject.add("key", keyList);
        jsonObject.add("result", result);

        return jsonObject;
    }

}
