package view.fxmlController;

import controller.BattleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.characters.Enemy;
import model.characters.Hero;
import view.classes.MyStage;
import view.classes.MyImageView;
import controller.entities.MyPlace;

import java.net.URL;
import java.util.*;

import static controller.entities.EntitiesDatas.*;
import static view.ressources.GameResources.*;

    /* =========================================================================================================
    === The battle controller : regroups all battle interactions and controls the view (display) of a battle ===
    ============================================================================================================ */

public class Battle implements Initializable {


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
    @FXML
    private Pane pane_battle;
    @FXML
    private Pane pane_commentary;

    //ProgressBars
    @FXML
    private ProgressBar progressBarHero;
    @FXML
    private ProgressBar progressBarEnemy;

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

    private BattleController battleController;

    /*** === METHODS === ***/

    // --- Events ---

    // - Set the action of the "ATTACK" button -
    @FXML
    private void setButton_attack(ActionEvent event) {

        battleController.heroAttack(place.getEnemy());
    }

    // - Set the action of the "HEAL" button -
    @FXML
    private void setButton_heal(ActionEvent event) {

        //If the player got all his life
        if (MY_HERO.getModel().getHP() >= Hero.DEFAULT_HP)
            this.labelCommentary.setText("You better choose another option, you're already full of life dumb !");

        else {
            battleController.healPlayer(place.getEnemy());
        }
    }

    // - Set the action of the "QUIT" button -
    @FXML
    private void setButton_quit(ActionEvent event) {

        //If the enemy is dead, the player must return to the game
        if (this.enemy.isDefeat()) {
            //We remove the enemy from the place
            this.place.removeEnemy();
            //We can now close the battle view.stage
            Stage stage = (Stage) this.buttonQuit.getScene().getWindow();
            stage.close();
        }

        //Else the game is over
        else {
            //We can now close the battle stage
            Stage stage = (Stage) this.buttonQuit.getScene().getWindow();
            stage.close();
            //We can close the main stage
            ((Stage) (HERO_IM.getInvView().getScene().getWindow())).close();
            //We now open the game over view
            MyStage gameOver = new MyStage("../fxml/game_over.fxml");
            gameOver.show();
        }
    }

    // --- Display ---

    public void livesDisplay() {
        //Labels
        this.labelEnemyLife.setText(String.valueOf(this.enemy.getHP()));
        this.labelHeroLife.setText(String.valueOf(MY_HERO.getModel().getHP()));

        //ProgressBars
        this.progressBarHero.progressProperty().bind(MY_HERO.getModel().getHpDoubleProperty().divide(100.0));
        this.progressBarEnemy.progressProperty().bind(this.enemy.getHpProperty().divide(this.eLife));
    }

    public void setImageFromURL(String url){
        this.enemyIm.setImage(new Image(url));
    }

    public void setImageFromImage(Image image) {
        this.enemyIm.setImage(image);
    }

    public void setCommentary(String text){ this.commentary = text; }

    public void addCommentary(String text){ this.commentary += text; }

    public void disableHealButton(){ this.buttonHeal.setDisable(true); }

    public void setVisibleQuitButton(){ this.buttonQuit.setVisible(true);}

    public void disableAttackButton(){ this.buttonAttack.setDisable(true);}

    public void applyCommentary(){ labelCommentary.setText(this.commentary);}


    // --- Initialization of the controller ---

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Initialization
        this.battleController = new BattleController(this);
        this.place = PLACE_TO_MY_PLACE.get(MY_HERO.getModel().getPlace());
        this.enemyImV = place.getEnemy().view;
        this.enemy = place.getEnemy().enemy_model;
        this.eLife = this.enemy.HP_MAX;

        //Labels
        this.labelEnemyName.setText(this.enemy.NAME);
        this.labelCommentary.setText(this.enemy.getOpeningScript() + "\nYou come face to face with " + this.enemy.NAME.toUpperCase());

        //Image
        this.enemyIm.setImage(new Image(this.enemyImV.getBattleOpening()));

        livesDisplay();

        //Heal button
       if (!HERO_IM.getInvView().getChildren().contains(SEXY_POSTER_IM_1) && !HERO_IM.getInvView().getChildren().contains(SEXY_POSTER_IM_2)) {
                this.buttonHeal.setDisable(true);
       }

        //Battle opening
        this.labelCommentary.setText(this.enemy.DESCRIPTION);
    }
}
