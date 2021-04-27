package model.objects;

import model.characters.*;
import model.others.*;

public class Fuse extends Obj {

	
	// ***** CONSTRUCTOR *****

	public Fuse(String name, String info) {
		super(name, info, Script.ORTHER_ITEM_SIMPLE_USE);
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
		Game.printLetterByLetter(this.SIMPLE_USE, Script.DEFAULT_NARRATOR);
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
