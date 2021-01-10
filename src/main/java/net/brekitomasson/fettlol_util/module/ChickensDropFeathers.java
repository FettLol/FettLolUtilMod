package net.brekitomasson.fettlol_util.module;

import net.brekitomasson.fettlol_util.UtilMod;
import net.brekitomasson.fettlol_util.base.Interface.Module;
import net.brekitomasson.fettlol_util.base.UtilModule;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;

@Module(mod = UtilMod.MOD_ID, description = "Chickens randomly drop feathers.")
public class ChickensDropFeathers extends UtilModule {
    public static void tryDropFeather(ChickenEntity chicken) {
        if (!UtilMod.CONFIG.doChickenDropFeathers()) {
            return;
        }

        boolean ChickenIsReady = chicken.isAlive()
            && !chicken.isBaby()
            && !chicken.world.isClient
            && !chicken.hasJockey()
            && chicken.world.random.nextFloat() < 0.2F;

        if (ChickenIsReady) {
            chicken.playSound(
                SoundEvents.ENTITY_CHICKEN_EGG,
                1.0F,
                (chicken.world.random.nextFloat() - chicken.world.random.nextFloat()) * 0.2F + 1.0F
            );

            chicken.dropItem(Items.FEATHER);

            chicken.eggLayTime = chicken.world.random.nextInt(3000) + 3000;
        }
    }
}
