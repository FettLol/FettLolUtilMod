package net.fettlol_util.mixin;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fettlol_util.UtilModConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerEntity.class)
public abstract class VillagerGoalMixin extends MerchantEntity {

    public VillagerGoalMixin(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    UtilModConfig CONFIG = AutoConfig.getConfigHolder(UtilModConfig.class).getConfig();

    @Inject(at = { @At("RETURN") }, method = { "setVillagerData" })
    private void setVillagerData(CallbackInfo ci) {
        if (CONFIG.VillagersFollowPlayersWithEmeraldBlocks) {
            TemptGoal followEmeraldGoal = new TemptGoal(
                    (PathAwareEntity) this,
                    .5D,
                    Ingredient.ofItems(Items.EMERALD_BLOCK),
                    true
            );

            this.goalSelector.add(2, (Goal) followEmeraldGoal);
        }
    }
}
