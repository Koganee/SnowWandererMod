package net.kogane.snowwanderermod.event;

import net.kogane.snowwanderermod.SnowWandererMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.FogRenderer.FogMode;

@Mod.EventBusSubscriber(modid = SnowWandererMod.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class FogEventHandler {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        //System.out.println("Fog event triggered!");
        event.setNearPlaneDistance(0f);
        event.setFarPlaneDistance(10.0f);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onComputeFogColor(ViewportEvent.ComputeFogColor event) {
        // Set a custom fog color, for example, a grayish fog
        event.setRed(0.7f);   // Adjust the red component
        event.setGreen(0.7f); // Adjust the green component
        event.setBlue(0.7f);  // Adjust the blue component
    }
}