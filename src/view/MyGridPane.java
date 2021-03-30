package view;

import javafx.scene.layout.GridPane;

public class MyGridPane extends GridPane {

    private MyPlace myPlace;


    public void setMyPlace(MyPlace myPlace) {
        this.myPlace = myPlace;
    }

    public MyPlace getMyPlace() {
        return myPlace;
    }
    public void addChildrens(){
        for(MyImageView im : myPlace.getImages()){
            this.add(im,im.x,im.y);
        }
    }

    public void removeChildrens(){
        for(MyImageView im : myPlace.getImages()){
            this.getChildren().remove(im);
        }
    }
}
