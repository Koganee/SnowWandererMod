package net.kogane.snowwanderermod.event;

import net.kogane.snowwanderermod.SnowWandererMod;
import net.kogane.snowwanderermod.entity.ModEntities;
import net.kogane.snowwanderermod.entity.client.SnowWandererModel;
import net.kogane.snowwanderermod.entity.custom.SnowWandererEntity;
import net.kogane.snowwanderermod.entity.layers.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SnowWandererMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SNOW_WANDERER_LAYER, SnowWandererModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SNOW_WANDERER.get(), SnowWandererEntity.createAttributes().build());
    }

}
