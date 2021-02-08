package net.brekitomasson.fettlol.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

/**
 * These methods help us create various types of crafting recipes via code.
 * Down the line, this file will need to be expanded in multiple ways, including:
 *
 * - Allowing multiple outputs in recipes.
 * - Adding support for recipes for some of the specialized recipe types in the modpack.
 */
public class RecipeHelper {

    public static JsonObject createSmithingRecipe(String baseItem, String additionItem, String resultItem) {
        return createSmithingRecipe(new Identifier(baseItem), new Identifier(additionItem), new Identifier(resultItem));
    }

    public static JsonObject createSmithingRecipe(Identifier baseItem, Identifier additionItem, Identifier resultItem) {
        // Define the various objects and arrays we'll be using.
        JsonObject jsonObject = new JsonObject();
        JsonObject base = new JsonObject();
        JsonObject addition = new JsonObject();
        JsonObject result = new JsonObject();

        // Populate the objects!
        base.addProperty("item", baseItem.toString());
        addition.addProperty("item", additionItem.toString());
        result.addProperty("item", resultItem.toString());

        // Put it all together!
        jsonObject.addProperty("type", "minecraft:smithing");
        jsonObject.add("base", base);
        jsonObject.add("addition", addition);
        jsonObject.add("result", result);

        // And return it!
        return jsonObject;
    }

    public static JsonObject createSmeltingRecipe(Identifier inputIdentifier, String inputType, Identifier output, Float experience, int time) {
        // Define the various objects we'll be using.
        JsonObject jsonObject = new JsonObject();
        JsonArray ingredientArray = new JsonArray();
        JsonObject ingredientObject = new JsonObject();
        JsonObject result = new JsonObject();

        // Define the ingredient
        ingredientObject.addProperty(inputType, inputIdentifier.toString());
        ingredientArray.add(ingredientObject);

        // Define the Result
        result.addProperty("item", output.toString());
        result.addProperty("count", 1);

        // Put it all together
        jsonObject.addProperty("type", "minecraft:smelting");
        jsonObject.add("ingredient", ingredientArray);
        jsonObject.add("result", result);
        jsonObject.addProperty("cookingTime", time);
        jsonObject.addProperty("experience", experience);

        return jsonObject;
    }

    public static JsonObject createShapelessRecipe(ArrayList<Identifier> items, ArrayList<String> type, Identifier output) {
        // Define the various objects and arrays we'll be using.
        JsonObject jsonObject = new JsonObject();
        JsonObject individualIngredient;
        JsonArray ingredientArray = new JsonArray();
        JsonObject result = new JsonObject();

        // Define the ingredients.
        for (int i = 0; i < items.size(); ++i) {
            individualIngredient = new JsonObject();
            individualIngredient.addProperty(type.get(i), items.get(i).toString());

            ingredientArray.add(individualIngredient);
        }

        // Define the result.
        result.addProperty("item", output.toString());
        result.addProperty("count", 1);

        jsonObject.addProperty("type", "minecraft:crafting_shapeless");
        jsonObject.add("ingredients", ingredientArray);
        jsonObject.add("result", result);

        return jsonObject;
    }

    public static JsonObject createShapedRecipe(ArrayList<Character> keys, ArrayList<Identifier> items, ArrayList<String> type, ArrayList<String> pattern, Identifier output) {

        // Define the various objects and arrays we'll be using.
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        JsonObject individualKey;
        JsonObject keyList = new JsonObject();
        JsonObject result = new JsonObject();

        // Define the crafting pattern for this recipe.
        jsonArray.add(pattern.get(0));
        jsonArray.add(pattern.get(1));
        jsonArray.add(pattern.get(2));

        // Define the keys and their definitions, as used in the crafting pattern.
        for (int i = 0; i < keys.size(); ++i) {
            individualKey = new JsonObject();
            individualKey.addProperty(type.get(i), items.get(i).toString());
            keyList.add(keys.get(i) + "", individualKey);
        }

        // Define the result object.
        result.addProperty("item", output.toString());
        result.addProperty("count", 1);

        // Put it all together into the original JSON Object!
        jsonObject.addProperty("type", "minecraft:crafting_shaped");
        jsonObject.add("pattern", jsonArray);
        jsonObject.add("key", keyList);
        jsonObject.add("result", result);

        // And return it!
        return jsonObject;
    }

}
