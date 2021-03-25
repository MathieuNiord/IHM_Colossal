package model.objects;

import model.characters.*;
import model.others.*;

public class Banana extends Obj {



	// ***** CONSTRUCTOR *****
	public Banana(String name, String info, int x, int y) {
		super(name, info, x, y);
	}



	// ***** METHODS *****


	// === COMMANDS ===

	@Override
	public void look() {
		Game.printLetterByLetter(Script.BANANA_DESCRIPT, Script.DEFAULT_NARRATOR);
	}

	public String getInfo() {return Script.BANANA_DESCRIPT;}

	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Maybe someone is interested for this " + this.NAME + "...\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h, String s) {
		this.use(h);
	}
	
}
