package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.characters.Animal;
import model.objects.Banana;
import model.objects.NaziPoster;
import model.others.Script;

import java.net.URL;
import java.util.*;

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
    private MyHeroImageView caveman;
    @FXML
    private MyImageView cat;
    @FXML
    private MyImageView piece;
    @FXML
    private MyImageView drapeau;

    private HashMap<ImageView,Pair<Integer,Integer>> imageViewPairHashMap;


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
    private void cavemanInteract(){
        //TODO (Interaction avec un voisin de la position du caveman)
        Pair<Integer, Integer> p = imageViewPairHashMap.get(caveman);

        int k = p.getKey();
        int v = p.getValue();

    }

    @FXML
    private void cavemanTake(){
                //TODO (Interaction avec un objet voisin à la position du caveman)
    }
    @FXML
    private void cavemanEvent(){
        pane_main.setOnKeyPressed(event -> {

            Pair<Integer,Integer> oldPair = imageViewPairHashMap.get(caveman);
            Pair<Integer,Integer> newPair=oldPair;
            switch (event.getCode()){
                case Z:newPair = computeNewPair(oldPair,0,-1) ; break;
                case Q:newPair = computeNewPair(oldPair,-1,0); break;
                case S:newPair = computeNewPair(oldPair,0,1); break;
                case D:newPair = computeNewPair(oldPair,1,0); break;
                case I:cavemanInteract(); break;
                case T:cavemanTake(); break;
                default:break;
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
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Quit");
        alert.setContentText("Are you sure you want to leave ? ");
        ButtonType buttonMenu = new ButtonType("Menu");
        ButtonType buttonQuit = new ButtonType("Quit");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonMenu, buttonQuit, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonMenu){
            try{
                Stage stage = (Stage) button_quit.getScene().getWindow();
                stage.close();
                FXMLLoader mainLoader = new FXMLLoader();
                mainLoader.setLocation(this.getClass().getResource("../view/home.fxml"));
                Parent homeRoot = mainLoader.load();
                Stage s = new Stage();
                s.setScene(new Scene(homeRoot));
                s.show();
            }catch (Exception ignored){}
        } else if (result.get() == buttonQuit) {
            Stage stage = (Stage) button_quit.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void setGridPane_mapBackground() {
        BackgroundImage backgroundImage= new BackgroundImage(
                new Image("ressource/pictures/floor.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        grid_game.setBackground(new Background(backgroundImage));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageViewPairHashMap = new HashMap<>();
        imageViewPairHashMap.put(caveman,new Pair<>(4,4));
        imageViewPairHashMap.put(cat,new Pair<>(2,2));
        piece.setObj(new Banana("Banana"));
        drapeau.setObj(new NaziPoster("naziPoster"));
        //permet de quitter le jeu
        button_quit.setOnAction(event -> { button_quitAction();});

        setGridPane_mapBackground();
        cavemanEvent();
        grid_game.setOnMousePressed(event -> {
            try{
                MyImageView im = (MyImageView)event.getTarget();
                if(im.obj != null){
                    if(im.equals(piece)){
                        grid_game.getChildren().remove(piece);
                        gridPane_inventory.add(im,1,1);
                    }
                    if(im.equals(drapeau)){
                        grid_game.getChildren().remove(drapeau);
                        gridPane_inventory.add(im,2,1);
                    }
                    im.obj.take(caveman.hero);

                }
                im.animal.talk(caveman.hero);
                im.monkey.talk(caveman.hero);



            } catch (Exception ignored){}


        });


    }
}
