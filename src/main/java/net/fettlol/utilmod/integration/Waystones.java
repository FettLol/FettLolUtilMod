package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.registry.LootApi;
import net.fettlol.utilmod.registry.RecipeApi;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.LootTableHelper;

public class Waystones {
    public static void init() {
        if (FettlolModIntegrations.isWaystonesLoaded) {
            LogHelper.log("Waystones detected! Applying integrations!");

            // These recipe are being replaced.
            RecipeApi.remove(FettlolModIntegrations.WAYSTONES, "abyss_watcher");
            RecipeApi.remove(FettlolModIntegrations.WAYSTONES, "blackstone_waystone");
            RecipeApi.remove(FettlolModIntegrations.WAYSTONES, "deepslate_waystone");
            RecipeApi.remove(FettlolModIntegrations.WAYSTONES, "desert_waystone");
            RecipeApi.remove(FettlolModIntegrations.WAYSTONES, "end_stone_waystone");
            RecipeApi.remove(FettlolModIntegrations.WAYSTONES, "nether_brick_waystone");
            RecipeApi.remove(FettlolModIntegrations.WAYSTONES, "red_desert_waystone");
            RecipeApi.remove(FettlolModIntegrations.WAYSTONES, "red_nether_brick_waystone");
            RecipeApi.remove(FettlolModIntegrations.WAYSTONES, "stone_brick_waystone");
            RecipeApi.remove(FettlolModIntegrations.WAYSTONES, "waystone");

            LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, tableBuilder, source) -> {
                if (LootTableHelper.isEndEndgameChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 1, 0.09F, FettlolModIntegrations.WAYSTONES, "end_stone_brick_waystone");
                }

                if (LootTableHelper.isNetherEndgameChest(identifier) || LootTableHelper.isNetherTempleChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 1, 0.06F, FettlolModIntegrations.WAYSTONES, "nether_brick_waystone");
                    LootApi.addToLootTable(tableBuilder, 1, 0.06F, FettlolModIntegrations.WAYSTONES, "red_nether_brick_waystone");
                }

                if (LootTableHelper.isAbandonedMineshaftChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 1, 0.06F, FettlolModIntegrations.WAYSTONES, "stone_brick_waystone");
                    LootApi.addToLootTable(tableBuilder, 1, 0.06F, FettlolModIntegrations.WAYSTONES, "waystone");
                }
            });
        }
    }
}
