package net.fettlol.utilmod.mixin.world;

import net.minecraft.block.AmethystBlock;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AmethystClusterBlock.class)
public abstract class AmethystClusterMixin extends AmethystBlock {
    public AmethystClusterMixin(Settings settings) {
        super(settings);
    }

    @Override
    public void afterBreak(World world, PlayerEntity playerEntity, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity, ItemStack itemStack) {
        super.afterBreak(world, playerEntity, blockPos, blockState, blockEntity, itemStack);

        if (blockShouldDropExperienceWhenBroken(world, blockState, itemStack)) {
            this.dropExperience((ServerWorld) world, blockPos, getTotalExperienceToDrop(world, itemStack));
        }
    }

    private boolean blockShouldDropExperienceWhenBroken(World world, BlockState blockState, ItemStack itemStack) {
        return !world.isClient
            && blockState.isOf(Blocks.AMETHYST_CLUSTER)
            && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, itemStack) == 0;
    }

    private int getTotalExperienceToDrop(World world, ItemStack itemStack) {
        return heldItemIsPickaxe(itemStack)
            ? 2 + world.random.nextInt(5)
            : 1 + world.random.nextInt(3);
    }

    /**
     * Removed FabricToolTags since this is no longer where it used to be.
     * @todo Move this functionality to fettlol-lib once I figure out where this is supposed to go.
     */
    private boolean heldItemIsPickaxe(ItemStack itemStack) {
        return itemStack.isIn(ItemTags.CLUSTER_MAX_HARVESTABLES);
            // || itemStack.isIn(FabricToolTags.PICKAXES);
    }

}
