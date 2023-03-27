package net.mcreator.cet.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;

public class AttackPlayerIfProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		double totdist = 0;
		double xdist = 0;
		double zdist = 0;
		double ydist = 0;
		boolean enable = false;
		enable = false;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			xdist = Math.abs(Math.abs(entity.getX()) - Math.abs(entityiterator.getX()));
			ydist = Math.abs(Math.abs(entity.getY()) - Math.abs(entityiterator.getY()));
			zdist = Math.abs(Math.abs(entity.getZ()) - Math.abs(entityiterator.getZ()));
			totdist = Math.hypot(xdist, Math.hypot(ydist, zdist));
			if (totdist > 256) {
				continue;
			} else {
				if (entityiterator.level
						.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(totdist)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entityiterator))
						.getBlockPos().getX() == Math.round(entity.getX())
						&& entityiterator.level.clip(
								new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(totdist)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entityiterator))
								.getBlockPos().getY() == Math.round(entity.getY() + entity.getBbHeight())
						&& entityiterator.level.clip(
								new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(totdist)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entityiterator))
								.getBlockPos().getZ() == Math.round(entity.getZ())) {
					{
						Entity _ent = entityiterator;
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective("enderman_can_attack");
						if (_so == null)
							_so = _sc.addObjective("enderman_can_attack", ObjectiveCriteria.DUMMY, Component.literal("enderman_can_attack"), ObjectiveCriteria.RenderType.INTEGER);
						_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
					}
					enable = true;
				}
			}
		}
		return enable;
	}
}
