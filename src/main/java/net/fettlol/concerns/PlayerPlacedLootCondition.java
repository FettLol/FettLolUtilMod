package net.fettlol.concerns;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.fettlol.util.RegistryHelper;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameter;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.JsonSerializer;
import net.minecraft.util.registry.Registry;

import java.util.Set;

public class PlayerPlacedLootCondition implements LootCondition {
	public static final LootConditionType PLAYER_PLACED = Registry.register(Registry.LOOT_CONDITION_TYPE,
		RegistryHelper.fettlolId("playerplaced"),
		new LootConditionType(new Serializer()));

	@Override
	public LootConditionType getType() {
		return PLAYER_PLACED;
	}

	public Set<LootContextParameter<?>> getRequiredParameters() {
		return ImmutableSet.of(LootContextParameters.BLOCK_ENTITY);
	}

	@Override
	public boolean test(LootContext lootContext) {
		BlockEntity blockEntity = lootContext.get(LootContextParameters.BLOCK_ENTITY);
		NbtCompound nbt = blockEntity.writeNbt(new NbtCompound());

		return nbt.getBoolean("IsPlayerPlaced");
	}

	public static class Builder implements LootCondition.Builder {
		@Override
		public LootCondition build() {
			return new PlayerPlacedLootCondition();
		}
	}

	public static class Serializer implements JsonSerializer<PlayerPlacedLootCondition> {
		@Override
		public void toJson(JsonObject json, PlayerPlacedLootCondition object, JsonSerializationContext context) {

		}

		@Override
		public PlayerPlacedLootCondition fromJson(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
			return new PlayerPlacedLootCondition();
		}
	}
}
