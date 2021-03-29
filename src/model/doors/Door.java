package model.doors;

import model.characters.*;
import model.others.*;
import model.interfaces.*;

import java.util.HashMap;

public class Door implements Crossable {


	// ***** ATTRIBUTES *****

	protected boolean open;
	private final HashMap<String, Place> places;
	protected final Place dest;


	// ***** CONSTRUCTORS *****

	public Door(Place dest) {
		this.dest = dest;
		this.places = null;
		this.open = true;
		System.out.println("Door " + dest.getName() + "initialized");
	}

	public Door(Place p1, Place p2) {
		this.dest=null;
		this.open = true;
		this.places = new HashMap<>();
		this.places.put(p1.getName(), p1);
		if(p2 != null)
			this.places.put(p2.getName(), p2);
	}


	// ***** METHODS *****


	// === GETTER ===

	public boolean isOpen(){
		return this.open;
	}

	public HashMap<String, Place> getPlaces(){
		return this.places;
	}

	public Place getDest() {
		return dest;
	}


	// === SETTER ===

	public void open(){
		this.open = true;
	}


	// === OTHER ===

	public void cross(Hero hero, String s){
		if(s != null) {
			s = s.toLowerCase();
			if (hero.getPlace().getDoors() != null) {
				if (hero.getPlace().getDoors().containsKey(s)) {
					if (this.isOpen()) {
						hero.setPlace(this.getPlaces().get(s));     //If it's open we can pass
					}
				}
			}
		}
	}

}