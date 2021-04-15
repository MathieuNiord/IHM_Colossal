package view.ressources;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ImageRessources {

    private ImageRessources() {}

    //IMAGES

    // - Hero -
    public final static Image GIF_CAVEMAN = new Image("assets/images/characters/caveman.gif");
    public final static Image IMAGE_CAVEMAN_BACK = new Image("assets/images/characters/cavemanBack.png");
    public final static Image IMAGE_CAVEMAN_FRONT = new Image("assets/images/characters/cavemanFix.png");

    // - Animals -
    public final static Image IMAGE_CAT = new Image("assets/images/characters/cat.gif");
    public final static Image IMAGE_MONKEY = new Image("assets/images/characters/cat.gif");
    public final static Image IMAGE_MOUSE = new Image("assets/images/characters/cat.gif");

    // - Enemies -
    public final static Image IMAGE_ACCOUNT_GUY = new Image("assets/images/characters/AccountGuyDefault.png");
    public final static Image IMAGE_NAZI_ZOMBIE = new Image("assets/images/characters/NaziZombieDefault.png");
    public final static Image IMAGE_BOSS = new Image("assets/images/characters/BossDefault.png");

    // - Objects -
    public final static Image IMAGE_BANANA = new Image("assets/images/objects/Banana.png");
    public final static Image IMAGE_BESCHERELLE = new Image("assets/images/objects/Bescherelle.png");
    public final static Image IMAGE_CAT_BESCHERELLE  = new Image("assets/images/objects/CatBescherelle.png");
    public final static Image IMAGE_TORCH = new Image("assets/images/place/Torch.gif");
    public final static Image IMAGE_NAZIS_POSTER = new Image("assets/images/objects/NazisPoster.png");
    public final static Image IMAGE_FLINT = new Image("assets/images/objects/Flint.png");
    public final static Image IMAGE_STICK = new Image("assets/images/objects/Stick.png");

    // - Environment -
    public final static Image IMAGE_HEART = new Image("assets/images/environment/Heart.png");
    public final static Image IMAGE_BACKGROUND_DEFAULT = new Image("assets/images/place/floor.png");
    public final static Image IMAGE_BACKGROUND_CORRIDOR = new Image("assets/images/place/corridor.png");
    public final static Image IMAGE_BACKGROUND_NO_LIGHT = new Image("assets/images/place/floor_no_light.png");

    // - Doors -
    public final static Image IMAGE_DOOR_UP = new Image("assets/images/place/BasicDoorUp.png");
    public final static Image IMAGE_DOOR_LEFT = new Image("assets/images/place/BasicDoorLeft.png");
    public final static Image IMAGE_DOOR_RIGHT = new Image("assets/images/place/BasicDoorRight.png");
    public final static Image IMAGE_DOOR_DOWN = new Image("assets/images/place/BasicDoorDown.png");

    public final static BackgroundImage BACKGROUND_IMAGE_DEFAULT = new BackgroundImage(IMAGE_BACKGROUND_DEFAULT,
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    public final static BackgroundImage BACKGROUND_IMAGE_CORRIDOR = new BackgroundImage(IMAGE_BACKGROUND_CORRIDOR,
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    public final static BackgroundImage BACKGROUND_IMAGE_NO_LIGHT = new BackgroundImage(IMAGE_BACKGROUND_NO_LIGHT,
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    public final static Background BACKGROUND_DEFAULT = new Background(BACKGROUND_IMAGE_DEFAULT);
    public final static Background BACKGROUND_CORRIDOR = new Background(BACKGROUND_IMAGE_CORRIDOR);
    public final static Background BACKGROUND_NO_lIGHT = new Background(BACKGROUND_IMAGE_NO_LIGHT);
}
