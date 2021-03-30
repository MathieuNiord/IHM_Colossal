package model.doors;

import model.characters.*;
import model.others.*;

public class CondemnedDoor extends Door {

	// ***** CONSTRUCTORS *****

	public CondemnedDoor(Place dest) {
		super(dest);
		this.open = false;
	}

	public CondemnedDoor(Place p1, Place p2) {
		super(p1, p2);
		this.open = false;
	}


	// ***** METHODS *****


	// === SETTER ===

	@Override
	public void open() {
		System.out.println("This door is condemned, you can't open it\n");
	}

	@Override
	public void cross(Hero hero, String s) {
		this.open();
	}

}
