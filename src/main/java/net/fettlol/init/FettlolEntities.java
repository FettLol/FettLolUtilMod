package net.fettlol.init;

import net.fettlol.UtilMod;
import net.fettlol.entities.WanderingHeadHunterEntity;
import net.fettlol.entities.spawn.WanderingHeadHunterSpawn;
import net.fettlol.util.RegistryHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.registry.Registry;

public class FettlolEntities {

    public static final EntityType<WanderingHeadHunterEntity> WANDERING_HEAD_HUNTER =
        Registry.register(
            Registry.ENTITY_TYPE,
            RegistryHelper.makeId("wandering_headhunter"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, WanderingHeadHunterEntity::new)
                .dimensions(EntityDimensions.fixed(0.6F, 1.95F))
                .trackRangeBlocks(12)
                .build()
            );


    public static void init() {
        FabricDefaultAttributeRegistry.register(WANDERING_HEAD_HUNTER, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D));

        if (UtilMod.CONFIG.shouldWanderingHeadhunterExist()) {
            ServerTickEvents.END_SERVER_TICK.register(server -> {
                ServerWorld world = server.getOverworld();
                WanderingHeadHunterSpawn.tick(world);
            });
        }
    }
}
