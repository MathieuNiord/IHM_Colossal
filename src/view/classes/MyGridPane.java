package view.classes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Pair;
import view.ressources.GameRessources;

import java.util.ArrayList;
import java.util.HashMap;

public class MyGridPane extends GridPane {

    /*** ATTRIBUTES ***/
    private MyPlace myPlace;

    private final ArrayList<MyImageView> positions;
    /*** CONSTRUCTOR ***/
    public MyGridPane(){
        super();
        positions = new ArrayList<>(64);
        this.setAlignment(Pos.CENTER);
        this.setLayoutX(51);
        this.setLayoutY(104);
        this.maxHeight(576);
        this.maxWidth(576);
        this.setPrefHeight(576);
        this.setPrefWidth(576);
        this.add(GameRessources.heroIm,GameRessources.heroIm.x.getValue(),GameRessources.heroIm.y.getValue());

    }

    public void setMyPlace(MyPlace myPlace) {
        if(this.myPlace!=null){
            this.getChildren().removeAll(this.myPlace.getImages());
            this.positions.clear();
        }
        this.myPlace = myPlace;
        for (MyImageView im: myPlace.getImages()) {
            this.add(im,im.x,im.y);
            this.positions.add((im.y)*8+ im.x,im);
        }
        BackgroundImage backgroundImage= new BackgroundImage(
                myPlace.getBackgroundImage(),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(backgroundImage));
    }

    /*** === METHODS === ***/
    public MyPlace getMyPlace() {
        return myPlace;
    }

    public ArrayList<MyImageView> getPositions() {
        return positions;
    }
}
