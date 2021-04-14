package view.classes;

import javafx.scene.image.Image;
import model.others.Place;

import java.util.ArrayList;

public class MyPlace {

    /*** === ATTRIBUTES === ***/

    private final ArrayList<MyImageView> images;
    private final Place place;
    private final int minX,maxX,minY,maxY;
    private MyImageView enemy;
    private final Image backgroundImage;
    private final Integer[][] positions_map;
    private boolean visited;


    /*** === CONSTRUCTOR === ***/

    public MyPlace(Place place, Image bg, int minBoundX, int maxBoundX, int minBoundY, int maxBoundY,
                   ArrayList<MyImageView> images, Integer[][] positions_map) {
        this.place = place;
        this.backgroundImage = bg;
        this.minX = minBoundX;
        this.maxX = maxBoundX;
        this.minY = minBoundY;
        this.maxY = maxBoundY;
        this.images = images;
        this.positions_map = positions_map;
        this.visited = false;
        this.enemy = null;

    }

    public MyPlace(Place place, Image bg, int minBoundX, int maxBoundX, int minBoundY
            , int maxBoundY, ArrayList<MyImageView> images, Integer[][] positions_map, MyImageView enemy) {
       this(place, bg, minBoundX, maxBoundX, minBoundY, maxBoundY, images, positions_map);
       this.enemy = enemy;
       //Add to the list of images to display the enemy in the room
       this.images.add(enemy);
    }


    /*** === METHODS === ***/

    // --- GETTER ---

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

    public Place getPlace() {
        return place;
    }

    public Integer[][] getPositions_map() {return positions_map;}

    public boolean isVisited(){return this.visited;}

    // --- SETTER ---

    public void makeVisited(){this.visited = true;}
}
