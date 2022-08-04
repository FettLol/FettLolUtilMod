package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.registry.LootApi;
import net.fettlol.utilmod.registry.RecipeApi;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.LootTableHelper;

public class RingOfAttraction {

    public static void init() {
        if (FettlolModIntegrations.isRingOfAttractionLoaded) {
            LogHelper.log("Ring of Attraction detected! Applying integrations!");

            // Remove the crafting recipe for this, as we want it only available as a drop.
            RecipeApi.remove(Mods.RING_OF_ATTRACTION, "ring_of_attraction");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // The Ring of Attraction has a tiny chance to appear in End City chests.
                if (LootTableHelper.isEndEndgameChest(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.01F, Mods.RING_OF_ATTRACTION, "ring_of_attraction");
                }
            });

        }
    }

}
