package me.codecraft.sticky_torches.sticky_torches.client.entity.soul_sticky_torch;

import me.codecraft.sticky_torches.sticky_torches.StickyTorches;
import me.codecraft.sticky_torches.sticky_torches.entity.SoulStickyTorchEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SoulStickyTorchRender extends EntityRenderer<SoulStickyTorchEntity, SoulStickyTorchRenderState> {

    private static final Identifier TEXTURE = Identifier.of(StickyTorches.MOD_ID,"textures/entity/soul_sticky_torch/soul_sticky_torch.png");
    private final SoulStickyTorchModel model;
    public SoulStickyTorchRender(EntityRendererFactory.Context context) {
        super(context);
        this.shadowRadius = 0.5F;
        this.model = new SoulStickyTorchModel(context.getPart(SoulStickyTorchModel.SOUL_STICKY_TORCH));

    }

    @Override
    public SoulStickyTorchRenderState createRenderState() {
        return new SoulStickyTorchRenderState();
    }

    @Override
    public void render(SoulStickyTorchRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {

        matrices.push();
        VertexConsumer vertexconsumer = ItemRenderer.getItemGlintConsumer(vertexConsumers,
        this.model.getLayer(TEXTURE), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);
        matrices.pop();
        super.render(state, matrices, vertexConsumers, light);
    }



    public Identifier getTexture(SoulStickyTorchRenderState stickyTorchRenderState) {
        return TEXTURE;
    }
}
