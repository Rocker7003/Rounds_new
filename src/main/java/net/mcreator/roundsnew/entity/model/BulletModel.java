package net.mcreator.roundsnew.entity.model;

import net.mcreator.roundsnew.entity.BulletEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

/**
 * Model class for the Bullet entity in the "rounds_new" namespace.
 * Updated for post-1.20.6 with safe, modern ResourceLocation usage.
 */
public class BulletModel extends GeoModel<BulletEntity> {

    @Override
    public ResourceLocation getAnimationResource(BulletEntity entity) {
        return ResourceLocation.parse("rounds_new:animations/bullet.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(BulletEntity entity) {
        return ResourceLocation.parse("rounds_new:geo/bullet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BulletEntity entity) {
        // Ensure we don't crash if the entity has an invalid or missing texture name
        String textureName = entity.getTexture();
        if (textureName == null || textureName.isEmpty()) {
            textureName = "default"; // fallback texture name
        }
        return ResourceLocation.parse("rounds_new:textures/entities/" + textureName + ".png");
    }

    @Override
    public void setCustomAnimations(BulletEntity animatable, long instanceId, AnimationState animationState) {
        CoreGeoBone head = this.getAnimationProcessor().getBone("bone");

        if (head != null) {
            int unpausedMultiplier = !Minecraft.getInstance().isPaused() ? 1 : 0;
            EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            // Degrees → Radians, applied only if unpaused
            head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
            head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
        }
    }
}