package controller.entities;

import javafx.scene.Cursor;
import model.characters.Hero;
import model.objects.Weapon;
import model.others.Game;
import view.classes.MyHeroImageView;
import view.fxmlController.Main;

import java.util.ArrayList;

import static controller.entities.EntitiesDatas.MY_HERO;
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

    public void addObj(MyEntity obj, Main main, String text, boolean isOnGridGame){
        this.inventory.add(obj);

        obj.obj_model.take(this.model);
        obj.obj_model.setDraggableTrue();
        obj.view.setCursor(Cursor.HAND);
        this.view.getInvView().getChildren().add(obj.view);

        if(isOnGridGame){
            main.removeOnGridPane(obj.view);
            MyPlace currentPlace =  PLACE_TO_MY_PLACE.get(this.getModel().getPlace());
            currentPlace.getEntities().remove(obj);
        }
        if(text != null) main.setOnGameLabel(text);


    }

    public void remClub(Main main){

        Weapon club = Game.CLUB;

        club.take(this.model);

        if(main != null){
            main.removeOnGridPane(EntitiesDatas.MY_CLUB.view);
            MyPlace currentPlace =  PLACE_TO_MY_PLACE.get(this.getModel().getPlace());
            currentPlace.getEntities().remove(EntitiesDatas.MY_CLUB);
        }
    }

    public void takeKey(Main main, MyEntity entity){
        MY_HERO.getModel().increaseKey();
        main.removeOnGridPane(entity.view);
        PLACE_TO_MY_PLACE.get(MY_HERO.getModel().getPlace()).getEntities().remove(entity);

        main.setOnGameLabel("You found a key");
    }

}
