package net.fettlol.integration;

import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.UtilMod;
import net.fettlol.init.ModIntegrations;
import net.fettlol.util.LootTableHelper;
import net.minecraft.util.Identifier;

public class Croptopia {

    public static void init() {
        if (ModIntegrations.isCroptopiaLoaded) {
            UtilMod.LOGGER.info("Croptopia detected! Applying integrations!");

            updateLootTablesForCroptopia();
        }
    }

    private static void updateLootTablesForCroptopia() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Add seeds to the loot tables for crops.
            // Should no longer be needed as of Croptopia v1.4.0.
            // net.fettlol.lists.Croptopia.PLANTED_CROPS.forEach(crop -> addSeedToCropBlock(crop, identifier, supplier));

            // Randomly add a selection of Croptopia foods to villager chests.
            if (LootTableHelper.isVillageHouseChest(identifier)) {
                net.fettlol.lists.Croptopia.VILLAGER_FOOD.forEach(food -> LootTableHelper.addToLootTable(
                    supplier, 2, 0.01F, croptopiaIdentifier(food)
                ));
                net.fettlol.lists.Croptopia.TOOLS.forEach(tool -> LootTableHelper.addToLootTable(
                    supplier, 1, 0.01F, croptopiaIdentifier(tool)
                ));
            }
        });
    }

    /**
     * @deprecated No longer needed as of Croptopia v1.4.0.
     */
    private static void addSeedToCropBlock(String crop, Identifier identifier, FabricLootSupplierBuilder supplier) {
        if (identifier.toString().equals(cropBlockLootTable(crop))) {
            LootTableHelper.addToLootTable(supplier, 1, 1, croptopiaSeed(crop));
        }
    }

    private static Identifier croptopiaIdentifier(String crop) {
        return new Identifier(ModIntegrations.CROPTOPIA, crop);
    }

    public static Identifier croptopiaSeed(String crop) {
        return new Identifier(ModIntegrations.CROPTOPIA, crop + "_seed");
    }

    private static String cropBlockLootTable(String crop) {
        return ModIntegrations.CROPTOPIA + ":blocks/" + crop + "_crop";
    }

}
