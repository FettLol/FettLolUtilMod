package net.fettlol.utilmod.enchantments;

import net.fettlol.utilmod.mixin.enchantments.EggCollectorMixin;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

/**
 * The Egg Collector enchantment is an enchantment that goes on Swords and/or Axes,
 * giving the player a small chance to get a Spawn Egg whenever a mob is killed.
 *
 * @see EggCollectorMixin
 */
public class EggCollectorEnchantment extends Enchantment {

    public EggCollectorEnchantment(Rarity rarity, EquipmentSlot... equipmentSlot) {
        super(rarity, EnchantmentTarget.WEAPON, equipmentSlot);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack) || stack.getItem() instanceof AxeItem;
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
