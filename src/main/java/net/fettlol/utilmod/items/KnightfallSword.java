package net.fettlol.utilmod.items;

import net.fettlol.utilmod.items.base.FettlolSwordItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

public class KnightfallSword extends FettlolSwordItem {

    public KnightfallSword() {
        super(
            ToolMaterials.NETHERITE,
            5,
            -2.5F,
            new Settings().fireproof().rarity(Rarity.RARE)
        );
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.fettlol.knightfall.tooltip"));
    }

}
