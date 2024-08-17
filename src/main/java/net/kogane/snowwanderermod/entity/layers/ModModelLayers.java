package net.kogane.snowwanderermod.entity.layers;

import io.netty.handler.codec.compression.Snappy;
import net.kogane.snowwanderermod.SnowWandererMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation SNOW_WANDERER_LAYER = new ModelLayerLocation(
            new ResourceLocation(SnowWandererMod.MOD_ID, "snow_wanderer_layer"), "snow_wanderer_layer");

}