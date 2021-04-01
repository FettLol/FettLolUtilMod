package net.fettlol;

import net.fettlol.base.ConfigurationMixinConditions;
import net.fettlol.config.UtilModConfig;
import net.fettlol.init.*;
import net.fettlol.util.RegistryHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UtilMod implements ModInitializer {

    public static final UtilModConfig CONFIG = ConfigurationMixinConditions.CONFIG;

    public static final String MOD_ID = "fettlol";

    public static Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static ItemGroup ITEMGROUP = FabricItemGroupBuilder.create(RegistryHelper.makeId(MOD_ID))
        .icon(() -> new ItemStack(net.minecraft.item.Items.ZOMBIE_HEAD))
        .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Starting FettLol Utility Mod.");

        // Initialize our entites!
        FettlolEntities.init();

        // Initialize our enchantments!
        FettlolEnchants.init();

        // Initialize our items!
        FettlolItems.init();

        // Initialize our tags!
        FettlolTags.init();

        // Initialize our loot tables!
        LootTables.init();

        // Initialize our custom mod integrations!
        ModIntegrations.init();

        // And, finally, initialize all our little tweaks and adjustments!
        Tweaks.init();

    }
}
