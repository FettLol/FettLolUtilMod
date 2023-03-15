package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.registry.LootApi;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.LootTableHelper;
import net.fettlol.utilmod.util.RegistryHelper;

public class AdditionalAdditions {

    public static void init() {
        if (FettlolModIntegrations.isAdditionalAdditionsLoaded) {
            LogHelper.log("Additional Additions detected! Applying integrations.");

            LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, tableBuilder, source) -> {
                // Villager Houses: Add Rope (3%).
                if (LootTableHelper.isVillageHouseChest(identifier)) {
                    LootApi.addToLootTable(tableBuilder, 1, 0.1F, FettlolModIntegrations.ADDITIONAL_ADDITIONS, "rope");
                }

                // Ruined Portals: Add Rose Gold items (1%).
                if (LootTableHelper.isRuinedPortalChest(identifier)) {
                    net.fettlol.utilmod.lists.integrations.AdditionalAdditions.ROSE_GOLD_ITEMS.forEach(item -> LootApi.addToLootTable(
                        tableBuilder, 1, 0.01F, RegistryHelper.modId(FettlolModIntegrations.ADDITIONAL_ADDITIONS, item)
                    ));
                }
            });


        }
    }

}
