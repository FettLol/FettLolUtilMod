package net.brekitomasson.fettlol.util;

import net.brekitomasson.fettlol.init.Enchants;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;

public class EnchantmentsHelper {

    public static boolean hasEggCollector(LivingEntity livingEntity) {
        return EnchantmentHelper.getEquipmentLevel(Enchants.EGG_COLLECTOR, livingEntity) > 0;
    }

}
