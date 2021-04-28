package view.classes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MiniMapCell extends HBox {

    /** ATTRIBUTES **/

    private final static Background background = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, new Insets(0)));
    private final Circle indicator = new Circle(5, Color.GREEN);


    /** CONSTRUCTORS **/

    public MiniMapCell(){
        super();
        this.fillBackground();
        this.getChildren().add(indicator);
        this.setAlignment(Pos.CENTER);
        this.hideIndicator();
    }


    /** METHODS **/

    public void fillBackground(){
        this.setBackground(background);
    }

    public void removeBackground(){
        this.setBackground(null);
    }

    public void showIndicator(){
        this.indicator.setVisible(true);
    }

    public void hideIndicator(){
        this.indicator.setVisible(false);
    }
}
