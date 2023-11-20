package net.fettlol.utilmod.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fettlol.utilmod.UtilMod;
import net.fettlol.utilmod.items.HeadhunterSpawnEgg;
import net.fettlol.utilmod.items.KnightfallSword;
import net.fettlol.utilmod.items.PeacekeeperSword;
import net.fettlol.utilmod.items.WitherBone;
import net.fettlol.utilmod.items.base.FettlolGemItem;
import net.fettlol.utilmod.util.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

import static net.fettlol.utilmod.config.Config.CONFIG;

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

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(RegistryHelper.fettlolId(UtilMod.MOD_ID))
        .icon(() -> new ItemStack(PEACEKEEPER))
        .build();

    public static void init() {
        RegistryHelper.register(Registry.ITEM, Item.class, FettlolItems.class);

        // Poisonous Potatoes should be compostable.
        if (CONFIG.doesPoisonousPotatoCompost()) {
            CompostingChanceRegistry.INSTANCE.add(Items.POISONOUS_POTATO, 0.85f);
        }
    }

}
