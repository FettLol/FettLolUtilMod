package net.fettlol.mixin.accessor;

import net.minecraft.entity.Entity;
import net.minecraft.world.MobSpawnerEntry;
import net.minecraft.world.MobSpawnerLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(MobSpawnerLogic.class)
public interface MobSpawnerLogicAccessor {

    @Accessor
    List<MobSpawnerEntry> getSpawnPotentials();

    @Accessor("spawnPotentials")
    public void setSpawnPotentials(List<MobSpawnerEntry> spawnPotentials);

    @Accessor("renderedEntity")
    public void setRenderedEntity(Entity entity);

    @Accessor
    int getSpawnDelay();

    @Accessor("spawnDelay")
    public void setSpawnDelay(int spawnDelay);

    @Accessor
    int getMinSpawnDelay();

    @Accessor("minSpawnDelay")
    public void setMinSpawnDelay(int minSpawnDelay);

    @Accessor
    int getMaxSpawnDelay();

    @Accessor("maxSpawnDelay")
    public void setMaxSpawnDelay(int maxSpawnDelay);

    @Accessor
    int getSpawnCount();

    @Accessor("spawnCount")
    public void setSpawnCount(int spawnCount);

    @Accessor
    int getRequiredPlayerRange();

    @Accessor("requiredPlayerRange")
    public void setRequiredPlayerRange(int requiredPlayerRange);

    @Accessor
    int getMaxNearbyEntities();

    @Accessor("maxNearbyEntities")
    public void setMaxNearbyEntities(int maxNearbyEntities);

    @Accessor
    int getSpawnRange();

    @Accessor("spawnRange")
    public void setSpawnRange(int spawnRange);

}
