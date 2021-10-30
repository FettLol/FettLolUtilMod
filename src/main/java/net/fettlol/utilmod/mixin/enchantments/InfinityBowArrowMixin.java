package net.fettlol.utilmod.mixin.enchantments;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Allow Infinity-enchanted bows to fire without an arrow in the inventory.
 */
@Mixin(BowItem.class)
public class InfinityBowArrowMixin {

    @Inject(at = @At("HEAD"), cancellable = true, method = "use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;")
    private void use(World world, PlayerEntity player, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> ci) {
        ItemStack stack = player.getStackInHand(hand);

        if (EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0) {
            player.setCurrentHand(hand);
            ci.setReturnValue(TypedActionResult.success(stack));
        }
    }

}
