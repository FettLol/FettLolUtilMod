package net.fettlol.util;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class TagHelper {

    public static Tag.Identified<Item> makeItemTag(String namespace, String name) {
        Identifier id = new Identifier(namespace, name);
        Tag<Item> tag = ItemTags.getTagGroup().getTag(id);
        return tag == null ? (Tag.Identified<Item>) TagRegistry.item(id) : (Tag.Identified<Item>) tag;
    }

}
