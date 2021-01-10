package net.brekitomasson.fettlol_util.module;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.brekitomasson.fettlol_util.UtilMod;
import net.brekitomasson.fettlol_util.base.Interface.Module;
import net.brekitomasson.fettlol_util.base.UtilModule;
import net.minecraft.item.Items;

@Module(mod = UtilMod.MOD_ID, description = "Make poisonous potatoes compostable.")
public class CompostablePoisonousPotato extends UtilModule {
    @Override
    public void init() {
        if (!UtilMod.CONFIG.doesPoisonousPotatoCompost()) {
            return;
        }

        CompostingChanceRegistry.INSTANCE.add(Items.POISONOUS_POTATO, 0.85f);
    }
}
