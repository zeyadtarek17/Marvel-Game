package model.effects;

import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import model.world.Champion;

public class Silence extends Effect {

	public Silence( int duration) {
		super("Silence", duration, EffectType.DEBUFF);
		
	}
	  public void apply(Champion C) throws AbilityUseException{
		int maxaction= (C.getMaxActionPointsPerTurn()+2);
    	C.setMaxActionPointsPerTurn(maxaction);
    	int curraction=(C.getCurrentActionPoints()+2);
    	C.setCurrentActionPoints(curraction);
	}
    public void remove (Champion c) {
    	int maxaction= (c.getMaxActionPointsPerTurn()-2);
    	c.setMaxActionPointsPerTurn(maxaction);
    	int curraction=(c.getCurrentActionPoints()-2);
    	c.setCurrentActionPoints(curraction);
    }

}
