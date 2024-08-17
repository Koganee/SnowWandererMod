package net.kogane.snowwanderermod.item;

import net.kogane.snowwanderermod.SnowWandererMod;
import net.kogane.snowwanderermod.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SnowWandererMod.MOD_ID);

    public static final RegistryObject<Item> SNOW_WANDERER_SPAWN_EGG = ITEMS.register("snow_wanderer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SNOW_WANDERER, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
