package net.fettlol_util.module;

import net.fettlol_util.UtilMod;
import net.fettlol_util.base.Interface.Config;
import net.fettlol_util.base.Interface.Module;
import net.fettlol_util.base.UtilModule;

@Module(mod = UtilMod.MOD_ID, client = CoreClient.class, alwaysEnabled = true, description = "Core configuration")
public class Core extends UtilModule
{
    @Config(name = "Debug mode", description = "Enables debug messages.")
    public static boolean debug = true;
}
