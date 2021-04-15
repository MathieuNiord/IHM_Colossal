package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import model.others.Game;
import model.others.Script;
import stage.MyStage;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {

    /** === ATTRIBUTES === **/

    public Label scriptLabel;
    public Button okButton;
    public TextArea textScript;

    /** === METHODS === **/

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
            MyStage myStage = new MyStage("../view/fxml/main.fxml");
            myStage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.okButton.setOnAction(event -> setOkButtonAction());

        this.scriptLabel.setText(Script.WELCOME_MESSAGE + Script.SYNOPSIS);
    }
}
