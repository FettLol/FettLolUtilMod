package net.fettlol.utilmod;

import net.fabricmc.api.ModInitializer;
import net.fettlol.utilmod.command.Commands;
import net.fettlol.utilmod.init.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UtilMod implements ModInitializer {

    public static final String MOD_ID = "fettlol";
    public static final String MOD_NAME = "Fettlol Utilmod";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

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
