package net.brekitomasson.fettlol.integration;

import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.init.ModIntegrations;
import net.brekitomasson.fettlol.util.LootTableHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;

public class Croptopia {
    public static void init() {
        if (ModIntegrations.isCroptopiaLoaded) {
            UtilMod.LOGGER.info("Croptopia detected! Modifying loot tables.");

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

                // Randomly add a selection of Croptopia foods to villager chests.
                if (LootTableHelper.isVillageHouseChest(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "artichoke");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "asparagus");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "avocado");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "banana");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "barley");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "basil");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "bellpepper");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "blackbean");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "blackberry");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "blueberry");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "broccoli");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "cabbage");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "cantaloupe");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "cauliflower");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "celery");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "cherry");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "chile_pepper");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "coconut");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "corn");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "coffee_beans");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "cranberry");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "cucumber");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "currant");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "date");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "dragonfruit");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "eggplant");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "elderberry");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "fig");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "garlic");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "ginger");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "grape");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "grapefruit");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "greenbean");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "greenonion");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "honeydew");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "hops");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "kale");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "kiwi");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "kumquat");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "leek");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "lemon");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "lettuce");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "lime");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "mango");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "mustard");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "nectarine");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "nutmeg");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "oat");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "olive");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "onion");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "orange");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "paprika");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "peach");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "peanut");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "pear");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "persimmon");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "pineapple");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "plum");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "radish");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "raspberry");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "rhubarb");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "rice");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "rutabaga");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "saguaro");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "salt");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "soybean");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "spinach");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "squash");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "starfruit");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "strawberry");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "sweetpotato");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "tomatillo");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "tomato");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "turmeric");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "turnip");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "vanilla");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "yam");
                    LootTableHelper.addToLootTable(supplier, 3, 0.01F, ModIntegrations.CROPTOPIA, "zucchini");
                }

            });
        } else {
            UtilMod.LOGGER.info("Croptopia not detected! Not adding mod interactions.");
        }
    }
}
