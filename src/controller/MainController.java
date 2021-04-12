package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.others.Game;
import stage.MyStage;
import view.ressources.GameRessources;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Pane paneMain;

    @FXML
    private GridPane gridPaneGame;

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

    @FXML
    void paneMainOnKeyPressed(KeyEvent event) {

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
        gridPaneGame = GameRessources.gridPaneAnimalRoom;
    }
}

