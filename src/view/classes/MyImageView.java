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
    private final Image battleDefaultIm;
    private final Image battleOpeningIm;
    private final Image battleDefeatIm;
    private final Image defeatFixIm;


    /*** CONSTRUCTOR ***/

    public MyImageView(Animal a, Image path, int x, int y, Integer fitImage){
        super(path);
        this.animal = a;
        this.x = x;
        this.y = y;
        fitImage(fitImage);
        this.battleDefaultIm = null;
        this.battleOpeningIm = null;
        this.battleDefeatIm = null;
        this.defeatFixIm = null;
    }

    public MyImageView(Monkey m, Image path, int x, int y, Integer fitImage){
        super(path);
        this.monkey = m;
        this.x = x;
        this.y = y;
        fitImage(fitImage);
        this.battleDefaultIm = null;
        this.battleOpeningIm = null;
        this.battleDefeatIm = null;
        this.defeatFixIm = null;
    }

    public MyImageView(Obj o, Image path, int x, int y, Integer fitImage){
        super(path);
        this.obj = o;
        this.x = x;
        this.y = y;
        fitImage(fitImage);
        this.battleDefaultIm = null;
        this.battleOpeningIm = null;
        this.battleDefeatIm = null;
        this.defeatFixIm = null;
    }

    public MyImageView(Enemy e, Image path, Image battle, Image opening, Image defeatAnim, Image defeatFix, int x, int y){
        super(path);
        this.enemy = e;
        this.battleDefaultIm = battle;
        this.battleOpeningIm = opening;
        this.battleDefeatIm = defeatAnim;
        this.defeatFixIm = defeatFix;
        this.x = x;
        this.y = y;
    }

    public MyImageView(Door d, Image path, int x, int y){
        super(path);
        this.door = d;
        this.x = x;
        this.y = y;
        this.battleDefaultIm = null;
        this.battleOpeningIm = null;
        this.battleDefeatIm = null;
        this.defeatFixIm = null;
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
    public Image getDefeatFixIm() {
        return this.defeatFixIm;
    }

    // --- SETTER ---

    // --- DESIGN ---

    // - Fit the height and the width of the ImageView with the given value -
    private void fitImage(Integer val) {
        this.setFitWidth(val);
        this.setFitHeight(val);
    }

}
