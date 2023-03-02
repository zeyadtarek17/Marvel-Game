package model.world;

import java.awt.Point;
import java.util.ArrayList;

import model.abilities.Ability;
import model.effects.Effect;

public abstract class Champion implements Damageable, Comparable {
	private String name;
	private int maxHP;
	private int currentHP;
	private int mana;
	private int maxActionPointsPerTurn;
	private int currentActionPoints;
	private int attackRange;
	private int attackDamage;
	private int speed;
	private ArrayList<Ability> abilities;
	private ArrayList<Effect> appliedEffects;
	private Condition condition;
	private Point location;

	public String toString() {
		return "name=" + name + "\n" + ",  maxHP=" + maxHP + "\n" + ", mana=" + mana + "\n"
				+ ", maxActionPointsPerTurn=" + maxActionPointsPerTurn + "\n" + ", attackRange=" + attackRange + "\n"
				+ ", attackDamage=" + attackDamage + "\n" + ", speed=" + speed + "\n" + ", abilities=" + abilities
				+ "\n";
	}

	public String playerdetailstoString(ArrayList<Champion> player1champions) {
		String x = "";
		for (int i = 0; i < player1champions.size(); i++) {
			Champion c = (Champion) player1champions.get(i);
			if (c instanceof Hero)
				x = x + "Champion Type: Hero" + "\n";
			if (c instanceof AntiHero)
				x = x + "Champion Type: AntiHero" + "\n";
			if (c instanceof Villain)
				x = x + "Champion Type: Villain" + "\n";
			x = x + "  name=" + c.name + "\n" + "Current HP=" + c.currentHP + "\n" + ", mana=" + c.mana + "\n"
					+ ", maxActionPointsPerTurn=" + c.maxActionPointsPerTurn + "\n" + ", attackRange=" + c.attackRange
					+ "\n" + ", attackDamage=" + c.attackDamage + "\n" + ", speed=" + c.speed + "\n";
		}
		return x;
	}

	public String playerdetailstoString() {
		String x = "";
		x = " name=" + name + "\n" + ", mana=" + mana + "\n" + ", maxActionPointsPerTurn=" + maxActionPointsPerTurn
				+ "\n" + ", attackRange=" + attackRange + "\n" + ", attackDamage=" + attackDamage + "\n" + ", speed="
				+ speed + "\n" + "Applied Effects : " + appliedEffects;
		return x;
	}

	public String toStringname() {
		return name + " ----------->>";
	}

	public String toStringoneline() {
		return "name=" + name + "mana=" + mana + ", attackRange=" + attackRange + ", attackDamage=" + attackDamage
				+ ", speed=" + speed + "Current Action Points=" + currentActionPoints + "Applied Effects : "
				+ appliedEffects + "\n" + abilities.get(0).toStringoneline(abilities);
	}

	public Champion(String name, int maxHP, int mana, int actions, int speed, int attackRange, int attackDamage) {
		this.name = name;
		this.maxHP = maxHP;
		this.mana = mana;
		this.currentHP = this.maxHP;
		this.maxActionPointsPerTurn = actions;
		this.speed = speed;
		this.attackRange = attackRange;
		this.attackDamage = attackDamage;
		this.condition = Condition.ACTIVE;
		this.abilities = new ArrayList<Ability>();
		this.appliedEffects = new ArrayList<Effect>();
		this.currentActionPoints = maxActionPointsPerTurn;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public String getName() {
		return name;
	}

	public void setCurrentHP(int hp) {

		if (hp < 0) {
			currentHP = 0;

		} else if (hp > maxHP)
			currentHP = maxHP;
		else
			currentHP = hp;

	}

	public int getCurrentHP() {

		return currentHP;
	}

	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int currentSpeed) {
		if (currentSpeed < 0)
			this.speed = 0;
		else
			this.speed = currentSpeed;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point currentLocation) {
		this.location = currentLocation;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public int getCurrentActionPoints() {
		return currentActionPoints;
	}

	public void setCurrentActionPoints(int currentActionPoints) {
		if (currentActionPoints > maxActionPointsPerTurn)
			currentActionPoints = maxActionPointsPerTurn;
		else if (currentActionPoints < 0)
			currentActionPoints = 0;
		this.currentActionPoints = currentActionPoints;
	}

	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}

	public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
	}

	public int compareTo(Object O) {
		Champion C = (Champion) O;
		if (this.speed > C.getSpeed()) {
			return -1;
		} else if (this.speed < C.getSpeed()) {
			return 1;
		} else {
			return this.name.compareTo(C.name);
		}
	}

	public abstract void useLeaderAbility(ArrayList<Champion> targets) throws CloneNotSupportedException;
}