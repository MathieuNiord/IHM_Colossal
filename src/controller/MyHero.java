package controller;

import model.characters.Hero;
import view.classes.MyHeroImageView;

public class MyHero {
    private final Hero model;
    private final MyHeroImageView view;

    public MyHero(Hero hero, MyHeroImageView heroIm){
        this.model = hero;
        this.view = heroIm;
    }

    public Hero getModel() { return this.model; }

    public MyHeroImageView getView() { return  this.view; }

}
