package model.effects;

import model.world.Champion;

public class Embrace extends Effect {
	

	public Embrace(int duration) {
		super("Embrace", duration, EffectType.BUFF);
	}
	public void apply(Champion C) {
		int MaxHP= C.getMaxHP();
		MaxHP=(int) (MaxHP*0.2);
		C.setCurrentHP(MaxHP+C.getCurrentHP());
		int Mana=(int) (C.getMana()*1.2);
		C.setMana(Mana);
		int AttackDamage=(int) (C.getAttackDamage()*1.2);
		int Speed=(int) (C.getSpeed()*1.2);
		C.setAttackDamage(AttackDamage);
		C.setSpeed(Speed);
	}
	public void remove(Champion C) {
		int AttackDamage=(int) (C.getAttackDamage()/1.2);
		int Speed=(int) (C.getSpeed()/1.2);
		C.setAttackDamage(AttackDamage);
		C.setSpeed(Speed);
	}
 

}
