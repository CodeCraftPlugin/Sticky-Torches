package me.codecraft.sticky_torches.sticky_torches.client;

import me.codecraft.sticky_torches.sticky_torches.entity.Entities;
import me.codecraft.sticky_torches.sticky_torches.client.entity.StickyTorchModel;
import me.codecraft.sticky_torches.sticky_torches.client.entity.StickyTorchRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class StickyTorchesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(StickyTorchModel.STICKY_TORCH, StickyTorchModel::getTexturedModelData);
        EntityRendererRegistry.register(Entities.STICKY_TORCH_ENTITY, StickyTorchRender::new);
    }
}
