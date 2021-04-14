package controller;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import model.others.Game;
import view.ressources.GameRessources;
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

    //Enemy life
    //private final int eLife = HERO_IM.hero.getPlace().getEnemies().getHP();

    /*** === METHODS === ***/

    @FXML
    private void lifeDisplay() {
        label_enemy_life.setText(String.valueOf(HERO_IM.hero.getPlace().getEnemies().getHP()));
        label_hero_life.setText(String.valueOf(HERO_IM.hero.getHP()));
        progress_bar_hero.setProgress((double) (HERO_IM.hero.getHP()/100));
        progress_bar_enemy.setProgress((double) (HERO_IM.hero.getPlace().getEnemies().getHP()/60));
    }

    @FXML
    private void setButton_attack() {
        button_attack.setOnAction( event -> {
            HERO_IM.hero.attack(HERO_IM.hero.getPlace().getEnemies());

            if (!HERO_IM.hero.getPlace().getEnemies().isDefeat()) {
                //label_commentary.setText("Yeah ! Kill him ! " + GameRessources.heroIm.hero.getPlace().getEnemies().NAME + " lost 20 HP");
                enemyTurn();
            }

            button_attack.setDisable(true);
            button_heal.setDisable(true);

            System.out.println("attack");
        });
    }

    // - Set the action of the HEAL button -
    @FXML
    private void setButton_heal() {
        button_heal.setOnAction( event -> {
            HERO_IM.hero.heal();
            button_attack.setDisable(true);
            button_heal.setDisable(true);
            System.out.println("heal");
        });
    }

    // - Enemy Turn -
    @FXML
    private void enemyTurn() {

        // -- Variables
        Random rand = new Random();
        int eHeal = rand.nextInt(10 + 1);  //Enemy heal

        if (!HERO_IM.hero.getPlace().getEnemies().isDefeat()) {

            if (eHeal == 1) {
                HERO_IM.hero.getPlace().getEnemies().heal(10);
                label_commentary.setText(HERO_IM.hero.getPlace().getEnemies().NAME + " healed itself");
            } else {
                HERO_IM.hero.getPlace().getEnemies().attack();
                HERO_IM.hero.setLife(HERO_IM.hero.getPlace().getEnemies().getDamage());
                label_commentary.setText("Ouch ! You took several damages... Get up and beat this Nazi Crap !");
            }
            button_attack.setDisable(false);
            button_heal.setDisable(false);
        }
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Initialization
        new Game("Test");
        //Image enemyIm = PLACE_TO_MY_PLACE.get(HERO_IM.hero.getPlace()).getEnemy().getImage();
        System.out.println("Test");
        System.out.println(HERO_IM.hero.getPlace().getEnemies().getHP());

        //ProgressBars
        progress_bar_hero = new ProgressBar((double) HERO_IM.hero.getHP());
        progress_bar_enemy = new ProgressBar((double) HERO_IM.hero.getPlace().getEnemies().getHP());
        System.out.println("ProgressBar");

        //Labels
        label_enemy_name.setText(HERO_IM.hero.getPlace().getEnemies().NAME);
        System.out.println("Label enemy");
        System.out.println(PLACE_TO_MY_PLACE.get(HERO_IM.hero.getPlace()).getEnemy().enemy.NAME);

        //Image
        //image_enemy.setImage(enemyIm);
        System.out.println("Image enemy");

        lifeDisplay();
        System.out.println("Life Display");

        setButton_attack();
        setButton_heal();
        System.out.println("Buttons");

        // -- Battle opening
        label_commentary.setText(HERO_IM.hero.getPlace().getEnemies().DESCRIPTION);
        System.out.println("Label Opening");

        // -- Battle is over
        if (HERO_IM.hero.getHP() == 0) label_commentary.setText("You loose");
        else if (HERO_IM.hero.getPlace().getEnemies().isDefeat()) label_commentary.setText("You win !");
        System.out.println("osef");
    }
}
