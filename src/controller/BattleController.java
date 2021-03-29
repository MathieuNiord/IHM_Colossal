package controller;
import javafx.scene.image.Image;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import model_bis.GameRessources;
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

    //GameRessources
    private final GameRessources game = new GameRessources();

    //IntegerProperty
    private IntegerProperty hLife;
    private IntegerProperty eLife;

    //Boolean Turns
    private boolean playerTurn;

    /*** === METHODS === ***/

    @FXML
    private void lifeDisplay() {
        label_enemy_life.setText(String.valueOf(game.hero.getPlace().getEnemies().getHP()));
        label_hero_life.setText(String.valueOf(game.hero.getHP()));

        hLife = new SimpleIntegerProperty(Integer.parseInt(label_hero_life.getText()));
        eLife = new SimpleIntegerProperty(Integer.parseInt(label_enemy_life.getText()));

        progress_bar_hero.progressProperty().bind(hLife);
        progress_bar_enemy.progressProperty().bind(eLife);
    }

    @FXML
    private void setButton_attack() {
        button_attack.setOnAction( event -> {
            if (playerTurn) {
                game.hero.attack(game.hero.getPlace().getEnemies());

                if (!game.hero.getPlace().getEnemies().isDefeat()) label_commentary.setText("Yeah ! Kill him ! " + game.hero.getPlace().getEnemies().NAME + " lost 20 HP");

                button_attack.setDisable(true);
                button_heal.setDisable(true);

                System.out.println("attack - playerTurn false");
                playerTurn = false;
            }
        });
    }

    // - Set the action of the HEAL button -
    @FXML
    private void setButton_heal() {
        button_heal.setOnAction( event -> {
            if (playerTurn) {
                game.hero.heal();
                button_attack.setDisable(true);
                button_heal.setDisable(true);
                System.out.println("heal - playerTurn false");
                playerTurn = false;
            }
        });
    }

    // - Enemy Turn -
    @FXML
    private void enemyTurn() {

        if (!playerTurn) {

            // -- Variables
            Random rand = new Random();
            int eHeal = rand.nextInt(10 + 1);  //Enemy heal

            if (!game.hero.getPlace().getEnemies().isDefeat()) {

                if (eHeal == 1) {
                    game.hero.getPlace().getEnemies().heal(10);
                    label_commentary.setText(game.hero.getPlace().getEnemies().NAME + " healed itself");
                } else {
                    game.hero.getPlace().getEnemies().attack();
                    game.hero.setLife(game.hero.getPlace().getEnemies().getDamage());
                    label_commentary.setText("Ouch ! You took several damages... Get up and beat this Nazi Crap !");
                }
                button_attack.setDisable(false);
                button_heal.setDisable(false);
                playerTurn = true;
            }
        }
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // -- Initialization

        //Booleans
        playerTurn = false;

        //ProgressBars

        progress_bar_hero = new ProgressBar((double) game.hero.getHP());
        progress_bar_enemy = new ProgressBar((double) game.hero.getPlace().getEnemies().getHP());

        //IntegerProperties

        hLife = new SimpleIntegerProperty();
        hLife.setValue(game.hero.getHP());
        eLife = new SimpleIntegerProperty();
        eLife.setValue(game.hero.getPlace().getEnemies().getHP());

        //Labels
        label_enemy_name.setText(game.hero.getPlace().getEnemies().NAME);

        //Image
        image_enemy.setImage(new Image("assets/images/characters/ZombiNazi.png"));

        lifeDisplay();

        setButton_attack();
        setButton_heal();

        // -- Battle opening
        label_commentary.setText(game.hero.getPlace().getEnemies().DESCRIPTION);

        // -- Battle area

        if (!(game.hero.getHP() == 0 && game.hero.getPlace().getEnemies().isDefeat())) {
            //if (!playerTurn)
                enemyTurn();
            System.out.println("enemyTurn - playerTurn = " + String.valueOf(playerTurn));
        }

        // -- Battle is over
        if (game.hero.getHP() == 0) label_commentary.setText("You loose");
        else if (game.hero.getPlace().getEnemies().isDefeat()) label_commentary.setText("You win !");
    }
}
