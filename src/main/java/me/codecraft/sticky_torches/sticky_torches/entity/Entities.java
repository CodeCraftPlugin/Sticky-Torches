package me.codecraft.sticky_torches.sticky_torches.entity;

import me.codecraft.sticky_torches.sticky_torches.StickyTorches;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Entities {

    public static final RegistryKey<EntityType<?>> STICKY_TORCH_ENTITY_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(StickyTorches.MOD_ID, "sticky_torch1"));
    public static final RegistryKey<EntityType<?>> SOUL_STICKY_TORCH_ENTITY_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(StickyTorches.MOD_ID, "soul_sticky_torch"));

    public static final EntityType<StickyTorchEntity> STICKY_TORCH_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(StickyTorches.MOD_ID, "sticky_torch"), EntityType.Builder.<StickyTorchEntity>create(StickyTorchEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build(STICKY_TORCH_ENTITY_KEY));


    public static final EntityType<SoulStickyTorchEntity> SOUL_STICKY_TORCH_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(StickyTorches.MOD_ID, "soul_sticky_torch"), EntityType.Builder.<SoulStickyTorchEntity>create(SoulStickyTorchEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build(SOUL_STICKY_TORCH_ENTITY_KEY));

}
