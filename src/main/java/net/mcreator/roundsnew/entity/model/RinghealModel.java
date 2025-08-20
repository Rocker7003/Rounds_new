package net.mcreator.roundsnew.entity.model;

import net.mcreator.roundsnew.entity.RinghealEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

/**
 * Geckolib model class for the Ringheal entity.
 * Updated for Minecraft 1.20.6+ with safe and modern ResourceLocation handling.
 */
public class RinghealModel extends GeoModel<RinghealEntity> {

    @Override
    public ResourceLocation getAnimationResource(RinghealEntity entity) {
        return ResourceLocation.parse("rounds_new:animations/bullet.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(RinghealEntity entity) {
        return ResourceLocation.parse("rounds_new:geo/bullet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RinghealEntity entity) {
        // Prevent null/empty texture names from causing a crash
        String textureName = entity.getTexture();
        if (textureName == null || textureName.isEmpty()) {
            textureName = "default"; // choose a safe fallback texture
        }
        return ResourceLocation.parse("rounds_new:textures/entities/" + textureName + ".png");
    }

    @Override
    public void setCustomAnimations(RinghealEntity animatable, long instanceId, AnimationState animationState) {
        CoreGeoBone head = this.getAnimationProcessor().getBone("bone");

        if (head != null) {
            int unpausedMultiplier = !Minecraft.getInstance().isPaused() ? 1 : 0;
            EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            // Apply head pitch & yaw in radians, only when game is unpaused
            head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
            head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
        }
    }
}