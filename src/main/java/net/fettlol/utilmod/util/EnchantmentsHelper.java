package net.fettlol.utilmod.util;

import net.fettlol.utilmod.init.FettlolEnchants;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;

public class EnchantmentsHelper {

    public static boolean hasEggCollector(LivingEntity livingEntity) {
        return EnchantmentHelper.getEquipmentLevel(FettlolEnchants.EGG_COLLECTOR, livingEntity) > 0;
    }

}
