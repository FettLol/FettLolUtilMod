package net.fettlol.items.base;

import net.fettlol.UtilMod;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class FettlolGemItem extends Item {

    public FettlolGemItem() {
        super(new Settings().maxCount(64).rarity(Rarity.EPIC).group(UtilMod.ITEMGROUP));
    }

}
