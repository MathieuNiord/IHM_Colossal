package model.objects;

import model.characters.Hero;
import model.others.Game;
import model.others.Script;

public class NaziPoster extends Poster{



	// ***** CONSTRUCTOR *****
	public NaziPoster(String name, String info, int x, int y) {
		super(name, info, x, y);
	}

	
	// ***** METHODS *****
	
	
	// === COMMANDS ===
	
	@Override
	public void look() {
		System.out.println(Script.NAZI_POSTER);
	}
	
	@Override
	public void take(Hero h)  {
		super.take(h);
		Game.printLetterByLetter("\nThis Poster is now in your inventory, use it to lose life !\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h){
		this.look();
		h.setLife(10);
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this NaziPoster with something else\n", Script.DEFAULT_NARRATOR);
	}
	
}
