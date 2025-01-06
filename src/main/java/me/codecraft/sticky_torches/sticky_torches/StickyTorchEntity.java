package me.codecraft.sticky_torches.sticky_torches;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class StickyTorchEntity extends ThrownItemEntity {
    public StickyTorchEntity(EntityType<? extends StickyTorchEntity> entityType, World world) {
        super(entityType, world);
    }

    public StickyTorchEntity(EntityType<? extends ThrownItemEntity> type, double x, double y, double z, World world, ItemStack stack) {
        super(type, x, y, z, world, stack);
    }

    public StickyTorchEntity(EntityType<? extends ThrownItemEntity> type, LivingEntity owner, World world, ItemStack stack) {
        super(type, owner, world, stack);
    }

    @Override
    protected void onBlockCollision(BlockState state) { // called on collision with a block
        super.onBlockCollision(state);


        ServerWorld serverWorld = (ServerWorld)this.getWorld(); // gets the world
        if (!this.getWorld().isClient) { // checks if the world is client
            BlockState torchState = Blocks.TORCH.getDefaultState();
            serverWorld.setBlockState(getBlockPos(), torchState);
            this.kill(serverWorld); // kills the projectile
        }

    }

    @Override
    protected Item getDefaultItem() {
        return Items.STICKY_TORCH;
    }
}
