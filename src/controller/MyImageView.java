package controller;

import javafx.scene.image.ImageView;
import model.characters.Animal;
import model.characters.Enemy;
import model.characters.Monkey;
import model.doors.Door;
import model.objects.Obj;
import model.others.Script;

public class MyImageView extends ImageView {
    public  Animal animal;
    public  Door door;
    public  Enemy enemy;
    public  Monkey monkey;
    public  Obj obj;

    public MyImageView(){
        super();
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }

    public void setObj(Obj obj) {
        this.obj = obj;
    }
}
