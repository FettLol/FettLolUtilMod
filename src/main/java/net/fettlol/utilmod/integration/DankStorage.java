package net.fettlol.utilmod.integration;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fettlol.lib.helper.LootTableHelper;
import net.fettlol.lib.registry.LootApi;
import net.fettlol.lib.registry.RecipeApi;
import net.fettlol.utilmod.UtilMod;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.RecipeHelper;
import net.fettlol.utilmod.util.RegistryHelper;
import net.minecraft.util.Identifier;

/**
 * @todo Update these recipes to include tokens from the Tokenable Furnaces & Storage mod?
 */
public class DankStorage {

    public static void init() {
        if (FettlolModIntegrations.isDankStorageLoaded) {
            LogHelper.log("Dank Storage detected! Applying integrations.");

            replaceDankRecipes();

            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, supplier, setter) -> {
                if (LootTableHelper.isEnderDragon(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.1F, Mods.DANKSTORAGE, "dank_5");
                }

                if (LootTableHelper.isNetherEndgameChest(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.05F, Mods.DANKSTORAGE, "dank_3");
                }

                if (LootTableHelper.isEndEndgameChest(identifier)) {
                    LootApi.addToLootTable(supplier, 1, 0.05F, Mods.DANKSTORAGE, "dank_4");
                }

            });
        }
    }

    public static void replaceDankRecipes() {
        RecipeApi.remove(Mods.DANKSTORAGE, "1_to_2");
        RecipeApi.remove(Mods.DANKSTORAGE, "2_to_3");
        RecipeApi.remove(Mods.DANKSTORAGE, "3_to_4");
        RecipeApi.remove(Mods.DANKSTORAGE, "4_to_5");
        RecipeApi.remove(Mods.DANKSTORAGE, "5_to_6");
        RecipeApi.remove(Mods.DANKSTORAGE, "6_to_7");

        replaceDank5();
        replaceDank6();
        replaceDank7();
    }

    /**
     * Dank 5 originally required 8 diamond blocks. 4 of these have been swapped with Aquamarine Gems.
     */
    private static void replaceDank5() {
        RecipeApi.remove(Mods.DANKSTORAGE, "5");

        RecipeApi.add(
            RegistryHelper.fettlolId("dank/5"),
            RecipeHelper.createShapedRecipeOfType(
                "dankstorage:upgrade",
                Lists.newArrayList('A', 'D', 'S'),
                Lists.newArrayList(
                    new Identifier(UtilMod.MOD_ID, "aquamarine_gem"),
                    new Identifier("minecraft", "diamond_block"),
                    new Identifier(Mods.DANKSTORAGE, "dank_4")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("ADA", "DSD", "ADA"),
                new Identifier(Mods.DANKSTORAGE, "dank_5")
            )
        );
    }

    /**
     * After Dank 5, it felt like 8 Obsidian was too cheap for the next level.
     * This replaces 4 of those Obsidian with Netherite Scraps instead.
     */
    private static void replaceDank6() {
        RecipeApi.remove(Mods.DANKSTORAGE, "6");

        RecipeApi.add(
            RegistryHelper.fettlolId("dank/6"),
            RecipeHelper.createShapedRecipeOfType(
                "dankstorage:upgrade",
                Lists.newArrayList('A', 'D', 'S'),
                Lists.newArrayList(
                    new Identifier("minecraft", "netherite_scrap"),
                    new Identifier("minecraft", "obsidian"),
                    new Identifier(Mods.DANKSTORAGE, "dank_5")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("ADA", "DSD", "ADA"),
                new Identifier(Mods.DANKSTORAGE, "dank_6")
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
            FettlolModIntegrations.isEarth2JavaLoaded
                && FettlolModIntegrations.isTerrestriaLoaded
                && FettlolModIntegrations.isBygLoaded
                && FettlolModIntegrations.isBetterEndLoaded
        ) {
            RecipeApi.remove(Mods.DANKSTORAGE, "7");

            RecipeApi.add(
                RegistryHelper.fettlolId("dank/7"),
                RecipeHelper.createShapedRecipeOfType(
                    "dankstorage:upgrade",
                    Lists.newArrayList('W', 'S', 'E', 'J', 'D', 'A', 'a', 's', 'e'),
                    Lists.newArrayList(
                        new Identifier(Mods.EARTH2JAVA, "rainbow_wool"),
                        new Identifier("minecraft", "nether_star"),
                        new Identifier("fettlol", "rainbow_saplings"),
                        new Identifier("fettlol", "jade_gem"),
                        new Identifier(Mods.DANKSTORAGE, "dank_6"),
                        new Identifier("fettlol", "aquamarine_gem"),
                        new Identifier(Mods.BYG, "ametrine_gems"),
                        new Identifier("fettlol", "soul_gem"),
                        new Identifier(Mods.BETTER_END, "eternal_crystal")
                    ),
                    Lists.newArrayList("item", "item", "tag", "item", "item", "item", "item", "item", "item"),
                    Lists.newArrayList("WSE", "JDA", "ase"),
                    new Identifier(Mods.DANKSTORAGE, "dank_7")
                )
            );
        }
    }
}
