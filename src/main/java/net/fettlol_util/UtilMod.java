package net.fettlol_util;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fettlol_util.base.Handler.LogHandler;
import net.fettlol_util.base.Handler.ModuleHandler;
import net.fettlol_util.module.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;

import java.util.Arrays;

public class UtilMod implements ModInitializer {

	public static final String MOD_ID = "fettlol_util";
	public static LogHandler LOG = new LogHandler("Fettlol-Util");

	@Override
	public void onInitialize() {

		LOG.debug("Starting UtilMod.");

		// Register all the modules we're loading.
		ModuleHandler.INSTANCE.registerFabricMod(MOD_ID, Arrays.asList(
			ChickensDropFeathers.class,
			CompostablePoisonousPotato.class,
			Core.class,
			FeatherFallingCrops.class,
			UnlockAllRecipes.class
		));

		// Anything else that needs doing goes here.

		// And, finally, init the ModuleHandler!
		ModuleHandler.INSTANCE.init();

		LOG.info("UtilMod loaded!");
	}
}
