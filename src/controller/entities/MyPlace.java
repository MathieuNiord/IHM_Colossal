package controller.entities;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import model.others.Place;
import view.classes.MyImageView;

import java.util.ArrayList;

public class MyPlace {

    /*** === ATTRIBUTES === ***/
    public final static int DEFAULT_MIN_BOUND = 0;
    public final static int DEFAULT_MAX_BOUND = 8;
    private final ArrayList<MyEntity> entities;
    private final Place place;
    private final int minX,maxX,minY,maxY;
    private MyEntity enemy;
    private Background backgroundImage;
    private final Integer[][] positions_map;
    private boolean visited;


    /*** === CONSTRUCTOR === ***/

    public MyPlace(Place place, Background bg, int minBoundX, int maxBoundX, int minBoundY, int maxBoundY,
                   ArrayList<MyEntity> entities, Integer[][] positions_map) {
        this.place = place;
        this.backgroundImage = bg;
        this.minX = minBoundX;
        this.maxX = maxBoundX;
        this.minY = minBoundY;
        this.maxY = maxBoundY;
        this.entities = entities;
        this.positions_map = positions_map;
        this.visited = false;
        this.enemy = null;
    }

    public MyPlace(Place place, Background bg, int minBoundX, int maxBoundX, int minBoundY, int maxBoundY,
                   ArrayList<MyEntity> images, Integer[][] positions_map, MyEntity enemy) {
       this(place, bg, minBoundX, maxBoundX, minBoundY, maxBoundY, images, positions_map);
       this.enemy = enemy;
    }

    public MyPlace(Place place, Background bg, ArrayList<MyEntity> images, Integer[][] positions_map) {
        this(place,bg,DEFAULT_MIN_BOUND,DEFAULT_MAX_BOUND,DEFAULT_MIN_BOUND,DEFAULT_MAX_BOUND,images,positions_map);
    }

    public MyPlace(Place place, Background bg, ArrayList<MyEntity> images, Integer[][] positions_map, MyEntity enemy) {
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

    public MyEntity getEnemy() {
        return this.enemy;
    }

    public ArrayList<MyEntity> getEntities() {
        return entities;
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
    public MyEntity getDoor(MyEntity door) {

        for (MyEntity entity : this.entities) {
            if (entity.door_model.equals(door.door_model)) {
                return entity;
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
        for(MyEntity entity : this.getEntities()){
            entity.view.setVisible(true);
        }
    }

    public void removeEnemy() {

        //Enemy is defeated so it loots something
        this.enemy.enemy_model.loot();
        //We add the possesed item to the room
        this.entities.add(this.enemy.getPossessedObject());
        //And the corpse
        this.entities.add(this.enemy.getCorpse());
        //Finally we remove the enemy by setting his image at no visible and his value at null
        this.enemy.view.setVisible(false);
        this.enemy = null;
    }
}
