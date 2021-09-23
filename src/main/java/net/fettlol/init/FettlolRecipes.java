package net.fettlol.init;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.fettlol.UtilMod;
import net.fettlol.lists.Mods;
import net.fettlol.util.RecipeHelper;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class FettlolRecipes {

    public static HashMap<String, JsonObject> CUSTOM_RECIPES = new HashMap<>();

    public static void init() {
        addTridentRecipe();
        addSaddleRecipe();
        addEnchantedGoldenAppleRecipe();
    }

    private static void addTridentRecipe() {
        if (FettlolModIntegrations.isAdornLoaded) {
            CUSTOM_RECIPES.put(
                "extras/trident",
                RecipeHelper.createShapedRecipe(
                    Lists.newArrayList('S', 'A', 'C', 'P'),
                    Lists.newArrayList(
                        new Identifier("minecraft", "prismarine_shard"),
                        new Identifier(UtilMod.MOD_ID, "aquamarine_gem"),
                        new Identifier("minecraft", "conduit"),
                        new Identifier(Mods.ADORN, "prismarine_brick_post")
                    ),
                    Lists.newArrayList("item", "item", "item", "item"),
                    Lists.newArrayList("SSS", "ACA", " P "),
                    new Identifier("minecraft", "trident")
                )
            );
        }
    }

    private static void addSaddleRecipe() {
        CUSTOM_RECIPES.put(
            "extras/saddle",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('#', 'T', 'g'),
                Lists.newArrayList(
                    new Identifier("minecraft", "leather"),
                    new Identifier("minecraft", "tripwire_hook"),
                    new Identifier("minecraft", "gold_ingot")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("###", "T#T", " g "),
                new Identifier("minecraft", "saddle")
            )
        );
    }

    private static void addEnchantedGoldenAppleRecipe() {
        CUSTOM_RECIPES.put(
            "extras/egapple",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('G', 'A'),
                Lists.newArrayList(
                    new Identifier("minecraft", "gold_block"),
                    new Identifier("minecraft", "apple")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList("GGG", "GAG", "GGG"),
                new Identifier("minecraft", "enchanted_golden_apple")
            )
        );
    }

}
