package model.effects;

import model.world.Champion;

public class Shock extends Effect {

	public Shock(int duration) {
		super("Shock", duration, EffectType.DEBUFF);
		
	}
	public void apply(Champion C) {
		int speed = (int) (C.getSpeed()*0.9);
		C.setSpeed(speed);
		int attackDamage= (int) (C.getAttackDamage()*0.9);
		C.setAttackDamage(attackDamage);
		int maxActions= C.getMaxActionPointsPerTurn()-1;
		int currentActions= C.getCurrentActionPoints()-1;
		C.setAttackDamage(attackDamage);
		C.setCurrentActionPoints(currentActions);	
		C.setMaxActionPointsPerTurn(maxActions);
	}
	 public void remove (Champion c) {
		 int speed=(int) (c.getSpeed()/0.9);
	     c.setSpeed(speed);
	     int attackdamage=(int) (c.getAttackDamage()/0.9);
	     c.setAttackDamage(attackdamage);
	     int maxaction= (c.getMaxActionPointsPerTurn()+1);
	   	 c.setMaxActionPointsPerTurn(maxaction);
	   	 int curraction=(c.getCurrentActionPoints()+1);
	     c.setCurrentActionPoints(curraction);
	     
	 }

}
