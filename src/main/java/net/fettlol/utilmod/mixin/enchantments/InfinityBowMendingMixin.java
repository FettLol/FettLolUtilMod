package net.fettlol.utilmod.mixin.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Allow Mending and Infinity enchantment to coexist on a bow.
 */
@Mixin(InfinityEnchantment.class)
public class InfinityBowMendingMixin extends Enchantment {

    protected InfinityBowMendingMixin(Rarity rarity, EnchantmentTarget enchantmentTarget, EquipmentSlot[] equipmentSlot) {
        super(rarity, enchantmentTarget, equipmentSlot);
    }

    @Inject(at = @At("HEAD"), method="canAccept(Lnet/minecraft/enchantment/Enchantment;)Z", cancellable = true)
    public void canAccept(Enchantment enchantment, CallbackInfoReturnable<Boolean> cir) {
        if (enchantment instanceof MendingEnchantment) {
            cir.setReturnValue(true);
        }
    }

}
