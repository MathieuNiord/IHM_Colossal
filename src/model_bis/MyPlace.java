package model_bis;

import javafx.scene.image.Image;
import java.util.ArrayList;

public class MyPlace extends model.others.Place {

    /*** === ATTRIBUTES === ***/
    private ArrayList<MyImageView> placeobjects;
    private ArrayList<MyImageView> placedoors;
    // -- There is only one animal in a room (Monkey is defined as a Monkey, not an Animal)
    private MyImageView placeAnimal;
    // -- There is only one monkey in a room
    private MyImageView placeMonkey;
    // -- There is only one enemy in the room
    private MyImageView placeEnemy;

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    private Image backgroundImage;

    /*** === CONSTRUCTOR === ***/
    public MyPlace(String NAME, boolean inf, boolean isEnlighted, Image bg, int minBoundX, int maxBoundX, int minBoundY, int maxBoundY, ArrayList<MyImageView> obj) {
        super(NAME, inf, isEnlighted);
        backgroundImage = bg;
        minX = minBoundX;
        maxX = maxBoundX;
        minY = minBoundY;
        maxY = maxBoundY;
        sortImageViews(obj);
    }

    /*** === METHODS === ***/

    private void sortImageViews(ArrayList<MyImageView> obj) {
        if (obj != null) {
            for (MyImageView im : obj) {
                if (im.animal != null) placeAnimal = im;
                else if (im.monkey != null) placeMonkey = im;
                else if (im.obj != null) placeobjects.add(im);
                else if (im.door != null) placedoors.add(im);
                else if (im.enemy != null) placeEnemy = im;
            }
        }
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public int getMinXBound() {
        return minX;
    }

    public int getMaxXBound() {
        return maxX;
    }

    public int getMinYBound() {
        return minY;
    }

    public int getMaxYBound() {
        return maxY;
    }

    public MyImageView getPlaceEnemy() {
        return placeEnemy;
    }
}
