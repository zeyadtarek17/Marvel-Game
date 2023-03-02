package model.effects;

import java.util.ArrayList;

import model.abilities.Ability;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.Champion;

public class PowerUp extends Effect {
	
	public PowerUp(int duration) {
		super("PowerUp", duration, EffectType.BUFF);
		
	}
	public void apply(Champion C) {
		ArrayList<Ability> abilities=C.getAbilities();
		for(int i=0;i<abilities.size();i++) {
			Ability a= abilities.get(i);
			if (a instanceof DamagingAbility) {
				int DamageAmount= (int) (((DamagingAbility) a).getDamageAmount()*1.2);
			    ((DamagingAbility) a).setDamageAmount(DamageAmount);
			}
			if (a instanceof HealingAbility) {
				int healAmount= (int) (((HealingAbility) a).getHealAmount()*1.2);
				((HealingAbility) a).setHealAmount(healAmount);

			}
			
			
		}
	}
	public void remove(Champion C) {
		ArrayList<Ability> abilities=C.getAbilities();
		for(int i=0;i<abilities.size();i++) {
			Ability a= abilities.get(i);
			if (a instanceof DamagingAbility) {
				int DamageAmount= (int) (((DamagingAbility) a).getDamageAmount()/1.2);
				((DamagingAbility) a).setDamageAmount(DamageAmount);
			}
			if (a instanceof HealingAbility) {
				int healAmount= (int) (((HealingAbility) a).getHealAmount()/1.2);
				((HealingAbility) a).setHealAmount(healAmount);
			}
			
		}
	}
}