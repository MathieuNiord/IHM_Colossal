package model.characters;

import model.others.*;
import model.interfaces.*;

public class Animal implements Lookable {


	/*** === ATTRIBUTES === ***/

	public final String NAME;
	public final String DESCRIPTION;

	//These attributes are used for dialog
	public final int BESCHERELLE_LEVEL;
	public final String NO_BESCHERELLE_DIALOG;
	public final String BESCHERELLE_DIALOG;


	/*** === CONSTRUCTOR === ***/
	public Animal(String name, int bLevel,String noBeschDialog,String beschDialog,String desc){
		this.BESCHERELLE_LEVEL =bLevel;
		this.NAME = name;
		this.NO_BESCHERELLE_DIALOG = noBeschDialog;
		this.BESCHERELLE_DIALOG = beschDialog;
		this.DESCRIPTION = desc;
	}


	/*** === METHODS === ***/

	// === DISPLAY ===

	@Override
	public String toString() {
		//Return the name of the animal
		return this.NAME;
	}

	//Returns the script according to the bescherelle level of the player (JavaFX)
	public String dialog(Hero h) {

		String dialog;

		if(h.getBLevel() >= BESCHERELLE_LEVEL)
			dialog = this.BESCHERELLE_DIALOG;

		else
			dialog = this.NO_BESCHERELLE_DIALOG;

		return dialog;
	}

	// === COMMANDS ===

	public void talk(Hero h) {
		/*If the bescherelle level of the hero is equal or higher than
		the bescherelle level needed to talk with this animal*/
		if(h.getBLevel() >= BESCHERELLE_LEVEL){
			Game.printLetterByLetter(this.BESCHERELLE_DIALOG, this.NAME);
		}
		else {
			Game.printLetterByLetter(this.NO_BESCHERELLE_DIALOG, this.NAME);
		}
	}

	
	public void look() {
		Game.printLetterByLetter(this.DESCRIPTION, this.NAME);
	}
}

