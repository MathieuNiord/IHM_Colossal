package model.objects;

import model.characters.*;
import model.others.*;

public class Weapon extends Obj{


	// ***** CONSTRUCTOR *****

	public Weapon(String name, String info) {
		super(name, info, Script.WEAPON_SIMPLE_USE);
	}


	// ***** METHODS *****


	// === COMMANDS ===

	@Override
	public void use(Hero h) {
		Game.printLetterByLetter( this.SIMPLE_USE + this.NAME, Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this "+ this.NAME+" with something else\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.CLUB_DESCRIPT, Script.DEFAULT_NARRATOR);
	}

}
