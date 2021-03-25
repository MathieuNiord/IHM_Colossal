package imageView;

import javafx.scene.image.ImageView;
import model.characters.Animal;
import model.characters.Enemy;
import model.characters.Monkey;
import model.doors.Door;
import model.objects.Obj;
import model.others.Script;

public class MyImageView extends ImageView {

    /*** ATTRIBUTES ***/
    public  Animal animal;
    public  Door door;
    public  Enemy enemy;
    public  Monkey monkey;
    public  Obj obj;

    /*** CONSTRUCTOR ***/
    public MyImageView(){
        super();
    }

    /*** METHODS ***/

    // - this method is used to set an animal to an image of our display -
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    // - this method is used to set a door to an image of our display -
    public void setDoor(Door door) {
        this.door = door;
    }

    // - this method is used to set an enemy to an image of our display -
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    // - this method is used to set a monkey to an image of our display -
    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }

    // - this method is used to set an object to an image of our display -
    public void setObj(Obj obj) {
        this.obj = obj;
    }
}
