package net.fettlol_util;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "fettlol_util")
public class UtilModConfig implements ConfigData {
    @ConfigEntry.Category("Tweaks")
    public boolean VillagersFollowPlayersWithEmeraldBlocks = true;
}
