package net.fettlol.mixin.accessor;

import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.world.MobSpawnerEntry;
import net.minecraft.world.MobSpawnerLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(MobSpawnerLogic.class)
public interface MobSpawnerLogicAccessor {

    @Accessor("spawnEntry")
    MobSpawnerEntry getSpawnEntry();

    @Accessor("spawnPotentials")
    List<MobSpawnerEntry> getSpawnPotentials();

    @Accessor("spawnPotentials")
    void setSpawnPotentials(List<MobSpawnerEntry> spawnPotentials);

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
