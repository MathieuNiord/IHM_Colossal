package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import model.others.Game;
import stage.MyStage;

public class HomeController implements Initializable {

    // === ATTRIBUTES ===

    public ImageView homeBG;
    @FXML
    private Button button_play;
    @FXML
    private Button button_credit;
    @FXML
    private Button button_quit;

    // === METHODS ===

    // --- Events ---

    // - Create a TextInputDialog and return a string which corresponds to the gamer tag -
    @FXML
    private void button_playAction(){

        //TextInputDialog configuration
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Choose your name please");
        dialog.setContentText("Please enter your name:");
        dialog.showAndWait();

        if (dialog.getResult() != null && !dialog.getResult().equals("")) {
            new Game(dialog.getResult());
            Stage currentStage = (Stage) button_play.getScene().getWindow();
            currentStage.close();
            MyStage myStage = new MyStage("../view/fxml/main.fxml");
            myStage.show();
        }
    }

    @FXML
    private void button_creditAction(){

        Stage currentStage = (Stage) button_credit.getScene().getWindow();
        currentStage.close();
        MyStage myStage = new MyStage("../view/fxml/credit.fxml");
        myStage.show();
    }

    @FXML
    private void button_quitAction(){
        // on ferme la page home
        Stage stage = (Stage) button_quit.getScene().getWindow();
        stage.close();
    }

    // --- Initialization of the controller ---

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_play.setOnAction(event -> button_playAction());

        button_credit.setOnAction(event -> button_creditAction());

        button_quit.setOnAction(event -> button_quitAction());
    }
}
