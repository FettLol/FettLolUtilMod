package net.fettlol.utilmod.mixin.mobs;

import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Liquid Crystal has the danger of drowning
@Mixin(EscapeDangerGoal.class)
public abstract class EscapeDangerGoalMixin {
	@Shadow @Final
	protected PathAwareEntity mob;

	private static final TagKey<Fluid> LIQUID_CRYSTAL = TagKey.of(Registry.FLUID_KEY, new Identifier("spectrum", "liquid_crystal"));

	@Inject(method = "isInDanger", at = @At("HEAD"), cancellable = true)
	public void f(CallbackInfoReturnable<Boolean> cir) {
		if (mob.isSubmergedIn(LIQUID_CRYSTAL)) {
			cir.setReturnValue(true);
		}
	}
}
