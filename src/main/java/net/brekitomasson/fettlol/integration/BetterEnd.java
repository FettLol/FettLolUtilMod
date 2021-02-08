package net.brekitomasson.fettlol.integration;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.init.ModIntegrations;
import net.brekitomasson.fettlol.util.LootTableHelper;
import net.brekitomasson.fettlol.util.RecipeHelper;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.util.Identifier;

public class BetterEnd {

    // Null definitions for custom recipes that may be applied if this mod is available.
    public static JsonObject AETERNIUM_AXE_RECIPE = null;
    public static JsonObject AETERNIUM_BOOTS_RECIPE = null;
    public static JsonObject AETERNIUM_CHESTPLATE_RECIPE = null;
    public static JsonObject AETERNIUM_HELMET_RECIPE = null;
    public static JsonObject AETERNIUM_HOE_RECIPE = null;
    public static JsonObject AETERNIUM_INGOT_RECIPE = null;
    public static JsonObject AETERNIUM_LEGGINGS_RECIPE = null;
    public static JsonObject AETERNIUM_PICKAXE_RECIPE = null;
    public static JsonObject AETERNIUM_SHOVEL_RECIPE = null;
    public static JsonObject AETERNIUM_SWORD_RECIPE = null;
    public static JsonObject TERMINITE_INGOT_RECIPE = null;

    public static void init() {
        if (ModIntegrations.isBetterEndLoaded) {
            UtilMod.LOGGER.info("Better End detected! Modifying loot tables.");

            defineLootTablesForBetterEnd();
            defineRecipesForBetterEnd();
        } else {
            UtilMod.LOGGER.info("Better End not detected! Not adding mod interactions.");
        }
    }

    public static void defineRecipesForBetterEnd() {
        // The Aeternium armor and tools added by Better End have a very roundabout acquisition process which
        // does not feel native to the overall Minecraft experience. To make things easier for everybody,
        // we'll also add all the standard recipes using sticks and/or Aeternium Ingots.
        AETERNIUM_AXE_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('I', 'S'),
            Lists.newArrayList(new Identifier("betterend", "aeternium_ingot"), new Identifier("minecraft", "stick")),
            Lists.newArrayList("item", "item"),
            Lists.newArrayList(" II", " SI", " S "),
            new Identifier("betterend", "aeternium_axe")
        );

        AETERNIUM_BOOTS_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('I'),
            Lists.newArrayList(new Identifier("betterend", "aeternium_ingot")),
            Lists.newArrayList("item"),
            Lists.newArrayList("   ", "I I", "I I"),
            new Identifier("betterend", "aeternium_boots")
        );

        AETERNIUM_CHESTPLATE_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('I'),
            Lists.newArrayList(new Identifier("betterend", "aeternium_ingot")),
            Lists.newArrayList("item"),
            Lists.newArrayList("I I", "III", "III"),
            new Identifier("betterend", "aeternium_chestplate")
        );

        AETERNIUM_HELMET_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('I'),
            Lists.newArrayList(new Identifier("betterend", "aeternium_ingot")),
            Lists.newArrayList("item"),
            Lists.newArrayList("   ", "III", "I I"),
            new Identifier("betterend", "aeternium_helmet")
        );

        AETERNIUM_HOE_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('I', 'S'),
            Lists.newArrayList(new Identifier("betterend", "aeternium_ingot"), new Identifier("minecraft", "stick")),
            Lists.newArrayList("item", "item"),
            Lists.newArrayList(" II", " S ", " S "),
            new Identifier("betterend", "aeternium_hoe")
        );

        AETERNIUM_LEGGINGS_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('I'),
            Lists.newArrayList(new Identifier("betterend", "aeternium_ingot")),
            Lists.newArrayList("item"),
            Lists.newArrayList("III", "I I", "I I"),
            new Identifier("betterend", "aeternium_leggings")
        );

        AETERNIUM_PICKAXE_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('I', 'S'),
            Lists.newArrayList(new Identifier("betterend", "aeternium_ingot"), new Identifier("minecraft", "stick")),
            Lists.newArrayList("item", "item"),
            Lists.newArrayList("III", " S ", " S "),
            new Identifier("betterend", "aeternium_pickaxe")
        );

        AETERNIUM_SHOVEL_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('I', 'S'),
            Lists.newArrayList(new Identifier("betterend", "aeternium_ingot"), new Identifier("minecraft", "stick")),
            Lists.newArrayList("item", "item"),
            Lists.newArrayList(" I ", " S ", " S "),
            new Identifier("betterend", "aeternium_shovel")
        );

        AETERNIUM_SWORD_RECIPE = RecipeHelper.createShapedRecipe(
            Lists.newArrayList('I', 'S'),
            Lists.newArrayList(new Identifier("betterend", "aeternium_ingot"), new Identifier("minecraft", "stick")),
            Lists.newArrayList("item", "item"),
            Lists.newArrayList(" I ", " I ", " S "),
            new Identifier("betterend", "aeternium_sword")
        );

        // We'll also create a custom recipe for the Aeternium Ingot itself, as the intended way of getting it
        // is also fairly roundabout and confusing.
        AETERNIUM_INGOT_RECIPE = RecipeHelper.createShapelessRecipe(
            Lists.newArrayList(new Identifier("betterend", "terminite_ingot"), new Identifier("minecraft", "netherite_ingot")),
            Lists.newArrayList("item", "item"),
            new Identifier("betterend", "aeternium_ingot")
        );

        // Finally, an alternative way for the Terminite Ingot, so we don't have to worry about Better End's
        // custom Anvil-types of recipes at all. This will also allow us to use all the Ender Dusts added by
        // Applied Energistics and TechReborn instead of just Better End's own Ender Dust item.
        TERMINITE_INGOT_RECIPE = RecipeHelper.createShapelessRecipe(
            Lists.newArrayList(new Identifier("c", "ender_pearl_dusts"), new Identifier("minecraft", "iron_ingot")),
            Lists.newArrayList("tag", "item"),
            new Identifier("betterend", "terminite_ingot")
        );
    }

    /**
     * Better End has a number of interesting items and blocks that we want to make available in other
     * parts of the game so as to make everything feel a little bit more connected.
     */
    private static void defineLootTablesForBetterEnd() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Endermen drop one Ender Dust 10% of the time.
            // TODO - Consider changing this to the Ender Dust from Applied Energistics?
            if (LootTableHelper.isEnderman(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.1F, ModIntegrations.BETTER_END, "ender_dust");
            }

            // Buried treasure has a 10% chance of containing one Raw Amber.
            if (LootTableHelper.isBuriedTreasure(identifier)) {
                LootTableHelper.addToLootTable(supplier, 1, 0.1F, ModIntegrations.BETTER_END, "raw_amber");
            }

        });
    }
}
