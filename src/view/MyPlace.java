package view;

import javafx.scene.image.Image;
import model.others.Place;

import java.util.ArrayList;

public class MyPlace {

    /*** === ATTRIBUTES === ***/
    private ArrayList<MyImageView> images;
    private final Place place;
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;
    private MyImageView enemy;
    private Image backgroundImage;

    /*** === CONSTRUCTOR === ***/
    public MyPlace(Place place, Image bg, int minBoundX, int maxBoundX, int minBoundY, int maxBoundY, ArrayList<MyImageView> images) {
        this.place = place;
        backgroundImage = bg;
        minX = minBoundX;
        maxX = maxBoundX;
        minY = minBoundY;
        maxY = maxBoundY;
        this.images = images;
        this.enemy = null;

    }
    public MyPlace(Place place, Image bg, int minBoundX, int maxBoundX, int minBoundY, int maxBoundY, ArrayList<MyImageView> images, MyImageView enemy) {
       this(place, bg, minBoundX, maxBoundX, minBoundY, maxBoundY, images);
       this.enemy = enemy;
    }
    /*** === METHODS === ***/

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

    public MyImageView getEnemy() {
        return this.enemy;
    }

    public ArrayList<MyImageView> getImages() {
        return images;
    }
}
