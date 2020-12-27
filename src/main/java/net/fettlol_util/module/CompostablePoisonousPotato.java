package net.fettlol_util.module;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fettlol_util.UtilMod;
import net.fettlol_util.base.Interface.Module;
import net.fettlol_util.base.UtilModule;
import net.minecraft.item.Items;

@Module(mod = UtilMod.MOD_ID, description = "Make poisonous potatoes compostable.")
public class CompostablePoisonousPotato extends UtilModule
{
    @Override
    public void init() {
        CompostingChanceRegistry.INSTANCE.add(Items.POISONOUS_POTATO, 0.85f);
    }
}
