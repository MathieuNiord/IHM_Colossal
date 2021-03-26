package imageView;

import javafx.scene.image.ImageView;
import model.GameRessources;
import model.characters.Hero;
import model.doors.Door;
import model.others.Place;

public class MyHeroImageView extends ImageView {

    /*** ATTRIBUTES ***/
    public final Hero hero;

    // TEST
    public final GameRessources game = new GameRessources();
    public final Place place = game.animalRoom;
    public final Door test = game.experimAndCold;
    // END TEST

    /*** CONSTRUCTOR ***/

    public MyHeroImageView(Hero hero, String path){

        // - Constructor call -
        super(path);

        //place.addDoor(test, "TEST2");

        // - Initialization of a hero in a room named 'TEST' -
        this.hero = new Hero("caveman", place);
    }
}
