package net.fettlol.utilmod.config;

import oshi.annotation.concurrent.Immutable;

@Immutable
public class PlayerConfig {
    public static class Builder {
        public boolean autoPlant = true;

        public Builder setAutoPlant(boolean value) {
            autoPlant = value;
            return this;
        }

        public PlayerConfig build() {
            return new PlayerConfig(this);
        }
    }

    public final boolean autoPlant;

    public PlayerConfig() {
        this(new Builder());
    }
    public PlayerConfig(Builder builder) {
        this.autoPlant = builder.autoPlant;
    }

    public Builder getBuilder() {
        return new Builder()
            .setAutoPlant(autoPlant);
    }
}
