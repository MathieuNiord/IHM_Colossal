package view.fxmlController;

import controller.entities.EntitiesDatas;
import controller.entities.MyEntity;
import controller.entities.MyPlace;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import model.characters.Hero;
import model.doors.*;
import model.others.Script;
import view.classes.*;
import view.classes.minimap.MiniMap;
import view.ressources.ImageResources;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static controller.entities.EntitiesDatas.*;
import static view.ressources.GameResources.*;

    /* =====================================================================================================
    === The main controller : regroups all game interactions and controls the view (display) of the game ===
    ======================================================================================================== */

public class MainController implements Initializable {

    /** === ATTRIBUTES === **/

    @FXML
    private MyGridPane gridPaneGame;
    @FXML
    private Label labelTitle;
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
    private Label labelGame;
    @FXML
    private ProgressBar hp_bar;
    @FXML
    private Label labelLife;


    /** === METHODS === **/

    // --- -------------- --- //
    // --- Buttons Events --- //
    // --- -------------- --- //

    // - The "HELP" button event -
    @FXML
    private void buttonHelpOnAction(ActionEvent event) {
        labelGame.setText(Script.HELP_DEFAULT);
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
    }


    // --- ------------------- --- //
    // --- Player Interactions --- //
    // --- ------------------- --- //

    // - This function regroups all interaction's constraints of the player -
    private void heroInteractWithIm(MyEntity entity) {

        Hero hero = MY_HERO.getModel();

        // -- Animals --
        if (entity.animal_model != null){
            //Dialog
            new AnimalScript();
            MyDialog myStage = new MyDialog("../fxml/animal_script.fxml");
            myStage.showAndWait();
        }
        if (entity.monkey_model != null) labelGame.setText(entity.monkey_model.NAME.toUpperCase() + " : " + entity.monkey_model.dialog(hero));

        // -- Objects --
        if (entity.obj_model != null) {

            // If the object is a key (specific take() method)
            if (entity.obj_model.NAME.equals(Script.DEFAULT_KEY1_NAME) || entity.obj_model.NAME.equals(Script.DEFAULT_KEY2_NAME)) {

                MY_HERO.getModel().increaseKey();
                gridPaneGame.myRemove(entity.view);
                PLACE_TO_MY_PLACE.get(MY_HERO.getModel().getPlace()).getEntities().remove(entity);

                this.labelGame.setText("You found a key");
            }

            // Else if the object isn't the electric meter or the locker or a corpse, the player can take it in his inventory
            else if (!entity.obj_model.NAME.equals(Script.DEFAULT_ELECTRICMETER_NAME) && !entity.obj_model.NAME.equals(Script.DEFAULT_LOCKER_NAME) && !entity.obj_model.NAME.equals(Script.DEFAULT_CORPSE_NAME)) {

                //Banana case when the cold room is unlighted
                if (!entity.view.isVisible()) entity.view.setVisible(true);

                MY_HERO.addObj(entity, gridPaneGame);

                this.labelGame.setText("You found a " + entity.obj_model.NAME);
            }

            // Else if it is the locker
            else if (entity.obj_model.NAME.equals(Script.DEFAULT_LOCKER_NAME)) {

                MY_HERO.addObj(MY_WALKMAN, null);
                LOCKER_IM.setImage(ImageResources.IMAGE_LOCKER_OPENED);
                //flowPaneInventory.getChildren().add(WALKMAN_IM);

                this.labelGame.setText("You found a walkman");
            }
        }

        // -- Doors --
        if (entity.door_model != null) {
            this.interactWithDoor(entity, hero);
        }
    }

    private void interactWithDoor(MyEntity entity, Hero hero){

        //SecretCodeDoor case
        if (entity.door_model instanceof SecretCodeDoor) {

            SecretCodeDoor d = (SecretCodeDoor) entity.door_model;

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
                heroCrossDoor(entity, hero);
                labelTitle.setText(hero.getPlace().getName());
                gridPaneMap.refreshMap(PLACE_TO_MY_PLACE.get(hero.getPlace()));
            }
            else
                labelGame.setText(entity.door_model.getDescription());
        }

