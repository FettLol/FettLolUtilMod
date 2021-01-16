package net.brekitomasson.fettlol_util.base;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.brekitomasson.fettlol_util.UtilModConfig;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class ConfigurationMixinConditions implements IMixinConfigPlugin {
    static {
        AutoConfig.register(UtilModConfig.class, GsonConfigSerializer::new);
    }

    private static final UtilModConfig CONFIG = AutoConfig.getConfigHolder(UtilModConfig.class).getConfig();

    @Override
    public void onLoad(String mixinPackage) {
        // Nothing here right now.
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains("ChickenEntityMixin")) {
            return CONFIG.doChickenDropFeathers();
        } else if (mixinClassName.contains("CustomWorldsMixin")) {
            return CONFIG.doSkipCustomWorldsWarning();
        } else if (mixinClassName.contains("FarmlandBlockMixin")) {
            return CONFIG.doesFeatherFallingNotBreakFarmland();
        } else if (mixinClassName.contains("InfinityBowArrowMixin")) {
            return CONFIG.doesInfinityWorkWithoutArrows();
        } else if (mixinClassName.contains("VillagerGoalMixin")) {
            return CONFIG.doVillagersFollowEmeraldBlocks();
        } else if (mixinClassName.contains("PlayerManagerMixin")) {
            return CONFIG.doAllRecipiesUnlockByDefault();
        } else if (mixinClassName.contains("InfinityBowMendingMixin")) {
            return CONFIG.canInfinityMixWithMending();
        } else if (mixinClassName.contains("EggCollectorMixin")) {
            return CONFIG.isEggCollectorEnchantmentAvailable();
        } else if (mixinClassName.contains("SpawnEggItemAccessor")) {
            return CONFIG.isEggCollectorEnchantmentAvailable();
        }

        // If all else fails, return false.
        return false;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
        // Nothing here right now.
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        // Nothing here right now.
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        // Nothing here right now.
    }

}
