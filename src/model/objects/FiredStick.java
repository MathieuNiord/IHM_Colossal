package model.objects;

import model.characters.*;
import model.others.Game;
import model.others.Script;

public class FiredStick extends Obj {


	// ***** CONSTRUCTOR *****

	public FiredStick(String name, String info) {
		super(name, info, Script.FIREDSTICK_SIMPLE_USE);
	}


	// ***** METHODS *****
	
	
	// === COMMANDS ===

	@Override
	public void look(){
		Game.printLetterByLetter(Script.FIRED_STICK_DESCRIPT, Script.DEFAULT_NARRATOR);
	}

	@Override
	public void use(Hero h) {
		Game.printLetterByLetter(this.SIMPLE_USE, Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this "+ this.NAME+" with something else\n", Script.DEFAULT_NARRATOR);
	}
	
}
