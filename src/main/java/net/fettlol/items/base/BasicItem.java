package net.fettlol.items.base;

import net.fettlol.UtilMod;
import net.minecraft.item.Item;

public class BasicItem extends Item {

    public BasicItem(Settings settings) {
        super(settings.group(UtilMod.ITEMGROUP));
    }

}
