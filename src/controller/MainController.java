package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.characters.Hero;
import model.doors.SecretCodeDoor;
import model.others.Script;
import view.classes.minimap.MiniMap;
import view.classes.MyGridPane;
import view.classes.MyImageView;
import view.ressources.ImageRessources;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static view.ressources.GameRessources.*;

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

    /** === METHODS === **/

    // --- Events ---

    // - The "HELP" button event -
    @FXML
    private void buttonHelpOnAction(ActionEvent event) {
        //TODO popup help
    }

    // - The "QUIT" button event -
    @FXML
    private void buttonQuitOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Leave the game ?");
        alert.setContentText("Are you sure you want to leave ? ");
        //ButtonType b1 = new ButtonType("Menu");
        ButtonType b2 = new ButtonType("Quit");
        ButtonType b3 = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll( b2, b3);

        Optional<ButtonType> result = alert.showAndWait();
        /*if (result.get() == b1){
            try{
                Stage stage = (Stage) buttonQuit.getScene().getWindow();
                stage.close();
                MyStage s = new MyStage("../view/fxml/home.fxml");
                s.show();
            }
            catch (Exception ignored){}
        }
        else */
        if (result.get() == b2) {
            Stage stage = (Stage) buttonQuit.getScene().getWindow();
            stage.close();
        }
    }

    // - Initialization of controller's listeners -
    private void initListener(){

        HERO_IM.x.addListener((observable, oldValue, newValue) -> {
            boolean collision =false;
            int x = newValue.intValue();
            int y = HERO_IM.y.getValue();
            MyImageView im = gridPaneGame.getPositions().get((y)*8+ x);
            if(im!=null){
                heroInteractWithIm(im);
                collision=true;

            }

            if(x<gridPaneGame.getMyPlace().getMaxXBound() && x>gridPaneGame.getMyPlace().getMinXBound() && !collision){
                gridPaneGame.getChildren().remove(HERO_IM);
                gridPaneGame.add(HERO_IM,x,y);
            }
            else{
                HERO_IM.x.setValue(oldValue);
            }
        });
        HERO_IM.y.addListener((observable, oldValue, newValue) -> {
            boolean collision =false;
            int x = HERO_IM.x.getValue();
            int y = newValue.intValue();
            MyImageView im = gridPaneGame.getPositions().get((y)*8+ x);
            if(im!=null){
                heroInteractWithIm(im);
                collision =true;

            }

            if(y<gridPaneGame.getMyPlace().getMaxYBound() && y>gridPaneGame.getMyPlace().getMinYBound() && !collision){
                gridPaneGame.getChildren().remove(HERO_IM);
                gridPaneGame.add(HERO_IM,x,y);
            }
            else{
                HERO_IM.y.setValue(oldValue);
            }
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

    // --- Player ---

    // - This function regroups all interaction's constraints of the player -
    private void heroInteractWithIm(MyImageView im) {
        Hero hero = HERO_IM.hero;
        if(im.animal!=null){ //interaction avec animal
            im.animal.talk(hero);
        }
        if(im.monkey!=null)im.monkey.talk(hero);
        if(im.obj!=null){ //interaction avec objet
            im.obj.take(hero);
            im.obj.setDraggableTrue();
            //l'objet eletricMeter n'est pas prennable
            if(im.obj.NAME.equals(Script.DEFAULT_LOCKER_NAME)){

            }
            else if(!im.obj.NAME.equals(Script.DEFAULT_ELECTRICMETER_NAME)){
                gridPaneGame.myRemove(im);
                flowPaneInventory.getChildren().add(im);
            }
        }
        if(im.door!=null){//interaction avec des portes
            if(im.door instanceof SecretCodeDoor){ //cas particulier de la SecretCodeDoor
                SecretCodeDoor d = (SecretCodeDoor) im.door;
                if(!d.isUnlock()){
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
            }
            else  {
                heroCrossDoor(im, hero);
                labelTitle.setText(hero.getPlace().getName());
                gridPaneMap.refreshMap(PLACE_TO_MY_PLACE.get(hero.getPlace()));
            }
        }
    }

    // - This function permits the player to cross doors -
    private void heroCrossDoor(MyImageView im, Hero hero) {
        String dest = null;
        for(String s : im.door.getPlaces().keySet()) {
            if(!s.equals(hero.getPlace().getName())){
                dest = s;
                System.out.println(dest);
                break;
            }
        }
        if(dest!=null){
            im.door.cross(hero,dest);
            gridPaneGame.setMyPlace(PLACE_TO_MY_PLACE.get(hero.getPlace()));
        }
    }

    // - Here we got all actions the player can make during the game -
    @FXML
    void paneMainOnKeyPressed(KeyEvent event) {
        switch (event.getCode()){
            case Z:
                HERO_IM.y.setValue(HERO_IM.y.getValue()-1);
                HERO_IM.setImage(ImageRessources.IMAGE_CAVEMAN_BACK);
                break;
            case Q:
                HERO_IM.x.setValue(HERO_IM.x.getValue()-1); break;
            case S:
                HERO_IM.y.setValue(HERO_IM.y.getValue()+1);
                HERO_IM.setImage(ImageRessources.IMAGE_CAVEMAN_FRONT);
                break;
            case D:
                HERO_IM.x.setValue(HERO_IM.x.getValue()+1); break;
            case T:
        }
    }

    // - Manage events in the Inventory -
    @FXML
    private void flowPaneInventorySetOnMouseClickedEvent(MouseEvent event){
        try {
            MyImageView im = (MyImageView)event.getTarget();
            if(event.getClickCount()==2) {
                if (im.obj != null) {
                    im.obj.use(HERO_IM.hero);
                    if (im.obj.NAME.equals(Script.DEFAULT_POTION_NAME) ||
                        im.obj.NAME.equals(Script.DEFAULT_NAZIPOSTER_NAME) ||
                        im.obj.NAME.equals(Script.DEFAULT_SEXYPOSTER_NAME)
                    ) flowPaneInventory.getChildren().remove(im);
                }
            }

            else {
                if (im.obj != null) {
                    labelObjectName.setText(((MyImageView) event.getTarget()).obj.NAME);
                    labelObjectInfo.setText(((MyImageView) event.getTarget()).obj.INFO);
                }
            }

        } catch (Exception ignored){
            labelObjectName.setText("");
            labelObjectInfo.setText("");
        }
    }

    // - Look action :
    @FXML
    private void gridPaneGameSetOnMouseClickedEvent(MouseEvent event){
        try{
            MyImageView im = (MyImageView)event.getTarget();
            System.out.println(event.getClickCount());
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
    // --- Initialization of the controller ---

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gridPaneGame.setMyPlace(MY_ANIMAL_ROOM);
        gridPaneMap.refreshMap(MY_ANIMAL_ROOM);
        new GameResourcesController(flowPaneInventory);
        initListener();
    }
}

