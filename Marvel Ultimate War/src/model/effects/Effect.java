package model.effects;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import model.world.Champion;

abstract public class Effect implements Cloneable{
	private String name;
	private EffectType type;
	private int duration;

	public Effect(String name, int duration, EffectType type) {
		this.name = name;
		this.type = type;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public EffectType getType() {
		return type;
	}
	
	abstract public void apply(Champion C) throws ChampionDisarmedException, AbilityUseException; 
	abstract public void remove(Champion C);
	
	public  Object clone() throws CloneNotSupportedException
		    {
		        return super.clone();
		    }

	@Override
	public String toString() {
		return "name=" + name + ", duration=" + duration ;
	}
}
