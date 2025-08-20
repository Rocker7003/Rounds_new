package net.mcreator.roundsnew.entity.model;

import net.mcreator.roundsnew.entity.BombEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class BombModel extends GeoModel<BombEntity> {

    @Override
    public ResourceLocation getAnimationResource(BombEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("rounds_new", "animations/bullet.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(BombEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("rounds_new", "geo/bullet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BombEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("rounds_new", "textures/entities/" + entity.getTexture() + ".png");
    }

    @Override
    public void setCustomAnimations(BombEntity animatable, long instanceId, AnimationState animationState) {
        CoreGeoBone head = this.getAnimationProcessor().getBone("bone");
        if (head != null) {
            int unpausedMultiplier = !Minecraft.getInstance().isPaused() ? 1 : 0;

            EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
            head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
        }
    }
}
