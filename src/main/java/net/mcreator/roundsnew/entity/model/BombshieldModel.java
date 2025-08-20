package net.mcreator.roundsnew.entity.model;

import net.mcreator.roundsnew.entity.BombshieldEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

/**
 * Model class for Bombshield entity in the "rounds_new" namespace.
 * Uses future-safe ResourceLocation handling (post-1.20.6).
 */
public class BombshieldModel extends GeoModel<BombshieldEntity> {

    @Override
    public ResourceLocation getAnimationResource(BombshieldEntity entity) {
        return ResourceLocation.parse("rounds_new:animations/bullet.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(BombshieldEntity entity) {
        return ResourceLocation.parse("rounds_new:geo/bullet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BombshieldEntity entity) {
        // Safe fallback to prevent null/invalid texture names from crashing
        String textureName = entity.getTexture();
        if (textureName == null || textureName.isEmpty()) {
            textureName = "default";
        }
        return ResourceLocation.parse("rounds_new:textures/entities/" + textureName + ".png");
    }

    @Override
    public void setCustomAnimations(BombshieldEntity animatable, long instanceId, AnimationState animationState) {
        CoreGeoBone head = this.getAnimationProcessor().getBone("bone");

        if (head != null) {
            int unpausedMultiplier = !Minecraft.getInstance().isPaused() ? 1 : 0;
            EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            // Degrees → radians conversion
            head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
            head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
        }
    }
}