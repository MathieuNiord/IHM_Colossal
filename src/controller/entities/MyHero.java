package controller.entities;

import javafx.scene.Cursor;
import model.characters.Hero;
import model.objects.Weapon;
import model.others.Game;
import view.classes.MyGridPane;
import view.classes.MyHeroImageView;
import view.fxmlController.MainController;

import java.util.ArrayList;

import static controller.entities.EntitiesDatas.MY_HERO;
import static view.ressources.GameResources.CLUB_IM;
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

    public void addObj(MyEntity obj, MainController mainController, String text, boolean isOnGridGame){
        this.inventory.add(obj);

        obj.obj_model.take(this.model);
        obj.obj_model.setDraggableTrue();
        obj.view.setCursor(Cursor.HAND);
        this.view.getInvView().getChildren().add(obj.view);

        if(isOnGridGame){
            mainController.removeOnGridPane(obj.view);
            MyPlace currentPlace =  PLACE_TO_MY_PLACE.get(this.getModel().getPlace());
            currentPlace.getEntities().remove(obj);
        }
        if(text != null) mainController.setOnGameLabel(text);


    }

    public void remClub(MainController mainController){

        Weapon club = Game.CLUB;

        club.take(this.model);

        if(mainController != null){
            mainController.removeOnGridPane(EntitiesDatas.MY_CLUB.view);
            MyPlace currentPlace =  PLACE_TO_MY_PLACE.get(this.getModel().getPlace());
            currentPlace.getEntities().remove(EntitiesDatas.MY_CLUB);
        }
    }

    public void takeKey(MainController mainController, MyEntity entity){
        MY_HERO.getModel().increaseKey();
        mainController.removeOnGridPane(entity.view);
        PLACE_TO_MY_PLACE.get(MY_HERO.getModel().getPlace()).getEntities().remove(entity);

        mainController.setOnGameLabel("You found a key");
    }

}
