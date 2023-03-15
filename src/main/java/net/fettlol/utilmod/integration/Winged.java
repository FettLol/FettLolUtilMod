package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.registry.LootApi;
import net.fettlol.utilmod.registry.RecipeApi;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.LootTableHelper;

public class Winged {

    public static void init() {
        if (FettlolModIntegrations.isWingedLoaded) {
            LogHelper.log("Winged detected! Applying integrations!");

            RecipeApi.remove(FettlolModIntegrations.WINGED, "core_of_flight");

            LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, tableBuilder, source) -> {
                // "End" Endgame: Add Random Wings (2%).
                if (LootTableHelper.isEndEndgameChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 1, 0.02F, FettlolModIntegrations.WINGED, "wing_random");
                }

            });
        }
    }

}
