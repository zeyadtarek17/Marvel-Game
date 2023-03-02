package model.world;

import java.util.ArrayList;

public class Villain extends Champion {

	public Villain(String name, int maxHP, int maxMana, int actions, int speed, int attackRange, int attackDamage) {
		super(name, maxHP, maxMana, actions, speed, attackRange, attackDamage);

	}
	public String toString() {
    	return super.toString()+"Champion's Type: Villain";
    }

	public void useLeaderAbility(ArrayList<Champion> targets) {
		for (int i = 0; i < targets.size(); i++) {
			targets.get(i).setCondition(Condition.KNOCKEDOUT);
			if (targets.get(i).getCurrentHP() < (0.3 * targets.get(i).getMaxHP())) {
				targets.get(i).setCurrentHP(0);
			}
		}
	}
}
