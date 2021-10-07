package net.fettlol.utilmod.integration;

import com.google.common.collect.Lists;
import net.fettlol.lib.registry.RecipeApi;
import net.fettlol.utilmod.init.FettlolModIntegrations;
import net.fettlol.utilmod.lists.Mods;
import net.fettlol.utilmod.util.LogHelper;
import net.fettlol.utilmod.util.RecipeHelper;
import net.fettlol.utilmod.util.RegistryHelper;

public class Adorn {
    public static void init() {
        if (FettlolModIntegrations.isAdornLoaded) {
            LogHelper.log("Adorn detected! Applying integrations.");

            RecipeApi.add(
                RegistryHelper.fettlolId("extras/trident"),
                RecipeHelper.createShapedRecipe(
                    Lists.newArrayList('S', 'A', 'C', 'P'),
                    Lists.newArrayList(
                        RegistryHelper.vanillaId("prismarine_shard"),
                        RegistryHelper.fettlolId("aquamarine_gem"),
                        RegistryHelper.vanillaId("conduit"),
                        RegistryHelper.modId(Mods.ADORN, "prismarine_brick_post")
                    ),
                    Lists.newArrayList("item", "item", "item", "item"),
                    Lists.newArrayList("SSS", "ACA", " P "),
                    RegistryHelper.modId("minecraft", "trident")
                )
            );
        }
    }
}
