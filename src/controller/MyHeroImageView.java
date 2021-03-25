package controller;

import javafx.scene.image.ImageView;
import model.characters.Hero;
import model.others.Place;

public class MyHeroImageView extends ImageView {

    /*** ATTRIBUTES ***/
    public final Hero hero;

    // TEST
    public final Place place = new Place("TEST", false, false);
    // END TEST

    /*** CONSTRUCTOR ***/

    public MyHeroImageView(){

        // - Constructor call -
        super();

        // - Initialization of a hero in a room named 'TEST' -
        this.hero = new Hero("caveman", place);
    }
}
