package net.fettlol.utilmod.init;

import net.fettlol.lib.list.Tags;
import net.fettlol.lib.registry.TagApi;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.lists.integrations.BetterEnd;
import net.fettlol.utilmod.lists.integrations.BetterNether;
import net.fettlol.utilmod.lists.integrations.CrimsonMoon;
import net.fettlol.utilmod.lists.integrations.TechReborn;
import net.minecraft.item.Items;

import java.util.Arrays;

public class FettlolTags {

    public static void init() {
        // Fettlol Items
        TagApi.assignItemTag(Tags.FABRIC_SWORDS, FettlolItems.KNIGHTFALL);
        TagApi.assignItemTag(Tags.FABRIC_SWORDS, FettlolItems.PEACEKEEPER);
        TagApi.assignItemTag(Tags.FETTLOL_GEMS, FettlolItems.AQUAMARINE_GEM);
        TagApi.assignItemTag(Tags.FETTLOL_GEMS, FettlolItems.JADE_GEM);
        TagApi.assignItemTag(Tags.FETTLOL_GEMS, FettlolItems.SOUL_GEM);

        // Vanilla Items
        TagApi.assignItemTag(Tags.BLOCKUS_BARRELS, Items.BARREL);
        TagApi.assignItemTag(Tags.C_BOOKSHELVES, Items.BOOKSHELF);
        TagApi.assignItemTag(Tags.C_SANDSTONE, Items.CHISELED_RED_SANDSTONE);
        TagApi.assignItemTag(Tags.C_SANDSTONE, Items.CHISELED_SANDSTONE);
        TagApi.assignItemTag(Tags.C_SANDSTONE, Items.CUT_RED_SANDSTONE);
        TagApi.assignItemTag(Tags.C_SANDSTONE, Items.CUT_SANDSTONE);
        TagApi.assignItemTag(Tags.C_SANDSTONE, Items.RED_SANDSTONE);
        TagApi.assignItemTag(Tags.C_SANDSTONE, Items.SANDSTONE);
        TagApi.assignItemTag(Tags.C_WOODEN_CHESTS, Items.CHEST);
        TagApi.assignItemTag(Tags.C_WOODEN_CHESTS, Items.TRAPPED_CHEST);
        TagApi.assignItemTag(Tags.C_IRON_INGOTS, Items.IRON_INGOT);
        TagApi.assignItemTag(Tags.C_QUARTZ, Items.QUARTZ);
        TagApi.assignItemTag(Tags.FABRIC_BOWS, Items.BOW);

        // Make "stone" tools and items easier to get.
        TagApi.assignItemTag(Tags.STONE_CRAFTING_MATERIALS, Items.STONE);
        TagApi.assignItemTag(Tags.STONE_CRAFTING_MATERIALS, Items.ANDESITE);
        TagApi.assignItemTag(Tags.STONE_CRAFTING_MATERIALS, Items.DIORITE);
        TagApi.assignItemTag(Tags.STONE_CRAFTING_MATERIALS, Items.MOSSY_COBBLESTONE);
        TagApi.assignItemTag(Tags.STONE_CRAFTING_MATERIALS, Items.GRANITE);

        // Applied Energistics & Better End
        if (FettlolModIntegrations.isAppliedEnergisticsLoaded && FettlolModIntegrations.isBetterEndLoaded) {
            TagApi.assignItemTag(Tags.AE2_DUSTS, Mods.BETTER_END, "ender_dust");
        }

        // Better End
        if (FettlolModIntegrations.isBetterEndLoaded) {
            for (String chestItem : BetterEnd.WOODEN_CHESTS) {
                TagApi.assignItemTag(Tags.C_WOODEN_CHESTS, Mods.BETTER_END, chestItem);
                TagApi.assignItemTag(Tags.C_CHESTS, Mods.BETTER_END, chestItem);
            }

            TagApi.assignItemTag(Tags.C_ENDER_PEARL_DUSTS, Mods.BETTER_END, "ender_dust");
        }

        // Better Nether
        if (FettlolModIntegrations.isBetterNetherLoaded) {
            TagApi.assignItemTag(Tags.C_IRON_INGOTS, Mods.BETTER_NETHER, "cincinnasite_ingot");

            for (String chestItem : BetterNether.WOODEN_CHESTS) {
                TagApi.assignItemTag(Tags.C_WOODEN_CHESTS, Mods.BETTER_NETHER, chestItem);
                TagApi.assignItemTag(Tags.C_CHESTS, Mods.BETTER_NETHER, chestItem);
            }

        }

        // Battle Towers
        if (FettlolModIntegrations.isBattletowersLoaded) {
            TagApi.assignItemTag(Tags.FABRIC_AXES, Mods.BATTLETOWERS, "key_axe");
            TagApi.assignItemTag(Tags.FABRIC_BOOTS, Mods.BATTLETOWERS, "key_boots");
            TagApi.assignItemTag(Tags.FABRIC_HELMETS, Mods.BATTLETOWERS, "key_helmet");
            TagApi.assignItemTag(Tags.FABRIC_HOES, Mods.BATTLETOWERS, "key_hoe");
            TagApi.assignItemTag(Tags.FABRIC_LEGGINGS, Mods.BATTLETOWERS, "key_leggings");
            TagApi.assignItemTag(Tags.FABRIC_PICKAXES, Mods.BATTLETOWERS, "key_pickaxe");
            TagApi.assignItemTag(Tags.FABRIC_SHOVELS, Mods.BATTLETOWERS, "key_shovel");
            TagApi.assignItemTag(Tags.FABRIC_SWORDS, Mods.BATTLETOWERS, "key_sword");
        }

        // Gilded Netherite
        if (FettlolModIntegrations.isGildedNetheriteLoaded) {
            TagApi.assignItemTag(Tags.FABRIC_AXES, Mods.GILDEDNETHERITE, "gilded_axe");
            TagApi.assignItemTag(Tags.FABRIC_BOOTS, Mods.GILDEDNETHERITE, "gilded_boots");
            TagApi.assignItemTag(Tags.FABRIC_CHESTPLATES, Mods.GILDEDNETHERITE, "gilded_chestplate");
            TagApi.assignItemTag(Tags.FABRIC_HELMETS, Mods.GILDEDNETHERITE, "gilded_helmet");
            TagApi.assignItemTag(Tags.FABRIC_HOES, Mods.GILDEDNETHERITE, "gilded_hoe");
            TagApi.assignItemTag(Tags.FABRIC_LEGGINGS, Mods.GILDEDNETHERITE, "gilded_leggings");
            TagApi.assignItemTag(Tags.FABRIC_PICKAXES, Mods.GILDEDNETHERITE, "gilded_pickaxe");
            TagApi.assignItemTag(Tags.FABRIC_SHIELDS, Mods.GILDEDNETHERITE, "gilded_shield");
            TagApi.assignItemTag(Tags.FABRIC_SHOVELS, Mods.GILDEDNETHERITE, "gilded_shovel");
            TagApi.assignItemTag(Tags.FABRIC_SWORDS, Mods.GILDEDNETHERITE, "gilded_sword");
        }

        // Expanded Storage
        if (FettlolModIntegrations.isExpandedStorageLoaded) {
            for (String chestItem : Arrays.asList("wood_chest", "old_wood_chest", "christmas_chest", "pumpkin_chest")) {
                TagApi.assignItemTag(Tags.C_WOODEN_CHESTS, Mods.EXPANDEDSTORAGE, chestItem);
                TagApi.assignItemTag(Tags.C_CHESTS, Mods.EXPANDEDSTORAGE, chestItem);
            }
        }

        // Biomes You'll Go
        if (FettlolModIntegrations.isBygLoaded) {
            TagApi.assignItemTag(Tags.STONE_CRAFTING_MATERIALS, Mods.BYG, "rocky_stone");
            TagApi.assignItemTag(Tags.FETTLOL_RAINBOW_SAPLINGS, Mods.BYG, "rainbow_eucalyptus_sapling");
            TagApi.assignItemTag(Tags.C_QUARTZ, Mods.BYG, "quartz_crystal");
        }

        // Tech Reborn
        if (FettlolModIntegrations.isTechRebornLoaded) {
            for (String bootItem : TechReborn.BOOTS) {
                TagApi.assignItemTag(Tags.FABRIC_BOOTS, Mods.TECH_REBORN, bootItem);
            }
            for (String chestItem : TechReborn.CHESTS) {
                TagApi.assignItemTag(Tags.FABRIC_CHESTPLATES, Mods.TECH_REBORN, chestItem);
            }
            for (String helmetItem : TechReborn.HELMS) {
                TagApi.assignItemTag(Tags.FABRIC_HELMETS, Mods.TECH_REBORN, helmetItem);
            }
            for (String legItem : TechReborn.LEGGINGS) {
                TagApi.assignItemTag(Tags.FABRIC_LEGGINGS, Mods.TECH_REBORN, legItem);
            }
        }

        // Croptopia
        if (FettlolModIntegrations.isCroptopiaLoaded) {
            TagApi.assignItemTag(Tags.C_VANILLAS, Mods.CROPTOPIA, "vanilla");
        }

        // Crimson Moon
        if (FettlolModIntegrations.isCrimsonMoonLoaded) {
            TagApi.assignItemTag(Tags.FABRIC_BOWS, Mods.CRIMSON_MOON, "bloodthirsty_bow");

            for (String swordItem : CrimsonMoon.SWORDS) {
                TagApi.assignItemTag(Tags.FABRIC_SWORDS, Mods.CRIMSON_MOON, swordItem);
            }
        }
    }

}
