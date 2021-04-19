package controller;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.characters.Hero;
import model.doors.SecretCodeDoor;
import model.others.Script;
import view.classes.MyDialog;
import view.classes.MyPlace;
import view.classes.minimap.MiniMap;
import view.classes.MyGridPane;
import view.classes.MyImageView;
import view.ressources.ImageResources;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static view.ressources.GameResources.*;

    /* =====================================================================================================
    === The main controller : regroups all game interactions and controls the view (display) of the game ===
    ======================================================================================================== */

public class MainController implements Initializable {

    /** === ATTRIBUTES === **/

    @FXML
    private Pane paneMain;
    @FXML
    private MyGridPane gridPaneGame;
    @FXML
    private Label labelTitle;
    @FXML
    private TabPane tabPane;
    @FXML
    private Label labelObjectName;
    @FXML
    private Label labelObjectInfo;
    @FXML
    private FlowPane flowPaneInventory;
    @FXML
    private MiniMap gridPaneMap;
    @FXML
    private Button buttonQuit;
    @FXML
    private Button buttonHelp;
    @FXML
    private TextArea textAreaScript;
    @FXML
    public ProgressBar hp_bar;

    /** === METHODS === **/

    // --- -------------- --- //
    // --- Buttons Events --- //
    // --- -------------- --- //

    // - The "HELP" button event -
    @FXML
    private void buttonHelpOnAction(ActionEvent event) {
        textAreaScript.appendText(Script.HELP_DEFAULT);
    }

