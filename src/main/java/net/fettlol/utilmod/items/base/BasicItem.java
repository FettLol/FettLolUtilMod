package net.fettlol.utilmod.items.base;

import net.fettlol.utilmod.init.FettlolItems;
import net.minecraft.item.Item;

public class BasicItem extends Item {

    public BasicItem(Settings settings) {
        super(settings.group(FettlolItems.ITEM_GROUP));
    }

}
