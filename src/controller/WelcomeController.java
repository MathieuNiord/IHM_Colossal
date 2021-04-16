package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import model.others.Game;
import model.others.Script;
import stage.MyStage;
import view.classes.Dialog;

import java.net.URL;
import java.util.ResourceBundle;

import static view.ressources.GameRessources.MY_FONT_16;
import static view.ressources.GameRessources.MY_FONT_32;

public class WelcomeController implements Initializable {

    /** === ATTRIBUTES === **/

    public Label scriptLabel;
    public Button okButton;

    /** === METHODS === **/

    // - when ok is pressed we ask the name of the player and redirect to the main.fxml -
    private void setOkButtonAction(){

        //TextInputDialog configuration
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Choose your name please");
        dialog.setContentText("Please enter your name:");
        dialog.showAndWait();

        if (dialog.getResult() != null && !dialog.getResult().equals("")) {
            new Game(dialog.getResult());
            Stage currentStage = (Stage) okButton.getScene().getWindow();
            currentStage.close();
            Dialog myStage = new Dialog("../fxml/main.fxml");
            //MyStage myStage = new MyStage("../view/fxml/main.fxml");
            myStage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.okButton.setOnAction(event -> setOkButtonAction());
        this.okButton.setFont(MY_FONT_16);

        this.scriptLabel.setText(Script.WELCOME_MESSAGE + Script.SYNOPSIS);
        this.scriptLabel.setFont(MY_FONT_32);
    }
}
