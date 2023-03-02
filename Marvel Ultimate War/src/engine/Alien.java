package engine;

import java.util.ArrayList;
import model.abilities.Ability;
import model.effects.Effect;
import model.world.Condition;

public class Alien {
	private String name;
	private int maxHP;
	private int currentHP=maxHP;
	private int attackDamage;
	private ArrayList<Ability> foundAbilities=new ArrayList<Ability>();
	private ArrayList<Effect> appliedEffects=new ArrayList<Effect>();
	private Condition condition= Condition.ACTIVE;
	public Alien (String name, int maxHP, int attackDamage) {
		this.name=name;
		this.maxHP=maxHP;
		this.attackDamage=attackDamage;
		this.currentHP=maxHP;
		foundAbilities= new ArrayList<Ability>();
		appliedEffects= new ArrayList<Effect>();
		condition=condition.ACTIVE;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public String getName() {
		return name;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public int getAttackDamage() {
		return attackDamage;
	}
	public ArrayList<Ability> getFoundAbilities() {
		return foundAbilities;
	}
	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}
	
}
