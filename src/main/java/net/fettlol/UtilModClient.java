package net.fettlol;

import net.fettlol.entities.render.WanderingHeadHunterRender;
import net.fettlol.init.FettlolEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class UtilModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        initializeEntities();
    }

    private void initializeEntities() {
        // Register the Wandering Headhunter in the client's Entity Renderer Registry.
        EntityRendererRegistry.INSTANCE.register(
            FettlolEntities.WANDERING_HEAD_HUNTER, (r, c) -> new WanderingHeadHunterRender(r)
        );
    }
}
