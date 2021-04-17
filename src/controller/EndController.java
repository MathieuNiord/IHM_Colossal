package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.others.Script;
import stage.MyStage;
import view.ressources.ImageRessources;

import java.net.URL;
import java.util.ResourceBundle;

import static view.ressources.GameRessources.MY_FONT_16;

public class EndController implements Initializable {

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
    private void continueButtonAction(){

        this.continueButton.setOnAction(event -> {

            this.count++;

            switch (this.count) {
                case 1 :
                    this.scriptLabel.setText(Script.WIN_ENDING_2);
                    this.illustrationScene.setImage(ImageRessources.GIF_CAVEMAN);
                    break;

                case 2 :
                    this.scriptLabel.setText(Script.WIN_ENDING_3);
                    this.illustrationScene.setImage(ImageRessources.IMAGE_TORCH);
                    break;

                case 3 :
                    this.scriptLabel.setText(Script.WIN_ENDING_4);
                    this.illustrationScene.setImage(ImageRessources.IMAGE_LOCKER_CLOSED);
                    break;

                case 4 :
                    this.scriptLabel.setText(Script.WIN_ENDING_5);
                    this.illustrationScene.setImage(ImageRessources.IMAGE_LOCKER_OPENED);
                    break;

                case 5 :
                    this.scriptLabel.setText(Script.WIN_ENDING_6);
                    this.illustrationScene.setImage(ImageRessources.IMAGE_ACCOUNT_GUY_BATTLE);
                    this.continueButton.setText("QUIT");
                    break;

                default :
                    Stage currentStage = (Stage) continueButton.getScene().getWindow();
                    currentStage.close();
                    MyStage myStage = new MyStage("../view/fxml/home.fxml");
                    myStage.show();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //this.continueButton.setOnAction(event -> continueButtonAction());
        continueButtonAction();
        this.illustrationScene.setImage(ImageRessources.IMAGE_BOSS_BATTLE);
        this.scriptLabel.setText(Script.WIN_ENDING_1);
    }
}