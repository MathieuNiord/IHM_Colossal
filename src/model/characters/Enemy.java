package model.characters;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.others.*;
import model.objects.*;
import model.interfaces.*;

public class Enemy implements Lookable {

    
    // ***** ATTRIBUTES *****

    public final String NAME;
    private int hp;
    private SimpleDoubleProperty hp_property = new SimpleDoubleProperty();
    public final int HP_MAX;
    private final int DAMAGE;
    private Obj item; //C'est l'objet que l'ennemi va loot à la fin du combat
    private boolean state = true; //true = vivant
    private final String OPENING_SCRIPT;
    private final String ATTACK_SCRIPT;
    private final String DEFEAT_SCRIPT;
    public final String DESCRIPTION;

    // ***** CONSTRUCTOR *****

    public Enemy(String name, int hp, int dmg, Obj loot, String op, String atk, String dft, String desc) {
        this.NAME = name;
        this.hp = hp;
        this.hp_property.setValue(this.hp);
        this.HP_MAX = hp;
        this.DAMAGE = dmg;
        this.item = loot;
        this.OPENING_SCRIPT = op;
        this.ATTACK_SCRIPT = atk;
        this.DEFEAT_SCRIPT = dft;
        this.DESCRIPTION=desc;
    }


    // ***** METHODS *****


    // === GETTER ===

    //On souhaite savoir si l'ennemi a perdu
    public boolean isDefeat() {
        if (this.hp <= 0) {
            this.state = false;
        }
        return !this.state;
    }

    //On souhaite connaître les points de vies restants de l'ennemi
    public int getHP() {
        return this.hp;
    }

    //On souhaite connaître les dégâts d'attaque de l'ennemi
    public int getDamage() {
        return this.DAMAGE;
    }

    //On souhaite connaître l'objet que possède l'ennemi
    public Obj getItem() {
        return this.item;
    }

    public SimpleDoubleProperty getHp_property() {return this.hp_property; }


    // === SETTER ===

    public void takeDamage(int damage) {
        if (this.hp - damage < 0) {
            this.hp = 0;
            this.state = false;
            this.defeat();
        }
        else if (this.hp > 0 && this.state) {
            this.hp -= damage;
        }
        else if (hp <= 0 && this.state) {
            this.state = false;
            this.defeat();
        }
        this.hp_property.setValue(this.hp / 100.0);
    }

    public void heal(int heal) {
        if (this.hp < HP_MAX && this.hp > 0 && this.state) {
            if (this.hp + heal > HP_MAX) {
                this.hp = HP_MAX;
                this.hp_property.setValue(this.hp / 100.0);
                System.out.print("\n" + this.NAME.toUpperCase() + " healed itself. He recovered all his HP\n\n");
            } else {
                this.hp += heal;
                this.hp_property.setValue(this.hp / 100.0);
                System.out.print("\n" + this.NAME.toUpperCase() + " healed itself.\n\n" + this.NAME.toUpperCase() + " gain " + heal + " HP.\n\n");
            }
        }
    }

    public void loot(){
        this.item = null;
    }


    // === COMMANDS ===

    public void look() {
        Game.printLetterByLetter(this.DESCRIPTION, Script.DEFAULT_NARRATOR);
    }


    // === DISPLAY ===

    public void opening() {
        Game.printLetterByLetter(this.OPENING_SCRIPT, this.NAME);
    }

    public void attack() {
        Game.printLetterByLetter(this.ATTACK_SCRIPT, this.NAME);
    }

    public void defeat() {
        Game.printLetterByLetter(this.DEFEAT_SCRIPT, this.NAME);
    }

    public void descript() {
        Game.printLetterByLetter(this.DESCRIPTION, Script.DEFAULT_NARRATOR);
    }

    public String getOpeningScript() {
        return this.OPENING_SCRIPT;
    }

    public String getAttackScript() {
        return this.ATTACK_SCRIPT;
    }

    public String getDefeatScript() {
        return this.DEFEAT_SCRIPT;
    }

}
