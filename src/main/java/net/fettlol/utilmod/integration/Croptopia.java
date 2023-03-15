package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.registry.LootApi;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.LootTableHelper;
import net.minecraft.util.Identifier;

public class Croptopia {

    public static void init() {
        if (FettlolModIntegrations.isCroptopiaLoaded) {
            LogHelper.log("Croptopia detected! Applying integrations!");

            LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, tableBuilder, source) -> {
                // Randomly add a selection of Croptopia foods to villager chests.
                if (LootTableHelper.isVillageHouseChest(identifier)) {
                    net.fettlol.utilmod.lists.integrations.Croptopia.VILLAGER_FOOD.forEach(food -> LootApi.addToLootTable(
                        tableBuilder, 2, 0.01F, croptopiaIdentifier(food)
                    ));
                    net.fettlol.utilmod.lists.integrations.Croptopia.TOOLS.forEach(tool -> LootApi.addToLootTable(
                        tableBuilder, 1, 0.01F, croptopiaIdentifier(tool)
                    ));
                }
            });
        }
    }

    private static Identifier croptopiaIdentifier(String item) {
        return new Identifier(FettlolModIntegrations.CROPTOPIA, item);
    }

}
