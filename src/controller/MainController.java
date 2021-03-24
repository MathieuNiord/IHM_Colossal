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
import javafx.util.Pair;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @FXML
    private ImageView cat;

    private HashMap<ImageView,Pair<Integer,Integer>> imageViewPairHashMap;

    public MainController() {
    }

    private Pair<Integer,Integer> computeNewPair(Pair<Integer,Integer> p,int x, int y){
        int newK = p.getKey();
        int newV = p.getValue();
        if(!(newK+x<1 || newK+x>7)){
            newK+=x;
        }
        if(!(newV+y<1 || newV+y>7)){
            newV+=y;
        }
        return new Pair<>(newK,newV);
    }

    @FXML
    private void cavemanMove(){
        pane_main.setOnKeyPressed(event -> {

            Pair<Integer,Integer> oldPair = imageViewPairHashMap.get(caveman);
            Pair<Integer,Integer> newPair;
            switch (event.getCode()){
                case Z:newPair = computeNewPair(oldPair,0,-1) ; break;
                case Q:newPair = computeNewPair(oldPair,-1,0); break;
                case S:newPair = computeNewPair(oldPair,0,1); break;
                case D:newPair = computeNewPair(oldPair,1,0); break;
                default: newPair = oldPair;break;
            }
            if(!newPair.equals(imageViewPairHashMap.get(cat)))
            {
                imageViewPairHashMap.replace(caveman,newPair);
                grid_game.getChildren().remove(caveman);
                grid_game.add(caveman,newPair.getKey(),newPair.getValue());
            }
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
        imageViewPairHashMap = new HashMap<>();
        imageViewPairHashMap.put(caveman,new Pair<>(4,4));
        imageViewPairHashMap.put(cat,new Pair<>(2,2));

        //permet de quitter le jeu
        button_quit.setOnAction(event -> { button_quitAction();});
        setGridPane_mapBackground();
        cavemanMove();


    }
}
