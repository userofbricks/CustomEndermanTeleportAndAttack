
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cet.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.cet.client.renderer.CustomTeleportingRenderer;
import net.mcreator.cet.client.renderer.CustomEndermanRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CETModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CETModEntities.CUSTOM_ENDERMAN.get(), CustomEndermanRenderer::new);
		event.registerEntityRenderer(CETModEntities.CUSTOM_TELEPORTING.get(), CustomTeleportingRenderer::new);
	}
}
