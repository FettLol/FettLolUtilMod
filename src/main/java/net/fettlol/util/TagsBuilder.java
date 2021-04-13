package net.fettlol.util;

import com.google.common.collect.ImmutableMap;
import net.fettlol.UtilMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TagsBuilder {

	private final Map<Identifier, Set<Identifier>> itemTags = new HashMap<>();
	private final Map<Identifier, Set<Identifier>> blockTags = new HashMap<>();

	public void putItemTag(Tag.Identified<Block> tag, Block... blocks) {
		Identifier tagId = tag.getId();
		Set<Identifier> set = blockTags.computeIfAbsent(tagId, k -> new HashSet<>());

		for (Block block: blocks) {
			Identifier id = Registry.BLOCK.getId(block);
			if (id != Registry.BLOCK.getDefaultId()) {
				set.add(id);
			}
		}
	}

	public void putItemTag(Tag.Identified<Item> itemTag, String namespace, String item) {
		putItemTag(itemTag, RegistryHelper.getItemFromRegistry(namespace, item));
	}

	public void putItemTag(Tag.Identified<Item> tag, ItemConvertible... items) {
		Identifier tagId = tag.getId();
		Set<Identifier> set = itemTags.computeIfAbsent(tagId, k -> new HashSet<>());

		for (ItemConvertible item : items) {
			Identifier id = Registry.ITEM.getId(item.asItem());
			if (id != Registry.ITEM.getDefaultId()) {
				set.add(id);
			}
		}
	}

	public ImmutableMap<Identifier, Set<Identifier>> buildItemTags() {
		return new ImmutableMap.Builder<Identifier, Set<Identifier>>().putAll(itemTags).build();
	}

	public ImmutableMap<Identifier, Set<Identifier>> buildBlockTags() {
		return new ImmutableMap.Builder<Identifier, Set<Identifier>>().putAll(blockTags).build();
	}

}
