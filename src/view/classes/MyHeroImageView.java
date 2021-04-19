package view.classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import model.characters.Hero;

public class MyHeroImageView extends ImageView {

    /*** === ATTRIBUTES === ***/

    public final Hero hero;
    public IntegerProperty x,y;
    private FlowPane inv;

    /*** === CONSTRUCTOR === ***/

    public MyHeroImageView(Hero hero, Image img, int x, int y) {
        super(img);
        this.hero = hero;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    /*** === METHODS === ***/

    //Getter

    public FlowPane getInvView() {
        return this.inv;
    }

    //Setter

    public void setInv(FlowPane inv) {
        this.inv = inv;
    }

    public void removeInv(MyImageView im) {
        this.inv.getChildren().remove(im);
    }

}
