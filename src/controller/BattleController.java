package controller;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import view.ressources.GameRessources;
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

    //Enemy life
    private final int eLife = GameRessources.heroIm.hero.getPlace().getEnemies().getHP();

    /*** === METHODS === ***/

    @FXML
    private void lifeDisplay() {
        label_enemy_life.setText(String.valueOf(GameRessources.heroIm.hero.getPlace().getEnemies().getHP()));
        label_hero_life.setText(String.valueOf(GameRessources.heroIm.hero.getHP()));
        progress_bar_hero.setProgress((double) (GameRessources.heroIm.hero.getHP()/100));
        progress_bar_enemy.setProgress((double) (GameRessources.heroIm.hero.getPlace().getEnemies().getHP()/this.eLife));
    }

    @FXML
    private void setButton_attack() {
        button_attack.setOnAction( event -> {
            GameRessources.heroIm.hero.attack(GameRessources.heroIm.hero.getPlace().getEnemies());

            if (!GameRessources.heroIm.hero.getPlace().getEnemies().isDefeat()) {
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
            GameRessources.heroIm.hero.heal();
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

        if (!GameRessources.heroIm.hero.getPlace().getEnemies().isDefeat()) {

            if (eHeal == 1) {
                GameRessources.heroIm.hero.getPlace().getEnemies().heal(10);
                label_commentary.setText(GameRessources.heroIm.hero.getPlace().getEnemies().NAME + " healed itself");
            } else {
                GameRessources.heroIm.hero.getPlace().getEnemies().attack();
                GameRessources.heroIm.hero.setLife(GameRessources.heroIm.hero.getPlace().getEnemies().getDamage());
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

        //ProgressBars
        progress_bar_hero = new ProgressBar((double) GameRessources.heroIm.hero.getHP());
        progress_bar_enemy = new ProgressBar((double) GameRessources.heroIm.hero.getPlace().getEnemies().getHP());

        //Labels
        label_enemy_name.setText(GameRessources.heroIm.hero.getPlace().getEnemies().NAME);

        //Image
        image_enemy.setImage(new Image("assets/images/characters/ZombiNazi.png"));

        lifeDisplay();

        setButton_attack();
        setButton_heal();

        // -- Battle opening
        label_commentary.setText(GameRessources.heroIm.hero.getPlace().getEnemies().DESCRIPTION);

        // -- Battle is over
        if (GameRessources.heroIm.hero.getHP() == 0) label_commentary.setText("You loose");
        else if (GameRessources.heroIm.hero.getPlace().getEnemies().isDefeat()) label_commentary.setText("You win !");
    }
}
