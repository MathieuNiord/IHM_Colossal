package view.classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.characters.Hero;
import model.doors.Door;
import model.others.Place;

public class MyHeroImageView extends ImageView {

    /*** ATTRIBUTES ***/

    public final Hero hero;
    public IntegerProperty x,y; //


    /*** CONSTRUCTOR ***/

    public MyHeroImageView(Hero hero, Image img, int x, int y) {
        super(img);
        this.hero = hero;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

}
