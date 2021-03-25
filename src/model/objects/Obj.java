package model.objects;

import model.characters.*;
import model.interfaces.*;

public abstract class Obj implements Lookable, Usable, Takable {


	// ***** ATTRIBUTES *****
	public final int x;
	public final int y;
	public final String NAME;
	public final String INFO;


	// ***** CONSTRUCTOR *****

	public Obj(String name, String info, int x , int y) {
		this.x=x;
		this.y=y;
		this.NAME = name;
		this.INFO = info;
	}


	// ***** METHODS *****


	// === COMMANDS ===
	
	@Override
	public void take(Hero h) {
		System.out.print("\nYou took the " + this.NAME.toUpperCase() + "\n");
		h.getObjs().put(this.NAME,this);
		h.getPlace().getItems().remove(this.NAME);
	}

	// === DISPLAY ===
	
	@Override
	public String toString() {
		return this.NAME;
	}
	
}
