package me.codecraft.sticky_torches.sticky_torches;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Entities {

    public static final RegistryKey<EntityType<?>> STICKY_TORCH_ENTITY_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Sticky_torches.MOD_ID, "sticky_torch"));

    public static final EntityType<StickyTorchEntity> STICKY_TORCH_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Sticky_torches.MOD_ID, "sticky_torch"), EntityType.Builder.<StickyTorchEntity>create(StickyTorchEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build(STICKY_TORCH_ENTITY_KEY));

}
