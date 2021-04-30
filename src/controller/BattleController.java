package controller;

import controller.entities.MyEntity;
import model.characters.Hero;
import view.classes.MyImageView;
import view.fxmlController.Battle;

import java.util.Random;

import static controller.entities.EntitiesDatas.MY_HERO;
import static view.ressources.GameResources.*;

public class BattleController {

    /** === ATTRIBUTES === **/

    private final Battle battle;

    /** === CONSTRUCTOR === **/

    public BattleController(Battle battle){ this.battle = battle; }

    /** === METHODS === **/

    public void healPlayer(MyEntity myEntity){
        //We set the default image
        battle.setImageFromImage(myEntity.view.getBattleDefaultIm());

        //We need to get which SexyPoster to remove it from the inventory (FlowPane)
        MyImageView sexyPoster;

        if (HERO_IM.getInvView().getChildren().contains(SEXY_POSTER_IM_1))
            sexyPoster = SEXY_POSTER_IM_1;

        else sexyPoster = SEXY_POSTER_IM_2;

        //The player heal himself/herself/itself (no discrimination)
        MY_HERO.getModel().heal();
        //We can remove the object
        HERO_IM.removeInv(sexyPoster);
        battle.setCommentary("- You healed yourself [+" + Hero.DEFAULT_HEAL + " HP]\n");

        //If now the player has nothing to heal
        if (!HERO_IM.getInvView().getChildren().contains(SEXY_POSTER_IM_1) && !HERO_IM.getInvView().getChildren().contains(SEXY_POSTER_IM_2)) {
            //The player can't no more heal hisself/herself/itself, we can disable the button
            battle.disableHealButton();
        }
        //It's the enemy turn
        enemyTurn(myEntity);
    }

    // - Enemy Turn -
    public void enemyTurn(MyEntity myEntity) {

        //Variables
        Random rand = new Random();
        int eHeal = rand.nextInt(10 + 1);  //Enemy heal

        //If enemy is alive
        if (!myEntity.enemy_model.isDefeat()) {

            if (eHeal == 1) {
                myEntity.enemy_model.heal(10);
                battle.addCommentary("-" + myEntity.enemy_model.NAME + " healed itself [+10 HP]");
            }

            else {
                myEntity.enemy_model.attack();
                MY_HERO.getModel().setLife(myEntity.enemy_model.getDamage());
                battle.addCommentary(
                        "-" + myEntity.enemy_model.NAME + " attacked you [-" +
                                myEntity.enemy_model.getDamage() + " HP]\n" +
                                "Ouch ! You took several damages... Get up and beat this Nazi Crap !");
            }
        }

        //Else enemy's dead
        else {

            //We change the image of the enemy
            battle.setImageFromURL(myEntity.view.getBattleDefeat());

            //Commentary
            battle.setCommentary(myEntity.enemy_model.getDefeatScript() + "YOU WON THE BATTLE ! Good game HOUGA BOUGA !");

            //Buttons
            battle.disableAttackButton();
            battle.disableHealButton();
            battle.setVisibleQuitButton();
        }

        //If the player lost
        if (!MY_HERO.getModel().isAlive()) {
            battle.setCommentary("You just succumbed to your wounds\n\nGAME OVER !");
            battle.disableAttackButton();
            battle.disableHealButton();
            battle.setVisibleQuitButton();
        }

        battle.applyCommentary();
        battle.livesDisplay();
    }

    public void heroAttack(MyEntity enemy){
        //We set the default image
        battle.setImageFromImage(enemy.view.getBattleDefaultIm());

        //The player attack the enemy
        MY_HERO.getModel().attack(enemy.enemy_model);

        //If the enemy is not yet defeated, we add a comment
        if (!enemy.enemy_model.isDefeat())
            this.battle.setCommentary( "-" + enemy.enemy_model.NAME + " took damages [-" + Hero.DEFAULT_DAMAGE + " HP]\n");

        //It's the enemy turn
        enemyTurn(enemy);
    }

}
