package net.fettlol.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "fettlol")
public class UtilModConfig implements ConfigData {

    boolean addEggCollectorEnchantment = true;
    boolean infinityCanMixWithMending = true;
    boolean infinityDoesNotRequireArrow = true;
    boolean witchesKeepDistance = true;
    boolean fettlandsBiome = false;
    boolean babyWitherSkeletons = true;
    boolean poisonousPotatoIsCompostable = true;
    boolean wanderingHeadHunter = true;
    boolean villagersFollowEmeraldBlocks = true;

    // Helper methods to check current config values from other parts of the codebase.
    public boolean doVillagersFollowEmeraldBlocks() { return villagersFollowEmeraldBlocks; }
    public boolean generateFettlandsBiome() { return fettlandsBiome; }
    public boolean doBabyWitherSkeletonsSpawn() { return babyWitherSkeletons; }
    public boolean doWitchesKeepTheirDistance() { return witchesKeepDistance; }
    public boolean canInfinityMixWithMending() { return infinityCanMixWithMending; }
    public boolean shouldWanderingHeadhunterExist() { return wanderingHeadHunter; }
    public boolean doesInfinityWorkWithoutArrows() { return infinityDoesNotRequireArrow; }
    public boolean doesPoisonousPotatoCompost() { return poisonousPotatoIsCompostable; }
    public boolean isEggCollectorEnchantmentAvailable() { return addEggCollectorEnchantment; }

}
