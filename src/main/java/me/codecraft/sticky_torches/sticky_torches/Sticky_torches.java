package me.codecraft.sticky_torches.sticky_torches;

import me.codecraft.sticky_torches.sticky_torches.item.Items;
import net.fabricmc.api.ModInitializer;

public class Sticky_torches implements ModInitializer {

    public static final String MOD_ID = "sticky_torches";

    @Override
    public void onInitialize() {
        System.out.println("Hello Fabric world!");
        Items.init();
    }
}
