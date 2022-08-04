package net.fettlol.utilmod.registry;

import net.fettlol.utilmod.api.RecipeImpl;
import net.minecraft.util.Identifier;

public class RecipeApi {
    public static void remove(Identifier recipe) {
        RecipeImpl.blockedRecipes.add(recipe);
    }

    public static void remove(String namespace, String recipe) {
        remove(new Identifier(namespace, recipe));
    }

}
