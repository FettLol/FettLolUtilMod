package net.fettlol.util;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;
import java.util.Set;

public class TagHelper {
    private static final Map<Identifier, Set<Identifier>> ITEM_TAGS = Maps.newHashMap();
    private static final Map<Identifier, Set<Identifier>> BLOCK_TAGS = Maps.newHashMap();

    public static Tag.Identified<Item> makeItemTag(String namespace, String name) {
        Identifier id = new Identifier(namespace, name);
        Tag<Item> tag = ItemTags.getTagGroup().getTag(id);
        return tag == null ? (Tag.Identified<Item>) TagRegistry.item(id) : (Tag.Identified<Item>) tag;
    }

    public static void addTag(Tag.Identified<Block> tag, Block... blocks) {
        Identifier tagId = tag.getId();
        Set<Identifier> set = BLOCK_TAGS.get(tagId);
        if (set == null) {
            set = Sets.newHashSet();
            BLOCK_TAGS.put(tagId, set);
        }

        for (Block block: blocks) {
            Identifier id = Registry.BLOCK.getId(block);
            if (id != Registry.BLOCK.getDefaultId()) {
                set.add(id);
            }
        }
    }

    public static void addTag(Tag.Identified<Item> tag, ItemConvertible... items) {
        Identifier tagId = tag.getId();
        Set<Identifier> set = ITEM_TAGS.get(tagId);
        if (set == null) {
            set = Sets.newHashSet();
            ITEM_TAGS.put(tagId, set);
        }

        for (ItemConvertible item: items) {
            Identifier id = Registry.ITEM.getId(item.asItem());
            if (id != Registry.ITEM.getDefaultId()) {
                set.add(id);
            }
        }
    }

    @SafeVarargs
    public static void addTags(ItemConvertible item, Tag.Identified<Item>... tags) {
        for (Tag.Identified<Item> tag: tags) {
            addTag(tag, item);
        }
    }

    @SafeVarargs
    public static void addTags(Block block, Tag.Identified<Block>... tags) {
        for (Tag.Identified<Block> tag: tags) {
            addTag(tag, block);
        }
    }

    public static Tag.Builder apply(Tag.Builder builder, Set<Identifier> ids) {
        ids.forEach((value) -> builder.add(value, "FettLol Utilmod"));
        return builder;
    }

    public static void apply(String entry, Map<Identifier, Tag.Builder> tagsMap) {
        Map<Identifier, Set<Identifier>> fettlolTags = null;
        if (entry.equals("block")) {
            fettlolTags = BLOCK_TAGS;
        } else if (entry.equals("item")) {
            fettlolTags = ITEM_TAGS;
        }
        if (fettlolTags != null) {
            fettlolTags.forEach((id, ids) -> {
                if (tagsMap.containsKey(id)) {
                    apply(tagsMap.get(id), ids);
                } else {
                    tagsMap.put(id, apply(Tag.Builder.create(), ids));
                }
            });
        }
    }

}
