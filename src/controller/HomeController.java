package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import stage.MyStage;

public class HomeController implements Initializable {
    @FXML
    private Button button_play;
    @FXML
    private Button button_credit;
    @FXML
    private Button button_quit;

    @FXML
    private void button_playAction(){

        Stage currentStage = (Stage) button_play.getScene().getWindow();
        currentStage.close();
        MyStage myStage = new MyStage("../view/main.fxml");
        myStage.show();
    }

    @FXML
    private void button_creditAction(){

        Stage currentStage = (Stage) button_credit.getScene().getWindow();
        currentStage.close();
        MyStage myStage = new MyStage("../view/credit.fxml");
        myStage.show();
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
