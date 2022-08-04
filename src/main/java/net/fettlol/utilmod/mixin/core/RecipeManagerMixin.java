package net.fettlol.utilmod.mixin.core;

import com.google.gson.JsonElement;
import net.fettlol.utilmod.api.RecipeImpl;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Map;
import java.util.stream.Collectors;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

    // remove recipes before they are processed
    @ModifyVariable(method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    protected Map<Identifier, JsonElement> filterRecipes(Map<Identifier, JsonElement> recipes) {
        return recipes.entrySet().stream()
            .filter(entry -> !RecipeImpl.blockedRecipes.contains(entry.getKey()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}