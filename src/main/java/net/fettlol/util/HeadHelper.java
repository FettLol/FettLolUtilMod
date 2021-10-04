package net.fettlol.util;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.text.LiteralText;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

import java.util.Random;

public class HeadHelper {

    public static ItemStack getPlayerHeadWithTexture(String playerName, int[] idArray, String texture) {
        ItemStack playerHead = new ItemStack(Items.PLAYER_HEAD, 1);
        NbtCompound tag = playerHead.getOrCreateNbt();

        NbtCompound value = new NbtCompound();
        NbtCompound textures = new NbtCompound();
        NbtCompound skullOwner = new NbtCompound();

        try {
            value.putString("Value", texture);
            textures = StringNbtReader.parse("{textures:[" + value + "]}");
            skullOwner.putIntArray("Id", idArray);
            skullOwner.put("Properties", textures);
        } catch (CommandSyntaxException e) {
            e.printStackTrace();
        }

        tag.put("SkullOwner", skullOwner);

        playerHead.writeNbt(tag);

        playerHead.setCustomName(new LiteralText(playerName));

        return playerHead;
    }

    public static ItemStack getPlayerHead(String playerName, String skullOwner) {
        ItemStack playerHead = new ItemStack(Items.PLAYER_HEAD, 1);
        NbtCompound tag = playerHead.getOrCreateNbt();

        tag.putString("SkullOwner", skullOwner);

        playerHead.writeNbt(tag);

        playerHead.setCustomName(new LiteralText(playerName));

        return playerHead;
    }

    /**
     * Get a head where the name and profile is the same.
     *
     * @param playerName String Name and Profile
     * @return SellHeadFactory
     */
    public static TradeOffers.Factory playerHeadForSale(String playerName) {
        return new SellHeadFactory(getPlayerHead(playerName, playerName), 1, 3, 10);
    }

    /**
     * Get a head where the name and profile are different.
     *
     * @param playerName String Name
     * @param skullOwner String Profile
     * @return SellHeadFactory
     */
    public static TradeOffers.Factory playerHeadForSale(String playerName, String skullOwner) {
        return new SellHeadFactory(getPlayerHead(playerName, skullOwner), 1, 3, 10);
    }

    /**
     * @param playerName String The player's name.
     * @param idArray    int[] The unique ID for this head.
     * @param texture    String The Texture ID
     * @return SellHeadFactory
     */
    public static TradeOffers.Factory playerTextureForSale(String playerName, int[] idArray, String texture) {
        return new SellHeadFactory(getPlayerHeadWithTexture(playerName, idArray, texture), 1, 3, 10);
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
            this(new ItemStack(item), price, 12, experience);
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
