package net.fettlol.integration;

import net.fettlol.UtilMod;
import net.fettlol.init.ModIntegrations;
import net.fettlol.lists.Integrations;
import net.fettlol.util.LootTableHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.util.RecipeHelper;

public class RingOfAttraction {

    public static void init() {
        if (ModIntegrations.isRingOfAttractionLoaded) {
            UtilMod.LOGGER.info("Ring of Attraction detected! Applying integrations!");

            // Remove the crafting recipe for this, as we want it only available as a drop.
            RecipeHelper.removeRecipe(Integrations.RING_OF_ATTRACTION, "ring_of_attraction");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                // The Ring of Attraction has a tiny chance to appear in End City chests.
                if (LootTableHelper.isEndEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.01F, Integrations.RING_OF_ATTRACTION, "ring_of_attraction");
                }
            });

        }
    }

}
