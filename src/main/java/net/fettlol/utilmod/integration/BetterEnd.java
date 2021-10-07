package net.fettlol.utilmod.integration;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.lib.helper.LootTableHelper;
import net.fettlol.lib.registry.LootApi;
import net.fettlol.lib.registry.RecipeApi;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.RecipeHelper;
import net.minecraft.util.Identifier;

import static net.fettlol.utilmod.util.RecipeHelper.createShapelessRecipe;
import static net.fettlol.utilmod.util.RegistryHelper.fettlolId;

public class BetterEnd {

    public static void init() {
        if (FettlolModIntegrations.isBetterEndLoaded) {
            LogHelper.log("Better End detected! Applying integrations.");

            RecipeApi.remove(Mods.BETTER_END, "tag_rail");

            defineLootTablesForBetterEnd();
            defineRecipesForBetterEnd();
        }
    }

    /**
     * There are a lot of weird recipes introduced in Better End, many of which introduce new ways of
     * crafting armor and tools. Since we want to have consistency in how these are made, these recipes
     * add the "normal" way of crafting armor and tools back for Aeternium, Thallasium and Terminite.
     */
    public static void defineRecipesForBetterEnd() {
        RecipeApi.add(
            fettlolId("betterend/aeternium_boots"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I'),
                Lists.newArrayList(new Identifier(Mods.BETTER_END, "aeternium_ingot")),
                Lists.newArrayList("item"),
                Lists.newArrayList("   ", "I I", "I I"),
                new Identifier(Mods.BETTER_END, "aeternium_boots")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/aeternium_chestplate"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I'),
                Lists.newArrayList(new Identifier(Mods.BETTER_END, "aeternium_ingot")),
                Lists.newArrayList("item"),
                Lists.newArrayList("I I", "III", "III"),
                new Identifier(Mods.BETTER_END, "aeternium_chestplate")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/aeternium_helmet"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I'),
                Lists.newArrayList(new Identifier(Mods.BETTER_END, "aeternium_ingot")),
                Lists.newArrayList("item"),
                Lists.newArrayList("   ", "III", "I I"),
                new Identifier(Mods.BETTER_END, "aeternium_helmet")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/aeternium_leggings"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I'),
                Lists.newArrayList(new Identifier(Mods.BETTER_END, "aeternium_ingot")),
                Lists.newArrayList("item"),
                Lists.newArrayList("III", "I I", "I I"),
                new Identifier(Mods.BETTER_END, "aeternium_leggings")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/aeternium_axe"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "aeternium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " SI", " S "),
                new Identifier(Mods.BETTER_END, "aeternium_axe")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/aeternium_hoe"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "aeternium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " S ", " S "),
                new Identifier(Mods.BETTER_END, "aeternium_hoe")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/aeternium_pickaxe"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "aeternium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList("III", " S ", " S "),
                new Identifier(Mods.BETTER_END, "aeternium_pickaxe")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/aeternium_shovel"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "aeternium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " S ", " S "),
                new Identifier(Mods.BETTER_END, "aeternium_shovel")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/aeternium_sword"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "aeternium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " I ", " S "),
                new Identifier(Mods.BETTER_END, "aeternium_sword")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/terminite_axe"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " SI", " S "),
                new Identifier(Mods.BETTER_END, "terminite_axe")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/terminite_hoe"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " S ", " S "),
                new Identifier(Mods.BETTER_END, "terminite_hoe")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/terminite_pickaxe"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList("III", " S ", " S "),
                new Identifier(Mods.BETTER_END, "terminite_pickaxe")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/terminite_shovel"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " S ", " S "),
                new Identifier(Mods.BETTER_END, "terminite_shovel")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/thallasium_axe"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "thallasium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " SI", " S "),
                new Identifier(Mods.BETTER_END, "thallasium_axe")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/thallasium_hoe"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "thallasium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" II", " S ", " S "),
                new Identifier(Mods.BETTER_END, "thallasium_hoe")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/thallasium_pickaxe"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "thallasium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList("III", " S ", " S "),
                new Identifier(Mods.BETTER_END, "thallasium_pickaxe")
            )
        );


        RecipeApi.add(
            fettlolId("betterend/thallasium_shovel"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "thallasium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " S ", " S "),
                new Identifier(Mods.BETTER_END, "thallasium_shovel")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/thallasium_sword"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "thallasium_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " I ", " S "),
                new Identifier(Mods.BETTER_END, "thallasium_sword")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/terminite_sword"),
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'S'),
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList(" I ", " I ", " S "),
                new Identifier(Mods.BETTER_END, "terminite_sword")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/aeternium_ingot"),
            createShapelessRecipe(
                Lists.newArrayList(
                    new Identifier(Mods.BETTER_END, "terminite_ingot"),
                    new Identifier("minecraft", "netherite_ingot")
                ),
                Lists.newArrayList("item", "item"),
                new Identifier(Mods.BETTER_END, "aeternium_ingot")
            )
        );

        RecipeApi.add(
            fettlolId("betterend/terminite_ingot"),
            createShapelessRecipe(
                Lists.newArrayList(
                    new Identifier("c", "ender_pearl_dusts"),
                    new Identifier("minecraft", "iron_ingot")
                ),
                Lists.newArrayList("tag", "item"),
                new Identifier(Mods.BETTER_END, "terminite_ingot")
            )
        );
    }

    /**
     * Better End has a number of interesting items and blocks that we want to make available in other
     * parts of the game so as to make everything feel a little bit more connected.
     */
    private static void defineLootTablesForBetterEnd() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {

            // Endermen: Add Ender Dust (5%).
            // @todo Change this to the Ender Dust from Applied Energistics?
            if (LootTableHelper.isEnderman(identifier)) {
                LootApi.addToLootTable(supplier, 1, 0.05F, Mods.BETTER_END, "ender_dust");
            }

            // Buried Treasure: Add Raw Amber (10%).
            if (LootTableHelper.isBuriedTreasureChest(identifier)) {
                LootApi.addToLootTable(supplier, 1, 0.1F, Mods.BETTER_END, "raw_amber");
            }

        });
    }

}
