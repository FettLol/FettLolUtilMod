package net.brekitomasson.fettlol.base;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.brekitomasson.fettlol.config.UtilModConfig;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class ConfigurationMixinConditions implements IMixinConfigPlugin {

    // I'd prefer not to have to register it here, but it won't be available in shouldApplyMixin otherwise.
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
        } else if (mixinClassName.contains("TraderOffers")) {
            return CONFIG.shouldWanderingHeadhunterExist();
        } else if (mixinClassName.contains("FarmerVillagerTask")) {
            // Used in Croptopia integration.
            return true;
        } else if (mixinClassName.contains("Accessor")) {
            // Always return true for Accessors.
            return true;
        } else if (mixinClassName.contains("RecipeManager")) {
            // Always return true for recipe modifications.
            return true;
        } else {
            // If the mixin is not detected above, we reject it.
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
