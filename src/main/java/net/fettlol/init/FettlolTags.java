package net.fettlol.init;

import com.google.common.collect.ImmutableMap;
import net.fettlol.util.TagHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static net.fettlol.init.ModIntegrations.*;

public class FettlolTags {

    private volatile static ImmutableMap<Identifier, Set<Identifier>> ITEM_TAGS;
    private volatile static ImmutableMap<Identifier, Set<Identifier>> BLOCK_TAGS;


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
        TagHelper builder = new TagHelper();

        // Fettlol Items
        builder.applyTag(FABRIC_SWORDS, FettlolItems.KNIGHTFALL);
        builder.applyTag(FABRIC_SWORDS, FettlolItems.PEACEKEEPER);
        builder.applyTag(GEMS, FettlolItems.AQUAMARINE_GEM);
        builder.applyTag(GEMS, FettlolItems.JADE_GEM);
        builder.applyTag(GEMS, FettlolItems.SOUL_GEM);

        // Vanilla Items
        builder.applyTag(BLOCKUS_BARRELS, Items.BARREL);
        builder.applyTag(C_BOOKSHELVES, Items.BOOKSHELF);
        builder.applyTag(C_SANDSTONE, Items.CHISELED_RED_SANDSTONE);
        builder.applyTag(C_SANDSTONE, Items.CHISELED_SANDSTONE);
        builder.applyTag(C_SANDSTONE, Items.CUT_RED_SANDSTONE);
        builder.applyTag(C_SANDSTONE, Items.CUT_SANDSTONE);
        builder.applyTag(C_SANDSTONE, Items.RED_SANDSTONE);
        builder.applyTag(C_SANDSTONE, Items.SANDSTONE);
        builder.applyTag(C_WOODEN_CHESTS, Items.CHEST);
        builder.applyTag(C_WOODEN_CHESTS, Items.TRAPPED_CHEST);
        builder.applyTag(FABRIC_BOWS, Items.BOW);

        // Make "stone" tools and items easier to get.
        builder.applyTag(STONE_CRAFTING_MATERIALS, Items.STONE);
        builder.applyTag(STONE_CRAFTING_MATERIALS, Items.ANDESITE);
        builder.applyTag(STONE_CRAFTING_MATERIALS, Items.DIORITE);
        builder.applyTag(STONE_CRAFTING_MATERIALS, Items.MOSSY_COBBLESTONE);
        builder.applyTag(STONE_CRAFTING_MATERIALS, Items.GRANITE);

        // Applied Energistics & Better End
        if (ModIntegrations.isAppliedEnergisticsLoaded && ModIntegrations.isBetterEndLoaded) {
            builder.applyTag(AE2_DUSTS, BETTER_END, "ender_dust");
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
                builder.applyTag(C_WOODEN_CHESTS, BETTER_END, chestItem);
                builder.applyTag(C_CHESTS, BETTER_END, chestItem);
            }

