package controller;

import imageView.MyHeroImageView;
import imageView.MyImageView;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.characters.Animal;
import model.characters.Enemy;
import model.characters.Hero;
import model.doors.Door;
import model.objects.Banana;
import model.objects.NaziPoster;
import model.objects.Obj;
import model.others.Game;
import model.others.Place;
import model.others.Script;
import stage.MyStage;

import java.net.URL;
import java.util.*;

public class BattleController implements Initializable {

    /*** === ATTRIBUTES === ***/

    //Panes
    @FXML
    private Pane root_battle;
    @FXML
    private Pane pane_commentary;

    //Labels
    @FXML
    private Label label_battle;
    @FXML
    private Label label_enemy_name;
    @FXML
    private Label label_commentary;
    @FXML
    private Label label_hero_life;
    @FXML
    private Label label_enemy_life;

    //ProgressBars
    @FXML
    private ProgressBar progress_bar_hero;
    @FXML
    private ProgressBar progress_bar_enemy;

    //Buttons
    @FXML
    private Button button_attack;
    @FXML
    private Button button_heal;

    //Imageview
    @FXML
    private ImageView image_enemy;


    /*** === METHODS === ***/

    @FXML
    private void lifeDisplay() {
        //progress_bar_hero.progressProperty().bind((IntegerProperty.integerExpression(hero.getHP()));
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
