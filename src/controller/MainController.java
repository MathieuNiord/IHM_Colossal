package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.others.Game;
import model.others.Script;
import stage.MyStage;
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
    private GridPane gridPaneMap;

    @FXML
    private ImageView deserted_room;

    @FXML
    private ImageView condamned_sas;

    @FXML
    private ImageView mortuary;

    @FXML
    private ImageView product_reserve;

    @FXML
    private ImageView garbage_room;

    @FXML
    private ImageView experiments_room;

    @FXML
    private ImageView cold_room;

    @FXML
    private ImageView dirty_changing_room;

    @FXML
    private ImageView transfer_room;

    @FXML
    private ImageView meeting_room;

    @FXML
    private ImageView archives_room;

    @FXML
    private ImageView animal_room;

    @FXML
    private ImageView changing_room;

    @FXML
    private ImageView entry;

    @FXML
    private ImageView decontamination_room;

    @FXML
    private ImageView exit;

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

                boolean containObject = false; //new pos contain an entity/object

                for (MyImageView im: gridPaneGame.getMyPlace().getImages()) {
                    if(im.x==newValue.intValue() && im.y == GameRessources.heroIm.y.getValue()){
                        containObject = true;
                        if(im.animal!=null){
                            im.animal.talk(GameRessources.heroIm.hero);
                        }
                        if(im.obj!=null){
                            im.obj.take(GameRessources.heroIm.hero);
                            gridPaneGame.getChildren().remove(im);
                            flowPaneInventory.getChildren().add(im);
                        }
                        break;
                    }
                }

                if(newValue.intValue()<gridPaneGame.getMyPlace().getMaxXBound() &&
                        newValue.intValue()>gridPaneGame.getMyPlace().getMinXBound() && !containObject){
                    gridPaneGame.getChildren().remove(GameRessources.heroIm);
                    gridPaneGame.add(GameRessources.heroIm,newValue.intValue(),GameRessources.heroIm.y.getValue());
                }
                else{
                    GameRessources.heroIm.x.setValue(oldValue);
                }
            }
        });
        GameRessources.heroIm.y.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                boolean containObject = false; //new pos contain an entity/object

                    int x = GameRessources.heroIm.x.getValue();
                    int y = newValue.intValue();
                    MyImageView im = gridPaneGame.getPositions().get((y)*8+ x);
                    if(im!=null){

                    }


                if(newValue.intValue()<gridPaneGame.getMyPlace().getMaxYBound() &&
                        newValue.intValue()>gridPaneGame.getMyPlace().getMinYBound() && !containObject){
                    gridPaneGame.getChildren().remove(GameRessources.heroIm);
                    gridPaneGame.add(GameRessources.heroIm,GameRessources.heroIm.x.getValue(),newValue.intValue());
                }
                else{
                    GameRessources.heroIm.y.setValue(oldValue);
                }
            }
        });
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        inputDialogUserName().ifPresent(Game::new);
        new GameRessources();
        gridPaneGame.setMyPlace(GameRessources.myAnimalRoom);
        new GameRessoursesController();
        initListener();
        System.setOut(new PrintStream(new OutputStream() {
                    @Override
                    public void write(int b) {labelScript.setText(labelScript.getText() + (char) b); }}));

    }
}

