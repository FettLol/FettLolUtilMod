package net.fettlol.utilmod.init;

import net.fettlol.lib.list.Tags;
import net.fettlol.lib.registry.TagApi;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.lists.integrations.TechReborn;
import net.minecraft.item.Items;

public class FettlolTags {

    public static void init() {
        // Fettlol Items
        // TagApi.assignItemTag(Tags.FABRIC_SWORDS, FettlolItems.KNIGHTFALL);
        // TagApi.assignItemTag(Tags.FABRIC_SWORDS, FettlolItems.PEACEKEEPER);
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
    }

}
