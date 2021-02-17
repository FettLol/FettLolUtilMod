package net.brekitomasson.fettlol.mixin;

import com.google.common.collect.ImmutableSet;
import net.brekitomasson.fettlol.integration.Croptopia;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(VillagerEntity.class)
public abstract class VillagerGoalMixin extends MerchantEntity {
    public VillagerGoalMixin(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = {@At("RETURN")}, method = {"setVillagerData"})
    private void setVillagerData(CallbackInfo ci) {
        this.goalSelector.add(0, new TemptGoal(
            this,
            0.5D,
            Ingredient.ofItems(Items.EMERALD_BLOCK.asItem()),
            false
        ));
    }

    @ModifyArg(method = "hasSeedToPlant", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/inventory/SimpleInventory;containsAny(Ljava/util/Set;)Z"))
    private Set<Item> addPlantableSeeds(Set<Item> set) {
        return ImmutableSet.<Item>builder()
            .addAll(set)
            .addAll(Croptopia.SEEDS)
            .build();
    }

}