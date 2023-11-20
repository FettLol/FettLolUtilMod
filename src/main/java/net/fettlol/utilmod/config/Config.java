package net.fettlol.utilmod.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraft.entity.player.PlayerEntity;

import java.util.UUID;
import java.util.function.Function;

// moved to it's own class due to delicate static initialization from mixins
public class Config {
    public static final UtilModConfig CONFIG;
    private static final ConfigHolder<UtilModConfig> CONFIG_HOLDER;

    static {
        AutoConfig.register(UtilModConfig.class, GsonConfigSerializer::new);
        CONFIG_HOLDER = AutoConfig.getConfigHolder(UtilModConfig.class);
        CONFIG = CONFIG_HOLDER.getConfig();
    }

    public static void saveConfig() {
        CONFIG_HOLDER.save();
    }

    public static PlayerConfig getPlayerConfig(UUID playerUuid) {
        return CONFIG.getPlayerConfig(playerUuid);
    }

    public static PlayerConfig getPlayerConfig(PlayerEntity player) {
        return getPlayerConfig(player.getUuid());
    }

    public static void updatePlayerConfig(UUID playerUuid, Function<PlayerConfig, PlayerConfig> transform) {
        CONFIG.setPlayerConfig(playerUuid, transform.apply(getPlayerConfig(playerUuid)));
        saveConfig();
    }

    public static void updatePlayerConfig(PlayerEntity player, Function<PlayerConfig, PlayerConfig> transform) {
        updatePlayerConfig(player.getUuid(), transform);
    }
}
