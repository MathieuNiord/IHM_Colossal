package controller;

import javafx.scene.image.ImageView;
import model.characters.Hero;

public class MyHeroImageView extends ImageView {
    public final Hero hero;
    public MyHeroImageView(){
        super();
        this.hero =new Hero("caveman", null);
    }
}
