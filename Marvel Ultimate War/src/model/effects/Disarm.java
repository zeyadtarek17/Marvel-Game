package model.effects;

import java.util.ArrayList;

import exceptions.ChampionDisarmedException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.DamagingAbility;
import model.world.Champion;

public class Disarm extends Effect {
	

	public Disarm( int duration) {
		super("Disarm", duration, EffectType.DEBUFF);
		
	}
	public void apply(Champion C) throws ChampionDisarmedException {
		DamagingAbility Punch =new DamagingAbility ("Punch",0,1,1,AreaOfEffect.SINGLETARGET,1,50);
		C.getAbilities().add(Punch);
	}
	public void remove(Champion C) {
		ArrayList<Ability> abilities =C.getAbilities();
		for(int i=0;i<abilities.size();i++) {
			Ability a= abilities.get(i);
			if ((a instanceof DamagingAbility) && a.getName()=="Punch"){
				abilities.remove(i);
			}
		}	
	}
}