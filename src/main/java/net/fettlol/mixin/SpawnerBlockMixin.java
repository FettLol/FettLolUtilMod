package net.fettlol.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SpawnerBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpawnerBlock.class)
public class SpawnerBlockMixin {

    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        CompoundTag tag1 = blockEntity.toTag(new CompoundTag());
        CompoundTag tag2 = itemStack.toTag(new CompoundTag()).getCompound("tag");

        blockEntity.fromTag(state, tag1.copyFrom(tag2));
    }

}
