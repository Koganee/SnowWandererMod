package net.kogane.snowwanderermod.event;

import net.kogane.snowwanderermod.SnowWandererMod;
import net.kogane.snowwanderermod.entity.ModEntities;
import net.kogane.snowwanderermod.entity.custom.SnowWandererEntity;
import net.kogane.snowwanderermod.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.Random;

@Mod.EventBusSubscriber(modid = SnowWandererMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    private static final Random random = new Random();
    private static final int SOUND_DURATION = 1500;
    private static int soundCooldown = 0;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Level world = player.getCommandSenderWorld();

        if (soundCooldown > 0) {
            soundCooldown--;
            return; // Exit the method to prevent another sound until cooldown is over
        }

        int randomNumber = random.nextInt(100) + 1;
        if(randomNumber == 50) {
            world.playSeededSound(null, player.getX() - 10, player.getY() - 10, player.getZ(), ModSounds.BREATHING_SOUND.get(), SoundSource.BLOCKS, 1.0F, 1.0F, 0);
            soundCooldown = SOUND_DURATION;
        }
    }


    @SubscribeEvent
    public static void onSleepEvent(PlayerSleepInBedEvent event)
    {
        System.out.println("Sleeping");
        LivingEntity entity = event.getEntity();
        Player player = (Player) entity;

        Level world = player.getCommandSenderWorld();

        //world.playSeededSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.BREATHING_SOUND.get(), SoundSource.BLOCKS, 100.0F, 1.0F, 0);
    }

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SNOW_WANDERER.get(), SnowWandererEntity.createAttributes().build());
    }
}
