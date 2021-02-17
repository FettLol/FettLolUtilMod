package net.brekitomasson.fettlol.mixin;

import net.brekitomasson.fettlol.integration.Croptopia;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.brain.task.FarmerVillagerTask;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(FarmerVillagerTask.class)
public class FarmerVillagerTaskMixin {

    @Shadow
    private @Nullable BlockPos currentTarget;

    @ModifyVariable(method = "keepRunning", at = @At("STORE"), ordinal = 0)
    private SimpleInventory addPlantableSeeds(SimpleInventory inventory, ServerWorld world, VillagerEntity villagerEntity, long l) {
        for (int iteration = 0; iteration < inventory.size(); ++iteration) {
            ItemStack itemStack = inventory.getStack(iteration);
            boolean bl = false;

            if (!itemStack.isEmpty()) {
                if (itemStack.getItem() == croptopiaSeed("artichoke")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("artichoke"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("asparagus")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("asparagus"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("barley")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("barley"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("basil")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("basil"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("bellpepper")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("bellpepper"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("blackbean")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("blackbean"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("blackberry")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("blackberry"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("blueberry")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("blueberry"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("broccoli")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("broccoli"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("cabbage")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("cabbage"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("cantaloupe")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("cantaloupe"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("cauliflower")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("cauliflower"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("celery")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("celery"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("chile_pepper")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("chile_pepper"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("coffee")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("coffee"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("corn")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("corn"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("cranberry")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("cranberry"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("cucumber")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("cucumber"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("currant")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("currant"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("eggplant")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("eggplant"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("elderberry")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("elderberry"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("garlic")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("garlic"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("ginger")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("ginger"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("grape")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("grape"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("greenbean")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("greenbean"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("greenonion")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("greenonion"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("honeydew")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("honeydew"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("hops")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("hops"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("kale")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("kale"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("kiwi")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("kiwi"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("leek")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("leek"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("lettuce")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("lettuce"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("mustard")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("mustard"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("oat")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("oat"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("olive")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("olive"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("onion")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("onion"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("peanut")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("peanut"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("pineapple")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("pineapple"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("radish")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("radish"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("raspberry")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("raspberry"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("rhubarb")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("rhubarb"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("rice")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("rice"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("rutabaga")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("rutabaga"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("saguaro")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("saguaro"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("soybean")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("soybean"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("spinach")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("spinach"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("squash")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("squash"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("strawberry")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("strawberry"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("sweetpotato")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("sweetpotato"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("tomatillo")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("tomatillo"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("tomato")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("tomato"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("turmeric")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("turmeric"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("turnip")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("turnip"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("yam")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("yam"), 3);
                    bl = true;
                } else if (itemStack.getItem() == croptopiaSeed("zucchini")) {
                    world.setBlockState(this.currentTarget, croptopiaBlock("zucchini"), 3);
                    bl = true;
                }
            }

            if (bl) {
                if (this.currentTarget != null) {
                    world.playSound(null,
                        this.currentTarget.getX(), this.currentTarget.getY(), this.currentTarget.getZ(),
                        SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0F, 1.0F
                    );
                }

                itemStack.decrement(1);

                if (itemStack.isEmpty()) inventory.setStack(iteration, ItemStack.EMPTY);

                break;
            }
        }

        return inventory;

    }

    private BlockState croptopiaBlock(String crop) {
        return Registry.BLOCK.get(Croptopia.cropBlock(crop)).getDefaultState();
    }

    private Item croptopiaSeed(String crop) {
        return Registry.ITEM.get(Croptopia.cropSeed(crop)).asItem();
    }

}