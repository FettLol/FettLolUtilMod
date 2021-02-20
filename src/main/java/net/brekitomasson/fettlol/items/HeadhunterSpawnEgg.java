package net.brekitomasson.fettlol.items;

import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.init.FettlolEntities;
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
