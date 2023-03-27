package net.mcreator.cet.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class CustomTeleportingOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xdist = 0;
		double ydist = 0;
		double zdist = 0;
		double totdist = 0;
		if (world.dayTime() % 100 == Mth.nextInt(RandomSource.create(), 1, 3) || !world.getEntitiesOfClass(Arrow.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
			TeleportRandomly2Procedure.execute(world, x, y, z, entity);
		}
	}
}
