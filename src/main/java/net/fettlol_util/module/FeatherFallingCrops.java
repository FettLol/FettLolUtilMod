package net.fettlol_util.module;

import net.fettlol_util.UtilMod;
import net.fettlol_util.base.Handler.ModuleHandler;
import net.fettlol_util.base.Helper.EnchantmentsHelper;
import net.fettlol_util.base.Interface.Module;
import net.fettlol_util.base.UtilModule;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

@Module(mod = UtilMod.MOD_ID, description = "Feather Falling disables crop trampling.")
public class FeatherFallingCrops extends UtilModule {
    public static boolean landedOnFarmlandBlock(Entity entity) {
        if (entity instanceof LivingEntity) {
            return ModuleHandler.enabled(UtilMod.MOD_ID + ":feather_falling_crops")
                && EnchantmentsHelper.hasFeatherFalling((LivingEntity) entity);
        }

        return false;
    }
}
