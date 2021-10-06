package net.fettlol.utilmod.mixin.accessor;

import net.minecraft.entity.Entity;
import net.minecraft.util.collection.Pool;
import net.minecraft.world.MobSpawnerEntry;
import net.minecraft.world.MobSpawnerLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MobSpawnerLogic.class)
public interface MobSpawnerLogicAccessor {

    @Accessor("spawnEntry")
    MobSpawnerEntry getSpawnEntry();

    @Accessor("spawnPotentials")
    Pool<MobSpawnerEntry> getSpawnPotentials();

    @Accessor("spawnPotentials")
    void setSpawnPotentials(Pool<MobSpawnerEntry> spawnPotentials);

    @Accessor("renderedEntity")
    void setRenderedEntity(Entity entity);

    @Accessor("spawnDelay")
    int getSpawnDelay();

    @Accessor("spawnDelay")
    void setSpawnDelay(int spawnDelay);

    @Accessor("minSpawnDelay")
    int getMinSpawnDelay();

    @Accessor("minSpawnDelay")
    void setMinSpawnDelay(int minSpawnDelay);

    @Accessor("maxSpawnDelay")
    int getMaxSpawnDelay();

    @Accessor("maxSpawnDelay")
    void setMaxSpawnDelay(int maxSpawnDelay);

    @Accessor("spawnCount")
    int getSpawnCount();

    @Accessor("spawnCount")
    void setSpawnCount(int spawnCount);

    @Accessor("requiredPlayerRange")
    int getRequiredPlayerRange();

    @Accessor("requiredPlayerRange")
    void setRequiredPlayerRange(int requiredPlayerRange);

    @Accessor("maxNearbyEntities")
    int getMaxNearbyEntities();

    @Accessor("maxNearbyEntities")
    void setMaxNearbyEntities(int maxNearbyEntities);

    @Accessor("spawnRange")
    int getSpawnRange();

    @Accessor("spawnRange")
    void setSpawnRange(int spawnRange);

}
