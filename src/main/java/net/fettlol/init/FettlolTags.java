package net.fettlol.init;

import net.fettlol.util.RegistryHelper;
import net.fettlol.util.TagHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.Tag;

import java.util.Arrays;

public class FettlolTags {

    // Fettlol Tags
    public static final Tag.Identified<Item> GEMS = TagHelper.makeItemTag("fettlol", "gems");

    // Fabric Tags
    public static final Tag.Identified<Item> FABRIC_AXES = TagHelper.makeItemTag("fabric", "axes");
    public static final Tag.Identified<Item> FABRIC_BOOTS = TagHelper.makeItemTag("fabric", "boots");
    public static final Tag.Identified<Item> FABRIC_BOWS = TagHelper.makeItemTag("fabric", "bows");
    public static final Tag.Identified<Item> FABRIC_CHESTPLATES = TagHelper.makeItemTag("fabric", "chestplates");
    public static final Tag.Identified<Item> FABRIC_CROSSBOWS = TagHelper.makeItemTag("fabric", "crossbows");
    public static final Tag.Identified<Item> FABRIC_HELMETS = TagHelper.makeItemTag("fabric", "helmets");
    public static final Tag.Identified<Item> FABRIC_HOES = TagHelper.makeItemTag("fabric", "hoes");
    public static final Tag.Identified<Item> FABRIC_LEGGINGS = TagHelper.makeItemTag("fabric", "leggings");
    public static final Tag.Identified<Item> FABRIC_PICKAXES = TagHelper.makeItemTag("fabric", "pickaxes");
    public static final Tag.Identified<Item> FABRIC_SHIELDS = TagHelper.makeItemTag("fabric", "shields");
    public static final Tag.Identified<Item> FABRIC_SHOVELS = TagHelper.makeItemTag("fabric", "shovels");
    public static final Tag.Identified<Item> FABRIC_SWORDS = TagHelper.makeItemTag("fabric", "swords");

    // Vanilla Tags
    public static final Tag.Identified<Item> STONE_CRAFTING_MATERIALS = TagHelper.makeItemTag("minecraft", "stone_crafting_materials");

    // AE2 Tags
    public static final Tag.Identified<Item> AE2_DUSTS = TagHelper.makeItemTag("appliedenergistics2", "dusts");

    // Blockus tags
    public static final Tag.Identified<Item> BLOCKUS_BARRELS = TagHelper.makeItemTag("blockus", "barrels");

    // Common tags
    public static final Tag.Identified<Item> C_IRON_INGOTS = TagHelper.makeItemTag("c", "iron_ingots");
    public static final Tag.Identified<Item> C_SANDSTONE = TagHelper.makeItemTag("c", "sandstone");
    public static final Tag.Identified<Item> C_BOOKSHELVES = TagHelper.makeItemTag("c", "bookshelves");
    public static final Tag.Identified<Item> C_ENDER_PEARL_DUSTS = TagHelper.makeItemTag("c", "ender_pearl_dusts");
    public static final Tag.Identified<Item> C_CHESTS = TagHelper.makeItemTag("c", "chests");
    public static final Tag.Identified<Item> C_WOODEN_CHESTS = TagHelper.makeItemTag("c", "wooden_chests");
    public static final Tag.Identified<Item> C_VANILLAS = TagHelper.makeItemTag("c", "vanillas");

    // Tiny Tweaks tags
    public static final Tag.Identified<Item> TINYTWEAKS_SHOWS_GRASS_HITBOXES = TagHelper.makeItemTag("tinytweaks", "shows_grass_hitboxes");

