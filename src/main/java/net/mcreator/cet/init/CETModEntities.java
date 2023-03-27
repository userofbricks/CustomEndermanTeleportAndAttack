
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.cet.entity.CustomTeleportingEntity;
import net.mcreator.cet.entity.CustomEndermanEntity;
import net.mcreator.cet.CETMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CETModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CETMod.MODID);
	public static final RegistryObject<EntityType<CustomEndermanEntity>> CUSTOM_ENDERMAN = register("custom_enderman",
			EntityType.Builder.<CustomEndermanEntity>of(CustomEndermanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEndermanEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CustomTeleportingEntity>> CUSTOM_TELEPORTING = register("custom_teleporting",
			EntityType.Builder.<CustomTeleportingEntity>of(CustomTeleportingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomTeleportingEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			CustomEndermanEntity.init();
			CustomTeleportingEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(CUSTOM_ENDERMAN.get(), CustomEndermanEntity.createAttributes().build());
		event.put(CUSTOM_TELEPORTING.get(), CustomTeleportingEntity.createAttributes().build());
	}
}
