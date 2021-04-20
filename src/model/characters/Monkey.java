package model.characters;

import model.others.*;

public class Monkey extends Animal{

	/*** === ATTRIBUTES === ***/

	public final String NO_HUNGRY_DIALOG;

	/* This attribute is used to know if the monkey
   got the banana that he asked for */
	private boolean hungry = true;


	/*** === CONSTRUCTOR === ***/
	public Monkey(String name, int bLevel, String noBeschDialog, String beschDialog,String hungryDialog,String desc) {
		super(name, bLevel, noBeschDialog, beschDialog,desc);
		this.NO_HUNGRY_DIALOG = hungryDialog;
	}


	/*** === METHODS === ***/

	// === GETTER ===

	public boolean getHungry() {
		return this.hungry;
	}

	// === SETTER ===

	public void setHungry(boolean state) { this.hungry = state;}

	// === DISPLAY ===

	@Override
	public String dialog(Hero h) {

		String dialog;

		if (h.getBLevel() == BESCHERELLE_LEVEL && !this.hungry)
			dialog = this.BESCHERELLE_DIALOG;

		else if (h.getBLevel() == BESCHERELLE_LEVEL && this.hungry)
			dialog = this.NO_HUNGRY_DIALOG;

		else
			dialog = this.NO_BESCHERELLE_DIALOG;

		return dialog;
	}

	// === COMMANDS ===

	@Override
	public void talk(Hero h) {

		if(this.BESCHERELLE_LEVEL >h.getBLevel()){
			Game.printLetterByLetter(this.NO_BESCHERELLE_DIALOG, this.NAME);
		}
		else if(this.hungry){
			Game.printLetterByLetter(this.BESCHERELLE_DIALOG, this.NAME);
		}
		else{
			Game.printLetterByLetter(this.NO_HUNGRY_DIALOG, this.NAME);
		}
	}

}
