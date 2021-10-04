package net.fettlol.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.init.FettlolModIntegrations;
import net.fettlol.lists.Mods;
import net.fettlol.util.LogHelper;
import net.fettlol.util.LootTableHelper;
import net.minecraft.util.Identifier;

public class Croptopia {

    public static void init() {
        if (FettlolModIntegrations.isCroptopiaLoaded) {
            LogHelper.log("Croptopia detected! Applying integrations!");

            updateLootTablesForCroptopia();
        }
    }

    private static void updateLootTablesForCroptopia() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
            // Randomly add a selection of Croptopia foods to villager chests.
            if (LootTableHelper.isVillageHouseChest(identifier)) {
                net.fettlol.lists.integrations.Croptopia.VILLAGER_FOOD.forEach(food -> LootTableHelper.addToLootTable(
                    supplier, 2, 0.005F, croptopiaIdentifier(food)
                ));
                net.fettlol.lists.integrations.Croptopia.TOOLS.forEach(tool -> LootTableHelper.addToLootTable(
                    supplier, 1, 0.005F, croptopiaIdentifier(tool)
                ));
            }
        });
    }

    private static Identifier croptopiaIdentifier(String crop) {
        return new Identifier(Mods.CROPTOPIA, crop);
    }

}
