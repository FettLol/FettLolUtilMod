package net.fettlol.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fettlol.init.FettlolRecipes;
import net.fettlol.util.RegistryHelper;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

    @Inject(method = "apply", at = @At("HEAD"))
    public void applyFettLolCustomRecipes(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci) {

        FettlolRecipes.CUSTOM_RECIPES.forEach((String name, JsonObject object) -> {
            addCustomRecipe(map, name, object);
        });

    }

    private void addCustomRecipe(Map<Identifier, JsonElement> map, String recipeName, JsonObject definition) {
        if (definition != null) {
            map.put(RegistryHelper.makeId(recipeName), definition);
        }
    }

}
