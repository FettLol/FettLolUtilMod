package net.brekitomasson.fettlol.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.LiteralText;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

import java.util.Random;
import java.util.UUID;

public class HeadHelper {

    public static ItemStack getPlayerHead(String playerName, UUID skullOwner) {
        ItemStack playerHead = new ItemStack(Items.PLAYER_HEAD, 1);

        CompoundTag tag = playerHead.getOrCreateTag();
        tag.putUuid("SkullOwner", skullOwner);
        playerHead.setTag(tag);

        playerHead.setCustomName(new LiteralText(playerName));

        return playerHead;
    }

    public static ItemStack getPlayerHead(String playerName, String skullOwner) {
        ItemStack playerHead = new ItemStack(Items.PLAYER_HEAD, 1);

        CompoundTag tag = playerHead.getOrCreateTag();
        tag.putString("SkullOwner", skullOwner);
        playerHead.setTag(tag);

        playerHead.setCustomName(new LiteralText(playerName));

        return playerHead;
    }

    public static TradeOffers.Factory playerHeadForSale(String playerName) {
        return new SellHeadFactory(getPlayerHead(playerName, playerName), 1, 3, 10);
    }

    public static TradeOffers.Factory playerHeadForSale(String playerName, UUID skullOwner) {
        return new SellHeadFactory(getPlayerHead(playerName, skullOwner), 1, 3, 10);
    }

    public static TradeOffers.Factory playerHeadForSale(String playerName, String skullOwner) {
        return new SellHeadFactory(getPlayerHead(playerName, skullOwner), 1, 3, 10);
    }

    /**
     * Static Factory class extending the standard TradeOffers factory and tuned specifically
     * for use when selling player heads using the "Wandering Headhunter" trader.
     */
    public static class SellHeadFactory implements TradeOffers.Factory {
        private final ItemStack sell;
        private final int price;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public SellHeadFactory(Block block, int price, int maxUses, int experience) {
            this(new ItemStack(block), price, maxUses, experience);
        }

        public SellHeadFactory(Item item, int price, int experience) {
            this((ItemStack)(new ItemStack(item)), price, 12, experience);
        }

        public SellHeadFactory(Item item, int price, int maxUses, int experience) {
            this(new ItemStack(item), price, maxUses, experience);
        }

        public SellHeadFactory(ItemStack stack, int price, int maxUses, int experience) {
            this(stack, price, maxUses, experience, 0.05F);
        }

        public SellHeadFactory(ItemStack stack, int price, int maxUses, int experience, float multiplier) {
            this.sell = stack;
            this.price = price;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }

        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new ItemStack(Items.EMERALD, this.price), this.sell, this.maxUses, this.experience, this.multiplier);
        }
    }

}
