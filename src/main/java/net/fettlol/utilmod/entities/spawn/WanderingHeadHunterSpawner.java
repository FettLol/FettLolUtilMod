package net.fettlol.utilmod.entities.spawn;

import net.fettlol.utilmod.entities.WanderingHeadHunterEntity;
import net.fettlol.utilmod.init.FettlolEntities;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.poi.PointOfInterestStorage;
import net.minecraft.world.poi.PointOfInterestTypes;
import net.minecraft.world.spawner.Spawner;
import org.jetbrains.annotations.Nullable;

public class WanderingHeadHunterSpawner implements Spawner {
    public static final int DESPAWN_DELAY = 32000;

    private final Random random = Random.create();

    @Override
    public int spawn(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals) {
        if (world.getGameRules().getBoolean(GameRules.DO_TRADER_SPAWNING)) {
            if (world.getTimeOfDay() % (24000 * 3) == 1500) {
                if (world.getRandom().nextInt(100) < 10) {
                    trySpawn(world);
                    return 1;
                }
            }
        }

        return 0;
    }

    private void trySpawn(ServerWorld world) {
        PlayerEntity player = world.getRandomAlivePlayer();
        if (player == null) return;

        BlockPos playerPos = player.getBlockPos();
        BlockPos rootPos = world.getPointOfInterestStorage().getPosition(
            poiType -> poiType.matchesKey(PointOfInterestTypes.MEETING), pos -> true, playerPos, 48, PointOfInterestStorage.OccupationStatus.ANY
        ).orElse(playerPos);
        BlockPos spawnPos = getNearbySpawnPos(world, rootPos, 48);

        if (spawnPos != null && doesNotSuffocateAt(world, spawnPos)) {
            WanderingHeadHunterEntity traderEntity = FettlolEntities.WANDERING_HEAD_HUNTER.spawn(world, null, null, null, spawnPos, SpawnReason.EVENT, false, false);

            if (traderEntity != null) {
                traderEntity.setDespawnDelay(DESPAWN_DELAY);
                traderEntity.setWanderTarget(rootPos);
                traderEntity.setPositionTarget(rootPos, 16);
            }
        }
    }

    @Nullable
    private BlockPos getNearbySpawnPos(WorldView world, BlockPos pos, int range) {
        BlockPos spawnPos = null;

        BlockPos.Mutable candidate = new BlockPos.Mutable();
        for (int i = 0; i < 10; i++) {
            int x = pos.getX() + random.nextInt(range * 2) - range;
            int z = pos.getZ() + random.nextInt(range * 2) - range;
            int y = world.getTopY(Heightmap.Type.WORLD_SURFACE, x, z);
            candidate.set(x, y, z);

            if (SpawnHelper.canSpawn(SpawnRestriction.Location.ON_GROUND, world, candidate, FettlolEntities.WANDERING_HEAD_HUNTER)) {
                spawnPos = candidate.toImmutable();
                break;
            }
        }

        return spawnPos;
    }

    private static boolean doesNotSuffocateAt(BlockView world, BlockPos pos) {
        for(BlockPos blockPos : BlockPos.iterate(pos, pos.add(1, 2, 1))) {
            if (!world.getBlockState(blockPos).getCollisionShape(world, blockPos).isEmpty()) {
                return false;
            }
        }

        return true;
    }
}
