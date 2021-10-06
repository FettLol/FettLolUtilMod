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

    /**
     * SpawnerBlock does not have its own "onPlaced" method, meaning it's (probably?) safe to @Override it from here.
     * This shouldn't conflict with any other mods, but it's probably a good idea to look into a more compatible way of
     * doing this in the future.
     */
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        // Transfer item NBT to the block entity.
        NbtCompound blockTags = blockEntity.writeNbt(new NbtCompound());
        NbtCompound itemTags = itemStack.writeNbt(new NbtCompound()).getCompound("tag");
        blockEntity.writeNbt(blockTags.copyFrom(itemTags));

        // Ensure the "setPlayerPlaced" tag is set to true.
        ((SpawnerInterface) blockEntity).setPlayerPlaced(true);
    }

}
