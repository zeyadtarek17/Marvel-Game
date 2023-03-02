package model.world;

import java.util.ArrayList;
import model.effects.Stun;

public class AntiHero extends Champion {

	public String toString() {
    	return super.toString()+"Champion's Type: AntiHero";
    }

	public AntiHero(String name, int maxHP, int maxMana, int actions, int speed, int attackRange, int attackDamage) {
		super(name, maxHP, maxMana, actions, speed, attackRange, attackDamage);

	}

	public void useLeaderAbility(ArrayList<Champion> targets) {
		if (!targets.isEmpty()) {
			for (int i = 0; i < targets.size(); i++) {
				Champion c = (Champion) targets.get(i);
				if (c instanceof AntiHero) {
					Stun stun = new Stun(3);
					stun.apply(targets.get(i));
					c.getAppliedEffects().add(stun);
				}
				if (c instanceof Hero) {
					Stun stun = new Stun(5);
					stun.apply(targets.get(i));
					c.getAppliedEffects().add(stun);
				}

				if (c instanceof Villain) {
					Stun stun = new Stun(4);
					stun.apply(targets.get(i));
					c.getAppliedEffects().add(stun);
				}
			}
		}
	}
}
