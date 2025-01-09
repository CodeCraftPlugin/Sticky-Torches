package me.codecraft.sticky_torches.sticky_torches.item;

import me.codecraft.sticky_torches.sticky_torches.Sticky_torches;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Items {
    public static final RegistryKey<Item> STICKY_TORCH_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Sticky_torches.MOD_ID, "sticky_torch"));
    public static final Item STICKY_TORCH = registerItem(Identifier.of(Sticky_torches.MOD_ID, "sticky_torch"), new Sticky(new Item.Settings().registryKey(STICKY_TORCH_KEY)));

    public static void init() {
        System.out.println("Loaded All Items");
    }


    private static Item registerItem(Identifier identifier, Item item) {
        return Registry.register(Registries.ITEM, identifier, item);
    }
}
