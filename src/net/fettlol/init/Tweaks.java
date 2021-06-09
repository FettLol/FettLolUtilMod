package net.fettlol.init;

import net.fettlol.UtilMod;
import net.fettlol.util.RegistryHelper;
import net.minecraft.item.Items;

public class Tweaks {


    public static void init() {

        if (UtilMod.CONFIG.doesPoisonousPotatoCompost()) {
            RegistryHelper.makeCompostable(Items.POISONOUS_POTATO, 0.85f);
        }

    }

}
