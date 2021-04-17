package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.characters.Enemy;
import model.characters.Hero;
import view.classes.MyImageView;
import view.classes.MyPlace;

import java.net.URL;
import java.util.*;

import static view.ressources.GameRessources.*;

    /* =========================================================================================================
    === The battle controller : regroups all battle interactions and controls the view (display) of a battle ===
    ============================================================================================================ */

public class BattleController implements Initializable {

    /*** === ATTRIBUTES === ***/

    //Labels
    @FXML
    private Label labelBattle;
    @FXML
    private Label labelEnemyName;
    @FXML
    private Label labelCommentary;
    @FXML
    private Label labelHeroLife;
    @FXML
    private Label labelEnemyLife;

    //ProgressBars
    @FXML
    private ProgressBar progressBarHero = new ProgressBar(1.0);
    @FXML
    private ProgressBar progressBarEnemy = new ProgressBar(1.0);

    //Buttons
    @FXML
    private Button buttonAttack;
    @FXML
    private Button buttonHeal;
    @FXML
    private Button buttonQuit;

    //Imageview
    @FXML
    private ImageView enemyIm;

    //MyImageview
    private MyImageView enemyImV;

    //MyPlace
    private MyPlace place;

    //Enemy
    private Enemy enemy;

    //Enemy life
    private int eLife;

    //String for the label commentary
    private String commentary = "";

    /*** === METHODS === ***/

    // --- Events ---

    // - Set the action of the "ATTACK" button -
    @FXML
    private void setButton_attack() {
        buttonAttack.setOnAction(event -> {

            //We set the default image
            this.enemyIm.setImage(this.enemyImV.getBattleDefaultIm());

            //The player attack the enemy
            HERO_IM.hero.attack(this.enemy);

            //If the enemy is not yet defeated, we add a comment
            if (!this.enemy.isDefeat())
                this.commentary = "-" + this.enemy.NAME + " took damages [-" + Hero.DEFAULT_DAMAGE + " HP]\n";

            //It's the enemy turn
            enemyTurn();
        });
    }

    // - Set the action of the "HEAL" button -
    @FXML
    private void setButton_heal() {
        buttonHeal.setOnAction(event -> {

            //We set the default image
            this.enemyIm.setImage(this.enemyImV.getBattleDefaultIm());

            //The player heal himself/herself/itself (no discrimination)
            HERO_IM.hero.heal();
            this.commentary = "- You healed yourself [+" + Hero.DEFAULT_HEAL + " HP]\n";

            //It's the enemy turn
            enemyTurn();
        });
    }

    // - Set the action of the "QUIT" button -
    @FXML
    private void setButton_quit() {
        buttonQuit.setOnAction(event -> {

            //We remove the enemy from the place
            this.place.removeEnemy();

            //We can now close the battle stage
            Stage stage = (Stage) buttonQuit.getScene().getWindow();
            stage.close();
        });
    }

    // - Enemy Turn -
    @FXML
    private void enemyTurn() {

        //Variables
        Random rand = new Random();
        int eHeal = rand.nextInt(10 + 1);  //Enemy heal

        //If enemy is alive
        if (!this.enemy.isDefeat()) {

            if (eHeal == 1) {
                this.enemy.heal(10);
                this.commentary += "-" + this.enemy.NAME + " healed itself [+10 HP]";
            }

            else {
                this.enemy.attack();
                HERO_IM.hero.setLife(this.enemy.getDamage());
                this.commentary +=
                        "-" + this.enemy.NAME + " attacked you [-" +
                        this.enemy.getDamage() + " HP]\n" +
                        "Ouch ! You took several damages... Get up and beat this Nazi Crap !";
            }
        }

        //Else enemy's dead
        else {

            //We change the image of the enemy
            this.enemyIm.setImage(this.enemyImV.getBattleDefeatIm());

            //Commentary
            this.commentary = this.enemyImV.enemy.getDefeatScript() + "YOU WON THE BATTLE ! Good game HOUGA BOUGA !";

            //Buttons
            buttonAttack.setDisable(true);
            buttonHeal.setDisable(true);
            buttonQuit.setVisible(true);
        }

        labelCommentary.setText(this.commentary);
        livesDisplay();
    }

    // --- Display ---

    @FXML
    private void livesDisplay() {
        //Labels
        labelEnemyLife.setText(String.valueOf(this.enemy.getHP()));
        labelHeroLife.setText(String.valueOf(HERO_IM.hero.getHP()));

        //ProgressBars
        progressBarHero.setProgress((double) (HERO_IM.hero.getHP()) / (double) (100));
        progressBarEnemy.setProgress((double) (this.enemy.getHP()) / (double) (this.eLife));
    }

    // --- Initialization of the controller ---

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Initialization
        this.place = PLACE_TO_MY_PLACE.get(HERO_IM.hero.getPlace());
        this.enemyImV = place.getEnemy();
        this.enemy = this.enemyImV.enemy;
        this.eLife = this.enemy.HP_MAX;

        //Labels
        labelEnemyName.setText(this.enemyImV.enemy.NAME);

        //Image
        enemyIm.setImage(this.enemyImV.getBattleOpeningIm());

        livesDisplay();

        setButton_attack();
        setButton_heal();
        setButton_quit();

        //Battle opening
        labelCommentary.setText(this.enemy.DESCRIPTION);
    }
}
