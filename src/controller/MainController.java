package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.characters.Hero;
import model.doors.SecretCodeDoor;
import model.others.Game;
import model.others.Script;
import stage.MyStage;
import view.classes.MiniMap;
import view.classes.MyGridPane;
import view.classes.MyImageView;
import view.ressources.GameRessources;
import view.ressources.ImageRessources;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

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
    private Label labelScript;


    @FXML
    void buttonHelpOnAction(ActionEvent event) {
        //TODO popup help
    }

    @FXML
    void buttonQuitOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Leave the game ?");
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

    //fonction qui initialise les listeners
    private void initListener(){


        GameRessources.heroIm.x.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                boolean collision =false;
                int x = newValue.intValue();
                int y = GameRessources.heroIm.y.getValue();
                MyImageView im = gridPaneGame.getPositions().get((y)*8+ x);
                if(im!=null){
                    heroInteractWithIm(im);
                    collision=true;

                }

                if(x<gridPaneGame.getMyPlace().getMaxXBound() && x>gridPaneGame.getMyPlace().getMinXBound() && !collision){
                    gridPaneGame.getChildren().remove(GameRessources.heroIm);
                    gridPaneGame.add(GameRessources.heroIm,x,y);
                }
                else{
                    GameRessources.heroIm.x.setValue(oldValue);
                }
            }
        });
        GameRessources.heroIm.y.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                boolean collision =false;
                int x = GameRessources.heroIm.x.getValue();
                int y = newValue.intValue();
                MyImageView im = gridPaneGame.getPositions().get((y)*8+ x);
                if(im!=null){
                    heroInteractWithIm(im);
                    collision =true;

                }

                if(y<gridPaneGame.getMyPlace().getMaxYBound() && y>gridPaneGame.getMyPlace().getMinYBound() && !collision){
                    gridPaneGame.getChildren().remove(GameRessources.heroIm);
                    gridPaneGame.add(GameRessources.heroIm,x,y);
                }
                else{
                    GameRessources.heroIm.y.setValue(oldValue);
                }
            }
        });
    }



    private void heroInteractWithIm(MyImageView im) {
        Hero hero = GameRessources.heroIm.hero;
        if(im.animal!=null){ //interaction avec animal
            im.animal.talk(hero);
        }
        if(im.obj!=null){ //interaction avec objet
            im.obj.take(hero);
            //l'objet eletricMeter n'est pas prennable
            if(!im.obj.NAME.equals(Script.DEFAULT_ELECTRICMETER_NAME)){
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
                }
            }
            else  {
                heroCrossDoor(im, hero);
                labelTitle.setText(hero.getPlace().getName());
            }
        }
    }

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
            gridPaneGame.setMyPlace(GameRessources.placeToMyPlace.get(hero.getPlace()));
        }
    }

    @FXML
    void paneMainOnKeyPressed(KeyEvent event) {
        switch (event.getCode()){
            case Z:
                GameRessources.heroIm.y.setValue(GameRessources.heroIm.y.getValue()-1);
                GameRessources.heroIm.setImage(ImageRessources.IMAGE_CAVEMAN_BACK);
                break;
            case Q:GameRessources.heroIm.x.setValue(GameRessources.heroIm.x.getValue()-1); break;
            case S:
                GameRessources.heroIm.y.setValue(GameRessources.heroIm.y.getValue()+1);
                GameRessources.heroIm.setImage(ImageRessources.IMAGE_CAVEMAN_FRONT);
                break;
            case D:GameRessources.heroIm.x.setValue(GameRessources.heroIm.x.getValue()+1); break;
            case T:
        }
    }

    private Optional<String> inputDialogUserName(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Choose your name please");
        dialog.setContentText("Please enter your name:");
        return dialog.showAndWait();
    }



    @FXML
    private void flowPaneInventorySetOnMousePressedEvent(MouseEvent event){
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
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        inputDialogUserName().ifPresent(Game::new);
        new GameRessources();
        gridPaneGame.setMyPlace(GameRessources.myAnimalRoom);
        new GameRessoursesController(flowPaneInventory);
        initListener();
        System.setOut(new PrintStream(new OutputStream() {
                    @Override
                    public void write(int b) { labelScript.setText(labelScript.getText() + (char) b); }}));
    }


}

