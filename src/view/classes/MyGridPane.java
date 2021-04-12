package view.classes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import view.ressources.GameRessources;

public class MyGridPane extends GridPane {

    /*** ATTRIBUTES ***/
    private MyPlace myPlace;

    /*** CONSTRUCTOR ***/
    public MyGridPane(){
        super();
        this.add(GameRessources.heroIm,GameRessources.heroIm.x.getValue(),GameRessources.heroIm.y.getValue());
        //listener
        GameRessources.heroIm.x.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                boolean containObject = false; //new pos contain an entity/object

                for (MyImageView im: myPlace.getImages()) {
                    if(im.x==newValue.intValue() && im.y == GameRessources.heroIm.y.getValue()){
                        containObject = true;
                        break;
                    }
                }

                if(newValue.intValue()<myPlace.getMaxXBound() &&
                        newValue.intValue()>myPlace.getMinXBound() && !containObject){
                    MyGridPane.this.getChildren().remove(GameRessources.heroIm);
                    MyGridPane.this.add(GameRessources.heroIm,newValue.intValue(),GameRessources.heroIm.y.getValue());
                }
                else{
                    GameRessources.heroIm.x.setValue(oldValue);
                }
            }
        });
        GameRessources.heroIm.y.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                boolean containObject = false; //new pos contain an entity/object

                for (MyImageView im: myPlace.getImages()) {
                    if(im.x==GameRessources.heroIm.x.getValue() && im.y == newValue.intValue()){
                        containObject = true;
                        break;
                    }
                }
                if(newValue.intValue()<myPlace.getMaxYBound() &&
                        newValue.intValue()>myPlace.getMinYBound() && !containObject){
                    MyGridPane.this.getChildren().remove(GameRessources.heroIm);
                    MyGridPane.this.add(GameRessources.heroIm,GameRessources.heroIm.x.getValue(),newValue.intValue());
                }
                else{
                    GameRessources.heroIm.y.setValue(oldValue);
                }
            }
        });
    }

    public void setMyPlace(MyPlace myPlace) {
        if(this.myPlace!=null){
            this.getChildren().removeAll(this.myPlace.getImages());
        }
        this.myPlace = myPlace;
        for (MyImageView im: myPlace.getImages()) {this.add(im,im.x,im.y); }
        this.setStyle("-fx-border-color: red");
        BackgroundImage backgroundImage= new BackgroundImage(
                myPlace.getBackgroundImage(),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(backgroundImage));
    }

    /*** === METHODS === ***/
    public MyPlace getMyPlace() {
        return myPlace;
    }

}
