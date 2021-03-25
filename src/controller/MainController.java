package controller;

import imageView.MyHeroImageView;
import imageView.MyImageView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.characters.Animal;
import model.doors.Door;
import model.objects.Banana;
import model.objects.NaziPoster;
import model.objects.Obj;
import model.others.Game;
import model.others.Place;
import model.others.Script;
import stage.MyStage;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {

    /*** === ATTRIBUTES === ***/

    // Labels
    @FXML
    private Label labelTitle;
    @FXML
    private Label labelScript;
    @FXML
    private Label labelObjectName;
    @FXML
    private Label labelObjectInfo;

    // Buttons
    @FXML
    private Button buttonUse;
    @FXML
    private Button buttonMatch;
    @FXML
    private Button buttonLook;
    @FXML
    private Button buttonQuit;
    @FXML
    private Button buttonSkip;
    @FXML
    private Button buttonHelp;

    // Panes
    @FXML
    private TabPane tabPane;
    @FXML
    private GridPane gridPaneInventory;
    @FXML
    private GridPane gridPaneMap;
    @FXML
    private Pane paneMain;
    @FXML
    private GridPane gridGame;

    // ImageViews
    @FXML
    private MyHeroImageView caveman;
    @FXML
    private MyImageView cat;
    @FXML
    private MyImageView piece;
    @FXML
    private MyImageView drapeau;
    @FXML
    private MyImageView porte;
    @FXML
    private MyImageView test;


    // HashMap ImageView->Position
    private HashMap<ImageView,Pair<Integer,Integer>> imageViewPairHashMap;

    /*** === METHODS === ***/

    // - this method is used to create bounds -
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
    private void gridGameSetOnMousePressedEvent(){
        gridGame.setOnMousePressed(event -> {
            try{
                MyImageView im = (MyImageView)event.getTarget();
                if(im.obj != null && im.obj.getClass().getSimpleName().equals("ElectricityMeter")) gridPaneInventory.getChildren().add(im);
                else if(im.animal != null) labelScript.setText(im.animal.description);
                else if (im.monkey != null) labelScript.setText(im.monkey.description);
                else if(im.enemy != null) labelScript.setText(im.enemy.NAME);
                else if(im.door != null) labelScript.setText(im.door.toString());
            }
            catch (Exception ignored){labelScript.setText("");}
        });
    }


    // - this method is called to do the hero interacts with objects -
    @FXML
    private void cavemanInteract(){
        //TODO (Interaction avec un voisin de la position du caveman)
        Pair<Integer, Integer> p = imageViewPairHashMap.get(caveman);

        int k = p.getKey();
        int v = p.getValue();

    }

    // - this method is called to do the hero takes objects -
    @FXML
    private void cavemanTake(){
                //TODO (Interaction avec un objet voisin à la position du caveman)
    }

    // - manage hero's actions with key pressed -
    @FXML
    private void cavemanEvent(){

        paneMain.setOnKeyPressed(event -> {

            Pair<Integer,Integer> oldPair = imageViewPairHashMap.get(caveman);
            Pair<Integer,Integer> newPair = oldPair;

            switch (event.getCode()){
                case Z : newPair = computeNewPair(oldPair,0,-1) ; break;
                case Q : newPair = computeNewPair(oldPair,-1,0); break;
                case S : newPair = computeNewPair(oldPair,0,1); break;
                case D : newPair = computeNewPair(oldPair,1,0); break;
                case I : cavemanInteract(); break;
                case T : cavemanTake(); break;
                default:break;
            }
            if(!newPair.equals(imageViewPairHashMap.get(cat)))
            {
                imageViewPairHashMap.replace(caveman,newPair);
                gridGame.getChildren().remove(caveman);
                gridGame.add(caveman,newPair.getKey(),newPair.getValue());
            }
        });
    }


    @FXML
    private void buttonQuitAction(){
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Quit");
        alert.setContentText("Are you sure you want to leave ? ");
        ButtonType b1 = new ButtonType("Menu");
        ButtonType b2 = new ButtonType("Quit");
        ButtonType b3 = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(b1, b2, b3);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == b1){
            try{
                Stage stage = (Stage) buttonQuit.getScene().getWindow();
                stage.close();
                MyStage s = new MyStage("../view/home.fxml");
                s.show();
            }catch (Exception ignored){}
        } else if (result.get() == b2) {
            Stage stage = (Stage) buttonQuit.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void setGridPane_mapBackground() {
        BackgroundImage backgroundImage= new BackgroundImage(
                new Image("assets/images/place/floor.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        gridGame.setBackground(new Background(backgroundImage));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final Game game = new Game("heroName");

        imageViewPairHashMap = new HashMap<>();
        imageViewPairHashMap.put(caveman,new Pair<>(4,4));
        imageViewPairHashMap.put(cat,new Pair<>(2,2));
        imageViewPairHashMap.put(test, new Pair<>(5, 5));
        cat.setAnimal(new Animal("cat", 1, Script.CAT_TEXT01, Script.CAT_TEXT02, Script.CAT_DESCRIPT));
        piece.setObj(new Banana("Banana", Script.BANANA_DESCRIPT));
        drapeau.setObj(new NaziPoster("Nazi's Poster", Script.NAZI_POSTER));
        test.setObj(new Banana("Electric Meter", Script.ELECTRICMETER_DESCRIPT));
        porte.setDoor(new Door(new Place("test", false, true),new Place("test1", false, true)));

        labelTitle.textProperty().bind(caveman.hero.getPlace().getNameProperty());



        setGridPane_mapBackground();
        cavemanEvent();
        gridGameSetOnMousePressedEvent();

        gridPaneInventory.setOnMousePressed(event -> {
            try{
                MyImageView im = (MyImageView)event.getTarget();
                if(im.obj != null){
                    labelObjectName.setText(((MyImageView) event.getTarget()).obj.NAME);
                    labelObjectInfo.setText(((MyImageView) event.getTarget()).obj.INFO);
                }
                else{
                    labelObjectName.setText("");
                    labelObjectInfo.setText("");
                }//Ne fonctionne pas
            } catch (Exception ignored){}


        });


    }

}
