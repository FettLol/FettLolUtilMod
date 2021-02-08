package net.brekitomasson.fettlol.init;

import net.brekitomasson.fettlol.entity.WanderingHeadHunterEntity;
import net.brekitomasson.fettlol.util.RegistryHelper;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class Entities {

    public static final EntityType<WanderingHeadHunterEntity> WANDERING_HEAD_HUNTER = FabricEntityTypeBuilder.<WanderingHeadHunterEntity>create(SpawnGroup.AMBIENT, (t, w) -> new WanderingHeadHunterEntity(w)).dimensions(EntityDimensions.fixed(0.6F, 1.95F)).trackRangeBlocks(12).build();

    public static void init() {
        RegistryHelper.register(Registry.ENTITY_TYPE, EntityType.class, Entities.class);
    }
}
