package net.fettlol.utilmod.items.base;

import net.fettlol.utilmod.UtilMod;
import net.minecraft.item.Item;

public class BasicItem extends Item {

    public BasicItem(Settings settings) {
        super(settings.group(UtilMod.ITEMGROUP));
    }

}
