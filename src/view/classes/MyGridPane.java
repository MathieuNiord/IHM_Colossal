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
        if(this.myPlace!=null){
            this.getChildren().removeAll(this.myPlace.getImages());
            this.positions.clear();
        }
        this.myPlace = myPlace;
        for (MyImageView im : myPlace.getImages()) {
            this.add(im, im.x, im.y);
            this.positions.put((im.y) * 9 + im.x, im);
        }
        BackgroundImage backgroundImage= new BackgroundImage(
                myPlace.getBackgroundImage(),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(backgroundImage));
    }

    // --- GETTER ---

    public MyPlace getMyPlace() {
        return myPlace;
    }

    public HashMap<Integer, MyImageView> getPositions() {
        return positions;
    }
}
