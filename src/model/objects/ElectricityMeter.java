package model.objects;

import model.characters.*;
import model.others.*;

public class ElectricityMeter extends Obj{
	

	// ***** ATTRIBUTES *****

	private boolean hasFuse;
	public final Place place;


	// ***** CONSTRUCTOR *****

	public ElectricityMeter(String name, String info, Place p,int x, int y) {
		super(name, info, x, y);
		this.hasFuse = false;
		this.place = p;
	}


	// ***** METHODS *****

	// === GETTER ===
	
	public Place getPlace() {
		return this.place;
	}

	public boolean getHasFuse() {
		return this.hasFuse;
	}

	// === SETTER ===

	public void setHasFuse(){
		this.hasFuse=true;
	}
	
	
	// === COMMANDS ===

	@Override
	public void look() {
		if(!this.hasFuse){
			Game.printLetterByLetter(Script.ELECTRICMETER_MISSING_DESCRIPT, Script.DEFAULT_NARRATOR);
		}
		else{
			Game.printLetterByLetter(Script.ELECTRICMETER_DESCRIPT, Script.DEFAULT_NARRATOR);
		}
	}

	@Override
	public void take(Hero h) {
		Game.printLetterByLetter("You cannot take this Electric meter, it's too heavy for HOUGA BOUGA\n", Script.DEFAULT_NARRATOR);
	}

	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Use this item with something else...\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h, String s) {
		if(!this.hasFuse){
			
			if(s.equals(Script.DEFAULT_FUSE_NAME) && h.getObjs().containsKey(Script.DEFAULT_FUSE_NAME)){
				
				Game.printLetterByLetter("You just added the missing " + Script.DEFAULT_FUSE_NAME + "\n", Script.DEFAULT_NARRATOR);
				
				h.getObjs().remove(Script.DEFAULT_FUSE_NAME);
				this.setHasFuse();
				
			}
			
		}
		if(this.hasFuse && !place.isEnlightened()){
			place.setEnlightened();
		}
		else{
			Game.printLetterByLetter("You've already placed the missing "+ Script.DEFAULT_FUSE_NAME +" !\n", Script.DEFAULT_NARRATOR);
		}
	}
	
}
