package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import stage.MyStage;

import static view.ressources.GameResources.MY_FONT_32;

public class HomeController implements Initializable {

    /** === ATTRIBUTES === **/

    public ImageView homeBG;
    @FXML
    private Button button_play;
    @FXML
    private Button button_credit;
    @FXML
    private Button button_quit;

    /** === METHODS === **/

    // --- Events ---

    // - Create a TextInputDialog and return a string which corresponds to the gamer tag -
    @FXML
    private void button_playAction(){
        //GameRessources.reset();
        Stage currentStage = (Stage) button_play.getScene().getWindow();
        currentStage.close();
        MyStage myStage = new MyStage("../view/fxml/welcome.fxml");
        myStage.show();
    }

    // - redirect to the credits -
    @FXML
    private void button_creditAction(){

        Stage currentStage = (Stage) button_credit.getScene().getWindow();
        currentStage.close();
        MyStage myStage = new MyStage("../view/fxml/credit.fxml");
        myStage.show();
    }

    // - close the game -
    @FXML
    private void button_quitAction(){
        Stage stage = (Stage) button_quit.getScene().getWindow();
        stage.close();
    }

    // --- Initialization of the controller ---

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_play.setOnAction(event -> button_playAction());
        button_play.setFont(MY_FONT_32);

        button_credit.setOnAction(event -> button_creditAction());
        button_credit.setFont(MY_FONT_32);

        button_quit.setOnAction(event -> button_quitAction());
        button_quit.setFont(MY_FONT_32);
    }
}