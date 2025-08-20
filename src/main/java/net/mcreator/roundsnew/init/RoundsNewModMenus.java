package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.world.inventory.CardsselectMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RoundsNewModMenus {
   public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "rounds_new");
   public static final RegistryObject<MenuType<CardsselectMenu>> CARDSSELECT = REGISTRY.register(
      "cardsselect", () -> IForgeMenuType.create(CardsselectMenu::new)
   );
}
