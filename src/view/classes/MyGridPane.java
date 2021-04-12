package view.classes;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class MyGridPane extends GridPane {

    /*** ATTRIBUTES ***/
    private final MyPlace myPlace;

    /*** CONSTRUCTOR ***/
    public MyGridPane(MyPlace myPlace){
        this.myPlace = myPlace;
        this.getChildren().addAll(myPlace.getImages());
        BackgroundImage backgroundImage= new BackgroundImage(
                new Image("assets/images/place/floor.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(backgroundImage));
    }

    /*** === METHODS === ***/
    public MyPlace getMyPlace() {
        return myPlace;
    }

}
