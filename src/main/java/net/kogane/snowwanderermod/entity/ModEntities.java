package net.kogane.snowwanderermod.entity;

import net.kogane.snowwanderermod.SnowWandererMod;
import net.kogane.snowwanderermod.entity.custom.SnowWandererEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SnowWandererMod.MOD_ID);

    public static final RegistryObject<EntityType<SnowWandererEntity>> SNOW_WANDERER =
            ENTITY_TYPES.register("snow_wanderer", () -> EntityType.Builder.of(SnowWandererEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.95F) .build("snow_wanderer"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
