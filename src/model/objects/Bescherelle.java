package model.objects;

import model.characters.*;
import model.others.*;

public class Bescherelle extends Obj{


	// ***** CONSTRUCTOR *****

	public Bescherelle(String name, String info) {
		super(name, info, Script.BESCHERELLE_SIMPLE_USE);
	}


	// ***** METHODS *****


	// === COMMANDS ===
	
	@Override
	public void use(Hero h) {
		Game.printLetterByLetter( this.SIMPLE_USE + this.NAME.toUpperCase() + "\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("NO PLEASE DON'T EAT THIS " + this.NAME.toUpperCase() + "\n", Script.DEFAULT_NARRATOR);
		
	}
	
	@Override
	public void take(Hero h)  {
		h.increaseBescherelle();
		super.take(h);
	}
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.BESCH_DESCRIPT, Script.DEFAULT_NARRATOR);
	}

}
