package net.brekitomasson.fettlol_util;

import net.fabricmc.api.ModInitializer;
import net.brekitomasson.fettlol_util.base.Handler.LogHandler;
import net.brekitomasson.fettlol_util.base.Handler.ModuleHandler;
import net.brekitomasson.fettlol_util.module.*;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;

import java.util.Arrays;

public class UtilMod implements ModInitializer {

    public static final String MOD_ID = "fettlol_util";
    public static LogHandler LOG = new LogHandler("Fettlol-Util");
    public static UtilModConfig CONFIG = AutoConfig.getConfigHolder(UtilModConfig.class).getConfig();

    @Override
    public void onInitialize() {

        LOG.debug("Starting UtilMod.");

        // Register all the modules we're loading.
        ModuleHandler.INSTANCE.registerFabricMod(MOD_ID, Arrays.asList(
            AddEggCollection.class,
            ChickensDropFeathers.class,
            CompostablePoisonousPotato.class,
            FeatherFallingCrops.class,
            UnlockAllRecipes.class
        ));

        // Anything else that needs doing goes here.

        // And, finally, init the ModuleHandler!
        ModuleHandler.INSTANCE.init();

        LOG.info("UtilMod loaded!");
    }
}
