package net.brekitomasson.fettlol_util.module;

import net.brekitomasson.fettlol_util.UtilMod;
import net.brekitomasson.fettlol_util.base.CustomEnchantments.EggCollectorEnchantment;
import net.brekitomasson.fettlol_util.base.Interface.Module;
import net.brekitomasson.fettlol_util.base.UtilModule;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

@Module(mod = UtilMod.MOD_ID, description = "Egg Collection Enchantment allows players to collect spawn eggs.")
public class AddEggCollection extends UtilModule {
    public static Enchantment EGG_COLLECTOR;

    @Override
    public void init() {
        if (!UtilMod.CONFIG.isEggCollectorEnchantmentAvailable()) {
            return;
        }

        EGG_COLLECTOR = new EggCollectorEnchantment(
            Enchantment.Rarity.VERY_RARE,
            EnchantmentTarget.WEAPON,
            new EquipmentSlot[] { EquipmentSlot.MAINHAND }
        );
    }

}
