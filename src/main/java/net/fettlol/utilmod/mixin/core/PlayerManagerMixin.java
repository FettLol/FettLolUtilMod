package net.fettlol.utilmod.mixin.core;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.ClientConnection;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.WorldSaveHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

/**
 * This file defines a number of hooks that can be used by code in
 * other places to ensure that it runs whenever a player connects,
 * loads their player data or saves their player data. Additional
 * hooks will be added here as they become relevant.
 *
 * @see MinecraftServerMixin for additional hooks related to server-
 * side things as well.
 */
@Mixin(PlayerManager.class)
public abstract class PlayerManagerMixin {
    @Shadow
    @Final
    private WorldSaveHandler saveHandler;

    // Hooks to run when a player connects to a server (including singleplayer worlds).
    @Inject(method = "onPlayerConnect", at = @At("RETURN"))
    private void hookAfterPlayerConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
        if (player != null) {
            RecipeManager recipeManager = player.world.getRecipeManager();
            Collection<Recipe<?>> allRecipes = recipeManager.values();

            // allRecipes can be manipulated in case there are any recipes
            // we do not want to unlock by default.

            player.unlockRecipes(allRecipes);
        }
    }

    // Hooks to run when a player is removed from a world for any reason.
    @Inject(method = "remove", at = @At("HEAD"))
    private void hookBeforeRemove(ServerPlayerEntity player, CallbackInfo ci) {
        // Nothing here yet.
    }

    // Hooks to run when a player respawns.
    @Inject(method = "respawnPlayer", at = @At("HEAD"))
    private void hookBeforeRespawnPlayer(ServerPlayerEntity player, boolean alive, CallbackInfoReturnable<ServerPlayerEntity> cir) {
        // Nothing here yet.
    }

    // Hooks to run when a player's data is loaded for any reason.
    @Inject(method = "loadPlayerData", at = @At("HEAD"))
    private void hookBeforeLoadPlayerData(ServerPlayerEntity player, CallbackInfoReturnable<NbtCompound> cir) {
        // Nothing here yet.
    }

    // Hooks to run when a player's data is saved for any reason.
    @Inject(method = "savePlayerData", at = @At("RETURN"))
    private void hookAfterSavePlayerData(ServerPlayerEntity player, CallbackInfo ci) {
        // Nothing here yet.
    }

}
