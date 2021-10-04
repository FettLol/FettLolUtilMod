package net.fettlol.init;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fettlol.UtilMod;
import net.fettlol.util.BlockHelper;
import net.fettlol.util.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * This file contains various tweaks and adjustments that don't fit cleanly into
 * a mixin or which don't belong elsewhere.
 */
public class FettlolTweaks {

    public static void init() {

        // Poisonous Potatoes should be compostable.
        if (UtilMod.CONFIG.doesPoisonousPotatoCompost()) {
            RegistryHelper.makeCompostable(Items.POISONOUS_POTATO, 0.85f);
        }

        // Players should be able to duplicate flowers with Bone Meal.
        UseBlockCallback.EVENT.register(FettlolTweaks::growOnUseBlock);

    }

    // @TODO - Refactor this method and the next out of this file.
    public static ActionResult growOnUseBlock(PlayerEntity playerEntity, World world, Hand hand, BlockHitResult blockHitResult) {
        boolean success = growFlowerWithBoneMeal(playerEntity, hand, world, blockHitResult.getBlockPos());

        if (!success) return ActionResult.PASS;

        if (!playerEntity.isCreative()) playerEntity.getStackInHand(hand).decrement(1);

        return ActionResult.SUCCESS;

    }

    private static boolean growFlowerWithBoneMeal(PlayerEntity playerEntity, Hand hand, World world, BlockPos blockPos) {
        ItemStack itemStack = playerEntity.getStackInHand(hand);

        // Fail early if player is not holding Bone Meal.
        if (!(itemStack.getItem() instanceof BoneMealItem)) return false;

        Block block = world.getBlockState(blockPos).getBlock();

        // Fail if the player is using Bone Meal on something other than a flower.
        if (!BlockHelper.isFlower(block)) return false;

        if (world.isClient) {
            BoneMealItem.createParticles(world, blockPos, world.random.nextInt(15));
        }

        playerEntity.world.playSound(
            null,
            blockPos.getX(),
            blockPos.getY(),
            blockPos.getZ(),
            SoundEvents.BLOCK_SWEET_BERRY_BUSH_PLACE,
            SoundCategory.BLOCKS,
            0.5F,
            1.0F
        );

        Block.dropStack(world, blockPos, new ItemStack(block, 1));

        return true;
    }
}
