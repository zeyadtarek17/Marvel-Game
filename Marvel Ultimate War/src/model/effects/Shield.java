package model.effects;

import model.world.Champion;

public class Shield extends Effect {

	public Shield( int duration) {
		super("Shield", duration, EffectType.BUFF);
		
	}

	public void apply(Champion C) {
		int speed=(int) (C.getSpeed()*1.02);
		C.setSpeed(speed);
		
	}

	public void remove(Champion C) {
		int speed=(int) (C.getSpeed()/1.02);
		C.setSpeed(speed);
	}

}
