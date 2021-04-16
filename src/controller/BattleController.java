package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.characters.Hero;
import model.others.Game;
import stage.MyStage;

import java.net.URL;
import java.util.*;

import static view.ressources.GameRessources.*;

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
    private ProgressBar progress_bar_hero = new ProgressBar(1.0);
    @FXML
    private ProgressBar progress_bar_enemy = new ProgressBar(1.0);

    //Buttons
    @FXML
    private Button button_attack;
    @FXML
    private Button button_heal;
    @FXML
    private Button button_quit;

    //Imageview
    @FXML
    private ImageView image_enemy;

    //Enemy life
    private int eLife;

    //String for the label commentary
    private String commentary = "";

    /*** === METHODS === ***/

    // --- Events ---

    // - Set the action of the "ATTACK" button -
    @FXML
    private void setButton_attack() {
        button_attack.setOnAction( event -> {

            HERO_IM.hero.attack(HERO_IM.hero.getPlace().getEnemy());

            if (!HERO_IM.hero.getPlace().getEnemy().isDefeat()) {
                label_commentary.setText("");
                this.commentary = "-" + HERO_IM.hero.getPlace().getEnemy().NAME + " took damages [-" + Hero.DEFAULT_DAMAGE + " HP]\n";
                enemyTurn();
            }

            else {
                lifeDisplay();
                label_commentary.setText("YOU WON THE BATTLE ! Good game HOUGA BOUGA !");
                button_attack.setDisable(true);
                button_heal.setDisable(true);
                button_quit.setVisible(true);
            }
        });
    }

    // - Set the action of the "HEAL" button -
    @FXML
    private void setButton_heal() {
        button_heal.setOnAction( event -> {
            HERO_IM.hero.heal();
            label_commentary.setText("");
            this.commentary = "- You healed yourself [+" + Hero.DEFAULT_HEAL + " HP]\n";
            enemyTurn();
        });
    }

    // - Set the action of the "QUIT" button -
    @FXML
    private void setButton_quit() {
        button_quit.setOnAction( event -> {
            Stage stage = (Stage) button_quit.getScene().getWindow();
            stage.close();
        });
    }

    // - Enemy Turn -
    @FXML
    private void enemyTurn() {

        //Variables
        Random rand = new Random();
        int eHeal = rand.nextInt(10 + 1);  //Enemy heal

        if (!HERO_IM.hero.getPlace().getEnemy().isDefeat()) {

            if (eHeal == 1) {
                HERO_IM.hero.getPlace().getEnemy().heal(10);
                this.commentary += "-" + HERO_IM.hero.getPlace().getEnemy().NAME + " healed itself [+10 HP]";
            }

            else {
                HERO_IM.hero.getPlace().getEnemy().attack();
                HERO_IM.hero.setLife(HERO_IM.hero.getPlace().getEnemy().getDamage());
                this.commentary +=
                        "-" + HERO_IM.hero.getPlace().getEnemy().NAME + " attacked you [-" +
                        HERO_IM.hero.getPlace().getEnemy().getDamage() + " HP]\n" +
                        "Ouch ! You took several damages... Get up and beat this Nazi Crap !";
            }

            label_commentary.setText(this.commentary);
            lifeDisplay();
        }
    }

    // --- Display ---

    @FXML
    private void lifeDisplay() {
        //Labels
        label_enemy_life.setText(String.valueOf(HERO_IM.hero.getPlace().getEnemy().getHP()));
        label_hero_life.setText(String.valueOf(HERO_IM.hero.getHP()));

        //ProgressBars
        progress_bar_hero.setProgress((double) (HERO_IM.hero.getHP()) / (double) (100));
        progress_bar_enemy.setProgress((double) (HERO_IM.hero.getPlace().getEnemy().getHP()) / (double) (this.eLife));
    }

    // --- Initialization of the controller ---

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Initialization
        //new Game("Test");
        this.eLife = PLACE_TO_MY_PLACE.get(HERO_IM.hero.getPlace()).getEnemy().enemy.getHP();

        //Labels
        label_enemy_name.setText(HERO_IM.hero.getPlace().getEnemy().NAME);

        //Image
        image_enemy.setImage(PLACE_TO_MY_PLACE.get(HERO_IM.hero.getPlace()).getEnemy().getImage());

        lifeDisplay();

        setButton_attack();
        setButton_heal();
        setButton_quit();

        //Battle opening
        label_commentary.setText(HERO_IM.hero.getPlace().getEnemy().DESCRIPTION);
    }
}
