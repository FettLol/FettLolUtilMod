package net.fettlol.items.base;

import net.minecraft.util.Rarity;

public class FettlolGemItem extends BasicItem {

    public FettlolGemItem() {
        super(new Settings().maxCount(64).rarity(Rarity.EPIC));
    }

}
