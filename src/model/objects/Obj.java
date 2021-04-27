package model.objects;

import model.characters.*;
import model.interfaces.*;

public abstract class Obj implements Lookable, Usable, Takable {


	// ***** ATTRIBUTES *****

	public final String NAME;
	public final String INFO;
	public final String SIMPLE_USE;
	private boolean draggable;


	// ***** CONSTRUCTOR *****

	public Obj(String name, String info, String simple_use) {
		this.NAME = name;
		this.INFO = info;
		this.draggable = false;
		this.SIMPLE_USE = simple_use;
	}

	public Obj(String name, String info) {
		this.NAME = name;
		this.INFO = info;
		this.draggable = false;
		this.SIMPLE_USE = "";
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

	// === Get/set ===

	public boolean getDraggable(){ return this.draggable; }

	public void setDraggableTrue(){ this.draggable = true; }
	
}
