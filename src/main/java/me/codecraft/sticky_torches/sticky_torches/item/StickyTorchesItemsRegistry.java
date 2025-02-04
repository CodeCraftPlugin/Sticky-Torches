package me.codecraft.sticky_torches.sticky_torches.item;

import me.codecraft.sticky_torches.sticky_torches.StickyTorches;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class StickyTorchesItemsRegistry {
    static final Identifier STICKY_TORCH_ID = Identifier.of(StickyTorches.MOD_ID, "sticky_torch");
    static final Identifier SOUL_STICKY_TORCH_ID = Identifier.of(StickyTorches.MOD_ID, "soul_sticky_torch");
    public static final RegistryKey<Item> STICKY_TORCH_KEY=RegistryKey.of(RegistryKeys.ITEM, STICKY_TORCH_ID);
    public static final RegistryKey<Item> SOUL_STICKY_TORCH_KEY=RegistryKey.of(RegistryKeys.ITEM, SOUL_STICKY_TORCH_ID);


    public static final Item STICKY_TORCH = registerItem(STICKY_TORCH_ID, new Sticky(new Item.Settings().registryKey(STICKY_TORCH_KEY)));
    public static final Item SOUL_STICKY_TORCH = registerItem(SOUL_STICKY_TORCH_ID, new Sticky(new Item.Settings().registryKey(SOUL_STICKY_TORCH_KEY)));

    public static void init() {
        System.out.println("Loaded All Items");
    }


    private static Item registerItem(Identifier identifier, Item item) {
        return Registry.register(Registries.ITEM, identifier, item);
    }
}
