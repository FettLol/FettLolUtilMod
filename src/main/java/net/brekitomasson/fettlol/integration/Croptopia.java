package net.brekitomasson.fettlol.integration;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.init.ModIntegrations;
import net.brekitomasson.fettlol.mixin.accessor.VillagerEntityAccessor;
import net.brekitomasson.fettlol.util.LootTableHelper;
import net.brekitomasson.fettlol.util.RegistryHelper;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Croptopia {

    private static List<String> PLANTED_CROPS = Arrays.asList("artichoke", "asparagus", "barley", "basil", "bellpepper", "blackbean", "blackberry", "blueberry", "broccoli", "cabbage", "cantaloupe", "cauliflower", "celery", "chile_pepper", "coffee", "corn", "cranberry", "cucumber", "currant", "eggplant", "elderberry", "garlic", "ginger", "grape", "greenbean", "greenonion", "honeydew", "hops", "kale", "kiwi", "leek", "lettuce", "mustard", "oat", "olive", "onion", "peanut", "pineapple", "radish", "raspberry", "rhubarb", "rice", "rutabaga", "saguaro", "soybean", "spinach", "squash", "strawberry", "sweetpotato", "tomatillo", "tomato", "turmeric", "turnip", "yam", "zucchini");

    private static List<String> VILLAGER_FOOD = Arrays.asList("artichoke", "asparagus", "avocado", "banana", "barley", "basil", "bellpepper", "blackbean", "blackberry", "blueberry", "broccoli", "cabbage", "cantaloupe", "cauliflower", "celery", "cherry", "chile_pepper", "coconut", "corn", "coffee_beans", "cranberry", "cucumber", "currant", "date", "dragonfruit", "eggplant", "elderberry", "fig", "garlic", "ginger", "grape", "grapefruit", "greenbean", "greenonion", "honeydew", "hops", "kale", "kiwi", "kumquat", "leek", "lemon", "lettuce", "lime", "mango", "mustard", "nectarine", "nutmeg", "oat", "olive", "onion", "orange", "paprika", "peach", "peanut", "pear", "persimmon", "pineapple", "plum", "radish", "raspberry", "rhubarb", "rice", "rutabaga", "saguaro", "salt", "soybean", "spinach", "squash", "starfruit", "strawberry", "sweetpotato", "tomatillo", "tomato", "turmeric", "turnip", "vanilla", "yam", "zucchini");

    public static List<Item> SEEDS = PLANTED_CROPS.stream()
        .map(seed -> Registry.ITEM.get(cropSeed(seed)).asItem())
        .collect(Collectors.toList());

    public static List<Item> CROPS = PLANTED_CROPS.stream()
        .map(crop -> cropItem(crop)).collect(Collectors.toList());

    public static void init() {
        if (ModIntegrations.isCroptopiaLoaded) {
            UtilMod.LOGGER.info("Croptopia detected! Applying integrations!");

            updateLootTablesForCroptopia();
            updateComposterForCroptopia();
            updateVillagersForCroptopia();
        }
    }

    private static void updateLootTablesForCroptopia() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Randomly add a selection of Croptopia foods to villager chests.
            if (LootTableHelper.isVillageHouseChest(identifier)) {
                VILLAGER_FOOD.forEach(food -> LootTableHelper.addToLootTable(supplier, 3, 0.02F, cropIdentifier(food)));
            }

            // This is a temporary workaround in order to allow Farmer villagers to harvest and replant
            // these plants while we wait for https://github.com/ExcessiveAmountsOfZombies/Croptopia/issues/49
            PLANTED_CROPS.forEach(crop -> addSeedToCropBlock(crop, identifier, supplier));

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

    private static Item cropItem(String crop) {
        return Registry.ITEM.get(cropIdentifier(crop)).asItem();
    }

    public static Identifier cropSeed(String crop) {
        return new Identifier(ModIntegrations.CROPTOPIA, crop + "_seed");
    }

    private static String cropBlockLootTable(String crop) {
        return ModIntegrations.CROPTOPIA + ":blocks/" + crop + "_crop";
    }

    public static Identifier cropBlock(String crop) {
        return new Identifier(ModIntegrations.CROPTOPIA + ":" + crop + "_crop");
    }

    private static void updateComposterForCroptopia() {
        // Tiny things, like berries etc. 10% probability to raise levels
        Arrays.asList("blackbean", "blackberry", "blueberry", "cherry", "chile_pepper", "coffee_beans", "cranberry", "currant", "elderberry", "fig", "grape", "hops", "oat", "raisins", "raspberry", "rice", "roasted_nuts", "strawberry")
            .forEach(crop -> RegistryHelper.makeCompostable(cropIdentifier(crop), 0.1f));

        // Slightly larger things, like nuts or bigger berries. 20% probability.
        Arrays.asList("almond", "artichoke", "broccoli", "cabbage", "candied_nuts", "candy_corn", "cashew", "cauliflower", "greenonion", "lemon", "lettuce", "lime", "mango", "nectarine", "olive", "onion", "orange", "paprika", "peach", "plum", "rhubarb", "rutabaga", "spinach", "squash", "starfruit", "sweetpotato", "turmeric", "turnip", "zucchini")
            .forEach(crop -> RegistryHelper.makeCompostable(cropIdentifier(crop), 0.2f));

        // Small to medium-sized fruit. 30% probability.
        Arrays.asList("apricot", "artichoke_dip", "asparagus", "avocado", "barley", "basil", "bellpepper", "cantaloupe", "celery", "coconut", "corn", "cucumber", "date", "doughnut", "eggplant", "garlic", "ginger", "grapefruit", "greenbean", "honeydew", "kale", "kiwi", "kumquat", "leek", "pear", "pecan", "pineapple", "popcorn", "radish", "soybean", "tomatillo", "tomato", "walnut", "yam")
            .forEach(crop -> RegistryHelper.makeCompostable(cropIdentifier(crop), 0.3f));

        // Medium-to-large fruit. 50%
        Arrays.asList("almond_brittle", "banana", "butter", "brownies", "buttered_toast", "caesar_salad", "cucumber_salad", "fruit_salad", "leafy_salad", "veggie_salad", "cherry_pie", "pecan_pie", "cheese_cake", "caramel", "chicken_and_rice", "egg_roll")
            .forEach(crop -> RegistryHelper.makeCompostable(cropIdentifier(crop), 0.5f));

        // Large stuff and complete meals, 80%
        Arrays.asList("apple_pie", "baked_beans", "banana_cream_pie", "banana_nut_bread", "blt", "cheese_pizza", "cheeseburger", "hamburger", "tofuburger", "dough")
            .forEach(crop -> RegistryHelper.makeCompostable(cropIdentifier(crop), 0.8f));

        // Other, huge or expensive, things. 90%.
        Arrays.asList("beef_jerky", "cashew_chicken", "cheese", "chicken_and_dumplings", "chicken_and_noodles", "chocolate", "dragonfruit", "flour", "french_fries", "fried_chicken", "grilled_cheese", "ham_sandwich", "kale_chips", "leek_soup", "lemon_chicken", "mustard", "noodle", "nougat", "nutmeg", "nutty_cookie", "oatmeal", "onion_rings", "peanut", "peanut_butter_and_jam", "pepperoni", "persimmon", "pineapple_pepperoni_pizza", "pizza", "pork_jerky", "potato_chips", "protein_bar", "raisin_oatmeal_cookie", "ravioli", "saguaro", "salsa", "saucy_chips", "scrambled_eggs", "snicker_doodle", "spaghetti_squash", "steamed_rice", "supreme_pizza", "sushi", "sweet_potato_fries", "taco", "toast", "toast_with_jam", "tofu", "tofu_and_dumplings", "tortilla", "trail_mix", "vanilla", "pork_and_beans", "yoghurt")
            .forEach(crop -> RegistryHelper.makeCompostable(cropIdentifier(crop), 0.9f));
    }

    public static void updateVillagersForCroptopia() {
        // Define what items Villagers treat as food.
        VillagerEntityAccessor.setItemFoodValues(ImmutableMap.<Item, Integer>builder()
            .putAll(VillagerEntity.ITEM_FOOD_VALUES)
            .put(cropItem("artichoke"), 1)
            .put(cropItem("asparagus"), 1)
            .put(cropItem("barley"), 1)
            .put(cropItem("basil"), 1)
            .put(cropItem("bellpepper"), 1)
            .put(cropItem("blackbean"), 1)
            .put(cropItem("blackberry"), 1)
            .put(cropItem("blueberry"), 1)
            .put(cropItem("broccoli"), 1)
            .put(cropItem("cabbage"), 1)
            .put(cropItem("cantaloupe"), 1)
            .put(cropItem("cauliflower"), 1)
            .put(cropItem("celery"), 1)
            .put(cropItem("chile_pepper"), 1)
            .put(cropItem("coffee"), 1)
            .put(cropItem("corn"), 1)
            .put(cropItem("cranberry"), 1)
            .put(cropItem("cucumber"), 1)
            .put(cropItem("currant"), 1)
            .put(cropItem("eggplant"), 1)
            .put(cropItem("elderberry"), 1)
            .put(cropItem("garlic"), 1)
            .put(cropItem("ginger"), 1)
            .put(cropItem("grape"), 1)
            .put(cropItem("greenbean"), 1)
            .put(cropItem("greenonion"), 1)
            .put(cropItem("honeydew"), 1)
            .put(cropItem("hops"), 1)
            .put(cropItem("kale"), 1)
            .put(cropItem("kiwi"), 1)
            .put(cropItem("leek"), 1)
            .put(cropItem("lettuce"), 1)
            .put(cropItem("mustard"), 1)
            .put(cropItem("oat"), 1)
            .put(cropItem("olive"), 1)
            .put(cropItem("onion"), 1)
            .put(cropItem("peanut"), 1)
            .put(cropItem("pineapple"), 1)
            .put(cropItem("radish"), 1)
            .put(cropItem("raspberry"), 1)
            .put(cropItem("rhubarb"), 1)
            .put(cropItem("rice"), 1)
            .put(cropItem("rutabaga"), 1)
            .put(cropItem("saguaro"), 1)
            .put(cropItem("soybean"), 1)
            .put(cropItem("spinach"), 1)
            .put(cropItem("squash"), 1)
            .put(cropItem("strawberry"), 1)
            .put(cropItem("sweetpotato"), 1)
            .put(cropItem("tomatillo"), 1)
            .put(cropItem("tomato"), 1)
            .put(cropItem("turmeric"), 1)
            .put(cropItem("turnip"), 1)
            .put(cropItem("yam"), 1)
            .put(cropItem("zucchini"), 1)
            .build()
        );

        VillagerEntityAccessor.setGatherableItems(ImmutableSet.<Item>builder()
            .addAll(VillagerEntityAccessor.getGatherableItems())
            .addAll(SEEDS)
            .addAll(CROPS)
            .build());
    }

}
