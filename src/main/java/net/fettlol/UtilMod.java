package net.fettlol;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fettlol.config.MixinConditions;
import net.fettlol.config.UtilModConfig;
import net.fettlol.init.*;
import net.fettlol.util.RegistryHelper;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class UtilMod implements ModInitializer {

    public static final UtilModConfig CONFIG = MixinConditions.CONFIG;

    public static final String MOD_ID = "fettlol";
    public static final String MOD_NAME = "Fettlol Utilmod";

    public static ItemGroup ITEMGROUP = FabricItemGroupBuilder.create(RegistryHelper.fettlolId(MOD_ID))
        .icon(() -> new ItemStack(FettlolItems.PEACEKEEPER))
        .build();

    @Override
    public void onInitialize() {
        FettlolEntities.init();
        FettlolEnchants.init();
        FettlolItems.init();
        FettlolTags.init();
        FettlolModIntegrations.init();
        FettlolCommands.init();
        FettlolLootTables.init();
        FettlolRecipes.init();
        FettlolTweaks.init();
    }
}
