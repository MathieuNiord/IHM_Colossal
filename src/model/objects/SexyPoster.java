package model.objects;

import model.characters.Hero;
import model.others.Game;
import model.others.Script;

public class SexyPoster extends Poster{

	
	// ***** CONSTRUCTOR *****
	
	public SexyPoster(String name, String info) {
		super(name, info, Script.SEXY_POSTER_SIMPLE_USE);
	}
	
	// ***** METHODS *****
	
	
	// === COMMANDS ===
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.SEXY_POSTER, Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h) {
		h.heal();
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this SexyPoster with something else\n", Script.DEFAULT_NARRATOR);
	}
	
}
