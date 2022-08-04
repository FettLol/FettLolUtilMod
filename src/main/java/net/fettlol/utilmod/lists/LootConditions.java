package net.fettlol.utilmod.lists;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;

public class LootConditions {
    public static final LootCondition.Builder WITH_SILK_TOUCH = MatchToolLootCondition.builder(
        ItemPredicate
            .Builder
            .create()
            .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1)))
    );

    public static final LootCondition.Builder WITHOUT_SILK_TOUCH = WITH_SILK_TOUCH.invert();

    public static final LootFunction.Builder HIGH_LEVEL_TREASURE_ENCHANTMENT = EnchantWithLevelsLootFunction
        .builder(UniformLootNumberProvider.create(20.0f, 40.0f))
        .allowTreasureEnchantments();
}
