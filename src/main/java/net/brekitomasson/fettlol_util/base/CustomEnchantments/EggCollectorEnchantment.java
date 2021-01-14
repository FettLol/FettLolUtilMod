package net.brekitomasson.fettlol_util.base.CustomEnchantments;

import net.brekitomasson.fettlol_util.UtilMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EggCollectorEnchantment extends Enchantment {

    public EggCollectorEnchantment(Rarity rarity, EnchantmentTarget enchantmentTarget, EquipmentSlot[] equipmentSlot) {
        super(rarity, enchantmentTarget, equipmentSlot);
        Registry.register(Registry.ENCHANTMENT, new Identifier(UtilMod.MOD_ID, "egg_collector"), this);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    // Not sure if these two default to true, so setting them just in case.

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }

}
