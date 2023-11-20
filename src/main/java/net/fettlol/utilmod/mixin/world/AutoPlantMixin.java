package net.fettlol.utilmod.mixin.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.fettlol.utilmod.config.Config.getPlayerConfig;

@Mixin(ItemEntity.class)
public abstract class AutoPlantMixin extends Entity {
    public AutoPlantMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract ItemStack getStack();

    private boolean fettlol$autoPlant = true; // note: doesn't persist through server restarts
    private BlockPos fettlol$triedToPlantAt;

    @Inject(method = "<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;)V", at = @At("RETURN"))
    public void decideFaith(CallbackInfo ci) {
        if (getStack().isIn(ItemTags.SAPLINGS) || getStack().isIn(ItemTags.FLOWERS)) {
            PlayerEntity player = getWorld().getClosestPlayer(this, -1);
            if (player != null) {
                fettlol$autoPlant = getPlayerConfig(player).autoPlant;
            }
        }
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;tick()V"))
    public void plantSaplings(CallbackInfo ci) {
        if (world.isClient) return;

        if (fettlol$autoPlant && age >= 666) {
            BlockPos pos = getBlockPos();
            if (pos != fettlol$triedToPlantAt && world.getFluidState(pos).isEmpty()) {
                ((BlockItem) getStack().getItem()).place(getGroundPlacement(getStack(), pos));

                fettlol$triedToPlantAt = pos;
            }
        }
    }

    @Unique
    private ItemPlacementContext getGroundPlacement(ItemStack stack, BlockPos pos) {
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
