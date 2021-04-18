package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.characters.Enemy;
import model.characters.Hero;
import model.others.Script;
import stage.MyStage;
import view.classes.MyImageView;
import view.classes.MyPlace;

import java.net.URL;
import java.util.*;

import static view.ressources.GameResources.*;

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

    //Can the player heal himself/herself/itself ?
    private boolean canHeal;

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

            //If the player got all his life
            if (HERO_IM.hero.getHP() >= Hero.DEFAULT_HP)
                this.labelCommentary.setText("You better choose another option, you're already full of life dumb !");

            else {

                //We set the default image
                this.enemyIm.setImage(this.enemyImV.getBattleDefaultIm());

                //The player heal himself/herself/itself (no discrimination)
                HERO_IM.hero.heal();
                this.commentary = "- You healed yourself [+" + Hero.DEFAULT_HEAL + " HP]\n";

                //If now the player has nothing to heal
                if (!HERO_IM.hero.getObjs().containsKey(Script.DEFAULT_SEXYPOSTER_NAME)) {
                    this.buttonHeal.setDisable(true);
                    //It's the enemy turn
                    enemyTurn();
                }
            }
        });
    }

    // - Set the action of the "QUIT" button -
    @FXML
    private void setButton_quit() {
        buttonQuit.setOnAction(event -> {

            //If the enemy is dead, the player must return to the game
            if (this.enemy.isDefeat()) {
                //We remove the enemy from the place
                this.place.removeEnemy();
                //We can now close the battle stage
                Stage stage = (Stage) this.buttonQuit.getScene().getWindow();
                stage.close();
            }

            //Else the game is over
            else {
                //We set a new image of the hero
                // - TODO Hero corpse -
                //We can now close the battle stage
                Stage stage = (Stage) this.buttonQuit.getScene().getWindow();
                stage.close();
                //TEST ====================================================
                //We now open the game over view
                MyStage gameOver = new MyStage("view/fxml/home.fxml");
                gameOver.show();
                // ========================================================
            }
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
            this.buttonAttack.setDisable(true);
            this.buttonHeal.setDisable(true);
            this.buttonQuit.setVisible(true);
        }

        //If the player lost
        if (!HERO_IM.hero.isAlive()) {
            this.commentary = "You just succumbed to your wounds\n\nGAME OVER !";
            this.buttonAttack.setDisable(true);
            this.buttonHeal.setDisable(true);
            this.buttonQuit.setVisible(true);
        }

        this.labelCommentary.setText(this.commentary);
        livesDisplay();
    }

    // --- Display ---

    @FXML
    private void livesDisplay() {
        //Labels
        this.labelEnemyLife.setText(String.valueOf(this.enemy.getHP()));
        this.labelHeroLife.setText(String.valueOf(HERO_IM.hero.getHP()));

        //ProgressBars
        this.progressBarHero.setProgress((double) (HERO_IM.hero.getHP()) / (double) (100));
        this.progressBarEnemy.setProgress((double) (this.enemy.getHP()) / (double) (this.eLife));
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
        this.canHeal = true;

        //Labels
        this.labelEnemyName.setText(this.enemyImV.enemy.NAME);

        //Image
        this.enemyIm.setImage(this.enemyImV.getBattleOpeningIm());

        livesDisplay();

        setButton_attack();
        setButton_heal();
        setButton_quit();

        //Heal button
       if (!HERO_IM.hero.getObjs().containsKey(Script.DEFAULT_SEXYPOSTER_NAME)) {
                this.canHeal = false;
                this.buttonHeal.setDisable(true);
       }

        //Battle opening
        this.labelCommentary.setText(this.enemy.DESCRIPTION);
    }
}
