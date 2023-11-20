package net.fettlol.utilmod.config;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

import static net.fettlol.utilmod.config.Config.CONFIG;

public class MixinConditions implements IMixinConfigPlugin {
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
        // Exceptions for those mixins that have configuration tied to them, so that they're not loaded
        // rather than loaded but then ignored using conditionals in the Mixin.

        if (mixinClassName.contains("InfinityBowArrow")) {
            return CONFIG.doesInfinityWorkWithoutArrows();
        } else if (mixinClassName.contains("InfinityBowMending")) {
            return CONFIG.canInfinityMixWithMending();
        } else if (mixinClassName.contains("EggCollector")) {
            return CONFIG.isEggCollectorEnchantmentAvailable();
        } else if (mixinClassName.contains("VillagerGoal")) {
            return CONFIG.doVillagersFollowEmeraldBlocks();
        } else if (mixinClassName.contains("WitherSkeletonMixin")) {
            return CONFIG.doBabyWitherSkeletonsSpawn();
        } else if (mixinClassName.contains("WitchMixin")) {
            return CONFIG.doWitchesKeepTheirDistance();
        }

        // Default to true for all mixins that do not have configuration.
        return true;
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
