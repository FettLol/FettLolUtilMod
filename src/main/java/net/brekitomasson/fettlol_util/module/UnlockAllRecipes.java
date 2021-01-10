package net.brekitomasson.fettlol_util.module;

import net.brekitomasson.fettlol_util.UtilMod;
import net.brekitomasson.fettlol_util.base.Interface.Module;
import net.brekitomasson.fettlol_util.base.UtilModule;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;

import java.util.Collection;

@Module(mod = UtilMod.MOD_ID, description = "Unlocks all vanilla recipes.")
public class UnlockAllRecipes extends UtilModule {
    public static void unlockRecipes(PlayerEntity player) {
        if (!UtilMod.CONFIG.doAllRecipiesUnlockByDefault()) {
            return;
        }

        if (player != null) {
            RecipeManager recipeManager = player.world.getRecipeManager();
            Collection<Recipe<?>> allRecipes = recipeManager.values();
            player.unlockRecipes(allRecipes);
        }

    }
}