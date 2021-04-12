package view.classes;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class MyGridPane extends GridPane {

    /*** ATTRIBUTES ***/
    private MyPlace myPlace;

    /*** CONSTRUCTOR ***/
    public MyGridPane(){
        super();
    }

    public void setMyPlace(MyPlace myPlace) {
        if(this.myPlace!=null){
            this.getChildren().removeAll(this.myPlace.getImages());
        }
        this.myPlace = myPlace;
        for (MyImageView im: myPlace.getImages()) {this.add(im,im.x,im.y); }
        this.setStyle("-fx-border-color: red");
    }

    /*** === METHODS === ***/
    public MyPlace getMyPlace() {
        return myPlace;
    }

}
