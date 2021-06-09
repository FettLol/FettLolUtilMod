package net.fettlol.init;

import net.fettlol.items.base.FettlolGemItem;
import net.fettlol.items.*;
import net.fettlol.util.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class FettlolItems {

    // Weapons - Swords
    public static final Item KNIGHTFALL = new KnightfallSword();
    public static final Item PEACEKEEPER = new PeacekeeperSword();

    // Other
    public static final Item HEADHUNTER_SPAWN_EGG = new HeadhunterSpawnEgg();
    public static final Item WITHER_BONE = new WitherBone();

    // Gems and Special Items
    public static final Item AQUAMARINE_GEM = new FettlolGemItem();
    public static final Item JADE_GEM = new FettlolGemItem();
    public static final Item SOUL_SHARD = new FettlolGemItem();
    public static final Item SOUL_GEM = new FettlolGemItem();

    public static void init() {
        RegistryHelper.register(Registry.ITEM, Item.class, FettlolItems.class);
    }

}
