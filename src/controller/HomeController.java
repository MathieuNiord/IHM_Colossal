package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

public class HomeController implements Initializable {
    @FXML
    public Button button_play;
    @FXML
    public Button button_credit;
    @FXML
    public Button button_quit;

    @FXML
    private void button_playAction(){

        Stage currentStage = (Stage) button_play.getScene().getWindow();
        currentStage.close();

        try{
            FXMLLoader mainLoader = new FXMLLoader();
            mainLoader.setLocation(this.getClass().getResource("../view/main.fxml"));
            Parent mainRoot = mainLoader.load();
            Stage s = new Stage();
            s.setScene(new Scene(mainRoot));
            s.show();
        }catch (Exception ignored){}
    }

    @FXML
    private void button_creditAction(){

        Stage currentStage = (Stage) button_credit.getScene().getWindow();
        currentStage.close();

        try{
            FXMLLoader mainLoader = new FXMLLoader();
            mainLoader.setLocation(this.getClass().getResource("../view/credit.fxml"));
            Parent creditRoot = mainLoader.load();
            Stage s = new Stage();
            s.setScene(new Scene(creditRoot));
            s.show();
        }catch (Exception ignored){}
    }

    @FXML
    private void button_quitAction(){
        // on ferme la page home
        Stage stage = (Stage) button_quit.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_play.setOnAction(event -> { button_playAction();});

        button_credit.setOnAction(event -> { button_creditAction(); });

        button_quit.setOnAction(event -> { button_quitAction(); });
    }
}
