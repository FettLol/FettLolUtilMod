package net.fettlol.init;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.fettlol.UtilMod;
import net.fettlol.lists.Mods;
import net.fettlol.util.RecipeHelper;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class FettlolRecipes {

    public static HashMap<String, JsonObject> CUSTOM_RECIPES = new HashMap<>();

    public static void init() {
        // Simplified or alternate versions of existing recipes.
        addSimplifiedDispenserRecipe();
        addSimplifiedDropperRecipe();
        addSimplifiedFurnaceRecipe();
        addSimplifiedObserverRecipe();
        addSimplifiedPistonRecipe();
        addSimplifiedRepeaterRecipe();

        // Bonus recipes for previously uncraftable things.
        addEnchantedGoldenAppleRecipe();
        addHopperRecipe();
        addTridentRecipe();
        addSaddleRecipe();
    }

    private static void addTridentRecipe() {
        if (FettlolModIntegrations.isAdornLoaded) {
            CUSTOM_RECIPES.put(
                "extras/trident",
                RecipeHelper.createShapedRecipe(
                    Lists.newArrayList('S', 'A', 'C', 'P'),
                    Lists.newArrayList(
                        new Identifier("minecraft", "prismarine_shard"),
                        new Identifier(UtilMod.MOD_ID, "aquamarine_gem"),
                        new Identifier("minecraft", "conduit"),
                        new Identifier(Mods.ADORN, "prismarine_brick_post")
                    ),
                    Lists.newArrayList("item", "item", "item", "item"),
                    Lists.newArrayList("SSS", "ACA", " P "),
                    new Identifier("minecraft", "trident")
                )
            );
        }
    }

    private static void addSaddleRecipe() {
        CUSTOM_RECIPES.put(
            "extras/saddle",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('#', 'T', 'g'),
                Lists.newArrayList(
                    new Identifier("minecraft", "leather"),
                    new Identifier("minecraft", "tripwire_hook"),
                    new Identifier("minecraft", "gold_ingot")
                ),
                Lists.newArrayList("item", "item", "item"),
                Lists.newArrayList("###", "T#T", " g "),
                new Identifier("minecraft", "saddle")
            )
        );
    }

    private static void addHopperRecipe() {
        CUSTOM_RECIPES.put(
            "extras/hopper",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('I', 'C'),
                Lists.newArrayList(
                    new Identifier("c", "wooden_chests"),
                    new Identifier("c", "iron_ingots")
                ),
                Lists.newArrayList("tag", "tag"),
                Lists.newArrayList("I I", "ICI", " I "),
                new Identifier("minecraft", "hopper")
            )
        );
    }

    private static void addEnchantedGoldenAppleRecipe() {
        CUSTOM_RECIPES.put(
            "extras/egapple",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('G', 'A'),
                Lists.newArrayList(
                    new Identifier("minecraft", "gold_block"),
                    new Identifier("minecraft", "apple")
                ),
                Lists.newArrayList("item", "item"),
                Lists.newArrayList("GGG", "GAG", "GGG"),
                new Identifier("minecraft", "enchanted_golden_apple")
            )
        );
    }

    private static void addSimplifiedDispenserRecipe() {
        CUSTOM_RECIPES.put(
            "cobblestone/dispenser",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S', 'R', 'B'),
                Lists.newArrayList(
                    new Identifier("minecraft", "stone_crafting_materials"),
                    new Identifier("minecraft", "redstone"),
                    new Identifier("fabric", "bows")
                ),
                Lists.newArrayList("tag", "item", "tag"),
                Lists.newArrayList("SSS", "SBS", "SRS"),
                new Identifier("minecraft", "dispenser")
            )
        );
    }

    private static void addSimplifiedDropperRecipe() {
        CUSTOM_RECIPES.put(
            "cobblestone/dropper",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S', 'R'),
                Lists.newArrayList(
                    new Identifier("minecraft", "stone_crafting_materials"),
                    new Identifier("minecraft", "redstone")
                ),
                Lists.newArrayList("tag", "item"),
                Lists.newArrayList("SSS", "S S", "SRS"),
                new Identifier("minecraft", "dropper")
            )
        );
    }

    private static void addSimplifiedObserverRecipe() {
        // c:quartz is defined in FettlolTags.java in case we're running in an environment
        // that doesn't have this tag defined yet.
        CUSTOM_RECIPES.put(
            "cobblestone/observer",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S', 'R', 'Q'),
                Lists.newArrayList(
                    new Identifier("minecraft", "stone_crafting_materials"),
                    new Identifier("minecraft", "redstone"),
                    new Identifier("c", "quartz")
                ),
                Lists.newArrayList("tag", "item", "tag"),
                Lists.newArrayList("SSS", "RRQ", "SSS"),
                new Identifier("minecraft", "observer")
            )
        );
    }

    private static void addSimplifiedFurnaceRecipe() {
        CUSTOM_RECIPES.put(
            "cobblestone/furnace",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S'),
                Lists.newArrayList(
                    new Identifier("minecraft", "stone_crafting_materials")
                ),
                Lists.newArrayList("tag"),
                Lists.newArrayList("SSS", "S S", "SSS"),
                new Identifier("minecraft", "furnace")
            )
        );
    }

    private static void addSimplifiedPistonRecipe() {
        // c:iron_ingots is defined in FettlolTags.java in case we're running in an environment
        // that doesn't have this tag defined yet.
        CUSTOM_RECIPES.put(
            "cobblestone/piston",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('P', 'S', 'R', 'I'),
                Lists.newArrayList(
                    new Identifier("minecraft", "planks"),
                    new Identifier("minecraft", "stone_crafting_materials"),
                    new Identifier("minecraft", "redstone"),
                    new Identifier("c", "iron_ingots")
                ),
                Lists.newArrayList("tag", "tag", "item", "tag"),
                Lists.newArrayList("PPP", "SIS", "SRS"),
                new Identifier("minecraft", "piston")
            )
        );
    }

    public static void addSimplifiedRepeaterRecipe() {
        CUSTOM_RECIPES.put(
            "simplified/repeater",
            RecipeHelper.createShapedRecipe(
                Lists.newArrayList('S', 'R', 'T'),
                Lists.newArrayList(
                    new Identifier("minecraft", "stone_crafting_materials"),
                    new Identifier("minecraft", "redstone"),
                    new Identifier("minecraft", "stick")
                ),
                Lists.newArrayList("tag", "item", "item"),
                Lists.newArrayList("R R", "TRT", "SSS"),
                new Identifier("minecraft", "repeater")
            )
        );
    }


}
