package view.fxmlController;

import controller.GameController;
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

public class MyGame implements Initializable {

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

    private GameController gameController;


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

    // --- ----- --- //
    // --- Place --- //
    // --- ----- --- //

    // - This function set the new position of the player after he crossed a specific door -
    public void heroPosDoor(MyPlace dest, MyEntity door) {

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
            gameController.heroInteractWithIm(findEntityOnGridGame(im));
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
                new Battle();
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
                if (MY_HERO.getModel().getObjs().containsKey(Script.DEFAULT_CLUB_NAME))
                    HERO_IM.setImage(ImageResources.IMAGE_ARMED_CAVEMAN_BACK);
                else
                    HERO_IM.setImage(ImageResources.IMAGE_CAVEMAN_DEFAULT_BACK);
                break;
            }
            case Q: {
                if (!isPositionContainsEntity(x - 1, y) && !isPosContainsEnemy(x - 1, y)) {
                    HERO_IM.x.setValue(HERO_IM.x.getValue() - 1);
                }
                if (MY_HERO.getModel().getObjs().containsKey(Script.DEFAULT_CLUB_NAME))
                    HERO_IM.setImage(ImageResources.IMAGE_ARMED_CAVEMAN_LEFT);
                else
                    HERO_IM.setImage(ImageResources.IMAGE_CAVEMAN_DEFAULT_LEFT);
                break;
            }
            case S: {
                if (!isPositionContainsEntity(x , y+1) && !isPosContainsEnemy(x, y + 1)) {
                    HERO_IM.y.setValue(HERO_IM.y.getValue() + 1);
                }
                if (MY_HERO.getModel().getObjs().containsKey(Script.DEFAULT_CLUB_NAME))
                    HERO_IM.setImage(ImageResources.IMAGE_ARMED_CAVEMAN_FRONT);
                else
                    HERO_IM.setImage(ImageResources.IMAGE_CAVEMAN_DEFAULT_FRONT);
                break;
            }
            case D: {
                if (!isPositionContainsEntity(x +1, y) && !isPosContainsEnemy(x + 1, y)) {
                    HERO_IM.x.setValue(HERO_IM.x.getValue() + 1);
                }
                if (MY_HERO.getModel().getObjs().containsKey(Script.DEFAULT_CLUB_NAME))
                    HERO_IM.setImage(ImageResources.IMAGE_ARMED_CAVEMAN_RIGHT);
                else
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

                gameController.useObj(entity);
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

    // --- ------- --- //
    // --- Setters --- //
    // --- ------- --- //
    public void setOnGameLabel(String text){
        this.labelGame.setText(text);
    }

    public void setOnGameTitle(String text){
        this.labelTitle.setText(text);
    }

    public void setNewPlace(MyPlace myPlace){
        gridPaneGame.setMyPlace(myPlace);
    }

    public void removeOnGridPane(MyImageView im){
        this.gridPaneGame.myRemove(im);
    }

    public void refreshMap(){ gridPaneMap.refreshMap(PLACE_TO_MY_PLACE.get(MY_HERO.getModel().getPlace()));}

    public void setOnDescObj(String title, String desc){
        labelObjectName.setText(title);
        labelObjectInfo.setText(desc);
    }

    public void exitGame(){
        Stage currentStage = (Stage) this.gridPaneGame.getScene().getWindow();
        currentStage.close();
        MyDialog end = new MyDialog("../fxml/end.fxml");
        end.show();
    }

    // --- -------------------------------- --- //
    // --- Initialization of the controller --- //
    // --- -------------------------------- --- //

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Initialization
        gameController = new GameController(this);
        gridPaneGame.setMyPlace(MY_ANIMAL_ROOM);
        gridPaneMap.refreshMap(MY_ANIMAL_ROOM);
        labelTitle.setText(MY_HERO.getModel().getPlace().getName());
        new InventoryDragInit(gameController);

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