package net.mcreator.roundsnew.item.model;

import net.mcreator.roundsnew.item.GunItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GunItemModel extends GeoModel<GunItem> {
   public ResourceLocation getAnimationResource(GunItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("rounds_new", "animations/pistol_s1.animation.json");
   }

   public ResourceLocation getModelResource(GunItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("rounds_new", "geo/pistol_s1.geo.json");
   }

   public ResourceLocation getTextureResource(GunItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("rounds_new", "textures/item/piton.png");
   }
}
