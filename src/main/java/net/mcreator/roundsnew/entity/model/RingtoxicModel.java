package net.mcreator.roundsnew.entity.model;

import net.mcreator.roundsnew.entity.RingtoxicEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

/**
 * Geckolib model class for the Ringtoxic entity.
 * Updated for Minecraft 1.20.6+ using safe ResourceLocation parsing.
 */
public class RingtoxicModel extends GeoModel<RingtoxicEntity> {

    @Override
    public ResourceLocation getAnimationResource(RingtoxicEntity entity) {
        return ResourceLocation.parse("rounds_new:animations/bullet.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(RingtoxicEntity entity) {
        return ResourceLocation.parse("rounds_new:geo/bullet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RingtoxicEntity entity) {
        String textureName = entity.getTexture();
        if (textureName == null || textureName.isEmpty()) {
            textureName = "default"; // fallback texture name if missing
        }
        return ResourceLocation.parse("rounds_new:textures/entities/" + textureName + ".png");
    }

    @Override
    public void setCustomAnimations(RingtoxicEntity animatable, long instanceId, AnimationState animationState) {
        CoreGeoBone head = this.getAnimationProcessor().getBone("bone");

        if (head != null) {
            int unpausedMultiplier = !Minecraft.getInstance().isPaused() ? 1 : 0;
            EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            // Apply head pitch & yaw in radians, respecting game pause state
            head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
            head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
        }
    }
}