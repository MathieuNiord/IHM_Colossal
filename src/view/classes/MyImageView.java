package view.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.characters.Animal;
import model.characters.Enemy;
import model.characters.Monkey;
import model.doors.Door;
import model.objects.Obj;

public class MyImageView extends ImageView {

    /*** ATTRIBUTES ***/

    public final int x,y;
    public Animal animal;
    public Door door;
    public Enemy enemy;
    public Monkey monkey;
    public Obj obj;
    private Image battleDefaultIm = null;
    private Image battleOpeningIm = null;
    private Image battleDefeatIm = null;
    private MyImageView defeat = null;
    private MyImageView possessedObject = null;


    /*** CONSTRUCTOR ***/

    public MyImageView(Animal a, Image path, int x, int y, Integer fitImage){
        super(path);
        this.animal = a;
        this.x = x;
        this.y = y;
        fitImage(fitImage);
    }

    public MyImageView(Monkey m, Image path, int x, int y, Integer fitImage){
        super(path);
        this.monkey = m;
        this.x = x;
        this.y = y;
        fitImage(fitImage);
    }

    public MyImageView(Obj o, Image path, int x, int y){
        super(path);
        this.obj = o;
        this.x = x;
        this.y = y;
    }

    public MyImageView(Obj o, Image path, int x, int y, Integer fitImage){
        super(path);
        this.obj = o;
        this.x = x;
        this.y = y;
        fitImage(fitImage);
    }

    public MyImageView(Enemy e, Image path, Image battle, Image opening, Image defeatAnim, MyImageView defeat, MyImageView possessedObject, int x, int y){
        super(path);
        this.enemy = e;
        this.battleDefaultIm = battle;
        this.battleOpeningIm = opening;
        this.battleDefeatIm = defeatAnim;
        this.defeat = defeat;
        this.possessedObject = possessedObject;
        this.x = x;
        this.y = y;
    }

    public MyImageView(Door d, Image path, int x, int y){
        super(path);
        this.door = d;
        this.x = x;
        this.y = y;;
    }


    /*** === METHODS === ***/

    // --- GETTER ---

    // -- Enemies get Images --

    //Battle default Image
    public Image getBattleDefaultIm() {
        return this.battleDefaultIm;
    }

    //Battle opening Image
    public Image getBattleOpeningIm() {
        return this.battleOpeningIm;
    }

    //Battle defeat gif
    public Image getBattleDefeatIm() {
        return this.battleDefeatIm;
    }

    //Defeat Image
    public MyImageView getCorpse() {
        return this.defeat;
    }

    public MyImageView getPossessedObject() {
        return this.possessedObject;
    }

    // --- SETTER ---

    // --- DESIGN ---

    // - Fit the height and the width of the ImageView with the given value -
    private void fitImage(Integer val) {
        this.setFitWidth(val);
        this.setFitHeight(val);
    }

}
