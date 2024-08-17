package net.kogane.snowwanderermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kogane.snowwanderermod.SnowWandererMod;
import net.kogane.snowwanderermod.entity.custom.SnowWandererEntity;
import net.kogane.snowwanderermod.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SnowWandererRenderer extends MobRenderer<SnowWandererEntity, SnowWandererModel<SnowWandererEntity>> {
    private static final ResourceLocation SNOW_WANDERER_LOCATION = new ResourceLocation(SnowWandererMod.MOD_ID,"textures/entity/snow_wanderer.png");

    public SnowWandererRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SnowWandererModel<>(pContext.bakeLayer(ModModelLayers.SNOW_WANDERER_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(SnowWandererEntity pEntity) {
        return SNOW_WANDERER_LOCATION;
    }

    @Override
    public void render(SnowWandererEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}