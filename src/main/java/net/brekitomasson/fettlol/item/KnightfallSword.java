package net.brekitomasson.fettlol.item;

import net.brekitomasson.fettlol.UtilMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

public class KnightfallSword extends SwordItem {

    public KnightfallSword() {
        super(
            ToolMaterials.NETHERITE,
            4,
            -2.4F,
            new Item.Settings().group(UtilMod.ITEMGROUP).fireproof().rarity(Rarity.RARE)
        );
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.fettlol.knightfall.tooltip"));
    }

}
