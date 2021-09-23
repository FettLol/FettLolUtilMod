package net.fettlol.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "fettlol")
public class UtilModConfig implements ConfigData {

    boolean addEggCollectorEnchantment = true;
    boolean infinityCanMixWithMending = true;
    boolean infinityDoesNotRequireArrow = true;
    boolean witchesKeepDistance = true;
    boolean babyWitherSkeletons = true;
    boolean poisonousPotatoIsCompostable = true;
    boolean wanderingHeadHunter = true;
    boolean villagersFollowEmeraldBlocks = true;

    // == Helper methods to check current config values from other parts of the codebase. ==

    // Mixin-specific helper methods to be used in net.fettlol.config.MixinConditions
    public boolean doesInfinityWorkWithoutArrows() { return infinityDoesNotRequireArrow; }
    public boolean canInfinityMixWithMending() { return infinityCanMixWithMending; }
    public boolean isEggCollectorEnchantmentAvailable() { return addEggCollectorEnchantment; }
    public boolean doVillagersFollowEmeraldBlocks() { return villagersFollowEmeraldBlocks; }
    public boolean doBabyWitherSkeletonsSpawn() { return babyWitherSkeletons; }
    public boolean doWitchesKeepTheirDistance() { return witchesKeepDistance; }

    // Other helpers, used where needed.
    public boolean shouldWanderingHeadhunterExist() { return wanderingHeadHunter; }
    public boolean doesPoisonousPotatoCompost() { return poisonousPotatoIsCompostable; }

}
