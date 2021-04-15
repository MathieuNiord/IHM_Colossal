package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.others.Script;
import stage.MyStage;

import java.net.URL;
import java.util.ResourceBundle;

public class EndController implements Initializable {

    /** === ATTRIBUTES === **/

    public Label scriptLabel;
    public Button endButton;

    /** === METHODS === **/

    private void endButtonAction(){
        Stage currentStage = (Stage) endButton.getScene().getWindow();
        currentStage.close();
        MyStage myStage = new MyStage("../view/fxml/home.fxml");
        myStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.endButton.setOnAction(event -> endButtonAction());

        this.scriptLabel.setText(Script.CREDITS);
    }
}
