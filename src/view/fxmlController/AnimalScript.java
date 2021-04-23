package view.fxmlController;

import controller.AnimalScriptController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimalScript implements Initializable {

    @FXML
    private ImageView imageAnimal;

    @FXML
    private Label labelScript;

    @FXML
    private Button buttonContinue;

    @FXML
    private Label labelName;

    @FXML
    void buttonContinueOnAction(ActionEvent event) {
        ((Stage) (this.buttonContinue.getScene().getWindow())).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new AnimalScriptController(this.imageAnimal, this.labelName, this.labelScript);
    }
}
