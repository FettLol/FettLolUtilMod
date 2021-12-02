package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.lib.helper.LootTableHelper;
import net.fettlol.lib.registry.LootApi;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.RegistryHelper;

public class AdditionalAdditions {

    public static void init() {
        if (FettlolModIntegrations.isAdditionalAdditionsLoaded) {
            LogHelper.log("Additional Addition detected! Applying integrations.");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // Villager Houses: Add Rope (3%).
                if (LootTableHelper.isVillageHouseChest(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.1F, Mods.ADDITIONAL_ADDITIONS, "rope");
                }

                // Ruined Portals: Add Rose Gold items (2%).
                if (LootTableHelper.isRuinedPortalChest(identifier)) {
                    net.fettlol.utilmod.lists.integrations.AdditionalAdditions.ROSE_GOLD_ITEMS.forEach(item -> LootApi.addToLootTable(
                        supplier, 1, 0.02F, RegistryHelper.modId(Mods.ADDITIONAL_ADDITIONS, item)
                    ));
                }
            });


        }
    }

}
