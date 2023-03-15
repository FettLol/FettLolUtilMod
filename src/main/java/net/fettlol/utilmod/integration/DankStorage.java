package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.registry.LootApi;
import net.fettlol.utilmod.registry.RecipeApi;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.LootTableHelper;

public class DankStorage {

    public static void init() {
        if (FettlolModIntegrations.isDankStorageLoaded) {
            LogHelper.log("Dank Storage detected! Applying integrations.");

            RecipeApi.remove(FettlolModIntegrations.DANKSTORAGE, "1_to_2");
            RecipeApi.remove(FettlolModIntegrations.DANKSTORAGE, "2_to_3");
            RecipeApi.remove(FettlolModIntegrations.DANKSTORAGE, "3_to_4");
            RecipeApi.remove(FettlolModIntegrations.DANKSTORAGE, "4_to_5");
            RecipeApi.remove(FettlolModIntegrations.DANKSTORAGE, "5_to_6");
            RecipeApi.remove(FettlolModIntegrations.DANKSTORAGE, "6_to_7");

            // These two recipes are being replaced using JSON files.
            RecipeApi.remove(FettlolModIntegrations.DANKSTORAGE, "5");
            RecipeApi.remove(FettlolModIntegrations.DANKSTORAGE, "6");
            RecipeApi.remove(FettlolModIntegrations.DANKSTORAGE, "7");

            LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, tableBuilder, source) -> {
                if (LootTableHelper.isEnderDragon(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 1, 0.1F, FettlolModIntegrations.DANKSTORAGE, "dank_5");
                }

                if (LootTableHelper.isNetherEndgameChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 1, 0.05F, FettlolModIntegrations.DANKSTORAGE, "dank_3");
                }

                if (LootTableHelper.isEndEndgameChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 1, 0.05F, FettlolModIntegrations.DANKSTORAGE, "dank_4");
                }

            });
        }
    }

}
