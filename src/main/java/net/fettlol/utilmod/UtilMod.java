package net.fettlol.utilmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fettlol.utilmod.command.Commands;
import net.fettlol.utilmod.init.*;
import net.fettlol.utilmod.util.RegistryHelper;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UtilMod implements ModInitializer {

    public static final String MOD_ID = "fettlol";
    public static final String MOD_NAME = "Fettlol Utilmod";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ItemGroup ITEMGROUP = FabricItemGroupBuilder.create(RegistryHelper.fettlolId(MOD_ID))
        .icon(() -> new ItemStack(FettlolItems.PEACEKEEPER))
        .build();

    @Override
    public void onInitialize() {
        FettlolEntities.init();
        FettlolEnchants.init();
        FettlolItems.init();
        FettlolTags.init();
        FettlolModIntegrations.init();
        FettlolLootTables.init();
        Commands.init();
    }
}