    // - The "QUIT" button event -
    @FXML
    private void buttonQuitOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Leave the game ?");
        alert.setContentText("Are you sure you want to leave ? ");
        ButtonType b1 = new ButtonType("Quit");
        ButtonType b2 = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll( b1, b2);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == b1) {
            Stage stage = (Stage) buttonQuit.getScene().getWindow();
            stage.close();
        }
    }

    // - Initialization of controller's listeners -
    private void initListener(){

        HERO_IM.x.addListener((observable, oldValue, newValue) -> {
            gridPaneGame.getChildren().remove(HERO_IM);
            gridPaneGame.add(HERO_IM,newValue.intValue(),HERO_IM.y.getValue());
        });

        HERO_IM.y.addListener((observable, oldValue, newValue) -> {
            gridPaneGame.getChildren().remove(HERO_IM);
            gridPaneGame.add(HERO_IM,HERO_IM.x.getValue(),newValue.intValue());
        });

       //textAreaScript :
        OutputStream o = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textAreaScript.appendText(String.valueOf((char)b));
            }
        };
        System.setOut(new PrintStream(o));

        textAreaScript.textProperty().addListener((observable, oldValue, newValue) -> textAreaScript.setScrollTop(Double.MAX_VALUE));
    }


    // --- ------------------- --- //
    // --- Player Interactions --- //
    // --- ------------------- --- //

    // - This function regroups all interaction's constraints of the player -
    private void heroInteractWithIm(MyImageView im) {

        Hero hero = HERO_IM.hero;

        // -- Animals --
        if (im.animal != null) im.animal.talk(hero);

        if (im.monkey != null) im.monkey.talk(hero);

        // -- Objects --
        if (im.obj != null) {

            // If the object is a key (specific take() method)
            if (im.obj.NAME.equals(Script.DEFAULT_KEY1_NAME) || im.obj.NAME.equals(Script.DEFAULT_KEY2_NAME)) {
                HERO_IM.hero.increaseKey();
                gridPaneGame.myRemove(im);
                this.textAreaScript.setText("You found a key");
            }

            // Else if the object isn't the electric meter or the locker or a corpse, the player can take it in his inventory
            else if (!im.obj.NAME.equals(Script.DEFAULT_ELECTRICMETER_NAME) && !im.obj.NAME.equals(Script.DEFAULT_LOCKER_NAME) && !im.obj.NAME.equals(Script.DEFAULT_CORPSE_NAME)) {
                im.obj.take(hero);
                im.obj.setDraggableTrue();
                im.setCursor(Cursor.HAND);
                gridPaneGame.myRemove(im);
                flowPaneInventory.getChildren().add(im);
                this.textAreaScript.setText("You found a " + im.obj.NAME);
            }

            // Else if it is the locker
            else if (im.obj.NAME.equals(Script.DEFAULT_LOCKER_NAME)) {
                LOCKER_IM.setImage(ImageResources.IMAGE_LOCKER_OPENED);
                flowPaneInventory.getChildren().add(WALKMAN_IM);
                this.textAreaScript.setText("You found a walkman");
            }
        }

        // -- Doors --
        if (im.door != null) {

            if (im.door instanceof SecretCodeDoor) { //SecretCodeDoor case

                SecretCodeDoor d = (SecretCodeDoor) im.door;

                if (!d.isUnlock()) {

                    // TextInputDialog Component
                    TextInputDialog code = new TextInputDialog();
                    code.setHeaderText("NEED A CODE");
                    code.getEditor().setPromptText("CODE");
                    code.showAndWait();

                    // Unlock and open the door
                    d.unlock(code.getResult());
                }

                if (d.isUnlock()) {
                    heroCrossDoor(im, hero);
                    labelTitle.setText(hero.getPlace().getName());
                    gridPaneMap.refreshMap(PLACE_TO_MY_PLACE.get(hero.getPlace()));
                }
            } else {
                heroCrossDoor(im, hero);
                labelTitle.setText(hero.getPlace().getName());
                gridPaneMap.refreshMap(PLACE_TO_MY_PLACE.get(hero.getPlace()));
            }
        }
    }


    // --- ----- --- //
    // --- Doors --- //
    // --- ----- --- //

    // - This function permits the player to cross doors -
    private void heroCrossDoor(MyImageView im, Hero hero) {
        String dest = null;
        for(String s : im.door.getPlaces().keySet()) {
            if(!s.equals(hero.getPlace().getName())){
                dest = s;
                break;
            }
        }
        if(dest!=null){
            im.door.cross(hero,dest);
            if(hero.getPlace().getName().equals(dest)){
                MyPlace newPlace = PLACE_TO_MY_PLACE.get(hero.getPlace());
                gridPaneGame.setMyPlace(newPlace);
                if (dest.equals("archives room")) {
                    HERO_IM.x.setValue(4);
                    HERO_IM.y.setValue(1);
                }

                //Else we check if the hero is in the last room
                else if (dest.equals("exit")) {
                    if (hero.isAlive() && !hero.isQuit()) {
                        Stage currentStage = (Stage) this.gridPaneGame.getScene().getWindow();
                        currentStage.close();
                        MyDialog end = new MyDialog("../fxml/end.fxml");
                        end.show();
                    }
                }

                else this.heroPosDoor(newPlace, im);
            }
        }
    }


    // --- ----- --- //
    // --- Place --- //
    // --- ----- --- //

    // - This function set the new position of the player after he crossed a specific door -
    private void heroPosDoor(MyPlace dest, MyImageView door) {

        MyImageView d = dest.getDoor(door);
        int newX = d.x;
        int newY =d.y;

        if (newY == 0) {
            HERO_IM.x.setValue(newX);
            HERO_IM.y.setValue(newY + 1);
        }
        else if (newY == dest.getMaxYBound()) {
            HERO_IM.x.setValue(newX);
            HERO_IM.y.setValue(newY - 1);
        }
        else if (newX == dest.getMinXBound()) {
            HERO_IM.x.setValue(newX + 1);
            HERO_IM.y.setValue(newY);
        }
        else if (newX == dest.getMaxXBound()) {
            HERO_IM.x.setValue(newX - 1);
            HERO_IM.y.setValue(newY);
        }
    }

    // - check if the position contain an entity in the map -
    private boolean isPositionContainsEntity(int x, int y){

        boolean ans = false;
        MyImageView im = gridPaneGame.getPositions().get((y) * 9 + x);

        if(im != null){
           ans =true;
           heroInteractWithIm(im);
        }

        //Out of bounds case
        if(!(x < gridPaneGame.getMyPlace().getMaxXBound() && x > gridPaneGame.getMyPlace().getMinXBound() &&
                y < gridPaneGame.getMyPlace().getMaxYBound() && y > gridPaneGame.getMyPlace().getMinYBound())) {
            ans = true;
        }

        return ans;
    }

    // - If the player approach an enemy, there's a battle -
    private boolean isPosContainsEnemy(int x, int y) {

        boolean res = false;
        MyImageView enemy = PLACE_TO_MY_PLACE.get(HERO_IM.hero.getPlace()).getEnemy();

        if (enemy != null && (
                (enemy.x == x + 2 && enemy.y == y) || (enemy.x == x - 2 && enemy.y == y)
                || (enemy.x == x && enemy.y == y + 2) || (enemy.x == x && enemy.y == y - 2)
                || (enemy.x == x + 2 && enemy.y == y + 2) || (enemy.x == x - 2 && enemy.y == y - 2)
                || (enemy.x == x - 2 && enemy.y == y + 2) || (enemy.x == x + 2 && enemy.y == y - 2)
            )
        ) {
            res = true;

            //Battle
            new BattleController();
            MyDialog myStage = new MyDialog("../fxml/battle.fxml");
            myStage.showAndWait();
            this.gridPaneGame.setMyPlace(PLACE_TO_MY_PLACE.get(HERO_IM.hero.getPlace()));
        }

        return res;
    }


    // --- ------------------------- --- //
    // --- Keyboard and Mouse Events --- //
    // --- ------------------------- --- //

    // - Here we got all actions the player can make during the game -
    @FXML
    void paneMainOnKeyPressed(KeyEvent event) {
        int x = HERO_IM.x.getValue();
        int y = HERO_IM.y.getValue();
        switch (event.getCode()){
            case Z: {
                if(!isPositionContainsEntity(x,y-1) && !isPosContainsEnemy(x, y - 1)) {
                    HERO_IM.y.setValue(HERO_IM.y.getValue()-1);
                }
                HERO_IM.setImage(ImageResources.IMAGE_CAVEMAN_DEFAULT_BACK);
                break;
            }
            case Q: {
                if (!isPositionContainsEntity(x - 1, y) && !isPosContainsEnemy(x - 1, y)) {
                    HERO_IM.x.setValue(HERO_IM.x.getValue() - 1);
                }
                HERO_IM.setImage(ImageResources.IMAGE_CAVEMAN_DEFAULT_LEFT);
                break;
            }
            case S: {
                if (!isPositionContainsEntity(x , y+1) && !isPosContainsEnemy(x, y + 1)) {
                    HERO_IM.y.setValue(HERO_IM.y.getValue() + 1);
                }
                HERO_IM.setImage(ImageResources.IMAGE_CAVEMAN_DEFAULT_FRONT);
                break;
            }
            case D: {
                if (!isPositionContainsEntity(x +1, y) && !isPosContainsEnemy(x + 1, y)) {
                    HERO_IM.x.setValue(HERO_IM.x.getValue() + 1);
                }
                HERO_IM.setImage(ImageResources.IMAGE_CAVEMAN_DEFAULT_RIGHT);
                break;
            }
        }
    }

    // - Look action -
    // TODO : Quand on clique sur la pièce, alors on affiche une description de la pièce
    @FXML
    private void gridPaneGameSetOnMouseClickedEvent(MouseEvent event){
        try{
            MyImageView im = (MyImageView)event.getTarget();
            if(im.obj != null){
                if(im.obj.NAME.equals(Script.DEFAULT_LOCKER_NAME)){
                    flowPaneInventory.getChildren().add(WALKMAN_IM);
                }
                im.obj.look();
            }
            if(im.animal != null) im.animal.look();
            if(im.monkey != null) im.monkey.look();
            if(im.enemy!=null) im.enemy.look();


        } catch (Exception ignored){
            labelObjectName.setText("");
            labelObjectInfo.setText("");
        }
    }


    // --- --------- --- //
    // --- Inventory --- //
    // --- --------- --- //

    // - Manage events in the Inventory -
    @FXML
    private void flowPaneInventorySetOnMouseClickedEvent(MouseEvent event) {
        try {
            MyImageView im = (MyImageView) event.getTarget();
            if (event.getClickCount() == 2) {

                if (im.obj != null) {

                    im.obj.use(HERO_IM.hero);

                    if (im.obj.NAME.equals(Script.DEFAULT_POTION_NAME) ||
                            im.obj.NAME.equals(Script.DEFAULT_NAZIPOSTER_NAME) ||
                            im.obj.NAME.equals(Script.DEFAULT_SEXYPOSTER_1_NAME) ||
                            im.obj.NAME.equals(Script.DEFAULT_SEXYPOSTER_2_NAME)
                    ) flowPaneInventory.getChildren().remove(im);
                }
            }

            else {
                if (im.obj != null) {

                    String name = ((MyImageView) event.getTarget()).obj.NAME;
                    String capName = name.substring(0, 1).toUpperCase() + name.substring(1);

                    labelObjectName.setText(capName);
                    labelObjectInfo.setText(((MyImageView) event.getTarget()).obj.INFO);
                }
            }

        } catch (Exception ignored) {
            labelObjectName.setText("");
            labelObjectInfo.setText("");
        }
    }


    // --- -------------------------------- --- //
    // --- Initialization of the controller --- //
    // --- -------------------------------- --- //

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Initialization
        gridPaneGame.setMyPlace(MY_ANIMAL_ROOM);
        gridPaneMap.refreshMap(MY_ANIMAL_ROOM);
        labelTitle.setText(HERO_IM.hero.getPlace().getName());
        new InventoryController(flowPaneInventory);
        initListener();
        HERO_IM.setInv(flowPaneInventory);

        //Fonts
        labelTitle.setFont(MY_FONT_64);
        textAreaScript.setFont(MY_FONT_16);
        labelObjectInfo.setFont(MY_FONT_32);
        labelObjectName.setFont(MY_FONT_32);
        buttonHelp.setFont(MY_FONT_16);
        buttonQuit.setFont(MY_FONT_16);

        Bindings.bindBidirectional(hp_bar.progressProperty(), HERO_IM.hero.getHpProperty());
    }
}