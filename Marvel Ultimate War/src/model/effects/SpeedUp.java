package model.effects;
import model.world.Champion;
public class SpeedUp extends Effect{

	public SpeedUp(int duration) {
		super("SpeedUp",duration,EffectType.BUFF);
	}
    public void apply (Champion c) {
    	int speed=(int) (c.getSpeed()*1.15);
    	c.setSpeed(speed);
    	int curraction=(c.getCurrentActionPoints()+1);
    	c.setCurrentActionPoints(curraction);
    	int maxaction= (c.getMaxActionPointsPerTurn()+1);
    	c.setMaxActionPointsPerTurn(maxaction);
    	
    }
    public void remove (Champion c) {
    	int speed=(int) (c.getSpeed()/1.15);
    	c.setSpeed(speed);
    	int curraction=(c.getCurrentActionPoints()-1);
    	c.setCurrentActionPoints(curraction);
    	int maxaction= (c.getMaxActionPointsPerTurn()-1);
    	c.setMaxActionPointsPerTurn(maxaction);
    	
    }
}
