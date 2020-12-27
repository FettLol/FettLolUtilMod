package net.fettlol_util.module;

import net.fettlol_util.UtilMod;
import net.fettlol_util.base.Handler.ModuleHandler;
import net.fettlol_util.base.Interface.Module;
import net.fettlol_util.base.UtilModule;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;

import java.util.Collection;

/*
 * This module is registered here, but is triggered from the PlayerManagerMixin for simplicity's sake.
 */

@Module(mod = UtilMod.MOD_ID, description = "Unlocks all vanilla recipes.")
public class UnlockAllRecipes extends UtilModule
{
    public static void unlockRecipes(PlayerEntity player) {
        if (!ModuleHandler.enabled(UtilMod.MOD_ID + ":unlock_all_recipes")) {
            return;
        }

        if (player != null) {
            RecipeManager recipeManager = player.world.getRecipeManager();
            Collection<Recipe<?>> allRecipes = recipeManager.values();
            player.unlockRecipes(allRecipes);
        }
    }
}