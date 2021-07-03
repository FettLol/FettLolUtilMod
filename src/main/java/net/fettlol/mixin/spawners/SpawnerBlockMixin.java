package net.fettlol.mixin.spawners;

import net.fettlol.api.SpawnerInterface;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SpawnerBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpawnerBlock.class)
public class SpawnerBlockMixin extends Block {

    public SpawnerBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        // Transfer item nbt to the block entity
        NbtCompound blockTags = blockEntity.writeNbt(new NbtCompound());
        NbtCompound itemTags = itemStack.writeNbt(new NbtCompound()).getCompound("tag");
        blockEntity.writeNbt(blockTags.copyFrom(itemTags));

        ((SpawnerInterface) blockEntity).setPlayerPlaced(true);
    }

}
