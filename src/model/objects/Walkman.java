package model.objects;

import model.characters.Hero;
import model.others.Game;
import model.others.Script;

public class Walkman extends Obj{


	public Walkman(String name, String info, int x, int y) {
		super(name, info, x, y);
	}

	@Override
	public void look() {
		Game.printLetterByLetter("Wow this Walkman has some good music on !!!\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Allumeeeeerrrrrrrrr le FEUUUUU, ALLUMEEEERRRRRRRRRRR LE FEUUUUUUUUUUU !!!!!!\n", this.NAME);
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this "+ this.NAME+" with something else\n", Script.DEFAULT_NARRATOR);
	}

	@Override
	public String toString() {
		return this.NAME;
	}
}
