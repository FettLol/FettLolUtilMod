package net.fettlol.utilmod.lists;

import net.fettlol.utilmod.registry.TagApi;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;

public class Tags {
    public static final TagKey<Item> AE2_DUSTS;
    public static final TagKey<Item> BLOCKUS_BARRELS;
    public static final TagKey<Item> C_BOOKSHELVES;
    public static final TagKey<Item> C_CHESTS;
    public static final TagKey<Item> C_ENDER_PEARL_DUSTS;
    public static final TagKey<Item> C_IRON_INGOTS;
    public static final TagKey<Item> C_QUARTZ;
    public static final TagKey<Item> C_SANDSTONE;
    public static final TagKey<Item> C_VANILLAS;
    public static final TagKey<Item> C_WOODEN_CHESTS;
    public static final TagKey<Item> FABRIC_BOOTS;
    public static final TagKey<Item> FABRIC_BOWS;
    public static final TagKey<Item> FABRIC_CHESTPLATES;
    public static final TagKey<Item> FABRIC_CROSSBOWS;
    public static final TagKey<Item> FABRIC_HELMETS;
    public static final TagKey<Item> FABRIC_LEGGINGS;
    public static final TagKey<Item> FABRIC_SHIELDS;
    public static final TagKey<Item> FETTLOL_GEMS;
    public static final TagKey<Item> FETTLOL_RAINBOW_SAPLINGS;
    public static final TagKey<Item> STONE_CRAFTING_MATERIALS;

    static {
        AE2_DUSTS = TagApi.makeItemTag("appliedenergistics2", "dusts");
        BLOCKUS_BARRELS = TagApi.makeItemTag("blockus", "barrels");
        C_BOOKSHELVES = TagApi.makeItemTag("c", "bookshelves");
        C_CHESTS = TagApi.makeItemTag("c", "chests");
        C_ENDER_PEARL_DUSTS = TagApi.makeItemTag("c", "ender_pearl_dusts");
        C_IRON_INGOTS = TagApi.makeItemTag("c", "iron_ingots");
        C_QUARTZ = TagApi.makeItemTag("c", "quartz");
        C_SANDSTONE = TagApi.makeItemTag("c", "sandstone");
        C_VANILLAS = TagApi.makeItemTag("c", "vanillas");
        C_WOODEN_CHESTS = TagApi.makeItemTag("c", "wooden_chests");
        FABRIC_BOOTS = TagApi.makeItemTag("fabric", "boots");
        FABRIC_BOWS = TagApi.makeItemTag("fabric", "bows");
        FABRIC_CHESTPLATES = TagApi.makeItemTag("fabric", "chestplates");
        FABRIC_CROSSBOWS = TagApi.makeItemTag("fabric", "crossbows");
        FABRIC_HELMETS = TagApi.makeItemTag("fabric", "helmets");
        FABRIC_LEGGINGS = TagApi.makeItemTag("fabric", "leggings");
        FABRIC_SHIELDS = TagApi.makeItemTag("fabric", "shields");
        FETTLOL_GEMS = TagApi.makeItemTag("fettlol:gems");
        FETTLOL_RAINBOW_SAPLINGS = TagApi.makeItemTag("fettlol:rainbow_saplings");
        STONE_CRAFTING_MATERIALS = TagApi.makeItemTag("minecraft", "stone_crafting_materials");
    }
}