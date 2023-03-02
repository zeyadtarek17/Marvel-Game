package model.abilities;

import java.util.ArrayList;

import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import model.effects.Effect;
import model.world.Damageable;
import model.world.Champion;

public class CrowdControlAbility extends Ability {
	private Effect effect;

	public CrowdControlAbility(String name, int cost, int baseCoolDown, int castRadius, AreaOfEffect area, int required,
			Effect effect) {
		super(name, cost, baseCoolDown, castRadius, area, required);
		this.effect = effect;

	}

	@Override
	public String toString() {
		return super.toString()+"CrowdControlAbility " + effect + "\n";
	}

	public Effect getEffect() {
		return effect;
	}

	public void execute(ArrayList<Damageable> targets)
			throws CloneNotSupportedException, ChampionDisarmedException, AbilityUseException {
		Effect e;
		Damageable a;
		for (int i = 0; i < targets.size(); i++) {
			a = targets.get(i);
			if (a instanceof Champion) {
				Champion x = (Champion) a;
				e = (Effect) this.effect.clone();
				x.getAppliedEffects().add(e);
				e.apply(x);
			}
		}
	}

	@Override
	public String getType() {
		return "CrowdControlAbility";
	}
}
