package me.codecraft.sticky_torches.sticky_torches.client.entity.soul_sticky_torch;

import me.codecraft.sticky_torches.sticky_torches.StickyTorches;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SoulStickyTorchModel extends EntityModel<SoulStickyTorchRenderState> {

    public static final EntityModelLayer SOUL_STICKY_TORCH = new EntityModelLayer(Identifier.of(StickyTorches.MOD_ID, "soul_sticky_torch"), "main");

    private final ModelPart sticky_torch;
    public SoulStickyTorchModel(ModelPart root) {
        super(root);
        this.sticky_torch = root.getChild("soul_sticky_torch");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("soul_sticky_torch", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, 0.0F, 3.1416F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }
    @Override
    public void setAngles(SoulStickyTorchRenderState state) {
        super.setAngles(state);
    }
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        sticky_torch.render(matrices, vertexConsumer, light, overlay);
    }
}
