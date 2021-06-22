package net.fettlol.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinConditions implements IMixinConfigPlugin {

    public static final UtilModConfig CONFIG;

    static {
        AutoConfig.register(UtilModConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(UtilModConfig.class).getConfig();
    }

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
        } else if (mixinClassName.contains("Spawner")) {
            return true; // No config for this yet.
        } else if (mixinClassName.contains("Accessor")) {
            return true; // Always return true for Accessors.
        } else if (mixinClassName.contains("TagGroupLoaderMixin")) {
            return true; // Always return true for the TagGroupLoader.
        } else if (mixinClassName.contains("ResourceSupplier")) {
            return true; // No config for this yet.
        } else if (mixinClassName.contains("BiomeFeaturesMixin")) {
            return true; // No config for this yet.
        } else if (mixinClassName.contains("MinecraftClientMixin")) {
            return true; // This feels like something we don't need a config option for.
        } else if (mixinClassName.contains("Manager")) {
            return true; // Always return true for PlayerManager and RecipeManager.
        } else {
            return false;
        }

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
