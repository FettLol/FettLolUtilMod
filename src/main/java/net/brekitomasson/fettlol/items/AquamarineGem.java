package net.brekitomasson.fettlol.items;

import net.brekitomasson.fettlol.UtilMod;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class AquamarineGem extends Item {
    public AquamarineGem() {
        super(new Settings().maxCount(64).rarity(Rarity.EPIC).group(UtilMod.ITEMGROUP));
    }
}

