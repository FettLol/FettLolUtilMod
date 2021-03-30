package net.fettlol.mixin;

import net.fettlol.util.EnchantmentsHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.fettlol.mixin.accessor.SpawnEggItemAccessor.getSPAWN_EGGS;

@Mixin(LivingEntity.class)
public abstract class EggCollectorMixin {

    @Inject(at = @At("HEAD"), method = "onDeath", cancellable = true)
    private void onEggCollectorKill(DamageSource source, CallbackInfo ci) {
        if (!(source.getAttacker() instanceof PlayerEntity)) {
            return;
        }

        PlayerEntity attacker = (PlayerEntity) source.getAttacker();
        LivingEntity target = (LivingEntity) (Object) this;

        if (EnchantmentsHelper.hasEggCollector(attacker)) {
            if (attacker.getRandom().nextFloat() <= 0.03F) {
                dropSpawnEgg(target);
                target.world.playSound(null, target.getX(), target.getY(), target.getZ(),
                    SoundEvents.ENTITY_FIREWORK_ROCKET_TWINKLE,
                    SoundCategory.PLAYERS, 1.0F, 0.5F
                );
            }
        }
    }

    private void dropSpawnEgg(LivingEntity entity) {
        entity.dropItem(getSPAWN_EGGS().get(entity.getType()).asItem());
    }

}
