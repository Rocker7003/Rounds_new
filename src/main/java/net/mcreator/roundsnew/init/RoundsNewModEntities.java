package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.entity.BombEntity;
import net.mcreator.roundsnew.entity.BombshieldEntity;
import net.mcreator.roundsnew.entity.BulletEntity;
import net.mcreator.roundsnew.entity.RinghealEntity;
import net.mcreator.roundsnew.entity.RingtoxicEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
        bus = Bus.MOD
)
public class RoundsNewModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "rounds_new");

    public static final RegistryObject<EntityType<BulletEntity>> BULLET = register(
            "bullet",
            // Corrected with a lambda expression
            Builder.of((EntityType.EntityFactory<BulletEntity>) BulletEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(BulletEntity::new)
                    .sized(0.1F, 0.1F)
    );
    public static final RegistryObject<EntityType<BombEntity>> BOMB = register(
            "bomb",
            // Corrected with a lambda expression
            Builder.of((EntityType.EntityFactory<BombEntity>) BombEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(BombEntity::new)
                    .sized(0.1F, 0.1F)
    );
    public static final RegistryObject<EntityType<RinghealEntity>> RINGHEAL = register(
            "ringheal",
            // Corrected with a lambda expression
            Builder.of((EntityType.EntityFactory<RinghealEntity>) RinghealEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(RinghealEntity::new)
                    .sized(0.1F, 0.1F)
    );
    public static final RegistryObject<EntityType<BombshieldEntity>> BOMBSHIELD = register(
            "bombshield",
            // Corrected with a lambda expression
            Builder.of((EntityType.EntityFactory<BombshieldEntity>) BombshieldEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(BombshieldEntity::new)
                    .sized(0.1F, 0.1F)
    );
    public static final RegistryObject<EntityType<RingtoxicEntity>> RINGTOXIC = register(
            "ringtoxic",
            // Corrected with a lambda expression
            Builder.of((EntityType.EntityFactory<RingtoxicEntity>) RingtoxicEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(RingtoxicEntity::new)
                    .sized(0.1F, 0.1F)
    );

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BulletEntity.init();
            BombEntity.init();
            RinghealEntity.init();
            BombshieldEntity.init();
            RingtoxicEntity.init();
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(BULLET.get(), BulletEntity.createAttributes().build());
        event.put(BOMB.get(), BombEntity.createAttributes().build());
        event.put(RINGHEAL.get(), RinghealEntity.createAttributes().build());
        event.put(BOMBSHIELD.get(), BombshieldEntity.createAttributes().build());
        event.put(RINGTOXIC.get(), RingtoxicEntity.createAttributes().build());
    }
}