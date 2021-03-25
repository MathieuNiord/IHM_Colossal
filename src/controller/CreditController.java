package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.others.Script;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CreditController implements Initializable {

    @FXML
    private Label label_credit;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label_credit.setText(Script.CREDITS);
    }
}
