package net.fettlol.utilmod.mixin.world;

import net.fettlol.lib.list.Tags;
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
        // Run whatever is in the parent classes' afterBreak first.
        super.afterBreak(world, playerEntity, blockPos, blockState, blockEntity, itemStack);

        if (passesCriteria(world, blockState, itemStack)) {
            this.dropExperience((ServerWorld) world, blockPos, getExpDropped(world, itemStack));
        }
    }

    private boolean passesCriteria(World world, BlockState blockState, ItemStack itemStack) {
        // Run on the server world, ensure the block is an Amethyst Cluster, and that it's not broken with Silk Touch
        return !world.isClient
            && blockState.isOf(Blocks.AMETHYST_CLUSTER)
            && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, itemStack) == 0;
    }

    private int getExpDropped(World world, ItemStack itemStack) {
        return heldItemIsPickaxe(itemStack)
            ? 2 + world.random.nextInt(5)
            : 1 + world.random.nextInt(3);
    }

    private boolean heldItemIsPickaxe(ItemStack itemStack) {
        // Since not all modded pickaxes are in minecraft:cluster_max_harvestables.
        return itemStack.isIn(ItemTags.CLUSTER_MAX_HARVESTABLES) || itemStack.isIn(Tags.FABRIC_PICKAXES);
    }

}
