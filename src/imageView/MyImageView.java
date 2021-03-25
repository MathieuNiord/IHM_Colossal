package imageView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.characters.Animal;
import model.characters.Enemy;
import model.characters.Monkey;
import model.doors.Door;
import model.objects.Obj;
import model.others.Script;

public class MyImageView extends ImageView {

    /*** ATTRIBUTES ***/
    public int x,y;
    public Animal animal;
    public Door door;
    public Enemy enemy;
    public Monkey monkey;
    public Obj obj;

    /*** CONSTRUCTOR ***/
    public MyImageView(Animal a, String path,int x,int y){
        super();
        this.setImage(new Image(getClass().getResourceAsStream(path)));
        this.animal=a;
        this.x=x;
        this.y=y;
    }
    public MyImageView(Monkey m, String path,int x,int y){
        super();
        this.setImage(new Image(getClass().getResourceAsStream(path)));
        this.monkey=m;
        this.x=x;
        this.y=y;
    }
    public MyImageView(Obj o, String path,int x,int y){
        super();
        this.setImage(new Image(getClass().getResourceAsStream(path)));
        this.obj=o;this.x=x;
        this.y=y;

    }
    public MyImageView(Enemy e, String path,int x,int y){
        super();
        this.setImage(new Image(getClass().getResourceAsStream(path)));
        this.enemy=e;
        this.x=x;
        this.y=y;
    }
    public MyImageView(Door d, String path,int x,int y){
        super();
        this.setImage(new Image(getClass().getResourceAsStream(path)));
        this.door=d;
        this.x=x;
        this.y=y;
    }
}
