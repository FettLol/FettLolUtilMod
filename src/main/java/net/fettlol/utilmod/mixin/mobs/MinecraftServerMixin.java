package net.fettlol.utilmod.mixin.mobs;

import com.google.common.collect.ImmutableList;
import net.fettlol.utilmod.config.Config;
import net.fettlol.utilmod.entities.spawn.WanderingHeadHunterSpawner;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.spawner.Spawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;

import static net.fettlol.utilmod.config.Config.CONFIG;

// add Wandering Head Hunter spawner
@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
	@ModifyArg(
		method = "createWorlds",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/world/ServerWorld;<init>(Lnet/minecraft/server/MinecraftServer;Ljava/util/concurrent/Executor;Lnet/minecraft/world/level/storage/LevelStorage$Session;Lnet/minecraft/world/level/ServerWorldProperties;Lnet/minecraft/util/registry/RegistryKey;Lnet/minecraft/world/dimension/DimensionOptions;Lnet/minecraft/server/WorldGenerationProgressListener;ZJLjava/util/List;Z)V",
			ordinal = 0
		),
		index = 9
	)
	public List<Spawner> addSpawners(List<Spawner> spawners) {
		if (CONFIG.shouldWanderingHeadhunterExist()) {
			return ImmutableList.<Spawner>builder().addAll(spawners).add(new WanderingHeadHunterSpawner()).build();
		}

		return spawners;
	}
}
