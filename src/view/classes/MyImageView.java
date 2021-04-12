package view.classes;

import javafx.scene.image.ImageView;
import model.characters.Animal;
import model.characters.Enemy;
import model.characters.Monkey;
import model.doors.Door;
import model.objects.Obj;

public class MyImageView extends ImageView {

    /*** ATTRIBUTES ***/
    private final int x,y;
    private Animal animal;
    private Door door;
    private Enemy enemy;
    private Monkey monkey;
    private Obj obj;

    /*** CONSTRUCTOR ***/

    public MyImageView(Animal a, String path,int x,int y, Integer fitImage){
        super(path);
        this.animal = a;
        this.x = x;
        this.y = y;
        fitImage(fitImage);
    }
    public MyImageView(Monkey m, String path,int x,int y){
        super(path);
        this.monkey = m;
        this.x = x;
        this.y = y;
    }
    public MyImageView(Obj o, String path,int x,int y, Integer fitImage){
        super(path);
        this.obj = o;
        this.x = x;
        this.y = y;
        fitImage(fitImage);
    }
    public MyImageView(Enemy e, String path,int x,int y){
        super(path);
        this.enemy = e;
        this.x = x;
        this.y = y;
    }
    public MyImageView(Door d, String path,int x,int y){
        super(path);
        this.door = d;
        this.x = x;
        this.y = y;
    }

    /*** === METHODS === ***/

    // --- GETTER ---

    // --- SETTER ---

    // --- DESIGN ---

    // - Fit the height and the width of the ImageView with the given value -
    private void fitImage(Integer val) {
        this.setFitWidth(val);
        this.setFitHeight(val);
    }

}
