package model.effects;

import java.text.BreakIterator;

import model.world.Champion;
import model.world.Condition;

public class Root extends Effect {

	public Root( int duration) {
		super("Root", duration, EffectType.DEBUFF);
		
	}

	public void apply(Champion C) {
		if(C.getCondition()!=Condition.INACTIVE) {
			C.setCondition(Condition.ROOTED);
		}
		else {
		C.setCondition(Condition.INACTIVE);
		}
	}
	public void remove(Champion C) {
		boolean flagRooted=false;
		Effect e;
		for(int i=0;i<C.getAppliedEffects().size();i++) {
			e=C.getAppliedEffects().get(i);
			if(e.getName()=="Root") {
				flagRooted=true;
			}
		}
		if(flagRooted==true) {
			C.setCondition(Condition.ROOTED);
		}
		else if(C.getCondition()!=Condition.INACTIVE) {
			C.setCondition(Condition.ACTIVE);
		}
		else {
		C.setCondition(Condition.INACTIVE);
		}
	}

}