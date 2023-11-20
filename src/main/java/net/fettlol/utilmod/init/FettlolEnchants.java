package net.fettlol.utilmod.init;

import net.fettlol.utilmod.enchantments.EggCollectorEnchantment;
import net.fettlol.utilmod.util.RegistryHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

import static net.fettlol.utilmod.config.Config.CONFIG;

public class FettlolEnchants {

    public static final Enchantment EGG_COLLECTOR = new EggCollectorEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.values());

    public static void init() {
        if (CONFIG.isEggCollectorEnchantmentAvailable()) {
            RegistryHelper.register(Registry.ENCHANTMENT, Enchantment.class, FettlolEnchants.class);
        }
    }
}
