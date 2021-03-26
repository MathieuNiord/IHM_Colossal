package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import stage.MyStage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreditController implements Initializable {

    @FXML
    private Button button_menu;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_menu.setOnAction( event -> {
            Stage currentStage = (Stage) button_menu.getScene().getWindow();
            currentStage.close();
            MyStage myStage = new MyStage("../view/home.fxml");
            myStage.show();
        });
    }
}
