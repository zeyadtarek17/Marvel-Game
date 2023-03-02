package model.abilities;

import java.util.ArrayList;

import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import model.world.Damageable;

public abstract class Ability implements Cloneable {
	private String name;
	private int manaCost;
	private int baseCooldown;
	private int currentCooldown;
	private int castRange;
	private AreaOfEffect castArea;
	private int requiredActionPoints;

	public Ability(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required) {
		this.name = name;
		this.manaCost = cost;
		this.baseCooldown = baseCoolDown;
		this.currentCooldown = 0;
		this.castRange = castRange;
		this.castArea = area;
		this.requiredActionPoints = required;
	}

	public int getCurrentCooldown() {
		return currentCooldown;
	}

	public void setCurrentCooldown(int currentCoolDown) {
		if (currentCoolDown < 0)
			currentCoolDown = 0;
		else if (currentCoolDown > baseCooldown)
			currentCoolDown = baseCooldown;
		this.currentCooldown = currentCoolDown;
	}

	public String getName() {
		return name;
	}

	public int getManaCost() {
		return manaCost;
	}

	public int getBaseCooldown() {
		return baseCooldown;
	}

	public int getCastRange() {
		return castRange;
	}

	public AreaOfEffect getCastArea() {
		return castArea;
	}

	public int getRequiredActionPoints() {
		return requiredActionPoints;
	}

	public abstract void execute(ArrayList<Damageable> targets)
			throws CloneNotSupportedException, ChampionDisarmedException, AbilityUseException;

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "name=" + name + "\n" + ", manaCost=" + manaCost + "\n" + ", baseCooldown=" + baseCooldown + "\n"
				+ ", currentCooldown=" + currentCooldown + "\n" + ", castRange=" + castRange + "\n" + ", castArea="
				+ castArea + "\n" + ", requiredActionPoints=" + requiredActionPoints + "\n";
	}

	public String toStringoneline(ArrayList<Ability> abilities) {
		String r = "";
		for (int i = 0; i < abilities.size(); i++) {
			Ability a = abilities.get(i);
			if(a instanceof DamagingAbility)
				r=r+"Ability Type : Damaging";
			if(a instanceof HealingAbility)
				r=r+"Ability Type : Healing";
			if(a instanceof CrowdControlAbility)
				r=r+"Ability Type : Crowd Control";
			r=r+ " name=" + a.name + ", manaCost=" + a.manaCost + ", baseCooldown=" + a.baseCooldown + ", currentCooldown="
					+ a.currentCooldown + ", castRange=" + a.castRange + ", castArea=" + a.castArea
					+ ", requiredActionPoints=" + a.requiredActionPoints+ "\n" ;
		}
		return r;
	}
	public abstract String getType() ;
		
}
