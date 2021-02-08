package net.brekitomasson.fettlol.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "fettlol")
public class UtilModConfig implements ConfigData {

    boolean addEggCollectorEnchantment = false;
    boolean infinityCanMixWithMending = true;
    boolean infinityDoesNotRequireArrow = true;
    boolean poisonousPotatoIsCompostable = true;

    // Helper methods to check current config values from other parts of the codebase.
    public boolean canInfinityMixWithMending() { return infinityCanMixWithMending; }
    public boolean doesInfinityWorkWithoutArrows() { return infinityDoesNotRequireArrow; }
    public boolean doesPoisonousPotatoCompost() { return poisonousPotatoIsCompostable; }
    public boolean isEggCollectorEnchantmentAvailable() { return addEggCollectorEnchantment; }

}
