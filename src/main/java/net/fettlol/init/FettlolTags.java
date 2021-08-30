package net.fettlol.init;

import com.google.common.collect.ImmutableMap;
import net.fettlol.lists.*;
import net.fettlol.lists.integrations.BetterEnd;
import net.fettlol.lists.integrations.BetterNether;
import net.fettlol.lists.integrations.CrimsonMoon;
import net.fettlol.lists.integrations.TechReborn;
import net.fettlol.lists.tags.*;
import net.fettlol.util.TagHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class FettlolTags {

    private volatile static ImmutableMap<Identifier, Set<Identifier>> ITEM_TAGS;
    private volatile static ImmutableMap<Identifier, Set<Identifier>> BLOCK_TAGS;

    // Fettlol Tags
    public static final Tag.Identified<Item> GEMS = TagHelper.makeItemTag("fettlol", "gems");
    public static final Tag.Identified<Item> RAINBOW_SAPLINGS = TagHelper.makeItemTag("fettlol", "rainbow_saplings");

    public static void init() {
        TagHelper builder = new TagHelper();

        // Fettlol Items
        builder.applyTag(FabricTags.FABRIC_SWORDS, FettlolItems.KNIGHTFALL);
        builder.applyTag(FabricTags.FABRIC_SWORDS, FettlolItems.PEACEKEEPER);
        builder.applyTag(GEMS, FettlolItems.AQUAMARINE_GEM);
        builder.applyTag(GEMS, FettlolItems.JADE_GEM);
        builder.applyTag(GEMS, FettlolItems.SOUL_GEM);

        // Vanilla Items
        builder.applyTag(BlockusTags.BLOCKUS_BARRELS, Items.BARREL);
        builder.applyTag(CommonTags.C_BOOKSHELVES, Items.BOOKSHELF);
        builder.applyTag(CommonTags.C_SANDSTONE, Items.CHISELED_RED_SANDSTONE);
        builder.applyTag(CommonTags.C_SANDSTONE, Items.CHISELED_SANDSTONE);
        builder.applyTag(CommonTags.C_SANDSTONE, Items.CUT_RED_SANDSTONE);
        builder.applyTag(CommonTags.C_SANDSTONE, Items.CUT_SANDSTONE);
        builder.applyTag(CommonTags.C_SANDSTONE, Items.RED_SANDSTONE);
        builder.applyTag(CommonTags.C_SANDSTONE, Items.SANDSTONE);
        builder.applyTag(CommonTags.C_WOODEN_CHESTS, Items.CHEST);
        builder.applyTag(CommonTags.C_WOODEN_CHESTS, Items.TRAPPED_CHEST);
        builder.applyTag(CommonTags.C_IRON_INGOTS, Items.IRON_INGOT);
        builder.applyTag(CommonTags.C_QUARTZ, Items.QUARTZ);
        builder.applyTag(FabricTags.FABRIC_BOWS, Items.BOW);

        // Make "stone" tools and items easier to get.
        builder.applyTag(VanillaTags.STONE_CRAFTING_MATERIALS, Items.STONE);
        builder.applyTag(VanillaTags.STONE_CRAFTING_MATERIALS, Items.ANDESITE);
        builder.applyTag(VanillaTags.STONE_CRAFTING_MATERIALS, Items.DIORITE);
        builder.applyTag(VanillaTags.STONE_CRAFTING_MATERIALS, Items.MOSSY_COBBLESTONE);
        builder.applyTag(VanillaTags.STONE_CRAFTING_MATERIALS, Items.GRANITE);

        // Applied Energistics & Better End
        if (FettlolModIntegrations.isAppliedEnergisticsLoaded && FettlolModIntegrations.isBetterEndLoaded) {
            builder.applyTag(AE2Tags.AE2_DUSTS, Mods.BETTER_END, "ender_dust");
        }

        // Better End
        if (FettlolModIntegrations.isBetterEndLoaded) {
            for (String chestItem : BetterEnd.WOODEN_CHESTS) {
                builder.applyTag(CommonTags.C_WOODEN_CHESTS, Mods.BETTER_END, chestItem);
                builder.applyTag(CommonTags.C_CHESTS, Mods.BETTER_END, chestItem);
            }

            builder.applyTag(CommonTags.C_ENDER_PEARL_DUSTS, Mods.BETTER_END, "ender_dust");
        }

        // Better Nether
        if (FettlolModIntegrations.isBetterNetherLoaded) {
            builder.applyTag(CommonTags.C_IRON_INGOTS, Mods.BETTER_NETHER, "cincinnasite_ingot");

            for (String chestItem : BetterNether.WOODEN_CHESTS) {
                builder.applyTag(CommonTags.C_WOODEN_CHESTS, Mods.BETTER_NETHER, chestItem);
                builder.applyTag(CommonTags.C_CHESTS, Mods.BETTER_NETHER, chestItem);
            }

        }

        // Battle Towers
        if (FettlolModIntegrations.isBattletowersLoaded) {
            builder.applyTag(FabricTags.FABRIC_AXES, Mods.BATTLETOWERS, "key_axe");
            builder.applyTag(FabricTags.FABRIC_BOOTS, Mods.BATTLETOWERS, "key_boots");
            builder.applyTag(FabricTags.FABRIC_HELMETS, Mods.BATTLETOWERS, "key_helmet");
            builder.applyTag(FabricTags.FABRIC_HOES, Mods.BATTLETOWERS, "key_hoe");
            builder.applyTag(FabricTags.FABRIC_LEGGINGS, Mods.BATTLETOWERS, "key_leggings");
            builder.applyTag(FabricTags.FABRIC_PICKAXES, Mods.BATTLETOWERS, "key_pickaxe");
            builder.applyTag(FabricTags.FABRIC_SHOVELS, Mods.BATTLETOWERS, "key_shovel");
            builder.applyTag(FabricTags.FABRIC_SWORDS, Mods.BATTLETOWERS, "key_sword");
        }

        // Gilded Netherite
        if (FettlolModIntegrations.isGildedNetheriteLoaded) {
            builder.applyTag(FabricTags.FABRIC_AXES, Mods.GILDEDNETHERITE, "gilded_axe");
            builder.applyTag(FabricTags.FABRIC_BOOTS, Mods.GILDEDNETHERITE, "gilded_boots");
            builder.applyTag(FabricTags.FABRIC_CHESTPLATES, Mods.GILDEDNETHERITE, "gilded_chestplate");
            builder.applyTag(FabricTags.FABRIC_HELMETS, Mods.GILDEDNETHERITE, "gilded_helmet");
            builder.applyTag(FabricTags.FABRIC_HOES, Mods.GILDEDNETHERITE, "gilded_hoe");
            builder.applyTag(FabricTags.FABRIC_LEGGINGS, Mods.GILDEDNETHERITE, "gilded_leggings");
            builder.applyTag(FabricTags.FABRIC_PICKAXES, Mods.GILDEDNETHERITE, "gilded_pickaxe");
            builder.applyTag(FabricTags.FABRIC_SHIELDS, Mods.GILDEDNETHERITE, "gilded_shield");
            builder.applyTag(FabricTags.FABRIC_SHOVELS, Mods.GILDEDNETHERITE, "gilded_shovel");
            builder.applyTag(FabricTags.FABRIC_SWORDS, Mods.GILDEDNETHERITE, "gilded_sword");
        }

        // Expanded Storage
        if (FettlolModIntegrations.isExpandedStorageLoaded) {
            for (String chestItem : Arrays.asList("wood_chest", "old_wood_chest", "christmas_chest", "pumpkin_chest")) {
                builder.applyTag(CommonTags.C_WOODEN_CHESTS, Mods.EXPANDEDSTORAGE, chestItem);
                builder.applyTag(CommonTags.C_CHESTS, Mods.EXPANDEDSTORAGE, chestItem);
            }
        }

        // Biomes You'll Go
        if (FettlolModIntegrations.isBygLoaded) {
            builder.applyTag(VanillaTags.STONE_CRAFTING_MATERIALS, Mods.BYG, "rocky_stone");
            builder.applyTag(RAINBOW_SAPLINGS, Mods.BYG, "rainbow_eucalyptus_sapling");
        }

        // Tech Reborn
        if (FettlolModIntegrations.isTechRebornLoaded) {
            for (String bootItem : TechReborn.BOOTS) {
                builder.applyTag(FabricTags.FABRIC_BOOTS, Mods.TECH_REBORN, bootItem);
            }
            for (String chestItem : TechReborn.CHESTS) {
                builder.applyTag(FabricTags.FABRIC_CHESTPLATES, Mods.TECH_REBORN, chestItem);
            }
            for (String helmetItem : TechReborn.HELMS) {
                builder.applyTag(FabricTags.FABRIC_HELMETS, Mods.TECH_REBORN, helmetItem);
            }
            for (String legItem : TechReborn.LEGGINGS) {
                builder.applyTag(FabricTags.FABRIC_LEGGINGS, Mods.TECH_REBORN, legItem);
            }
        }

        // Croptopia
        if (FettlolModIntegrations.isCroptopiaLoaded) {
            builder.applyTag(CommonTags.C_VANILLAS, Mods.CROPTOPIA, "vanilla");
        }

        // Crimson Moon
        if (FettlolModIntegrations.isCrimsonMoonLoaded) {
            builder.applyTag(FabricTags.FABRIC_BOWS, Mods.CRIMSON_MOON, "bloodthirsty_bow");

            for (String swordItem : CrimsonMoon.SWORDS) {
                builder.applyTag(FabricTags.FABRIC_SWORDS, Mods.CRIMSON_MOON, swordItem);
            }
        }

        ITEM_TAGS = builder.buildItemTags();
        BLOCK_TAGS = builder.buildBlockTags();
    }

    public static void apply(String entry, Map<Identifier, Tag.Builder> tagsMap) {
        Map<Identifier, Set<Identifier>> fettlolTags = null;

        if (entry.equals("tags/blocks")) {
            fettlolTags = BLOCK_TAGS;
        } else if (entry.equals("tags/item")) {
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
