package net.fettlol.integration;

import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.UtilMod;
import net.fettlol.init.ModIntegrations;
import net.fettlol.util.LootTableHelper;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

public class Croptopia {

    private static List<String> PLANTED_CROPS = Arrays.asList("artichoke", "asparagus", "barley", "basil", "bellpepper", "blackbean", "blackberry", "blueberry", "broccoli", "cabbage", "cantaloupe", "cauliflower", "celery", "chile_pepper", "coffee", "corn", "cranberry", "cucumber", "currant", "eggplant", "elderberry", "garlic", "ginger", "grape", "greenbean", "greenonion", "honeydew", "hops", "kale", "kiwi", "leek", "lettuce", "mustard", "oat", "olive", "onion", "peanut", "pineapple", "radish", "raspberry", "rhubarb", "rice", "rutabaga", "saguaro", "soybean", "spinach", "squash", "strawberry", "sweetpotato", "tomatillo", "tomato", "turmeric", "turnip", "yam", "zucchini");

    private static final List<String> VILLAGER_FOOD = Arrays.asList(
        "almond",
        "almond_brittle",
        "apple_juice",
        "apple_pie",
        "apricot",
        "apricot_jam",
        "artichoke",
        "artichoke_dip",
        "artichoke_seed",
        "asparagus",
        "avocado",
        "baked_beans",
        "banana",
        "banana_cream_pie",
        "banana_nut_bread",
        "banana_smoothie",
        "barley",
        "basil",
        "beef_jerky",
        "beer",
        "bellpepper",
        "blackbean",
        "blackberry",
        "blackberry_jam",
        "blt",
        "blueberry",
        "blueberry_jam",
        "broccoli",
        "brownies",
        "burrito",
        "butter",
        "buttered_toast",
        "cabbage",
        "caesar_salad",
        "candied_nuts",
        "candy_corn",
        "cantaloupe",
        "caramel",
        "carnitas",
        "cashew",
        "cashew_chicken",
        "cauliflower",
        "celery",
        "cheese",
        "cheese_cake",
        "cheese_pizza",
        "cheeseburger",
        "cherry",
        "cherry_jam",
        "cherry_pie",
        "chicken_and_dumplings",
        "chicken_and_noodles",
        "chicken_and_rice",
        "chile_pepper",
        "chili_relleno",
        "chimichanga",
        "chocolate",
        "chocolate_milkshake",
        "churros",
        "cinnamon",
        "coconut",
        "coffee",
        "coffee_beans",
        "corn",
        "corn_husk",
        "cranberry",
        "cranberry_juice",
        "crema",
        "cucumber",
        "cucumber_salad",
        "currant",
        "date",
        "dough",
        "doughnut",
        "dragonfruit",
        "egg_roll",
        "eggplant",
        "elderberry",
        "elderberry_jam",
        "enchilada",
        "fajitas",
        "fig",
        "flour",
        "french_fries",
        "fried_chicken",
        "fruit_salad",
        "fruit_smoothie",
        "garlic",
        "ginger",
        "grape",
        "grape_jam",
        "grape_juice",
        "grapefruit",
        "greenbean",
        "greenonion",
        "grilled_cheese",
        "ham_sandwich",
        "hamburger",
        "honeydew",
        "hops",
        "horchata",
        "kale",
        "kale_chips",
        "kale_smoothie",
        "kiwi",
        "kumquat",
        "leafy_salad",
        "leek",
        "leek_soup",
        "lemon",
        "lemon_chicken",
        "lemonade",
        "lettuce",
        "lime",
        "limeade",
        "mango",
        "mango_ice_cream",
        "mead",
        "melon_juice",
        "molasses",
        "mustard",
        "nectarine",
        "noodle",
        "nougat",
        "nutmeg",
        "nutty_cookie",
        "oat",
        "oatmeal",
        "olive",
        "olive_oil",
        "onion",
        "onion_rings",
        "orange",
        "orange_juice",
        "paprika",
        "peach",
        "peach_jam",
        "peanut",
        "peanut_butter_and_jam",
        "pear",
        "pecan",
        "pecan_ice_cream",
        "pecan_pie",
        "pepper",
        "pepperoni",
        "persimmon",
        "pineapple",
        "pineapple_juice",
        "pineapple_pepperoni_pizza",
        "pizza",
        "plum",
        "popcorn",
        "pork_and_beans",
        "pork_jerky",
        "potato_chips",
        "protein_bar",
        "pumpkin_spice_latte",
        "quesadilla",
        "radish",
        "raisin_oatmeal_cookie",
        "raisins",
        "raspberry",
        "raspberry_jam",
        "ravioli",
        "refried_beans",
        "rhubarb",
        "rice",
        "roasted_nuts",
        "rum",
        "rum_raisin_ice_cream",
        "rutabaga",
        "saguaro",
        "saguaro_juice",
        "salsa",
        "salt",
        "saucy_chips",
        "scrambled_eggs",
        "snicker_doodle",
        "soy_milk",
        "soy_sauce",
        "soybean",
        "spaghetti_squash",
        "spinach",
        "squash",
        "starfruit",
        "steamed_rice",
        "strawberry",
        "strawberry_ice_cream",
        "strawberry_jam",
        "strawberry_smoothie",
        "stuffed_poblanos",
        "supreme_pizza",
        "sushi",
        "sweet_potato_fries",
        "sweetpotato",
        "taco",
        "tamales",
        "toast",
        "toast_with_jam",
        "tofu",
        "tofu_and_dumplings",
        "tofuburger",
        "tomatillo",
        "tomato",
        "tomato_juice",
        "tortilla",
        "tostada",
        "trail_mix",
        "tres_leche_cake",
        "tuna_sandwich",
        "turmeric",
        "turnip",
        "vanilla",
        "vanilla_ice_cream",
        "veggie_salad",
        "walnut",
        "whipping_cream",
        "wine",
        "yam",
        "yam_jam",
        "yoghurt",
        "zucchini");

    public static void init() {
        if (ModIntegrations.isCroptopiaLoaded) {
            UtilMod.LOGGER.info("Croptopia detected! Applying integrations!");

            updateLootTablesForCroptopia();
        }
    }

    private static void updateLootTablesForCroptopia() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Add seeds to the loot tables for crops.
            PLANTED_CROPS.forEach(crop -> addSeedToCropBlock(crop, identifier, supplier));

            // Randomly add a selection of Croptopia foods to villager chests.
            if (LootTableHelper.isVillageHouseChest(identifier)) {
                VILLAGER_FOOD.forEach(food -> LootTableHelper.addToLootTable(
                    supplier, 4, 0.01F, cropIdentifier(food))
                );
            }
        });
    }

    private static void addSeedToCropBlock(String crop, Identifier identifier, FabricLootSupplierBuilder supplier) {
        if (identifier.toString().equals(cropBlockLootTable(crop))) {
            LootTableHelper.addToLootTable(supplier, 1, 1, cropSeed(crop));
        }
    }

    private static Identifier cropIdentifier(String crop) {
        return new Identifier(ModIntegrations.CROPTOPIA, crop);
    }

    public static Identifier cropSeed(String crop) {
        return new Identifier(ModIntegrations.CROPTOPIA, crop + "_seed");
    }

    private static String cropBlockLootTable(String crop) {
        return ModIntegrations.CROPTOPIA + ":blocks/" + crop + "_crop";
    }

}
