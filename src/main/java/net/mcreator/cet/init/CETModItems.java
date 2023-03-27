
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.cet.item.TestTeleportItem;
import net.mcreator.cet.CETMod;

public class CETModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CETMod.MODID);
	public static final RegistryObject<Item> CUSTOM_ENDERMAN_SPAWN_EGG = REGISTRY.register("custom_enderman_spawn_egg",
			() -> new ForgeSpawnEggItem(CETModEntities.CUSTOM_ENDERMAN, -6750208, -6750208, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> CUSTOM_TELEPORTING_SPAWN_EGG = REGISTRY.register("custom_teleporting_spawn_egg",
			() -> new ForgeSpawnEggItem(CETModEntities.CUSTOM_TELEPORTING, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> TEST_TELEPORT = REGISTRY.register("test_teleport", () -> new TestTeleportItem());
}
