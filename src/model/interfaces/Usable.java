package model.interfaces;

import model.characters.*;

//This interface is for Objs usable
public interface Usable {
	void use(Hero h);
	void use(Hero h, String s); // use for conbined model.objects
}
