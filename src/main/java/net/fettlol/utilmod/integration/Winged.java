package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
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

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // "End" Endgame: Add Random Wings (2%).
                if (LootTableHelper.isEndEndgameChest(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.02F, FettlolModIntegrations.WINGED, "wing_random");
                }

            });
        }
    }

}