        else {
            labelGame.setText(entity.door_model.getDescription());

            heroCrossDoor(entity, hero);
            labelTitle.setText(hero.getPlace().getName());
            gridPaneMap.refreshMap(PLACE_TO_MY_PLACE.get(hero.getPlace()));
        }
    }


    // --- ----- --- //
    // --- Doors --- //
    // --- ----- --- //

    // - This function permits the player to cross doors -
    private void heroCrossDoor(MyEntity entity, Hero hero) {

        String dest = null;

        //First we get the good place
        for(String s : entity.door_model.getPlaces().keySet()) {
            if(!s.equals(hero.getPlace().getName())){
                dest = s;
                break;
            }
        }

        if(dest != null) {

            entity.door_model.cross(hero,dest);

            if (hero.getPlace().getName().equals(dest)) {

                MyPlace newPlace = PLACE_TO_MY_PLACE.get(hero.getPlace());
                gridPaneGame.setMyPlace(newPlace);

                labelGame.setText("You entered in the " + hero.getPlace().getName());

                //If the new place is the archive room, we set a position to the player
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

                //Else we compute the new position of the player in the room
                else this.heroPosDoor(newPlace, entity);
            }
        }
    }


    // --- ----- --- //
    // --- Place --- //
    // --- ----- --- //

    // - This function set the new position of the player after he crossed a specific door -
    private void heroPosDoor(MyPlace dest, MyEntity door) {

        MyImageView d = dest.getDoor(door).view;
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
           heroInteractWithIm(findEntityOnGridGame(im));
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
        MyEntity entityEnemy = (PLACE_TO_MY_PLACE.get(MY_HERO.getModel().getPlace())).getEnemy();

        if ( entityEnemy != null ){
            MyImageView enemy = entityEnemy.view;
            if ( (enemy.x == x + 2 && enemy.y == y) || (enemy.x == x - 2 && enemy.y == y)
                            || (enemy.x == x && enemy.y == y + 2) || (enemy.x == x && enemy.y == y - 2)
                            || (enemy.x == x + 2 && enemy.y == y + 2) || (enemy.x == x - 2 && enemy.y == y - 2)
                            || (enemy.x == x - 2 && enemy.y == y + 2) || (enemy.x == x + 2 && enemy.y == y - 2)
            ) {
                res = true;

                //Battle
                new BattleController();
                MyDialog myStage = new MyDialog("../fxml/battle.fxml");
                myStage.showAndWait();
                this.gridPaneGame.setMyPlace(PLACE_TO_MY_PLACE.get(MY_HERO.getModel().getPlace()));
            }
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
    @FXML
    private void gridPaneGameSetOnMouseClickedEvent(MouseEvent event){
        try{
            MyImageView im = (MyImageView) event.getTarget();
            MyEntity entity = EntitiesDatas.findEntity(im);

            if (entity.obj_model != null) labelGame.setText(entity.obj_model.INFO);
            if (entity.animal_model != null) labelGame.setText(entity.animal_model.DESCRIPTION);
            if (entity.monkey_model != null) labelGame.setText(entity.monkey_model.DESCRIPTION);
            if (entity.enemy_model != null) labelGame.setText(entity.enemy_model.DESCRIPTION);

        } catch (Exception ignored){
            labelGame.setText("Hum...Did you just click on nothing ?");
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
            MyEntity entity = EntitiesDatas.findEntity(im);
            if (event.getClickCount() == 2) {

                if (entity.obj_model != null) {

                    entity.obj_model.use(MY_HERO.getModel());

                    if (entity.obj_model.NAME.equals(Script.DEFAULT_POTION_NAME) ||
                            entity.obj_model.NAME.equals(Script.DEFAULT_NAZIPOSTER_NAME) ||
                            entity.obj_model.NAME.equals(Script.DEFAULT_SEXYPOSTER_1_NAME) ||
                            entity.obj_model.NAME.equals(Script.DEFAULT_SEXYPOSTER_2_NAME)
                    ) flowPaneInventory.getChildren().remove(im);

                    labelObjectName.setText("");
                    labelObjectInfo.setText("");
                }
            }

            else {
                if (entity.obj_model != null) {

                    String name = entity.obj_model.NAME;
                    String capName = name.substring(0, 1).toUpperCase() + name.substring(1);

                    labelObjectName.setText(capName);
                    labelObjectInfo.setText(entity.obj_model.INFO);
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
        labelTitle.setText(MY_HERO.getModel().getPlace().getName());
        new InventoryController(flowPaneInventory);
        initListener();

        //Set the inventory of the player
        HERO_IM.setInv(flowPaneInventory);

        //Fonts
        labelTitle.setFont(MY_FONT_64);
        labelGame.setFont(MY_FONT_16);
        labelObjectInfo.setFont(MY_FONT_32);
        labelObjectName.setFont(MY_FONT_32);
        buttonHelp.setFont(MY_FONT_16);
        buttonQuit.setFont(MY_FONT_16);
        labelLife.setFont(MY_FONT_16);

        // bindings
        hp_bar.progressProperty().bind(MY_HERO.getModel().getHpDoubleProperty().divide(100.0));
        Bindings.bindBidirectional(labelLife.textProperty(), MY_HERO.getModel().getHpDoubleProperty(), new NumberStringConverter());

    }
}