package net.brekitomasson.fettlol.init;

import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.util.RegistryHelper;
import net.minecraft.item.Items;

/**
 * This class contains a number of minor tweaks and adjustments that don't fit into any of
 * the other init files. Most of them are going to be fairly straight-forward but should
 * still get a quick comment describing each individual tweak or adjustment.
 */
public class Tweaks {

    public static void init() {

        // Add poisonous potato to the list of things accepted by the Composter, because for
        // some reason they are not already there.
        if (UtilMod.CONFIG.doesPoisonousPotatoCompost()) {
            RegistryHelper.makeCompostable(Items.POISONOUS_POTATO, 0.85f);
        }

    }

}
