package me.codecraft.sticky_torches.sticky_torches.client.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.state.EntityRenderState;
import org.jetbrains.annotations.Nullable;


@Environment(EnvType.CLIENT)
public class StickyTorchRenderState extends EntityRenderState {

    @Nullable
    public BlockState blockState;

    public StickyTorchRenderState() {
    }
}
