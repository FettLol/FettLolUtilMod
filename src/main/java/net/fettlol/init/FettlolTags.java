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

        // MCDA
        if (ModIntegrations.isMcdaLoaded) {
            for (String helmetItem : Arrays.asList("beenest_armor_helmet", "beehive_armor_helmet", "champions_armor_helmet", "heros_armor_helmet", "dark_armor_helmet", "titans_shroud_helmet", "ghostly_armor_helmet", "ghost_kindler_helmet", "grim_armor_helmet", "wither_armor_helmet", "guards_armor_helmet", "curious_armor_helmet", "mercenary_armor_helmet", "renegade_armor_helmet", "hungry_horror_helmet", "white_mystery_armor_helmet", "blue_mystery_armor_helmet", "green_mystery_armor_helmet", "purple_mystery_armor_helmet", "red_mystery_armor_helmet", "ocelot_armor_helmet", "shadow_walker_armor_helmet", "phantom_armor_helmet", "frost_bite_armor_helmet", "plate_armor_helmet", "full_metal_armor_helmet", "reinforced_mail_helmet", "stalwart_armor_helmet", "highland_armor_helmet", "snow_armor_helmet", "frost_armor_helmet", "spelunker_armor_helmet", "cave_crawler_armor_helmet", "emerald_gear_helmet", "opulent_armor_helmet", "gilded_glory_helmet")) {
                addItemToItemTag(FABRIC_HELMETS, ModIntegrations.MCDA, helmetItem);
            }

            for (String chestItem : Arrays.asList("beenest_armor_chestplate", "beehive_armor_chestplate", "champions_armor_chestplate", "heros_armor_chestplate", "dark_armor_chestplate", "titans_shroud_chestplate", "ghostly_armor_chestplate", "ghost_kindler_chestplate", "grim_armor_chestplate", "hunters_chestplate", "wither_armor_chestplate", "guards_armor_chestplate", "curious_armor_chestplate", "mercenary_armor_chestplate", "renegade_armor_chestplate", "hungry_horror_chestplate", "white_mystery_armor_chestplate", "blue_mystery_armor_chestplate", "green_mystery_armor_chestplate", "purple_mystery_armor_chestplate", "red_mystery_armor_chestplate", "ocelot_armor_chestplate", "shadow_walker_armor_chestplate", "phantom_armor_chestplate", "frost_bite_armor_chestplate", "plate_armor_chestplate", "full_metal_armor_chestplate", "reinforced_mail_chestplate", "stalwart_armor_chestplate", "highland_armor_chestplate", "snow_armor_chestplate", "frost_armor_chestplate", "spelunker_armor_chestplate", "cave_crawler_armor_chestplate", "emerald_gear_chestplate", "opulent_armor_chestplate", "gilded_glory_chestplate")) {
                addItemToItemTag(FABRIC_CHESTPLATES, ModIntegrations.MCDA, chestItem);
            }

            for (String legItem : Arrays.asList("beenest_armor_leggings", "beehive_armor_leggings", "champions_armor_leggings", "heros_armor_leggings", "dark_armor_leggings", "titans_shroud_leggings", "ghostly_armor_leggings", "ghost_kindler_leggings", "grim_armor_leggings", "wither_armor_leggings", "guards_armor_leggings", "curious_armor_leggings", "mercenary_armor_leggings", "renegade_armor_leggings", "hungry_horror_leggings", "white_mystery_armor_leggings", "blue_mystery_armor_leggings", "green_mystery_armor_leggings", "purple_mystery_armor_leggings", "red_mystery_armor_leggings", "ocelot_armor_leggings", "shadow_walker_armor_leggings", "phantom_armor_leggings", "frost_bite_armor_leggings", "plate_armor_leggings", "full_metal_armor_leggings", "reinforced_mail_leggings", "stalwart_armor_leggings", "highland_armor_leggings", "snow_armor_leggings", "frost_armor_leggings", "spelunker_armor_leggings", "cave_crawler_armor_leggings", "emerald_gear_leggings", "opulent_armor_leggings", "gilded_glory_leggings")) {
                addItemToItemTag(FABRIC_CHESTPLATES, ModIntegrations.MCDA, legItem);
            }

            for (String bootItem : Arrays.asList("beenest_armor_boots", "beehive_armor_boots", "champions_armor_boots", "heros_armor_boots", "dark_armor_boots", "titans_shroud_boots", "ghostly_armor_boots", "ghost_kindler_boots", "grim_armor_boots", "wither_armor_boots", "guards_armor_boots", "curious_armor_boots", "mercenary_armor_boots", "renegade_armor_boots", "hungry_horror_boots", "white_mystery_armor_boots", "blue_mystery_armor_boots", "green_mystery_armor_boots", "purple_mystery_armor_boots", "red_mystery_armor_boots", "ocelot_armor_boots", "shadow_walker_armor_boots", "phantom_armor_boots", "frost_bite_armor_boots", "plate_armor_boots", "full_metal_armor_boots", "reinforced_mail_boots", "stalwart_armor_boots", "highland_armor_boots", "snow_armor_boots", "frost_armor_boots", "spelunker_armor_boots", "cave_crawler_armor_boots", "emerald_gear_boots", "opulent_armor_boots", "gilded_glory_boots")) {
                addItemToItemTag(FABRIC_CHESTPLATES, ModIntegrations.MCDA, bootItem);
            }
        }

        // MCDW
        if (ModIntegrations.isMcdwLoaded) {
            for (String axeItem : Arrays.asList("axe", "axe_cursed", "axe_double", "axe_firebrand", "axe_highland", "axe_whirlwind")) {
                addItemToItemTag(FABRIC_AXES, ModIntegrations.MCDW, axeItem);
            }
            for (String bowItem : Arrays.asList("bow_ancient_bow", "bow_bonebow", "bow_burst_gale_bow", "bow_echo_of_the_valley", "bow_elite_power_bow", "bow_green_menace", "bow_guardian_bow", "bow_haunted_bow", "bow_hunters_promise", "bow_hunting_bow", "bow_longbow", "bow_lost_souls", "bow_love_spell_bow", "bow_masters_bow", "bow_mechanical_shortbow", "bow_nocturnal_bow", "bow_pink_scoundrel", "bow_power_bow", "bow_purple_storm", "bow_red_snake", "bow_sabrewing", "bow_shivering_bow", "bow_shortbow", "bow_snow_bow", "bow_soul_bow", "bow_trickbow", "bow_wind_bow", "bow_winters_touch")) {
                addItemToItemTag(FABRIC_BOWS, ModIntegrations.MCDW, bowItem);
            }
            for (String crossbowItem : Arrays.asList("crossbow_auto_crossbow", "crossbow_azure_seeker", "crossbow_baby_crossbow", "crossbow_burst_crossbow", "crossbow_butterfly_crossbow", "crossbow_cog_crossbow", "crossbow_corrupted_crossbow", "crossbow_doom_crossbow", "crossbow_dual_crossbow", "crossbow_exploding_crossbow", "crossbow_feral_soul_crossbow", "crossbow_firebolt_thrower", "crossbow_harp_crossbow", "crossbow_heavy_crossbow", "crossbow_imploding_crossbow", "crossbow_lightning_harp_crossbow", "crossbow_pride_of_the_piglins", "crossbow_rapid_crossbow", "crossbow_scatter_crossbow", "crossbow_slayer_crossbow", "crossbow_soul_crossbow", "crossbow_soul_hunter_crossbow", "crossbow_spellbound_crossbow", "crossbow_the_slicer", "crossbow_voidcaller_crossbow")) {
                addItemToItemTag(FABRIC_CROSSBOWS, ModIntegrations.MCDW, crossbowItem);
            }
            for (String pickaxeItem : Arrays.asList("pick_diamond_pickaxe_var", "pick_hailing_pinnacle", "pick_howling_pick", "pick_mountaineer_pick")) {
                addItemToItemTag(FABRIC_PICKAXES, ModIntegrations.MCDW, pickaxeItem);
            }
            for (String shieldItem : Arrays.asList("shield_royal_guard", "shield_vanguard")) {
                addItemToItemTag(FABRIC_SHIELDS, ModIntegrations.MCDW, shieldItem);
            }
            for (String swordItem : Arrays.asList("dagger_chill_gale_knife", "dagger_dagger", "dagger_eternal_knife", "dagger_fangs_of_frost", "dagger_moon", "dagger_resolute_tempest_knife", "dagger_shear_dagger", "dagger_soul_knife", "dagger_tempest_knife", "gauntlet_gauntlet", "gauntlet_maulers", "gauntlet_soul_fists", "sickle_frost_scythe", "sickle_jailors_scythe", "sickle_last_laugh_gold", "sickle_last_laugh_silver", "sickle_nightmares_bite", "sickle_sickle", "sickle_soul_scythe", "spear_fortune", "spear_glaive", "spear_grave_bane", "spear_spear", "spear_venom_glaive", "spear_whispering_spear", "staff_battlestaff", "staff_battlestaff_of_terror", "staff_growing_staff", "sword_beestinger", "sword_broadsword", "sword_broken_sawblade", "sword_claymore", "sword_cutlass", "sword_dancers_sword", "sword_dark_katana", "sword_diamond_sword_var", "sword_freezing_foil", "sword_frost_slayer", "sword_great_axeblade", "sword_hawkbrand", "sword_heartstealer", "sword_iron_sword_var", "sword_katana", "sword_masters_katana", "sword_mechanized_sawblade", "sword_nameless_blade", "sword_rapier", "sword_truthseeker", "whip_vine_whip", "whip_whip")) {
                addItemToItemTag(FABRIC_SWORDS, ModIntegrations.MCDW, swordItem);
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
