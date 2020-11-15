package net.fettlol_util;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class UtilMod implements ModInitializer {

	public static final String MOD_ID = "fettlol_util";
	public static UtilModConfig CONFIG;

	@Override
	public void onInitialize() {
		AutoConfig.register(UtilModConfig.class, GsonConfigSerializer::new);

		UtilModConfig CONFIG = AutoConfig.getConfigHolder(UtilModConfig.class).getConfig();
	}
}
