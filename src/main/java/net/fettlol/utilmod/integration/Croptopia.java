package net.fettlol.utilmod.integration;

import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.lib.helper.LootTableHelper;
import net.fettlol.lib.registry.LootApi;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
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
                net.fettlol.utilmod.lists.integrations.Croptopia.VILLAGER_FOOD.forEach(food -> LootApi.addToLootTable(
                    supplier, 3, 0.02F, croptopiaIdentifier(food)
                ));
                net.fettlol.utilmod.lists.integrations.Croptopia.TOOLS.forEach(tool -> LootApi.addToLootTable(
                    supplier, 1, 0.05F, croptopiaIdentifier(tool)
                ));
            }
        });
    }

    private static Identifier croptopiaIdentifier(String crop) {
        return new Identifier(Mods.CROPTOPIA, crop);
    }

}
