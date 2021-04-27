package view.fxmlController;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.others.Game;
import model.others.Script;
import view.classes.MyDialog;

import java.net.URL;
import java.util.ResourceBundle;

import static view.ressources.GameResources.MY_FONT_16;
import static view.ressources.GameResources.MY_FONT_32;

public class Welcome implements Initializable {

    /** === ATTRIBUTES === **/

    public Label scriptLabel;
    public Button okButton;

    /** === METHODS === **/

    // - when ok is pressed we ask the name of the player and redirect to the main.fxml -
    private void setOkButtonAction(){

        //TextInputDialog configuration
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Choose a gamer tag");
        dialog.setContentText("Please enter your name :");
        dialog.showAndWait();

        if (dialog.getResult() != null && !dialog.getResult().equals("")) {

            // Initialization of the game
            new Game(dialog.getResult());
            new Main();

            // Simple Alert which simply is a joke
            Alert alert = new Alert(Alert.AlertType.NONE, "You sure you want to be called \"HOUGA BOUGA\" ?");

            ButtonType ok01 = new ButtonType("Ok I choose this name btw...");
            ButtonType ok02 = new ButtonType("Whatever launch that game please !");
            alert.getButtonTypes().addAll(ok01, ok02);

            alert.showAndWait();

            // The game Stageq
            Stage currentStage = (Stage) okButton.getScene().getWindow();
            currentStage.close();
            MyDialog myStage = new MyDialog("../fxml/main.fxml");
            myStage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.okButton.setOnAction(event -> setOkButtonAction());
        this.okButton.setFont(MY_FONT_16);

        this.scriptLabel.setText(Script.WELCOME_MESSAGE + Script.SYNOPSIS);
        this.scriptLabel.setFont(MY_FONT_32);
    }
}
