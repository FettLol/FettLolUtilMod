package net.brekitomasson.fettlol_util.base.Handler;

import net.minecraft.entity.LivingEntity;

import static net.brekitomasson.fettlol_util.mixin.accessor.SpawnEggItemAccessor.getSPAWN_EGGS;

public class DropEggHandler {

    public static void dropSpawnEgg (LivingEntity entity) {
        entity.dropItem(getSPAWN_EGGS().get(entity.getType()).asItem());
    }

}
