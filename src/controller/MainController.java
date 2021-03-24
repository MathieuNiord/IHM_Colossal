package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Label label_title;
    @FXML
    private Label label_script;
    @FXML
    private TabPane tabPane;
    @FXML
    private GridPane gridPane_inventory;
    @FXML
    private Label label_object_name;
    @FXML
    private Label label_object_info;
    @FXML
    private Button button_use;
    @FXML
    private Button button_match;
    @FXML
    private Button button_look;
    @FXML
    private GridPane gridPane_map;
    @FXML
    private Button button_quit;
    @FXML
    private Button button_skip;
    @FXML
    private Pane pane_main;
    @FXML
    private GridPane grid_game;
    @FXML
    private ImageView caveman;

    private int cavemanX = 4;
    private int cavemanY = 4;

    @FXML
    private void cavemanMove(){
        pane_main.setOnKeyPressed(event -> {

            switch (event.getCode()){
                case Z:cavemanY--; break;
                case Q:cavemanX--; break;
                case S:cavemanY++; break;
                case D:cavemanX++; break;
                default:break;
            }
            if(cavemanY<1) cavemanY++;
            if(cavemanX<1) cavemanX++;
            if(cavemanY>7) cavemanY--;
            if(cavemanX>7) cavemanX--;
            grid_game.getChildren().remove(caveman);
            grid_game.add(caveman,cavemanX,cavemanY);
        });
    }

    @FXML
    private void button_quitAction(){
        Stage stage = (Stage) button_quit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void setGridPane_mapBackground() {
        BackgroundImage backgroundImage= new BackgroundImage(
                new Image("/ressource/pictures/floor.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
//then you set to your node
        grid_game.setBackground(new Background(backgroundImage));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //permet de quitter le jeu
        button_quit.setOnAction(event -> { button_quitAction();});
        setGridPane_mapBackground();
        cavemanMove();


    }
}
