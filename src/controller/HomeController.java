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
    private Button button_play;
    @FXML
    private Button button_credit;
    @FXML
    private Button button_quit;

    @FXML
    private void button_playAction(){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent home;

        try{
            home = loader.load(getClass().getResource("view/main.fxml"));
            stage.setScene(new Scene(home));
            stage.show();
        }catch (Exception e){
            System.err.println(e + " : main open err !");
        }


        // on ferme la page home
        Stage currentStage = (Stage) button_play.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    private void button_creditAction(){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent home;

        try{
            home = loader.load(getClass().getResource("view/main.fxml"));
            stage.setScene(new Scene(home));
            stage.show();
        }catch (Exception e){
            System.err.println(e + " : credit open err !");
        }

        // on ferme la page home
        Stage currentStage = (Stage) button_play.getScene().getWindow();
        currentStage.close();
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
