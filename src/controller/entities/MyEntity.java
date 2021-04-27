package controller.entities;

import model.characters.*;
import model.doors.Door;
import model.objects.Obj;
import view.classes.MyImageView;

public class MyEntity {

    /*** === ATTRIBUTES === ***/

    public Animal animal_model;
    public Door door_model;
    public Enemy enemy_model;
    public Monkey monkey_model;
    public Obj obj_model;
    public MyImageView view;
    private MyEntity defeat = null;
    private MyEntity possessedObject = null;

    /*** === CONSTRUCTORS === ***/

    public MyEntity(Enemy enemy, MyImageView myImageView, MyEntity defeat, MyEntity possessedObject){
        this.enemy_model = enemy;
        this.view = myImageView;
        this.defeat = defeat;
        this.possessedObject = possessedObject;
    }

    public MyEntity(Enemy enemy, MyImageView myImageView){
        this.enemy_model = enemy;
        this.view = myImageView;
    }

    public MyEntity(Monkey monkey, MyImageView myImageView){
        this.monkey_model = monkey;
        this.view = myImageView;
    }

    public MyEntity(MyImageView myImageView){
        this.view = myImageView;
    }

    public MyEntity(Obj obj, MyImageView myImageView){
        this.obj_model = obj;
        this.view = myImageView;
    }

    public MyEntity(Animal animal, MyImageView myImageView){
        this.animal_model = animal;
        this.view = myImageView;
    }

    public MyEntity(Door door, MyImageView myImageView){
        this.door_model = door;
        this.view = myImageView;
    }


    /*** === METHODS === ***/

    // - Enemies methods -
    public MyEntity getCorpse() {
        return this.defeat;
    }
    public MyEntity getPossessedObject() {
        return this.possessedObject;
    }

}
