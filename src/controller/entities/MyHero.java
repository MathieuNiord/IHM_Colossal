package controller.entities;

import javafx.scene.Cursor;
import model.characters.Hero;
import view.classes.MyGridPane;
import view.classes.MyHeroImageView;

import java.util.ArrayList;

import static view.ressources.GameResources.PLACE_TO_MY_PLACE;

public class MyHero {
    private Hero model;
    private MyHeroImageView view;
    public ArrayList<MyEntity> inventory = new ArrayList<>();


    public MyHero(Hero hero, MyHeroImageView heroIm){
        this.model = hero;
        this.view = heroIm;
    }

    public Hero getModel() { return this.model; }

    public MyHeroImageView getView() { return  this.view; }

    public void removeObj(MyEntity obj){
        this.inventory.remove(obj);

        this.model.getObjs().remove(obj.obj_model.NAME);
        this.view.getInvView().getChildren().remove(obj.view);
    }

    public void addObj(MyEntity obj, MyGridPane gridPaneGame){
        this.inventory.add(obj);

        obj.obj_model.take(this.model);
        obj.obj_model.setDraggableTrue();
        obj.view.setCursor(Cursor.HAND);
        this.view.getInvView().getChildren().add(obj.view);

        if(gridPaneGame != null){
            gridPaneGame.myRemove(obj.view);
            MyPlace currentPlace =  PLACE_TO_MY_PLACE.get(this.getModel().getPlace());
            currentPlace.getEntities().remove(obj);
        }
    }

}
