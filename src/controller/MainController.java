package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.doors.SecretCodeDoor;
import model_bis.GameRessources;
import model_bis.MyHeroImageView;
import model_bis.MyImageView;
import model_bis.Test;
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

    // === TEST
    // GameRessources
    private final GameRessources game = new GameRessources();

    //Test
    private final Test gameTest = new Test();

    // Hero
    private final MyHeroImageView cavemanIm = new MyHeroImageView(gameTest.hero, "assets/images/characters/CavemanFix.png");

    // Animals
    private final MyImageView catIm = new MyImageView(game.cat, "assets/images/characters/cat.gif", 2, 2, 45);

    // Objects
    private final MyImageView naziPosterIm = new MyImageView(game.naziPoster, "assets/images/objects/NazisPoster.png", 3, 0, 40);

    // Doors
    private final MyImageView doorTestIm = new MyImageView(gameTest.animToTransf, "assets/images/place/BasicDoorUp.png", 5, 0);

    // Enemy

    // HashMap ImageView->Position
    //private HashMap<ImageView,Pair<Integer,Integer>> imageViewPairHashMap;
    private Pair<Integer, Integer> cavemanPos = new Pair<>(4, 4);



    // === FIN TEST

    /*** === METHODS === ***/

    // --- GRIDGAME ---

    // - Background display of the grigGame componant -
    @FXML
    private void setGridPane_mapBackground() {
        BackgroundImage backgroundImage= new BackgroundImage(
                new Image("assets/images/place/floor.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        gridGame.setBackground(new Background(backgroundImage));
    }

    // - This method is used to add an ImageView in the GridPane -
    private void addGame(MyImageView im) {
        gridGame.add(im, im.x, im.y);
    }

    // - This method is used to affect bounds on player -
    private Pair<Integer, Integer> computeNewPair(Pair<Integer, Integer> p, int x, int y){
        int newK = p.getKey();
        int newV = p.getValue();
        if(!(newK + x < 1 || newK + x > 7)){
            newK += x;
        }
        if(!(newV + y < 1 || newV + y > 7)){
            newV += y;
        }
        return new Pair<>(newK, newV);
    }

    // - Mouse clicked on the game display -
    @FXML
    private void gridGameSetOnMousePressedEvent(){
        gridGame.setOnMousePressed(event -> {
            try{
                MyImageView im = (MyImageView)event.getTarget();
                if(im.obj != null && !(im.obj.getClass().getSimpleName().equals("ElectricityMeter"))) gridPaneInventory.getChildren().add(im);
                else if(im.animal != null) labelScript.setText(im.animal.description);
                else if (im.monkey != null) labelScript.setText(im.monkey.description);
                else if(im.enemy != null) labelScript.setText(im.enemy.NAME);
                else if(im.door != null) cavemanGo_aux(im);//labelScript.setText(im.door.toString());
            }
            catch (Exception ignored){labelScript.setText("");}
        });
    }


    // --- CAVEMAN ---

    // - This method is called to do the hero interacts with objects -
    /*@FXML
    private void cavemanInteract(){
        //TODO (Interaction avec un voisin de la position du caveman)
        Pair<Integer, Integer> p = imageViewPairHashMap.get(hero);

        int k = p.getKey();
        int v = p.getValue();

    }*/

    // - This method is used to open a door and go in the other room -
    private void cavemanGo(MyImageView im) {
        if (im.door.getPlaces() != null) {
            for (String key : im.door.getPlaces().keySet()) {
                if (!(cavemanIm.hero.getPlace().getName().equals(key)) && key != null) {
                    if (im.door instanceof model.doors.SecretCodeDoor) {
                        // Cast
                        SecretCodeDoor secretCodeDoor = (SecretCodeDoor) im.door;

                        if (!secretCodeDoor.isUnlock()) {

                            // TextInputDialog Component
                            TextInputDialog code = new TextInputDialog();
                            code.setHeaderText("NEED A CODE");
                            code.getEditor().setPromptText("CODE");
                            code.showAndWait();
                            System.out.println(code.getResult());

                            // Unlock and open the door
                            secretCodeDoor.unlock(code.getResult());
                        }

                        if (secretCodeDoor.isUnlock()) {
                            cavemanIm.hero.setPlace(secretCodeDoor.getPlaces().get(key));
                            // Room Title
                            labelTitle.setText(key);
                            // Label Info
                            labelScript.setText("You entered in " + cavemanIm.hero.getPlace().getName());
                        }
                    } else cavemanIm.hero.go(key);
                    break;
                }
            }
        }
    }

    // - This method is used to open a door and go in the other room -
    private void cavemanGo_aux(MyImageView im) {
        if (im.door.getDest() != null) {

            if (im.door instanceof model.doors.SecretCodeDoor) {

                // Cast
                SecretCodeDoor secretCodeDoor = (SecretCodeDoor) im.door;

                if (!secretCodeDoor.isUnlock()) {

                    // TextInputDialog Component
                    TextInputDialog code = new TextInputDialog();
                    code.setHeaderText("NEED A CODE");
                    code.getEditor().setPromptText("CODE");
                    code.showAndWait();
                    System.out.println(code.getResult());

                    // Unlock and open the door
                    secretCodeDoor.unlock(code.getResult());
                }

                if (secretCodeDoor.isUnlock()) {
                    cavemanIm.hero.setPlace(secretCodeDoor.getDest());
                    // Room Title
                    labelTitle.setText(secretCodeDoor.getDest().getName());
                    // Label Info
                    labelScript.setText("You entered in " + cavemanIm.hero.getPlace().getName());
                }
            } else cavemanIm.hero.go(im.door.getDest().getName());
        }
    }

    // - This method is called to do the hero takes objects -
    @FXML
    private void cavemanTake(){
                //TODO (Interaction avec un objet voisin à la position du caveman)
    }

    // - Manage hero's actions with key pressed -
    @FXML
    private void cavemanEvent(){

        paneMain.setOnKeyPressed(event -> {

            Pair<Integer,Integer> newPair = cavemanPos;

            switch (event.getCode()){
                // Move up
                case Z :
                    newPair = computeNewPair(cavemanPos,0,-1);
                    cavemanIm.setImage(new Image("assets/images/characters/CavemanBack.png"));
                break;
                // Move left
                case Q : newPair = computeNewPair(cavemanPos,-1,0); break;
                // Move down
                case S :
                    newPair = computeNewPair(cavemanPos,0,1);
                    cavemanIm.setImage(new Image("assets/images/characters/CavemanFix.png"));
                break;
                // Move right
                case D : newPair = computeNewPair(cavemanPos,1,0); break;
                // Tests
                case E :
                    // ================================ TEST
                    break;
                    // ============================= FIN TEST
                case T : cavemanTake(); break;
                default:break;
            }
            if(!newPair.equals(new Pair<>(catIm.x, catIm.y)))
            {
                cavemanPos = newPair;
                gridGame.getChildren().remove(cavemanIm);
                gridGame.add(cavemanIm,cavemanPos.getKey(),cavemanPos.getValue());
            }
        });
    }

    // --- COMPONENT ACTIONS ---

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
            }
            catch (Exception ignored){}
        }
        else if (result.get() == b2) {
            Stage stage = (Stage) buttonQuit.getScene().getWindow();
            stage.close();
        }
    }

    // --- INITIALIZE ---
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("GameRessources Initialized");

        labelTitle.setText(cavemanIm.hero.getPlace().getName());

        // GridMap ===

        // - Background
        BackgroundImage backgroundImage= new BackgroundImage(
                new Image("assets/images/background/Mini-Map.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        gridPaneMap.setBackground(new Background(backgroundImage));


        // GridGame ===

        // - Background
        setGridPane_mapBackground();

        // - Layout
        addGame(catIm);
        addGame(naziPosterIm);
        addGame(doorTestIm);
        gridGame.add(cavemanIm, cavemanPos.getKey(), cavemanPos.getValue());

        gridGameSetOnMousePressedEvent();


        // Caveman ===

        // - On mouse hover
        cavemanIm.setOnMouseEntered( event -> {
            cavemanIm.setImage(new Image("assets/images/characters/caveman.gif"));
        });

        // - On mouse exited
        cavemanIm.setOnMouseExited( event -> {
            cavemanIm.setImage(new Image("assets/images/characters/CavemanFix.png"));

        });

        cavemanEvent();


        // Inventory ===

        gridPaneInventory.setOnMousePressed(event -> {
            try{
                MyImageView im = (MyImageView)event.getTarget();
                if(im.obj != null){
                    labelObjectName.setText(((MyImageView) event.getTarget()).obj.NAME);
                    labelObjectInfo.setText(((MyImageView) event.getTarget()).obj.INFO);
                }
            } catch (Exception ignored){
                labelObjectName.setText("");
                labelObjectInfo.setText("");
            }
        });

        System.out.println("Main initialized");
    }

}
