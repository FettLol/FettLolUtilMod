package net.fettlol.items;

import net.fettlol.UtilMod;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class JadeGem extends Item {
    public JadeGem() {
        super(new Settings().maxCount(64).rarity(Rarity.EPIC).group(UtilMod.ITEMGROUP));
    }
}
