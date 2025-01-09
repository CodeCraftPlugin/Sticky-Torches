package me.codecraft.sticky_torches.sticky_torches.client.entity;

import me.codecraft.sticky_torches.sticky_torches.entity.StickyTorchEntity;
import me.codecraft.sticky_torches.sticky_torches.Sticky_torches;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class StickyTorchRender extends EntityRenderer<StickyTorchEntity,StickyTorchRenderState> {

    private static final Identifier TEXTURE = Identifier.of(Sticky_torches.MOD_ID,"textures/entity/sticky_torch/sticky_torch.png");
    private final StickyTorchModel model;
    public StickyTorchRender(EntityRendererFactory.Context context) {
        super(context);
        this.shadowRadius = 0.5F;
        this.model = new StickyTorchModel(context.getPart(StickyTorchModel.STICKY_TORCH));

    }

    @Override
    public StickyTorchRenderState createRenderState() {
        return new StickyTorchRenderState();
    }

    @Override
    public void render(StickyTorchRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {

        matrices.push();
        VertexConsumer vertexconsumer = ItemRenderer.getItemGlintConsumer(vertexConsumers,
                this.model.getLayer(TEXTURE), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);
        matrices.pop();
        super.render(state, matrices, vertexConsumers, light);
    }



    public Identifier getTexture(StickyTorchRenderState stickyTorchRenderState) {
        return TEXTURE;
    }
}