            builder.applyTag(C_ENDER_PEARL_DUSTS, BETTER_END, "ender_dust");
        }

        // Better Nether
        if (ModIntegrations.isBetterNetherLoaded) {
            builder.applyTag(C_IRON_INGOTS, BETTER_NETHER, "cincinnasite_ingot");

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
                builder.applyTag(C_WOODEN_CHESTS, BETTER_NETHER, chestItem);
                builder.applyTag(C_CHESTS, BETTER_NETHER, chestItem);
            }

        }

        // Battle Towers
        if (ModIntegrations.isBattletowersLoaded) {
            builder.applyTag(FABRIC_AXES, BATTLETOWERS, "key_axe");
            builder.applyTag(FABRIC_BOOTS, BATTLETOWERS, "key_boots");
            builder.applyTag(FABRIC_HELMETS, BATTLETOWERS, "key_helmet");
            builder.applyTag(FABRIC_HOES, BATTLETOWERS, "key_hoe");
            builder.applyTag(FABRIC_LEGGINGS, BATTLETOWERS, "key_leggings");
            builder.applyTag(FABRIC_PICKAXES, BATTLETOWERS, "key_pickaxe");
            builder.applyTag(FABRIC_SHOVELS, BATTLETOWERS, "key_shovel");
            builder.applyTag(FABRIC_SWORDS, BATTLETOWERS, "key_sword");
        }

        // Gilded Netherite
        if (ModIntegrations.isGildedNetheriteLoaded) {
            builder.applyTag(FABRIC_AXES, GILDEDNETHERITE, "gilded_axe");
            builder.applyTag(FABRIC_BOOTS, GILDEDNETHERITE, "gilded_boots");
            builder.applyTag(FABRIC_CHESTPLATES, GILDEDNETHERITE, "gilded_chestplate");
            builder.applyTag(FABRIC_HELMETS, GILDEDNETHERITE, "gilded_helmet");
            builder.applyTag(FABRIC_HOES, GILDEDNETHERITE, "gilded_hoe");
            builder.applyTag(FABRIC_LEGGINGS, GILDEDNETHERITE, "gilded_leggings");
            builder.applyTag(FABRIC_PICKAXES, GILDEDNETHERITE, "gilded_pickaxe");
            builder.applyTag(FABRIC_SHIELDS, GILDEDNETHERITE, "gilded_shield");
            builder.applyTag(FABRIC_SHOVELS, GILDEDNETHERITE, "gilded_shovel");
            builder.applyTag(FABRIC_SWORDS, GILDEDNETHERITE, "gilded_sword");
        }

        // Expanded Storage
        if (ModIntegrations.isExpandedStorageLoaded) {
            for (String chestItem : Arrays.asList("wood_chest", "old_wood_chest", "christmas_chest", "pumpkin_chest")) {
                builder.applyTag(C_WOODEN_CHESTS, EXPANDEDSTORAGE, chestItem);
                builder.applyTag(C_CHESTS, EXPANDEDSTORAGE, chestItem);
            }
        }

        // Biomes You'll Go
        if (ModIntegrations.isBygLoaded) {
            builder.applyTag(STONE_CRAFTING_MATERIALS, BYG, "rocky_stone");
        }

        // Tech Reborn
        if (ModIntegrations.isTechRebornLoaded) {
            for (String bootItem : Arrays.asList("bronze_boots", "peridot_boots", "quantum_boots", "ruby_boots", "sapphire_boots")) {
                builder.applyTag(FABRIC_BOOTS, TECH_REBORN, bootItem);
            }
            for (String chestItem : Arrays.asList("bronze_chestplate", "peridot_chestplate", "quantum_chestplate", "ruby_chestplate", "sapphire_chestplate")) {
                builder.applyTag(FABRIC_CHESTPLATES, TECH_REBORN, chestItem);
            }
            for (String helmetItem : Arrays.asList("bronze_helmet", "peridot_helmet", "quantum_helmet", "ruby_helmet", "sapphire_helmet")) {
                builder.applyTag(FABRIC_HELMETS, TECH_REBORN, helmetItem);
            }
            for (String legItem : Arrays.asList("bronze_leggings", "peridot_leggings", "quantum_leggings", "ruby_leggings", "sapphire_leggings")) {
                builder.applyTag(FABRIC_LEGGINGS, TECH_REBORN, legItem);
            }
        }

        // Croptopia
        if (ModIntegrations.isCroptopiaLoaded) {
            builder.applyTag(C_VANILLAS, CROPTOPIA, "vanilla");
        }

        // Crimson Moon
        if (ModIntegrations.isCrimsonMoonLoaded) {
            builder.applyTag(FABRIC_BOWS, CRIMSON_MOON, "bloodthirsty_bow");

            for (String swordItem : Arrays.asList("carnage", "crimson_bone_blade", "crimson_crusher", "rib_destroyer")) {
                builder.applyTag(FABRIC_SWORDS, CRIMSON_MOON, swordItem);
            }
        }

        // Tiny Tweaks
        if (ModIntegrations.isTinyTweaksLoaded) {
            builder.applyTag(TINYTWEAKS_SHOWS_GRASS_HITBOXES, Items.BONE_MEAL);
        }

        ITEM_TAGS = builder.buildItemTags();
        BLOCK_TAGS = builder.buildBlockTags();
    }

    // called from worker threads
    public static void apply(String entry, Map<Identifier, Tag.Builder> tagsMap) {
        Map<Identifier, Set<Identifier>> fettlolTags = null;

        if (entry.equals("block")) {
            fettlolTags = BLOCK_TAGS;
        } else if (entry.equals("item")) {
            fettlolTags = ITEM_TAGS;
        }

        if (fettlolTags != null) {
            fettlolTags.forEach((id, ids) ->
                tagsMap.compute(id, (k, v) ->
                    v == null
                        ? apply(Tag.Builder.create(), ids)
                        : apply(v, ids)));
        }
    }

    public static Tag.Builder apply(Tag.Builder builder, Set<Identifier> ids) {
        ids.forEach((value) -> builder.add(value, "FettLol Utilmod"));

        return builder;
    }

}
