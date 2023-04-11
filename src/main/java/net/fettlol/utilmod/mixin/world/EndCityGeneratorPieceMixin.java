package net.fettlol.utilmod.mixin.world;

import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.structure.EndCityGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(EndCityGenerator.Piece.class)
public abstract class EndCityGeneratorPieceMixin {
	ThreadLocal<Random> fettlol$random = ThreadLocal.withInitial(() -> null);

	@Inject(
		method = "handleMetadata(Ljava/lang/String;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/util/math/random/Random;Lnet/minecraft/util/math/BlockBox;)V",
		at = @At("HEAD")
	)
	public void fettlol$captureRandom(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox, CallbackInfo ci) {
		fettlol$random.set(random);
	}

	@ModifyArg(
		method = "handleMetadata(Ljava/lang/String;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/util/math/random/Random;Lnet/minecraft/util/math/BlockBox;)V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/decoration/ItemFrameEntity;setHeldItemStack(Lnet/minecraft/item/ItemStack;Z)V")
	)
	public ItemStack fettlol$replaceElytraWithWings(ItemStack item) {
		Optional<Item> randomWing = Registry.ITEM.getOrEmpty(new Identifier(FettlolModIntegrations.WINGED, "wing_random"));

		if (randomWing.isPresent() && fettlol$random.get().nextInt(12) != 0) {
			return new ItemStack(randomWing.get());
		}

		return item;
	}
}
