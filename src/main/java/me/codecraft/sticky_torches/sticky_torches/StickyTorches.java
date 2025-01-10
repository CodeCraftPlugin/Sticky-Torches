package me.codecraft.sticky_torches.sticky_torches;

import me.codecraft.sticky_torches.sticky_torches.item.StickyTorchesItemsRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class StickyTorches implements ModInitializer {

    public static final String MOD_ID = "sticky_torches";

    @Override
    public void onInitialize() {
        System.out.println("Hello Fabric world!");
        StickyTorchesItemsRegistry.init();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(StickyTorchesItemsRegistry.STICKY_TORCH));
    }
}
