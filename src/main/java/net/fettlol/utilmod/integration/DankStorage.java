package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.registry.LootApi;
import net.fettlol.utilmod.registry.RecipeApi;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.LootTableHelper;

public class DankStorage {

    public static void init() {
        if (FettlolModIntegrations.isDankStorageLoaded) {
            LogHelper.log("Dank Storage detected! Applying integrations.");

            RecipeApi.remove(Mods.DANKSTORAGE, "1_to_2");
            RecipeApi.remove(Mods.DANKSTORAGE, "2_to_3");
            RecipeApi.remove(Mods.DANKSTORAGE, "3_to_4");
            RecipeApi.remove(Mods.DANKSTORAGE, "4_to_5");
            RecipeApi.remove(Mods.DANKSTORAGE, "5_to_6");
            RecipeApi.remove(Mods.DANKSTORAGE, "6_to_7");

            RecipeApi.remove(Mods.DANKSTORAGE, "5");
            RecipeApi.remove(Mods.DANKSTORAGE, "6");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                if (LootTableHelper.isEnderDragon(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.1F, Mods.DANKSTORAGE, "dank_5");
                }

                if (LootTableHelper.isNetherEndgameChest(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.05F, Mods.DANKSTORAGE, "dank_3");
                }

                if (LootTableHelper.isEndEndgameChest(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.05F, Mods.DANKSTORAGE, "dank_4");
                }

            });
        }
    }

}
