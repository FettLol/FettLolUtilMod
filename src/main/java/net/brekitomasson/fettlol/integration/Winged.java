package net.brekitomasson.fettlol.integration;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.init.ModIntegrations;
import net.brekitomasson.fettlol.util.LootTableHelper;
import net.brekitomasson.fettlol.util.RecipeHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.util.Identifier;

public class Winged {

    // Null definition for Core of Flight to redefine the recipe if Winged is loaded.
    public static JsonObject CORE_OF_FLIGHT = null;

    public static void init() {
        if (ModIntegrations.isWingedLoaded) {
            UtilMod.LOGGER.info("Winged detected! Applying integrations!");

            CORE_OF_FLIGHT = RecipeHelper.createShapedRecipe(
                Lists.newArrayList('A','B','E','S','P'),
                Lists.newArrayList(
                    new Identifier("fettlol", "aquamarine_gem"),
                    new Identifier("winged", "broken_core_of_flight"),
                    new Identifier("minecraft", "ender_eye"),
                    new Identifier("minecraft", "shulker_shell"),
                    new Identifier("minecraft", "phantom_membrane")
                ),
                Lists.newArrayList("item", "item", "item", "item", "item"),
                Lists.newArrayList("PSP", "EBE", "ASA"),
                new Identifier("winged", "core_of_flight")
            );

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

                // 2% Chance of finding a random set of Wings in End City chests
                if (LootTableHelper.isEndEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.02F, ModIntegrations.WINGED, "wing_random");
                }

            });

        }
    }
}
