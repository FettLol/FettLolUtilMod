package net.fettlol.utilmod.init;

import com.google.common.collect.Lists;
import net.fettlol.lib.registry.RecipeApi;
import net.fettlol.utilmod.util.RecipeHelper;
import net.fettlol.utilmod.util.RegistryHelper;

public class FettlolRecipes {

    public static void init() {
        addSaddleRecipe();
        addEnchantedGoldenAppleRecipe();
    }

    private static void addSaddleRecipe() {
        RecipeApi.add(
            RegistryHelper.fettlolId("extras/saddle"),
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
        RecipeApi.add(
            RegistryHelper.fettlolId("extras/egapple"),
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
