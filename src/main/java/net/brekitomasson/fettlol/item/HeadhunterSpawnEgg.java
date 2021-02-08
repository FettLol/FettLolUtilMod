package net.brekitomasson.fettlol.item;

import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.init.Entities;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class HeadhunterSpawnEgg extends SpawnEggItem {
    public HeadhunterSpawnEgg() {
        super(
            Entities.WANDERING_HEAD_HUNTER,
            0xaa00ff,
            0x704040,
            new Item.Settings().group(UtilMod.ITEMGROUP)
        );
    }
}
