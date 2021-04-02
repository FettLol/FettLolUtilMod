package net.fettlol.items;

import net.fettlol.items.base.FettlolSwordItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

public class PeacekeeperSword extends FettlolSwordItem {

    public PeacekeeperSword() {
        super(
            ToolMaterials.DIAMOND,
            3,
            -1.8F,
            new Settings().rarity(Rarity.RARE)
        );
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.fettlol.peacekeeper.tooltip"));
    }

}
