package controller;

import view.MyGridPane;
import view.MyImageView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.GameRessources;
import model.doors.SecretCodeDoor;
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
    private MyGridPane gridGame;

    // === TEST
    // GameRessources
    private GameRessources game = new GameRessources();


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

    // - Mouse clicked on the game display -
    @FXML
    private void gridGameSetOnMousePressedEvent(){
        gridGame.setOnMousePressed(event -> {
            try{
                MyImageView im = (MyImageView)event.getTarget();
                if(im.obj != null && !(im.obj.getClass().getSimpleName().equals("ElectricityMeter"))){
                    gridPaneInventory.getChildren().add(im);
                    gridGame.getMyPlace().getImages().remove(im);
                    game.hero.take(im.obj.NAME);
                }
                else if(im.animal != null) labelScript.setText(im.animal.description);
                else if (im.monkey != null) labelScript.setText(im.monkey.description);
                else if(im.enemy != null) labelScript.setText(im.enemy.NAME);
                else if(im.door != null) cavemanGo_aux(im);//labelScript.setText(im.door.toString());
            }
            catch (Exception ignored){labelScript.setText("");}
        });
    }

    // - This method is used to open a door and go in the other room -
    private void cavemanGo(MyImageView im) {
        for (String key : im.door.getPlaces().keySet()) {
            if (!(game.heroIm.hero.getPlace().getName().equals(key)) && key != null) {
                if (im.door instanceof model.doors.SecretCodeDoor) {
                    // Cast
                    SecretCodeDoor secretCodeDoor = (SecretCodeDoor)im.door;

                    if (!secretCodeDoor.isUnlock()) {

                        // TextInputDialog Composant
                        TextInputDialog code = new TextInputDialog();
                        code.setHeaderText("NEED A CODE");
                        code.getEditor().setPromptText("CODE");
                        code.showAndWait();
                        System.out.println(code.getResult());

                        // Unlock and open the door
                        secretCodeDoor.unlock(code.getResult());
                    }

                    if (secretCodeDoor.isUnlock()) {
                        game.heroIm.hero.setPlace(secretCodeDoor.getPlaces().get(key));
                        gridGame.removeChildrens();
                        gridGame.setMyPlace(game.myTransferRoom1);
                        gridGame.addChildrens();
                        // Room Title
                        labelTitle.setText(key);
                        // Label Info
                        labelScript.setText("You entered in " + game.heroIm.hero.getPlace().getName());
                    }
                }
                else {
                    game.heroIm.hero.go(key);
                    gridGame.removeChildrens();
                    gridGame.setMyPlace(game.myAnimalRoom);
                    gridGame.addChildrens();
                }

                break;
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
                    game.heroIm.hero.setPlace(secretCodeDoor.getDest());
                    gridGame.removeChildrens();
                    gridGame.setMyPlace(game.myTransferRoom1);
                    gridGame.addChildrens();
                    // Room Title
                    labelTitle.setText(secretCodeDoor.getDest().getName());
                    // Label Info
                    labelScript.setText("You entered in " + game.heroIm.hero.getPlace().getName());
                }
            } else  {
                game.heroIm.hero.go(im.door.getDest().getName());
                gridGame.removeChildrens();
                gridGame.setMyPlace(game.myAnimalRoom);
                gridGame.addChildrens();
            }
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

            switch (event.getCode()){
                // Move up
                case Z :
                    game.heroIm.setImage(new Image("assets/images/characters/CavemanBack.png"));
                break;
                // Move left
                case Q : break;
                // Move down
                case S :

                    game.heroIm.setImage(new Image("assets/images/characters/CavemanFix.png"));
                break;
                // Move right
                case D : break;
                // Tests
                case E :
                    // ================================ TEST
                    break;
                    // ============================= FIN TEST
                case T : cavemanTake(); break;
                default:break;
            }
           //TODO TEST SI Animaux sont sur la cellule
        });
    }

    // --- COMPOSANT ACTIONS ---

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

        labelTitle.setText(game.heroIm.hero.getPlace().getName());

        // GridGame ===

        // - Background
        setGridPane_mapBackground();

        gridGame.setMyPlace(game.myAnimalRoom);
        gridGame.addChildrens();
        // - Layout
        gridGame.add(game.heroIm,game.heroIm.x,game.heroIm.y);

        gridGameSetOnMousePressedEvent();

        // Caveman ===

        // - On mouse hover
        game.heroIm.setOnMouseEntered( event -> {
            game.heroIm.setImage(new Image("assets/images/characters/caveman.gif"));
        });

        // - On mouse exited
        game.heroIm.setOnMouseExited( event -> {
            game.heroIm.setImage(new Image("assets/images/characters/CavemanFix.png"));

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
    }

}
