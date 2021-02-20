package net.brekitomasson.fettlol.init;

import net.brekitomasson.fettlol.UtilMod;
import net.brekitomasson.fettlol.enchantments.EggCollectorEnchantment;
import net.brekitomasson.fettlol.util.RegistryHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class FettlolEnchants {

    public static final Enchantment EGG_COLLECTOR = new EggCollectorEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.values());

    public static void init() {
        if (UtilMod.CONFIG.isEggCollectorEnchantmentAvailable()) {
            RegistryHelper.register(Registry.ENCHANTMENT, Enchantment.class, FettlolEnchants.class);
        }
    }
}
