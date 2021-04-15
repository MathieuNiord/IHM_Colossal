package model.doors;

import model.characters.*;
import model.others.*;

public class BurnableDoor extends LockableDoor{
	
	// ***** CONSTRUCTORS *****

	public BurnableDoor(Place p1, Place p2) {
		super(p1, p2);
	}


	// ***** METHODS *****

	@Override
	public void cross(Hero hero, String s){
		s = s.toLowerCase();
		if(!this.isUnlock()){
			Game.printLetterByLetter("Is it a tunnel ? There are too many spiderwebs for you to borrow. Maybe by setting it on fire ...\n", Script.DEFAULT_NARRATOR);
		}
		if(this.isUnlock()){
			hero.setPlace(this.getPlaces().get(s));
		}
	}

}
