package model.objects;

import model.characters.*;
import model.others.*;

public class Fuse extends Obj {

	
	// ***** CONSTRUCTOR *****

	public Fuse(String name) {
		super(name);
	}


	// ***** METHODS *****

	
	// === COMMANDS ===

	@Override
	public void look() {
		Game.printLetterByLetter(Script.FUSE_DESCRIPT, Script.DEFAULT_NARRATOR);
	}

	//Faire take() avec remove du fuse

	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Use this item with something else...\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h, String s) {
		if(s != null) {
			s = s.toLowerCase();
			if (s.equals(Script.DEFAULT_ELECTRICMETER_NAME)) {
				h.getPlace().getItems().get(Script.DEFAULT_ELECTRICMETER_NAME).use(h, this.NAME);
			}
		}
	}
	
}
