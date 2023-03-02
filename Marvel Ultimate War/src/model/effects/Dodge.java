package model.effects;

import model.world.Champion;

public class Dodge extends Effect {

	public Dodge(int duration) {
		super("Dodge", duration, EffectType.BUFF);
		
	}
	public void apply(Champion C) {
		int speed=C.getSpeed();
		speed= (int) (speed*1.05);
		C.setSpeed(speed);
	}
	public void remove(Champion C) {
		int speed=C.getSpeed();
		speed= (int) (speed/1.05);
		C.setSpeed(speed);
	}
}
