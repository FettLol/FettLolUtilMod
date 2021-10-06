package net.fettlol.utilmod.init;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.RecipeHelper;
import net.fettlol.utilmod.util.RegistryHelper;

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
                        RegistryHelper.vanillaId("prismarine_shard"),
                        RegistryHelper.fettlolId("aquamarine_gem"),
                        RegistryHelper.vanillaId("conduit"),
                        RegistryHelper.modId(Mods.ADORN, "prismarine_brick_post")
                    ),
                    Lists.newArrayList("item", "item", "item", "item"),
                    Lists.newArrayList("SSS", "ACA", " P "),
                    RegistryHelper.modId("minecraft", "trident")
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
                    RegistryHelper.vanillaId("leather"),
                    RegistryHelper.vanillaId("tripwire_hook"),
                    RegistryHelper.vanillaId("gold_ingot")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("###", "T#T", " g "),
                RegistryHelper.vanillaId("saddle")
            )
        );
    }

    private static void addEnchantedGoldenAppleRecipe() {
        CUSTOM_RECIPES.put(
            "extras/egapple",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('G', 'A'),
                Lists.newArrayList(
                    RegistryHelper.vanillaId("gold_block"),
                    RegistryHelper.vanillaId("apple")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList("GGG", "GAG", "GGG"),
                RegistryHelper.vanillaId("enchanted_golden_apple")
            )
        );
    }

}
