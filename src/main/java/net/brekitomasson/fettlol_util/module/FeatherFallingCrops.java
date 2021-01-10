package net.brekitomasson.fettlol_util.module;

import net.brekitomasson.fettlol_util.UtilMod;
import net.brekitomasson.fettlol_util.base.Helper.EnchantmentsHelper;
import net.brekitomasson.fettlol_util.base.Interface.Module;
import net.brekitomasson.fettlol_util.base.UtilModule;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

@Module(mod = UtilMod.MOD_ID, description = "Feather Falling disables crop trampling.")
public class FeatherFallingCrops extends UtilModule {
    public static boolean landedOnFarmlandBlock(Entity entity) {
        if (!UtilMod.CONFIG.doesFeatherFallingNotBreakFarmland()) {
            return false;
        }

        if (entity instanceof LivingEntity) {
            return EnchantmentsHelper.hasFeatherFalling((LivingEntity) entity);
        }

        return false;
    }
}
