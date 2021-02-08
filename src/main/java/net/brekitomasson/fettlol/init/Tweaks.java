package net.brekitomasson.fettlol.init;

import net.brekitomasson.fettlol.UtilMod;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Items;

/**
 * This class contains a number of minor tweaks and adjustments that don't fit into any of
 * the other init files. Most of them are going to be fairly straight-forward but should
 * still get a one-line comment describing each individual tweak or adjustment.
 */
public class Tweaks {

    public static void init() {
        // Add poisonous potato to the list of things accepted by the Composter.
        if (UtilMod.CONFIG.doesPoisonousPotatoCompost()) {
            CompostingChanceRegistry.INSTANCE.add(Items.POISONOUS_POTATO, 0.85f);
        }

    }

}
