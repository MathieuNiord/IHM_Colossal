package view.classes;

import controller.entities.MyEntity;
import controller.entities.MyPlace;
import javafx.scene.layout.*;
import view.ressources.GameResources;
import java.util.HashMap;

public class MyGridPane extends GridPane {

    /*** ATTRIBUTES ***/

    private MyPlace myPlace;
    private final HashMap<Integer,MyImageView> positions;


    /*** CONSTRUCTOR ***/

    public MyGridPane(){
        super();
        positions = new HashMap<>();
        this.add(GameResources.HERO_IM, GameResources.HERO_IM.x.getValue(), GameResources.HERO_IM.y.getValue());
    }


    /*** === METHODS === ***/

    public void myRemove(MyImageView im){
        this.getChildren().remove(im);
        this.positions.remove(im.y * 9 + im.x);
    }

    // --- SETTER ---

    public void setMyPlace(MyPlace myPlace) {

        //remove all children from previous place
        if(this.myPlace!=null){
            for(MyEntity entity : this.myPlace.getEntities()){
                this.getChildren().remove(entity.view);
            }
            if(this.myPlace.getEnemy()!=null)
                this.getChildren().remove(this.myPlace.getEnemy().view);
            this.positions.clear();
        }
        //set new place
        this.myPlace = myPlace;

        //add all children from the new place
        for (MyEntity entity : myPlace.getEntities()) {
            MyImageView im = entity.view;
            this.add(im, im.x, im.y);
            this.positions.put((im.y) * 9 + im.x, im);
        }

        //adding enemy if the place has one
        if(this.myPlace.getEnemy()!=null){
            this.add(this.myPlace.getEnemy().view,this.myPlace.getEnemy().view.x,this.myPlace.getEnemy().view.y);
        }

        //setting the background of the place
        this.setBackground(this.myPlace.getBackground());
    }

    // --- GETTER ---

    public MyPlace getMyPlace() {
        return myPlace;
    }

    public HashMap<Integer, MyImageView> getPositions() {
        return positions;
    }
}
