package net.fettlol.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.init.FettlolModIntegrations;
import net.fettlol.lists.Mods;
import net.fettlol.util.LogHelper;
import net.fettlol.util.LootTableHelper;
import net.fettlol.util.RegistryHelper;

public class AdditionalAdditions {

    public static void init() {
        if (FettlolModIntegrations.isAdditionalAdditionsLoaded) {
            LogHelper.log("Additional Addition detected! Applying integrations.");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // Villager Houses: Add Rope (3%).
                if (LootTableHelper.isVillageHouseChest(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.3F, Mods.ADDITIONAL_ADDITIONS, "rope");
                }

                // Ruined Portals: Add Rose Gold items (2%).
                if (LootTableHelper.isRuinedPortal(identifier)) {
                    net.fettlol.lists.integrations.AdditionalAdditions.ROSE_GOLD_ITEMS.forEach(item -> LootTableHelper.addToLootTable(
                        supplier, 1, 0.02F, RegistryHelper.modId(Mods.ADDITIONAL_ADDITIONS, item)
                    ));
                }
            });


        }
    }

}
