
package net.mcreator.cet.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.cet.entity.CustomTeleportingEntity;

public class CustomTeleportingRenderer extends HumanoidMobRenderer<CustomTeleportingEntity, HumanoidModel<CustomTeleportingEntity>> {
	public CustomTeleportingRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
		this.addLayer(new EyesLayer<CustomTeleportingEntity, HumanoidModel<CustomTeleportingEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("c_e_t:textures/entities/enderman_tutorial_skin.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(CustomTeleportingEntity entity) {
		return new ResourceLocation("c_e_t:textures/entities/enderman_tutorial_skin.png");
	}
}
