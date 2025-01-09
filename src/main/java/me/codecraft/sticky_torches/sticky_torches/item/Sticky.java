package me.codecraft.sticky_torches.sticky_torches.item;

import me.codecraft.sticky_torches.sticky_torches.entity.StickyTorchEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Sticky extends Item  {
    public Sticky(Item.Settings settings) {
        super(settings.useCooldown(1));
    }
    public static float POWER = 1.5F;

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            StickyTorchEntity stickyTorchEntity = new StickyTorchEntity(user,world,itemStack,null);
            stickyTorchEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, POWER, 0f);
            world.spawnEntity(stickyTorchEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        itemStack.decrementUnlessCreative(1, user);
        return ActionResult.SUCCESS;
    }

}
