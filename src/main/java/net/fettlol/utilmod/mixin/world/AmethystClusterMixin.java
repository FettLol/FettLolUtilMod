package net.fettlol.utilmod.mixin.world;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
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
     * This method should probably be refactored into `fettlol-lib` and made part of a larger
     * collection of methods that take an ItemStack as their argument and return a boolean.
     * In this case, we're checking if an item is a Pickaxe in two different ways, since not
     * all pickaxes added via mods are in minecraft:cluster_max_harvestables, but they should
     * at least be in fabric:pickaxes. All things considered, there should probably be a check
     * to see if the item is an instance of PickaxeItem, too.
     */
    private boolean heldItemIsPickaxe(ItemStack itemStack) {
        return itemStack.isIn(ItemTags.CLUSTER_MAX_HARVESTABLES)
            || itemStack.isIn(FabricToolTags.PICKAXES);
    }

}
