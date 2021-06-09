package net.fettlol.integration;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.UtilMod;
import net.fettlol.init.FettlolRecipes;
import net.fettlol.init.ModIntegrations;
import net.fettlol.util.LootTableHelper;
import net.fettlol.util.RecipeHelper;
import net.minecraft.util.Identifier;

public class DankStorage {

    public static void init() {
        if (ModIntegrations.isDankStorageLoaded) {
            UtilMod.LOGGER.info("Dank Storage detected! Applying integrations.");

            replaceDankRecipes();

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                if (LootTableHelper.isEnderDragon(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.1F, ModIntegrations.DANKSTORAGE, "dank_5");
                }

                if (LootTableHelper.isNetherEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.05F, ModIntegrations.DANKSTORAGE, "dank_3");
                }

                if (LootTableHelper.isEndEndgame(identifier)) {
                    LootTableHelper.addToLootTable(supplier, 1, 0.05F, ModIntegrations.DANKSTORAGE, "dank_4");
                }

            });
        }
    }

    public static void replaceDankRecipes() {
        replaceDank5();
        replaceDank6();
        replaceDank7();
    }

    /**
     * Dank 5 originally required 8 diamond blocks. 4 of these have been swapped with Aquamarine Gems.
     */
    private static void replaceDank5() {
        RecipeHelper.removeRecipe(ModIntegrations.DANKSTORAGE, "4_to_5");
        RecipeHelper.removeRecipe(ModIntegrations.DANKSTORAGE, "5");

        FettlolRecipes.CUSTOM_RECIPES.put("dank/4_to_5",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('A', 'D', 'S'),
                Lists.newArrayList(
                    new Identifier(UtilMod.MOD_ID, "aquamarine_gem"),
                    new Identifier("minecraft", "diamond_block"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("ADA", "DSD", "ADA"),
                new Identifier(ModIntegrations.DANKSTORAGE, "4_to_5")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put("dank/5",
            RecipeHelper.createShapedRecipeOfType(
                "dankstorage:upgrade",
                Lists.newArrayList('A', 'D', 'S'),
                Lists.newArrayList(
                    new Identifier(UtilMod.MOD_ID, "aquamarine_gem"),
                    new Identifier("minecraft", "diamond_block"),
                    new Identifier(ModIntegrations.DANKSTORAGE, "dank_4")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("ADA", "DSD", "ADA"),
                new Identifier(ModIntegrations.DANKSTORAGE, "dank_5")
            )
        );
    }

    /**
     * After Dank 5, it felt like 8 Obsidian was too cheap for the next level.
     * This replaces 4 of those Obsidian with Netherite Scraps instead.
     */
    private static void replaceDank6() {
        RecipeHelper.removeRecipe(ModIntegrations.DANKSTORAGE, "5_to_6");
        RecipeHelper.removeRecipe(ModIntegrations.DANKSTORAGE, "6");

        FettlolRecipes.CUSTOM_RECIPES.put("dank/5_to_6",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('A', 'D', 'S'),
                Lists.newArrayList(
                    new Identifier("minecraft", "netherite_scrap"),
                    new Identifier("minecraft", "obsidian"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("ADA", "DSD", "ADA"),
                new Identifier(ModIntegrations.DANKSTORAGE, "5_to_6")
            )
        );

        FettlolRecipes.CUSTOM_RECIPES.put("dank/6",
            RecipeHelper.createShapedRecipeOfType(
                "dankstorage:upgrade",
                Lists.newArrayList('A', 'D', 'S'),
                Lists.newArrayList(
                    new Identifier("minecraft", "netherite_scrap"),
                    new Identifier("minecraft", "obsidian"),
                    new Identifier(ModIntegrations.DANKSTORAGE, "dank_5")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("ADA", "DSD", "ADA"),
                new Identifier(ModIntegrations.DANKSTORAGE, "dank_6")
            )
        );
    }

    /**
     * Eight Nether Stars for Dank 7? ... EIGHT NETHER STARS?
     * How about we use a couple of materials from various mods that fit the
     * entire "rainbow"-like theme a little better instead?
     */
    private static void replaceDank7() {
        if (
            ModIntegrations.isEarth2JavaLoaded
                && ModIntegrations.isTerrestriaLoaded
                && ModIntegrations.isBygLoaded
                && ModIntegrations.isBetterEndLoaded
        ) {
            RecipeHelper.removeRecipe(ModIntegrations.DANKSTORAGE, "6_to_7");
            RecipeHelper.removeRecipe(ModIntegrations.DANKSTORAGE, "7");

            FettlolRecipes.CUSTOM_RECIPES.put("dank/6_to_7",
                RecipeHelper.createShapedRecipe(
                    Lists.newArrayList('D', 'S'),
                    Lists.newArrayList(
                        new Identifier("minecraft", "nether_star"),
                        new Identifier("minecraft", "stick")
                    ),
                    Lists.newArrayList("item", "item", "item"),
                    Lists.newArrayList(" D ", "DSD", " D "),
                    new Identifier(ModIntegrations.DANKSTORAGE, "6_to_7")
                )
            );

            FettlolRecipes.CUSTOM_RECIPES.put("dank/7",
                RecipeHelper.createShapedRecipeOfType(
                    "dankstorage:upgrade",
                    Lists.newArrayList('W', 'S', 'E', 'J', 'D', 'A', 'a', 's', 'e'),
                    Lists.newArrayList(
                        new Identifier(ModIntegrations.EARTH2JAVA, "rainbow_wool"),
                        new Identifier("minecraft", "nether_star"),
                        new Identifier(ModIntegrations.TERRESTRIA, "rainbow_eucalyptus_sapling"),
                        new Identifier("fettlol", "jade_gem"),
                        new Identifier(ModIntegrations.DANKSTORAGE, "dank_6"),
                        new Identifier("fettlol", "aquamarine_gem"),
                        new Identifier(ModIntegrations.BYG, "ametrine_gems"),
                        new Identifier("fettlol", "soul_gem"),
                        new Identifier(ModIntegrations.BETTER_END, "eternal_crystal")
                    ),
                    Lists.newArrayList("item", "item", "item", "item", "item", "item", "item", "item", "item"),
                    Lists.newArrayList("WSE", "JDA", "ase"),
                    new Identifier(ModIntegrations.DANKSTORAGE, "dank_7")
                )
            );
        }
    }
}