    public static void init() {
        // Fettlol Items
        TagHelper.addTag(FABRIC_SWORDS, FettlolItems.KNIGHTFALL);
        TagHelper.addTag(FABRIC_SWORDS, FettlolItems.PEACEKEEPER);
        TagHelper.addTag(GEMS, FettlolItems.AQUAMARINE_GEM);
        TagHelper.addTag(GEMS, FettlolItems.JADE_GEM);
        TagHelper.addTag(GEMS, FettlolItems.SOUL_GEM);

        // Vanilla Items
        TagHelper.addTag(BLOCKUS_BARRELS, Items.BARREL);
        TagHelper.addTag(C_BOOKSHELVES, Items.BOOKSHELF);
        TagHelper.addTag(C_SANDSTONE, Items.CHISELED_RED_SANDSTONE);
        TagHelper.addTag(C_SANDSTONE, Items.CHISELED_SANDSTONE);
        TagHelper.addTag(C_SANDSTONE, Items.CUT_RED_SANDSTONE);
        TagHelper.addTag(C_SANDSTONE, Items.CUT_SANDSTONE);
        TagHelper.addTag(C_SANDSTONE, Items.RED_SANDSTONE);
        TagHelper.addTag(C_SANDSTONE, Items.SANDSTONE);
        TagHelper.addTag(C_WOODEN_CHESTS, Items.CHEST);
        TagHelper.addTag(C_WOODEN_CHESTS, Items.TRAPPED_CHEST);
        TagHelper.addTag(FABRIC_BOWS, Items.BOW);

        // Make "stone" tools and items easier to get.
        TagHelper.addTag(STONE_CRAFTING_MATERIALS, Items.STONE);
        TagHelper.addTag(STONE_CRAFTING_MATERIALS, Items.ANDESITE);
        TagHelper.addTag(STONE_CRAFTING_MATERIALS, Items.DIORITE);
        TagHelper.addTag(STONE_CRAFTING_MATERIALS, Items.MOSSY_COBBLESTONE);
        TagHelper.addTag(STONE_CRAFTING_MATERIALS, Items.GRANITE);

        // Applied Energistics & Better End
        if (ModIntegrations.isAppliedEnergisticsLoaded && ModIntegrations.isBetterEndLoaded) {
            addItemToItemTag(AE2_DUSTS, ModIntegrations.BETTER_END, "ender_dust");
        }

        // Better End
        if (ModIntegrations.isBetterEndLoaded) {
            for (String chestItem : Arrays.asList(
                "dragon_tree_chest",
                "end_lotus_chest",
                "helix_tree_chest",
                "jellyshroom_chest",
                "lacugrove_chest",
                "mossy_glowshroom_chest",
                "pythadendron_chest",
                "tenanea_chest",
                "umbrella_tree_chest"
            )) {
                addItemToItemTag(C_WOODEN_CHESTS, ModIntegrations.BETTER_END, chestItem);
                addItemToItemTag(C_CHESTS, ModIntegrations.BETTER_END, chestItem);
            }

            addItemToItemTag(C_ENDER_PEARL_DUSTS, ModIntegrations.BETTER_END, "ender_dust");
        }

        // Better Nether
        if (ModIntegrations.isBetterNetherLoaded) {
            addItemToItemTag(C_IRON_INGOTS, ModIntegrations.BETTER_NETHER, "cincinnasite_ingot");

            for (String chestItem : Arrays.asList(
                "chest_anchor_tree",
                "chest_nether_sakura",
                "chest_crimson",
                "chest_warped",
                "chest_stalagnate",
                "chest_reed",
                "chest_willow",
                "chest_wart",
                "chest_rubeus",
                "chest_mushroom",
                "chest_fir"
            )) {
                addItemToItemTag(C_WOODEN_CHESTS, ModIntegrations.BETTER_NETHER, chestItem);
                addItemToItemTag(C_CHESTS, ModIntegrations.BETTER_NETHER, chestItem);
            }

        }

        // Battle Towers
        if (ModIntegrations.isBattletowersLoaded) {
            addItemToItemTag(FABRIC_AXES, ModIntegrations.BATTLETOWERS, "key_axe");
            addItemToItemTag(FABRIC_BOOTS, ModIntegrations.BATTLETOWERS, "key_boots");
            addItemToItemTag(FABRIC_HELMETS, ModIntegrations.BATTLETOWERS, "key_helmet");
            addItemToItemTag(FABRIC_HOES, ModIntegrations.BATTLETOWERS, "key_hoe");
            addItemToItemTag(FABRIC_LEGGINGS, ModIntegrations.BATTLETOWERS, "key_leggings");
            addItemToItemTag(FABRIC_PICKAXES, ModIntegrations.BATTLETOWERS, "key_pickaxe");
            addItemToItemTag(FABRIC_SHOVELS, ModIntegrations.BATTLETOWERS, "key_shovel");
            addItemToItemTag(FABRIC_SWORDS, ModIntegrations.BATTLETOWERS, "key_sword");
        }

        // Gilded Netherite
        if (ModIntegrations.isGildedNetheriteLoaded) {
            addItemToItemTag(FABRIC_AXES, ModIntegrations.GILDEDNETHERITE, "gilded_axe");
            addItemToItemTag(FABRIC_BOOTS, ModIntegrations.GILDEDNETHERITE, "gilded_boots");
            addItemToItemTag(FABRIC_CHESTPLATES, ModIntegrations.GILDEDNETHERITE, "gilded_chestplate");
            addItemToItemTag(FABRIC_HELMETS, ModIntegrations.GILDEDNETHERITE, "gilded_helmet");
            addItemToItemTag(FABRIC_HOES, ModIntegrations.GILDEDNETHERITE, "gilded_hoe");
            addItemToItemTag(FABRIC_LEGGINGS, ModIntegrations.GILDEDNETHERITE, "gilded_leggings");
            addItemToItemTag(FABRIC_PICKAXES, ModIntegrations.GILDEDNETHERITE, "gilded_pickaxe");
            addItemToItemTag(FABRIC_SHIELDS, ModIntegrations.GILDEDNETHERITE, "gilded_shield");
            addItemToItemTag(FABRIC_SHOVELS, ModIntegrations.GILDEDNETHERITE, "gilded_shovel");
            addItemToItemTag(FABRIC_SWORDS, ModIntegrations.GILDEDNETHERITE, "gilded_sword");
        }

        // Expanded Storage
        if (ModIntegrations.isExpandedStorageLoaded) {
            for (String chestItem : Arrays.asList("wood_chest", "old_wood_chest", "christmas_chest", "pumpkin_chest")) {
                addItemToItemTag(C_WOODEN_CHESTS, ModIntegrations.EXPANDEDSTORAGE, chestItem);
                addItemToItemTag(C_CHESTS, ModIntegrations.EXPANDEDSTORAGE, chestItem);
            }
        }

        // Biomes You'll Go
        if (ModIntegrations.isBygLoaded) {
            addItemToItemTag(STONE_CRAFTING_MATERIALS, ModIntegrations.BYG, "rocky_stone");
        }

        // Tech Reborn
        if (ModIntegrations.isTechRebornLoaded) {
            for (String bootItem : Arrays.asList("bronze_boots", "peridot_boots", "quantum_boots", "ruby_boots", "sapphire_boots")) {
                addItemToItemTag(FABRIC_BOOTS, ModIntegrations.TECH_REBORN, bootItem);
            }
            for (String chestItem : Arrays.asList("bronze_chestplate", "peridot_chestplate", "quantum_chestplate", "ruby_chestplate", "sapphire_chestplate")) {
                addItemToItemTag(FABRIC_CHESTPLATES, ModIntegrations.TECH_REBORN, chestItem);
            }
            for (String helmetItem : Arrays.asList("bronze_helmet", "peridot_helmet", "quantum_helmet", "ruby_helmet", "sapphire_helmet")) {
                addItemToItemTag(FABRIC_HELMETS, ModIntegrations.TECH_REBORN, helmetItem);
            }
            for (String legItem : Arrays.asList("bronze_leggings", "peridot_leggings", "quantum_leggings", "ruby_leggings", "sapphire_leggings")) {
                addItemToItemTag(FABRIC_LEGGINGS, ModIntegrations.TECH_REBORN, legItem);
            }
        }

        // Croptopia
        if (ModIntegrations.isCroptopiaLoaded) {
            addItemToItemTag(C_VANILLAS, ModIntegrations.CROPTOPIA, "vanilla");
        }

        // Crimson Moon
        if (ModIntegrations.isCrimsonMoonLoaded) {
            addItemToItemTag(FABRIC_BOWS, ModIntegrations.CRIMSON_MOON, "bloodthirsty_bow");

            for (String swordItem : Arrays.asList("carnage", "crimson_bone_blade", "crimson_crusher", "rib_destroyer")) {
                addItemToItemTag(FABRIC_SWORDS, ModIntegrations.CRIMSON_MOON, swordItem);
            }
        }

        // Tiny Tweaks
        if (ModIntegrations.isTinyTweaksLoaded) {
            TagHelper.addTag(TINYTWEAKS_SHOWS_GRASS_HITBOXES, Items.BONE_MEAL);
        }

    }

    public static void addItemToItemTag(Tag.Identified<Item> itemTag, String itemName) {
        TagHelper.addTag(itemTag, RegistryHelper.getItemFromRegistry(itemName));
    }

    public static void addItemToItemTag(Tag.Identified<Item> itemTag, String namespace, String item) {
        TagHelper.addTag(itemTag, RegistryHelper.getItemFromRegistry(namespace, item));
    }

}
