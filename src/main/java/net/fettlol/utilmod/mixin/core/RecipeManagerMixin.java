package net.fettlol.utilmod.mixin.core;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fettlol.utilmod.init.FettlolRecipes;
import net.fettlol.utilmod.util.RecipeHelper;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

/**
 * This file is required to make sure the various recipes defined and used all over the place are actually loaded into
 * the game itself. See net.fettlol.init.FettlolRecipes for more details.
 */
@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

    @Inject(method = "apply", at = @At("HEAD"))
    public void applyFettLolCustomRecipes(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci) {
        FettlolRecipes.CUSTOM_RECIPES.forEach((String name, JsonObject object) -> {
            RecipeHelper.addCustomRecipe(map, name, object);
        });
    }

}
