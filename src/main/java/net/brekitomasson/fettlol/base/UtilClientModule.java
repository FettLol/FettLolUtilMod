package net.brekitomasson.fettlol.base;

import net.minecraft.client.MinecraftClient;

public abstract class UtilClientModule {
    protected UtilModule module;

    public UtilClientModule(UtilModule module) {
        this.module = module;
    }

    public UtilModule getModule() {
        return module;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public void register() {
        // Nothing here.
    }

    public void init() {
        // Nothing here.
    }

    public void loadWorld(MinecraftClient client) {
        // Runs on clients.
    }

}
