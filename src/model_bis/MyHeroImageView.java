package model_bis;

import javafx.scene.image.ImageView;
import model.characters.Hero;
import model.doors.Door;
import model.others.Place;

public class MyHeroImageView extends ImageView {

    /*** ATTRIBUTES ***/
    public final Hero hero;
    private MyPlace myPlace;

    // TEST
    public final GameRessources game = new GameRessources();
    public final Place place = game.animalRoom;
    public final Door test = game.experimToCold;
    // END TEST

    /*** CONSTRUCTOR ***/

    public MyHeroImageView(Hero hero, String path) {//, MyPlace place){

        // - Constructor call -
        super(path);

        //place.addDoor(test, "TEST2");
        //myPlace = place;

        // - Initialization of a hero in a room named 'TEST' -
        this.hero = new Hero("caveman", place);
    }

    public MyPlace getMyPlace() {
        return myPlace;
    }


}
