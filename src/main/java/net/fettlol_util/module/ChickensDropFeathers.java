package net.fettlol_util.module;

import net.fettlol_util.UtilMod;
import net.fettlol_util.base.Handler.ModuleHandler;
import net.fettlol_util.base.Interface.Module;
import net.fettlol_util.base.UtilModule;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.ItemTags;

@Module(mod = UtilMod.MOD_ID, description = "Chickens randomly drop feathers.")
public class ChickensDropFeathers extends UtilModule {
    public static void tryDropFeather(ChickenEntity chicken) {
        if (!ModuleHandler.enabled(UtilMod.MOD_ID + ":chickens_drop_feathers")) {
            return;
        }

        if (chicken.isAlive()
            && !chicken.isBaby()
            && !chicken.world.isClient
            && !chicken.hasJockey()
            && chicken.world.random.nextFloat() < 0.2F
        ) {
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
