package net.brekitomasson.fettlol.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EggCollectorEnchantment extends Enchantment {

    public EggCollectorEnchantment(Rarity rarity, EquipmentSlot... equipmentSlot) {
        super(rarity, EnchantmentTarget.WEAPON, equipmentSlot);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }

}
