package view.fxmlController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.others.Script;
import view.ressources.ImageResources;

import java.net.URL;
import java.util.ResourceBundle;

public class End implements Initializable {

    /** === ATTRIBUTES === **/

    //Label
    @FXML
    private Label scriptLabel;

    //Button
    @FXML
    private Button continueButton;

    //ImageView
    @FXML
    private ImageView illustrationScene;

    //Count
    private int count;

    /** === METHODS === **/

    // - redirect to the home page -
    private void continueButtonAction(ActionEvent event){
        this.count++;

        switch (this.count) {
            case 1 :
                this.scriptLabel.setText(Script.WIN_ENDING_2);
                this.illustrationScene.setImage(ImageResources.END_02);
                break;

            case 2 :
                this.scriptLabel.setText(Script.WIN_ENDING_3);
                this.illustrationScene.setImage(ImageResources.END_03);
                break;

            case 3 :
                this.scriptLabel.setText(Script.WIN_ENDING_4);
                this.illustrationScene.setImage(ImageResources.END_04);
                break;

            case 4 :
                this.scriptLabel.setText(Script.WIN_ENDING_5);
                this.illustrationScene.setImage(ImageResources.END_05);
                break;

            case 5 :
                this.scriptLabel.setText(Script.WIN_ENDING_6);
                this.illustrationScene.setImage(ImageResources.END_06);
                this.continueButton.setText("QUIT");
                break;

            default :
                Stage currentStage = (Stage) continueButton.getScene().getWindow();
                currentStage.close();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.continueButton.setOnAction(event -> continueButtonAction(event));
        this.illustrationScene.setImage(ImageResources.END_01);
        this.scriptLabel.setText(Script.WIN_ENDING_1);
    }
}