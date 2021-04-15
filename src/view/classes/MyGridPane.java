package view.classes;

import javafx.scene.layout.*;
import view.ressources.GameRessources;
import java.util.HashMap;

public class MyGridPane extends GridPane {

    /*** ATTRIBUTES ***/

    private MyPlace myPlace;
    private final HashMap<Integer,MyImageView> positions;


    /*** CONSTRUCTOR ***/

    public MyGridPane(){
        super();
        positions = new HashMap<>();
        this.add(GameRessources.HERO_IM,GameRessources.HERO_IM.x.getValue(),GameRessources.HERO_IM.y.getValue());
    }


    /*** === METHODS === ***/

    public void myRemove(MyImageView im){
        this.getChildren().remove(im);
        this.positions.remove(im.y * 9 + im.x);
        this.myPlace.getImages().remove(im);
    }

    // --- SETTER ---

    public void setMyPlace(MyPlace myPlace) {

        //remove all children from previous place
        if(this.myPlace!=null){
            this.getChildren().removeAll(this.myPlace.getImages());
            this.getChildren().remove(this.myPlace.getEnemy());
            this.positions.clear();
        }
        //set new place
        this.myPlace = myPlace;

        //add all children from the new place
        for (MyImageView im : myPlace.getImages()) {
            this.add(im, im.x, im.y);
            this.positions.put((im.y) * 9 + im.x, im);
        }

        //adding enemy if the place has one
        if(this.myPlace.getEnemy()!=null){
            this.add(this.myPlace.getEnemy(),this.myPlace.getEnemy().x,this.myPlace.getEnemy().y);
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
