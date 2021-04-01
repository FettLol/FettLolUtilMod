package net.fettlol.init;

import net.fettlol.util.TagHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;

public class FettlolTags {

    public static final Tag.Identified<Item> GEMS = TagHelper.makeItemTag("fettlol", "gems");

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

    public static final Tag.Identified<Item> AE2_DUSTS = TagHelper.makeItemTag("appliedenergistics2", "dusts");

    public static final Tag.Identified<Item> BLOCKUS_BARRELS = TagHelper.makeItemTag("blockus", "barrels");

    public static final Tag.Identified<Item> C_BOOKSHELVES = TagHelper.makeItemTag("c", "bookshelves");
    public static final Tag.Identified<Item> C_ENDER_PEARL_DUSTS = TagHelper.makeItemTag("c", "ender_pearl_dusts");
    public static final Tag.Identified<Item> C_WOODEN_CHESTS = TagHelper.makeItemTag("c", "wooden_chests");
    public static final Tag.Identified<Item> C_VANILLAS = TagHelper.makeItemTag("c", "vanillas");

    public static final Tag.Identified<Item> TINYTWEAKS_SHOWS_GRASS_HITBOXES = TagHelper.makeItemTag("tinytweaks", "shows_grass_hitboxes");


    public static void init() {
        // Fettlol Items
        for (Item swordItem : Arrays.asList(FettlolItems.KNIGHTFALL, FettlolItems.PEACEKEEPER)) {
            TagHelper.addTag(FABRIC_SWORDS, swordItem);
        }

        for (Item gemItem : Arrays.asList(FettlolItems.AQUAMARINE_GEM, FettlolItems.JADE_GEM, FettlolItems.SOUL_GEM)) {
            TagHelper.addTag(GEMS, gemItem);
        }

        // Vanilla Items
        TagHelper.addTag(BLOCKUS_BARRELS, Items.BARREL);
        TagHelper.addTag(C_BOOKSHELVES, Items.BOOKSHELF);
        TagHelper.addTag(C_WOODEN_CHESTS, Items.CHEST);
        TagHelper.addTag(C_WOODEN_CHESTS, Items.TRAPPED_CHEST);

        // Applied Energistics & Better End
        if (ModIntegrations.isAppliedEnergisticsLoaded && ModIntegrations.isBetterEndLoaded) {
            TagHelper.addTag(AE2_DUSTS, getItemFromRegistry("betterend:ender_dust"));
        }

        // Better End
        if (ModIntegrations.isBetterEndLoaded) {
            for (String s : Arrays.asList("betterend:ender_dust", "betterend:mossy_glowshroom_chest", "betterend:pythadendron_chest", "betterend:end_lotus_chest", "betterend:lacugrove_chest", "betterend:dragon_tree_chest", "betterend:tenanea_chest", "betterend:helix_tree_chest", "betterend:umbrella_tree_chest", "betterend:jellyshroom_chest")) {
                TagHelper.addTag(C_ENDER_PEARL_DUSTS, getItemFromRegistry(s));
            }
        }

        // Battle Towers
        if (ModIntegrations.isBattletowersLoaded) {
            TagHelper.addTag(FABRIC_AXES, getItemFromRegistry("battletowers:key_axe"));
            TagHelper.addTag(FABRIC_BOOTS, getItemFromRegistry("battletowers:key_boots"));
            TagHelper.addTag(FABRIC_HELMETS, getItemFromRegistry("battletowers:key_helmet"));
            TagHelper.addTag(FABRIC_HOES, getItemFromRegistry("battletowers:key_hoe"));
            TagHelper.addTag(FABRIC_LEGGINGS, getItemFromRegistry("battletowers:key_leggings"));
            TagHelper.addTag(FABRIC_PICKAXES, getItemFromRegistry("battletowers:key_pickaxe"));
            TagHelper.addTag(FABRIC_SHOVELS, getItemFromRegistry("battletowers:key_shovel"));
            TagHelper.addTag(FABRIC_SWORDS, getItemFromRegistry("battletowers:key_sword"));
        }

        // Gilded Netherite
        if (ModIntegrations.isGildedNetheriteLoaded) {
            TagHelper.addTag(FABRIC_AXES, getItemFromRegistry("gildednetherite:gilded_axe"));
            TagHelper.addTag(FABRIC_BOOTS, getItemFromRegistry("gildednetherite:gilded_boots"));
            TagHelper.addTag(FABRIC_CHESTPLATES, getItemFromRegistry("gildednetherite:gilded_chestplate"));
            TagHelper.addTag(FABRIC_HELMETS, getItemFromRegistry("gildednetherite:gilded_helmet"));
            TagHelper.addTag(FABRIC_HOES, getItemFromRegistry("gildednetherite:gilded_hoe"));
            TagHelper.addTag(FABRIC_LEGGINGS, getItemFromRegistry("gildednetherite:gilded_leggings"));
            TagHelper.addTag(FABRIC_PICKAXES, getItemFromRegistry("gildednetherite:gilded_pickaxe"));
            TagHelper.addTag(FABRIC_SHIELDS, getItemFromRegistry("gildednetherite:gilded_shield"));
            TagHelper.addTag(FABRIC_SHOVELS, getItemFromRegistry("gildednetherite:gilded_shovel"));
            TagHelper.addTag(FABRIC_SWORDS, getItemFromRegistry("gildednetherite:gilded_sword"));
        }

        // Tech Reborn
        if (ModIntegrations.isTechRebornLoaded) {
            TagHelper.addTag(FABRIC_BOOTS, getItemFromRegistry("techreborn:bronze_boots"));
            TagHelper.addTag(FABRIC_BOOTS, getItemFromRegistry("techreborn:peridot_boots"));
            TagHelper.addTag(FABRIC_BOOTS, getItemFromRegistry("techreborn:quantum_boots"));
            TagHelper.addTag(FABRIC_BOOTS, getItemFromRegistry("techreborn:ruby_boots"));
            TagHelper.addTag(FABRIC_BOOTS, getItemFromRegistry("techreborn:sapphire_boots"));
            TagHelper.addTag(FABRIC_CHESTPLATES, getItemFromRegistry("techreborn:bronze_chestplate"));
            TagHelper.addTag(FABRIC_CHESTPLATES, getItemFromRegistry("techreborn:peridot_chestplate"));
            TagHelper.addTag(FABRIC_CHESTPLATES, getItemFromRegistry("techreborn:quantum_chestplate"));
            TagHelper.addTag(FABRIC_CHESTPLATES, getItemFromRegistry("techreborn:ruby_chestplate"));
            TagHelper.addTag(FABRIC_CHESTPLATES, getItemFromRegistry("techreborn:sapphire_chestplate"));
            TagHelper.addTag(FABRIC_HELMETS, getItemFromRegistry("techreborn:bronze_helmet"));
            TagHelper.addTag(FABRIC_HELMETS, getItemFromRegistry("techreborn:peridot_helmet"));
            TagHelper.addTag(FABRIC_HELMETS, getItemFromRegistry("techreborn:quantum_helmet"));
            TagHelper.addTag(FABRIC_HELMETS, getItemFromRegistry("techreborn:ruby_helmet"));
            TagHelper.addTag(FABRIC_HELMETS, getItemFromRegistry("techreborn:sapphire_helmet"));
            TagHelper.addTag(FABRIC_LEGGINGS, getItemFromRegistry("techreborn:bronze_leggings"));
            TagHelper.addTag(FABRIC_LEGGINGS, getItemFromRegistry("techreborn:peridot_leggings"));
            TagHelper.addTag(FABRIC_LEGGINGS, getItemFromRegistry("techreborn:quantum_leggings"));
            TagHelper.addTag(FABRIC_LEGGINGS, getItemFromRegistry("techreborn:ruby_leggings"));
            TagHelper.addTag(FABRIC_LEGGINGS, getItemFromRegistry("techreborn:sapphire_leggings"));
        }

        // MCDA
        if (ModIntegrations.isMcdaLoaded) {
            for (String helmetItem : Arrays.asList("mcda:beenest_armor_helmet", "mcda:beehive_armor_helmet", "mcda:champions_armor_helmet", "mcda:heros_armor_helmet", "mcda:dark_armor_helmet", "mcda:titans_shroud_helmet", "mcda:ghostly_armor_helmet", "mcda:ghost_kindler_helmet", "mcda:grim_armor_helmet", "mcda:wither_armor_helmet", "mcda:guards_armor_helmet", "mcda:curious_armor_helmet", "mcda:mercenary_armor_helmet", "mcda:renegade_armor_helmet", "mcda:hungry_horror_helmet", "mcda:white_mystery_armor_helmet", "mcda:blue_mystery_armor_helmet", "mcda:green_mystery_armor_helmet", "mcda:purple_mystery_armor_helmet", "mcda:red_mystery_armor_helmet", "mcda:ocelot_armor_helmet", "mcda:shadow_walker_armor_helmet", "mcda:phantom_armor_helmet", "mcda:frost_bite_armor_helmet", "mcda:plate_armor_helmet", "mcda:full_metal_armor_helmet", "mcda:reinforced_mail_helmet", "mcda:stalwart_armor_helmet", "mcda:highland_armor_helmet", "mcda:snow_armor_helmet", "mcda:frost_armor_helmet", "mcda:spelunker_armor_helmet", "mcda:cave_crawler_armor_helmet", "mcda:emerald_gear_helmet", "mcda:opulent_armor_helmet", "mcda:gilded_glory_helmet")) {
                TagHelper.addTag(FABRIC_HELMETS, getItemFromRegistry(helmetItem));
            }

            for (String chestItem : Arrays.asList("mcda:beenest_armor_chestplate", "mcda:beehive_armor_chestplate", "mcda:champions_armor_chestplate", "mcda:heros_armor_chestplate", "mcda:dark_armor_chestplate", "mcda:titans_shroud_chestplate", "mcda:ghostly_armor_chestplate", "mcda:ghost_kindler_chestplate", "mcda:grim_armor_chestplate", "mcda:hunters_chestplate", "mcda:wither_armor_chestplate", "mcda:guards_armor_chestplate", "mcda:curious_armor_chestplate", "mcda:mercenary_armor_chestplate", "mcda:renegade_armor_chestplate", "mcda:hungry_horror_chestplate", "mcda:white_mystery_armor_chestplate", "mcda:blue_mystery_armor_chestplate", "mcda:green_mystery_armor_chestplate", "mcda:purple_mystery_armor_chestplate", "mcda:red_mystery_armor_chestplate", "mcda:ocelot_armor_chestplate", "mcda:shadow_walker_armor_chestplate", "mcda:phantom_armor_chestplate", "mcda:frost_bite_armor_chestplate", "mcda:plate_armor_chestplate", "mcda:full_metal_armor_chestplate", "mcda:reinforced_mail_chestplate", "mcda:stalwart_armor_chestplate", "mcda:highland_armor_chestplate", "mcda:snow_armor_chestplate", "mcda:frost_armor_chestplate", "mcda:spelunker_armor_chestplate", "mcda:cave_crawler_armor_chestplate", "mcda:emerald_gear_chestplate", "mcda:opulent_armor_chestplate", "mcda:gilded_glory_chestplate")) {
                TagHelper.addTag(FABRIC_CHESTPLATES, getItemFromRegistry(chestItem));
            }

            for (String legItem : Arrays.asList("mcda:beenest_armor_leggings", "mcda:beehive_armor_leggings", "mcda:champions_armor_leggings", "mcda:heros_armor_leggings", "mcda:dark_armor_leggings", "mcda:titans_shroud_leggings", "mcda:ghostly_armor_leggings", "mcda:ghost_kindler_leggings", "mcda:grim_armor_leggings", "mcda:wither_armor_leggings", "mcda:guards_armor_leggings", "mcda:curious_armor_leggings", "mcda:mercenary_armor_leggings", "mcda:renegade_armor_leggings", "mcda:hungry_horror_leggings", "mcda:white_mystery_armor_leggings", "mcda:blue_mystery_armor_leggings", "mcda:green_mystery_armor_leggings", "mcda:purple_mystery_armor_leggings", "mcda:red_mystery_armor_leggings", "mcda:ocelot_armor_leggings", "mcda:shadow_walker_armor_leggings", "mcda:phantom_armor_leggings", "mcda:frost_bite_armor_leggings", "mcda:plate_armor_leggings", "mcda:full_metal_armor_leggings", "mcda:reinforced_mail_leggings", "mcda:stalwart_armor_leggings", "mcda:highland_armor_leggings", "mcda:snow_armor_leggings", "mcda:frost_armor_leggings", "mcda:spelunker_armor_leggings", "mcda:cave_crawler_armor_leggings", "mcda:emerald_gear_leggings", "mcda:opulent_armor_leggings", "mcda:gilded_glory_leggings")) {
                TagHelper.addTag(FABRIC_CHESTPLATES, getItemFromRegistry(legItem));
            }

            for (String bootItem : Arrays.asList("mcda:beenest_armor_boots", "mcda:beehive_armor_boots", "mcda:champions_armor_boots", "mcda:heros_armor_boots", "mcda:dark_armor_boots", "mcda:titans_shroud_boots", "mcda:ghostly_armor_boots", "mcda:ghost_kindler_boots", "mcda:grim_armor_boots", "mcda:wither_armor_boots", "mcda:guards_armor_boots", "mcda:curious_armor_boots", "mcda:mercenary_armor_boots", "mcda:renegade_armor_boots", "mcda:hungry_horror_boots", "mcda:white_mystery_armor_boots", "mcda:blue_mystery_armor_boots", "mcda:green_mystery_armor_boots", "mcda:purple_mystery_armor_boots", "mcda:red_mystery_armor_boots", "mcda:ocelot_armor_boots", "mcda:shadow_walker_armor_boots", "mcda:phantom_armor_boots", "mcda:frost_bite_armor_boots", "mcda:plate_armor_boots", "mcda:full_metal_armor_boots", "mcda:reinforced_mail_boots", "mcda:stalwart_armor_boots", "mcda:highland_armor_boots", "mcda:snow_armor_boots", "mcda:frost_armor_boots", "mcda:spelunker_armor_boots", "mcda:cave_crawler_armor_boots", "mcda:emerald_gear_boots", "mcda:opulent_armor_boots", "mcda:gilded_glory_boots")) {
                TagHelper.addTag(FABRIC_CHESTPLATES, getItemFromRegistry(bootItem));
            }
        }

        // MCDW
        if (ModIntegrations.isMcdwLoaded) {
            for (String axeItem : Arrays.asList("mcdw:axe", "mcdw:axe_cursed", "mcdw:axe_double", "mcdw:axe_firebrand", "mcdw:axe_highland", "mcdw:axe_whirlwind")) {
                TagHelper.addTag(FABRIC_AXES, getItemFromRegistry(axeItem));
            }
            for (String bowItem : Arrays.asList("mcdw:bow_ancient_bow", "mcdw:bow_bonebow", "mcdw:bow_burst_gale_bow", "mcdw:bow_echo_of_the_valley", "mcdw:bow_elite_power_bow", "mcdw:bow_green_menace", "mcdw:bow_guardian_bow", "mcdw:bow_haunted_bow", "mcdw:bow_hunters_promise", "mcdw:bow_hunting_bow", "mcdw:bow_longbow", "mcdw:bow_lost_souls", "mcdw:bow_love_spell_bow", "mcdw:bow_masters_bow", "mcdw:bow_mechanical_shortbow", "mcdw:bow_nocturnal_bow", "mcdw:bow_pink_scoundrel", "mcdw:bow_power_bow", "mcdw:bow_purple_storm", "mcdw:bow_red_snake", "mcdw:bow_sabrewing", "mcdw:bow_shivering_bow", "mcdw:bow_shortbow", "mcdw:bow_snow_bow", "mcdw:bow_soul_bow", "mcdw:bow_trickbow", "mcdw:bow_wind_bow", "mcdw:bow_winters_touch")) {
                TagHelper.addTag(FABRIC_BOWS, getItemFromRegistry(bowItem));
            }
            for (String crossbowItem : Arrays.asList("mcdw:crossbow_auto_crossbow", "mcdw:crossbow_azure_seeker", "mcdw:crossbow_baby_crossbow", "mcdw:crossbow_burst_crossbow", "mcdw:crossbow_butterfly_crossbow", "mcdw:crossbow_cog_crossbow", "mcdw:crossbow_corrupted_crossbow", "mcdw:crossbow_doom_crossbow", "mcdw:crossbow_dual_crossbow", "mcdw:crossbow_exploding_crossbow", "mcdw:crossbow_feral_soul_crossbow", "mcdw:crossbow_firebolt_thrower", "mcdw:crossbow_harp_crossbow", "mcdw:crossbow_heavy_crossbow", "mcdw:crossbow_imploding_crossbow", "mcdw:crossbow_lightning_harp_crossbow", "mcdw:crossbow_pride_of_the_piglins", "mcdw:crossbow_rapid_crossbow", "mcdw:crossbow_scatter_crossbow", "mcdw:crossbow_slayer_crossbow", "mcdw:crossbow_soul_crossbow", "mcdw:crossbow_soul_hunter_crossbow", "mcdw:crossbow_spellbound_crossbow", "mcdw:crossbow_the_slicer", "mcdw:crossbow_voidcaller_crossbow")) {
                TagHelper.addTag(FABRIC_CROSSBOWS, getItemFromRegistry(crossbowItem));
            }
            for (String pickaxeItem : Arrays.asList("mcdw:pick_diamond_pickaxe_var", "mcdw:pick_hailing_pinnacle", "mcdw:pick_howling_pick", "mcdw:pick_mountaineer_pick")) {
                TagHelper.addTag(FABRIC_PICKAXES, getItemFromRegistry(pickaxeItem));
            }
            for (String shieldItem : Arrays.asList("mcdw:shield_royal_guard", "mcdw:shield_vanguard")) {
                TagHelper.addTag(FABRIC_SHIELDS, getItemFromRegistry(shieldItem));
            }
            for (String swordItem : Arrays.asList("mcdw:dagger_chill_gale_knife", "mcdw:dagger_dagger", "mcdw:dagger_eternal_knife", "mcdw:dagger_fangs_of_frost", "mcdw:dagger_moon", "mcdw:dagger_resolute_tempest_knife", "mcdw:dagger_shear_dagger", "mcdw:dagger_soul_knife", "mcdw:dagger_tempest_knife", "mcdw:gauntlet_gauntlet", "mcdw:gauntlet_maulers", "mcdw:gauntlet_soul_fists", "mcdw:sickle_frost_scythe", "mcdw:sickle_jailors_scythe", "mcdw:sickle_last_laugh_gold", "mcdw:sickle_last_laugh_silver", "mcdw:sickle_nightmares_bite", "mcdw:sickle_sickle", "mcdw:sickle_soul_scythe", "mcdw:spear_fortune", "mcdw:spear_glaive", "mcdw:spear_grave_bane", "mcdw:spear_spear", "mcdw:spear_venom_glaive", "mcdw:spear_whispering_spear", "mcdw:staff_battlestaff", "mcdw:staff_battlestaff_of_terror", "mcdw:staff_growing_staff", "mcdw:sword_beestinger", "mcdw:sword_broadsword", "mcdw:sword_broken_sawblade", "mcdw:sword_claymore", "mcdw:sword_cutlass", "mcdw:sword_dancers_sword", "mcdw:sword_dark_katana", "mcdw:sword_diamond_sword_var", "mcdw:sword_freezing_foil", "mcdw:sword_frost_slayer", "mcdw:sword_great_axeblade", "mcdw:sword_hawkbrand", "mcdw:sword_heartstealer", "mcdw:sword_iron_sword_var", "mcdw:sword_katana", "mcdw:sword_masters_katana", "mcdw:sword_mechanized_sawblade", "mcdw:sword_nameless_blade", "mcdw:sword_rapier", "mcdw:sword_truthseeker", "mcdw:whip_vine_whip", "mcdw:whip_whip")) {
                TagHelper.addTag(FABRIC_SWORDS, getItemFromRegistry(swordItem));
            }
        }

        // Croptopia
        if (ModIntegrations.isCroptopiaLoaded) {
            TagHelper.addTag(C_VANILLAS, getItemFromRegistry("croptopia:vanilla"));
        }

        // Crimson Moon
        if (ModIntegrations.isCrimsonMoonLoaded) {
            TagHelper.addTag(FABRIC_BOWS, getItemFromRegistry("crimsonmoon:bloodthirsty_bow"));

            for (String swordItem : Arrays.asList("crimsonmoon:carnage", "crimsonmoon:crimson_bone_blade", "crimsonmoon:crimson_crusher", "crimsonmoon:rib_destroyer")) {
                TagHelper.addTag(FABRIC_SWORDS, getItemFromRegistry(swordItem));
            }
        }

        // Tiny Tweaks
        if (ModIntegrations.isTinyTweaksLoaded) {
            TagHelper.addTag(TINYTWEAKS_SHOWS_GRASS_HITBOXES, Items.BONE_MEAL);
        }

    }

    private static Item getItemFromRegistry(String itemName) {
        return Registry.ITEM.get(new Identifier(itemName)).asItem();
    }

}
