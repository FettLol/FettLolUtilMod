package net.fettlol_util.base;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public abstract class UtilModule
{
    public boolean enabled = true;
    public boolean enabledByDefault = true;
    public boolean alwaysEnabled = false;
    public String description = "";
    public String mod = "";
    public Class<? extends UtilClientModule> client = null;

    public boolean depends() {
        return true;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public List<Identifier> getRecipesToRemove() {
        return new ArrayList<>();
    }

    public void register() {
        // Nothing here.
    }

    public void init() {
        // Nothing here.
    }

    public void loadWorld(MinecraftServer server) {
        // Runs on servers.
    }

}
