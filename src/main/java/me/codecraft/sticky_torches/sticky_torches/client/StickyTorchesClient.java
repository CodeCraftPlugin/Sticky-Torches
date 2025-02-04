package me.codecraft.sticky_torches.sticky_torches.client;

import me.codecraft.sticky_torches.sticky_torches.client.entity.soul_sticky_torch.SoulStickyTorchModel;
import me.codecraft.sticky_torches.sticky_torches.client.entity.soul_sticky_torch.SoulStickyTorchRender;
import me.codecraft.sticky_torches.sticky_torches.entity.Entities;
import me.codecraft.sticky_torches.sticky_torches.client.entity.sticky_torch.StickyTorchModel;
import me.codecraft.sticky_torches.sticky_torches.client.entity.sticky_torch.StickyTorchRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class StickyTorchesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(StickyTorchModel.STICKY_TORCH, StickyTorchModel::getTexturedModelData);
        EntityRendererRegistry.register(Entities.STICKY_TORCH_ENTITY, StickyTorchRender::new);

        EntityModelLayerRegistry.registerModelLayer(SoulStickyTorchModel.SOUL_STICKY_TORCH, SoulStickyTorchModel::getTexturedModelData);
        EntityRendererRegistry.register(Entities.SOUL_STICKY_TORCH_ENTITY, SoulStickyTorchRender::new);
    }
}
