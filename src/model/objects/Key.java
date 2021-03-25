package model.objects;

import model.characters.*;
import model.others.*;

public class Key extends Obj{


    // ***** CONSTRUCTOR *****
    public Key(String name, String info, int x, int y) {
        super(name, info, x, y);
    }


    // ***** METHODS *****


    // === COMMANDS ===

    @Override
    public void use(Hero h) {
        Game.printLetterByLetter("What exactly are you trying to do with this key ?\n", Script.DEFAULT_NARRATOR);
    }
    
    @Override
    public void use(Hero h, String s) {
        Game.printLetterByLetter("You cannot use this Key with something else\n", Script.DEFAULT_NARRATOR);
    }
    
    @Override
    public void take(Hero h) {
        h.increaseKey();
        h.getObjs().put(this.NAME, this);
        h.getPlace().getItems().remove(this.NAME);
    }

    @Override
    public void look() {
        Game.printLetterByLetter(Script.KEY_DESCRIPT, Script.DEFAULT_NARRATOR);
    }

}
