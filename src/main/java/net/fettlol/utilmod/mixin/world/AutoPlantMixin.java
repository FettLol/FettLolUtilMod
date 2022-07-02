package net.fettlol.utilmod.mixin.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class AutoPlantMixin extends Entity {
    public AutoPlantMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract ItemStack getStack();

    private BlockPos triedToPlantAt;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;tick()V"))
    public void plantSaplings(CallbackInfo ci) {
        ItemStack stack = this.getStack();

        if ((stack.isIn(ItemTags.SAPLINGS) || stack.isIn(ItemTags.FLOWERS)) && this.age >= 666) {
            BlockPos pos = this.getBlockPos();
            if (this.getBlockPos() != triedToPlantAt && world.getFluidState(pos).isEmpty()) {
                ((BlockItem) stack.getItem()).place(getItemPlacementContext(stack, pos));

                triedToPlantAt = this.getBlockPos();
            }
        }
    }

    @NotNull
    private ItemPlacementContext getItemPlacementContext(ItemStack stack, BlockPos pos) {
        return new ItemPlacementContext(
            world,
            null,
            null,
            stack,
            world.raycast(
                new RaycastContext(
                    new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5),
                    new Vec3d(pos.getX() + 0.5, pos.getY() - 0.5, pos.getZ() + 0.5),
                    RaycastContext.ShapeType.COLLIDER,
                    RaycastContext.FluidHandling.ANY,
                    this
                )
            )
        );
    }

}
