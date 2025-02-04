package me.codecraft.sticky_torches.sticky_torches.client.entity.soul_sticky_torch;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.state.EntityRenderState;
import org.jetbrains.annotations.Nullable;


@Environment(EnvType.CLIENT)
public class SoulStickyTorchRenderState extends EntityRenderState {

    @Nullable
    public BlockState blockState;

    public SoulStickyTorchRenderState() {
    }
}
