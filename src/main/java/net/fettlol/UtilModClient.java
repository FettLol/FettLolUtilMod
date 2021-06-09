package net.fettlol;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fettlol.entities.render.WanderingHeadHunterRender;
import net.fettlol.init.FettlolEntities;

public class UtilModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        initializeEntities();
    }

    private void initializeEntities() {
        // Register the Wandering Headhunter in the client's Entity Renderer Registry.
        EntityRendererRegistry.INSTANCE.register(
            FettlolEntities.WANDERING_HEAD_HUNTER,
            WanderingHeadHunterRender::new
        );
    }
}
