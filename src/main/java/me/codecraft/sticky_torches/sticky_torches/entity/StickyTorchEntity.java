package me.codecraft.sticky_torches.sticky_torches.entity;

import me.codecraft.sticky_torches.sticky_torches.Entities;
import me.codecraft.sticky_torches.sticky_torches.item.Items;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class StickyTorchEntity extends PersistentProjectileEntity {
    public StickyTorchEntity(EntityType<? extends StickyTorchEntity> entityType, World world) {
        super(entityType, world);
    }


//    public StickyTorchEntity(double x, double y, double z, World world, ItemStack stack) {
//        super(Entities.STICKY_TORCH_ENTITY, x, y, z, world, stack);
//    }
//    public StickyTorchEntity(World world, LivingEntity owner, ItemStack stack) {
//        super(Entities.STICKY_TORCH_ENTITY, owner, world, stack);
//    }

    public StickyTorchEntity(LivingEntity owner, World world, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(Entities.STICKY_TORCH_ENTITY, owner, world, stack, shotFrom);
    }

    public StickyTorchEntity(double x, double y, double z, World world, ItemStack stack, @Nullable ItemStack weapon) {
        super(Entities.STICKY_TORCH_ENTITY, x, y, z, world, stack, weapon);
    }

    protected void onBlockCollision(BlockState state) {
        super.onBlockCollision(state);
        if (!this.getWorld().isClient) { // Ensure this runs only on the server
            ServerWorld serverWorld = (ServerWorld) this.getWorld();
            BlockPos hitPos = this.getBlockPos();
            Direction hitDirection = this.getHorizontalFacing();// for some unknown reason this minecraft gets east and west wrong but places the torch in the right way
            BlockState torchState;
            // Check if the block below the collided block is air
            if (serverWorld.getBlockState(hitPos.down()).isAir()) {
                this.kill(serverWorld); // Kill the entity without placing a torch
                return; // Exit early
            }if (state.isSideSolidFullSquare(this.getWorld(), hitPos, hitDirection)){
                if ((hitDirection==Direction.NORTH||hitDirection==Direction.SOUTH)){
                    torchState = Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, hitDirection.getOpposite());
                    serverWorld.setBlockState(hitPos, torchState);
                    this.kill(serverWorld);
                }// Check if the block hit is a solid full square on the given side
                if ((hitDirection==Direction.EAST||hitDirection==Direction.WEST)) {
                    torchState = Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, hitDirection);
                    serverWorld.setBlockState(hitPos, torchState);
                    this.kill(serverWorld); // Kill the entity without placing a torch
                }
            }
             else {
                // Place a regular torch above the hit block
                BlockPos abovePos = hitPos.up();
                torchState = Blocks.TORCH.getDefaultState();
                serverWorld.setBlockState(abovePos, torchState);
            }

            this.kill(serverWorld); // Remove the projectile
        }
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return Items.STICKY_TORCH.getDefaultStack();
    }
}
