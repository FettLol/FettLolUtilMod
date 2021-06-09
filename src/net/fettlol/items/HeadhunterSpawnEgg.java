package net.fettlol.items;

import net.fettlol.UtilMod;
import net.fettlol.init.FettlolEntities;
import net.minecraft.item.SpawnEggItem;

public class HeadhunterSpawnEgg extends SpawnEggItem {
    public HeadhunterSpawnEgg() {
        super(
            FettlolEntities.WANDERING_HEAD_HUNTER,
            0xaa00ff,
            0x704040,
            new Settings().group(UtilMod.ITEMGROUP)
        );
    }
}
