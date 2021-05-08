package net.fettlol;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fettlol.config.MixinConditions;
import net.fettlol.config.UtilModConfig;
import net.fettlol.init.*;
import net.fettlol.util.RegistryHelper;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UtilMod implements ModInitializer {

    public static final UtilModConfig CONFIG = MixinConditions.CONFIG;

    public static final String MOD_ID = "fettlol";

    public static Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static ItemGroup ITEMGROUP = FabricItemGroupBuilder.create(RegistryHelper.makeId(MOD_ID))
        .icon(() -> new ItemStack(RegistryHelper.getItemFromRegistry("fettlol", "peacekeeper")))
        .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Starting FettLol Utility Mod.");

        // Register our entites!
        FettlolEntities.init();

        // Register our enchantments!
        FettlolEnchants.init();

        // Register our items!
        FettlolItems.init();

        // Register our item/block tags!
        FettlolTags.init();

        // Register our mod integrations!
        ModIntegrations.init();

        // Register our commands!
        FettlolCommands.init();

        // Register our biomes!
        FettlolBiomes.init();

        // Register our loot tables!
        FettlolLootTables.init();

        // Register our recipes!
        FettlolRecipes.init();

        // And, finally, initialize any remaining tweaks and adjustments that don't fit the list above!
        Tweaks.init();

    }
}
