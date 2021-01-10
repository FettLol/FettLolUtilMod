package net.brekitomasson.fettlol_util;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "fettlol_util")
public class UtilModConfig implements ConfigData {
    boolean displayDebugData = true;
    boolean chickensDropFeathers = true;
    boolean skipCustomWorldsWarning = true;
    boolean infinityDoesNotRequireArrow = true;
    boolean featherFallingDoesNotBreakFarmland = true;
    boolean villagersFollowEmeraldBlocks = true;
    boolean poisonousPotatoIsCompostable = true;
    boolean allRecipiesUnlockedByDefault = true;

    public boolean doesDebugDataDisplay() { return displayDebugData; }

    public boolean doChickenDropFeathers() {
        return chickensDropFeathers;
    }

    public boolean doSkipCustomWorldsWarning() {
        return skipCustomWorldsWarning;
    }

    public boolean doesInfinityWorkWithoutArrows() {
        return infinityDoesNotRequireArrow;
    }

    public boolean doesFeatherFallingNotBreakFarmland() {
        return featherFallingDoesNotBreakFarmland;
    }

    public boolean doVillagersFollowEmeraldBlocks() {
        return villagersFollowEmeraldBlocks;
    }

    public boolean doesPoisonousPotatoCompost() {
        return poisonousPotatoIsCompostable;
    }

    public boolean doAllRecipiesUnlockByDefault() {
        return allRecipiesUnlockedByDefault;
    }
}
