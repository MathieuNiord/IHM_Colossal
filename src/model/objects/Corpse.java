package model.objects;

// ======================================================
// === This class is only used for the JavaFx project ===
// ======================================================

import model.characters.Hero;
import model.others.Game;
import model.others.Place;
import model.others.Script;

public class Corpse extends Obj{


    // ***** ATTRIBUTES *****

    private boolean hasFuse;


    // ***** CONSTRUCTOR *****

    public Corpse (String name, String info) {
        super(name, info);
        this.hasFuse = false;
    }


    // ***** METHODS *****

    // === GETTER ===

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
        Game.printLetterByLetter(Script.CORPSE_DESCRIPT, Script.DEFAULT_NARRATOR);
    }

    @Override
    public void take(Hero h) {
        Game.printLetterByLetter("Wow ! I under esteemed your knowledge in battle...", Script.DEFAULT_NARRATOR);
    }

    @Override
    public void use(Hero hero) {}

    @Override
    public void use(Hero hero, String string) {}

}

