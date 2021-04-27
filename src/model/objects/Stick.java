package model.objects;

import model.characters.*;
import model.others.*;

public class Stick extends Obj {

	
	// ***** CONSTRUCTOR *****
	
	public Stick(String name, String info) {
		super(name, info, Script.ORTHER_ITEM_SIMPLE_USE);
	}


	// ***** METHODS *****


	// === COMMANDS ===
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.STICK_DESCRIPT, Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h) {
		Game.printLetterByLetter(this.SIMPLE_USE, Script.DEFAULT_NARRATOR);
	}

	@Override
	public void use(Hero h,String s) {
		if(s != null) {
			s = s.toLowerCase();
			if (s.equals(Script.DEFAULT_FLINT_NAME)) {
				if (h.getObjs().containsKey(s)) {
					h.getObjs().remove(s);
					h.getObjs().remove(this.NAME);
					FiredStick firedStick = Game.FIRED_STICK;
					h.getObjs().put(firedStick.NAME, firedStick);
					Game.printLetterByLetter("With your knowledge of caveman, you managed to create fire with your flint and your stick, a fired stick.\n", Script.DEFAULT_NARRATOR);
				}
			} else {
				Game.printLetterByLetter("You cannot combine those model.objects together\n", Script.DEFAULT_NARRATOR);
			}
		}
	}
	
}

