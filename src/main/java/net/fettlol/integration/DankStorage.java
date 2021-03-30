package net.fettlol.integration;

import net.fettlol.UtilMod;
import net.fettlol.init.ModIntegrations;
import net.fettlol.util.LootTableHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;

public class DankStorage {

    public static void init() {
        if (ModIntegrations.isDankStorageLoaded) {
            UtilMod.LOGGER.info("Dank Storage detected! Applying integrations.");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                if (LootTableHelper.isEnderDragon(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.1F, ModIntegrations.DANKSTORAGE, "dank_4");
                }

                if (LootTableHelper.isNetherEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.05F, ModIntegrations.DANKSTORAGE, "dank_3");
                }

                if (LootTableHelper.isEndEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.05F, ModIntegrations.DANKSTORAGE, "dank_4");
                }

            });


        }
    }

}
