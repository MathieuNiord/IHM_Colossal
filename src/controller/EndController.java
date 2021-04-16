package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.others.Script;
import stage.MyStage;

import java.net.URL;
import java.util.ResourceBundle;

import static view.ressources.GameRessources.MY_FONT_16;

public class EndController implements Initializable {

    /** === ATTRIBUTES === **/

    public Label scriptLabel;
    public Button endButton;

    /** === METHODS === **/

    // - redirect to the home page -
    private void endButtonAction(){
        Stage currentStage = (Stage) endButton.getScene().getWindow();
        currentStage.close();
        MyStage myStage = new MyStage("../view/fxml/home.fxml");
        myStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.endButton.setOnAction(event -> endButtonAction());
        this.endButton.setFont(MY_FONT_16);

        this.scriptLabel.setText(Script.CREDITS);
        this.scriptLabel.setFont(MY_FONT_16);
    }
}
