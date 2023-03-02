package model.world;

import java.util.ArrayList;

import model.effects.Disarm;
import model.effects.Effect;
import model.effects.Embrace;
import model.effects.Root;
import model.effects.Shock;
import model.effects.Silence;
import model.effects.Stun;

public class Hero extends Champion {

	public Hero(String name, int maxHP, int maxMana, int actions, int speed, int attackRange, int attackDamage) {
		super(name, maxHP, maxMana, actions, speed, attackRange, attackDamage);

	}

	public void useLeaderAbility(ArrayList<Champion> targets) throws CloneNotSupportedException {
		for (int i = 0; i < targets.size(); i++) {
			Champion c = targets.get(i);
			Embrace embrace = new Embrace(2);
			c.getAppliedEffects().add(embrace);
			embrace.apply(c);
			for (int k = 0; k < c.getAppliedEffects().size(); k++) {
				Effect e;
				switch (c.getAppliedEffects().get(k).getName()) {
				case "Root":
					e = (Effect) c.getAppliedEffects().get(k).clone();
					e.remove(c);
					c.getAppliedEffects().remove(k);
					k--;
					break;
				case "Shock":
					e = (Effect) c.getAppliedEffects().get(k).clone();
					e.remove(c);
					c.getAppliedEffects().remove(k);
					k--;
					break;
				case "Stun":
					e = (Effect) c.getAppliedEffects().get(k).clone();
					e.remove(c);
					c.getAppliedEffects().remove(k);
					k--;
					break;
				case "Silence":
					e = (Effect) c.getAppliedEffects().get(k).clone();
					e.remove(c);
					c.getAppliedEffects().remove(k);
					k--;
					break;
				case "Disarm":
					e = (Effect) c.getAppliedEffects().get(k).clone();
					e.remove(c);
					c.getAppliedEffects().remove(k);
					k--;
					break;
				}
			}
		}
	}
        public String toString() {
        	return super.toString()+"Champion's Type:Hero";
        }
}
