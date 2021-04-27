package view.fxmlController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.classes.MyStage;

import java.net.URL;
import java.util.ResourceBundle;

public class Credit implements Initializable {

    @FXML
    private Button button_menu;

    @FXML
    void quit(ActionEvent event) {
        Stage currentStage = (Stage) button_menu.getScene().getWindow();
        currentStage.close();
        MyStage myStage = new MyStage("../fxml/home.fxml");
        myStage.show();
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
