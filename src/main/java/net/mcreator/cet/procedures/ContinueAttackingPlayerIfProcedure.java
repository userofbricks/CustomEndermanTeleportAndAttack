package net.mcreator.cet.procedures;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class ContinueAttackingPlayerIfProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("enderman_can_attack", (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) == 1) {
			return true;
		}
		return false;
	}
}
