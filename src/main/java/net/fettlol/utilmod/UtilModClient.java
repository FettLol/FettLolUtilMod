package net.fettlol.utilmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fettlol.utilmod.init.FettlolEntities;
import net.fettlol.utilmod.entities.render.WanderingHeadHunterRender;

public class UtilModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        initializeEntities();
    }

    private void initializeEntities() {
        // Register the Wandering Headhunter in the client's Entity Renderer Registry.
        EntityRendererRegistry.register(
            FettlolEntities.WANDERING_HEAD_HUNTER,
            WanderingHeadHunterRender::new
        );
    }
}
