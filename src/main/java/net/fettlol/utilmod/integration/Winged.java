package net.fettlol.utilmod.integration;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.lib.helper.LootTableHelper;
import net.fettlol.lib.registry.LootApi;
import net.fettlol.lib.registry.RecipeApi;
import net.fettlol.utilmod.UtilMod;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.RecipeHelper;
import net.fettlol.utilmod.util.RegistryHelper;
import net.minecraft.util.Identifier;

public class Winged {

    public static void init() {
        if (FettlolModIntegrations.isWingedLoaded) {
            LogHelper.log("Winged detected! Applying integrations!");

            replaceCoreOfFlightRecipe();

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // "End" Endgame: Add Random Wings (2%).
                if (LootTableHelper.isEndEndgameChest(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.02F, Mods.WINGED, "wing_random");
                }

            });
        }
    }

    /**
     * The Core of Flight recipe is too easy to get in early game. This makes for a significantly
     * harder time to get your wings up and running. First you need to repair a Broken Core of Flight
     * down to level 25, then fix it with this more complex recipe:
     */
    private static void replaceCoreOfFlightRecipe() {
        RecipeApi.remove(Mods.WINGED, "core_of_flight");

        RecipeApi.add(
            RegistryHelper.fettlolId("winged/core_of_flight"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('A','B','E','S','P'),
                Lists.newArrayList(
                    new Identifier(UtilMod.MOD_ID, "aquamarine_gem"),
                    new Identifier(Mods.WINGED, "broken_core_of_flight_25"),
                    new Identifier("minecraft", "ender_eye"),
                    new Identifier("minecraft", "shulker_shell"),
                    new Identifier("minecraft", "phantom_membrane")
                ),
                Lists.newArrayList("item", "item", "item", "item", "item"),
                Lists.newArrayList("PSP", "EBE", "ASA"),
                new Identifier(Mods.WINGED, "core_of_flight")
            )
        );
    }
}
