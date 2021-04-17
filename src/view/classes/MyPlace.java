package view.classes;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import model.others.Place;

import java.util.ArrayList;

public class MyPlace {

    /*** === ATTRIBUTES === ***/
    public final static int DEFAULT_MIN_BOUND = 0;
    public final static int DEFAULT_MAX_BOUND = 8;
    private final ArrayList<MyImageView> images;
    private final Place place;
    private final int minX,maxX,minY,maxY;
    private MyImageView enemy;
    private Background backgroundImage;
    private final Integer[][] positions_map;
    private boolean visited;


    /*** === CONSTRUCTOR === ***/

    public MyPlace(Place place, Background bg, int minBoundX, int maxBoundX, int minBoundY, int maxBoundY,
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

    public MyPlace(Place place, Background bg, int minBoundX, int maxBoundX, int minBoundY, int maxBoundY,
                   ArrayList<MyImageView> images, Integer[][] positions_map, MyImageView enemy) {
       this(place, bg, minBoundX, maxBoundX, minBoundY, maxBoundY, images, positions_map);
       this.enemy = enemy;
    }

    public MyPlace(Place place, Background bg, ArrayList<MyImageView> images, Integer[][] positions_map) {
        this(place,bg,DEFAULT_MIN_BOUND,DEFAULT_MAX_BOUND,DEFAULT_MIN_BOUND,DEFAULT_MAX_BOUND,images,positions_map);
    }

    public MyPlace(Place place, Background bg, ArrayList<MyImageView> images, Integer[][] positions_map, MyImageView enemy) {
        this(place,bg,DEFAULT_MIN_BOUND,DEFAULT_MAX_BOUND,DEFAULT_MIN_BOUND,DEFAULT_MAX_BOUND,images,positions_map, enemy);
        this.enemy = enemy;
    }

    /*** === METHODS === ***/

    // --- GETTER ---

    public Background getBackground() {
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

    // - Return true if there is an enemy in the room -
    public boolean battle() {

        boolean res = false;

        if (this.enemy != null) res = true;

        return res;
    }


    // - This function get the position of a specific door -
    public MyImageView getDoor(MyImageView door) {

        for (MyImageView im : this.images) {
            if (im.door.equals(door.door)) {
                return im;
            }
        }
        return null;
    }

    // --- SETTER ---

    public void setBackgroundImage(Background backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public void makeVisited(){this.visited = true;}

    public void setImagesVisible(){
        for(ImageView im : this.getImages()){
            im.setVisible(true);
        }
    }

    public void removeEnemy() {

        //Enemy is defeated so it loots something
        this.enemy.enemy.loot();
        //We add the possesed item to the room
        this.images.add(this.enemy.getPossessedObject());
        //And the corpse
        this.images.add(this.enemy.getCorpse());
        //Finally we remove the enemy
        this.enemy = null;
    }
}
