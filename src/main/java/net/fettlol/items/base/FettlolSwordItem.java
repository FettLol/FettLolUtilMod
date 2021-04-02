package net.fettlol.items.base;

import net.fettlol.UtilMod;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class FettlolSwordItem extends SwordItem {

    public FettlolSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.group(UtilMod.ITEMGROUP));
    }

}
