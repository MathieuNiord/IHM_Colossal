package view.ressources;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ImageResources {

    private ImageResources() {}

    /**** IMAGES ***/

    // - Hero -
    public final static Image GIF_CAVEMAN = new Image("assets/images/characters/Caveman.gif");

    public final static Image IMAGE_CAVEMAN_DEFAULT_FRONT = new Image("assets/images/characters/CavemanFront.png");
    public final static Image IMAGE_CAVEMAN_DEFAULT_LEFT = new Image("assets/images/characters/CavemanLeft.png");
    public final static Image IMAGE_CAVEMAN_DEFAULT_RIGHT = new Image("assets/images/characters/CavemanRight.png");
    public final static Image IMAGE_CAVEMAN_DEFAULT_BACK = new Image("assets/images/characters/CavemanBack.png");

    public final static Image IMAGE_ARMED_CAVEMAN_FRONT = new Image("assets/images/characters/ArmedCavemanFront.png");
    public final static Image IMAGE_ARMED_CAVEMAN_LEFT = new Image("assets/images/characters/ArmedCavemanLeft.png");
    public final static Image IMAGE_ARMED_CAVEMAN_RIGHT = new Image("assets/images/characters/ArmedCavemanRight.png");
    public final static Image IMAGE_ARMED_CAVEMAN_BACK = new Image("assets/images/characters/ArmedCavemanBack.png");


    // - Animals -
    public final static Image IMAGE_CAT = new Image("assets/images/characters/Cat.gif");
    public final static Image IMAGE_MONKEY = new Image("assets/images/characters/Cat.gif");
    public final static Image IMAGE_MOUSE = new Image("assets/images/characters/Cat.gif");


    // - Enemies -
    public final static Image IMAGE_ACCOUNT_GUY_DEFAULT = new Image("assets/images/characters/AccountGuyDefault.png");
    public final static Image IMAGE_ACCOUNT_GUY_BATTLE = new Image("assets/images/characters/AccountGuyDefault.png");
    public final static Image IMAGE_ACCOUNT_GUY_OPENING = new Image("assets/images/characters/AcountGuyOpening.PNG");
    public final static Image IMAGE_ACCOUNT_GUY_DEFEAT_ANIM = new Image("assets/images/characters/AccountGuyLoose.PNG");
    public final static Image IMAGE_ACCOUNT_GUY_DEFEAT_FIX = new Image("assets/images/characters/AccountGuyLoose.PNG");

    public final static Image IMAGE_NAZI_ZOMBIE_DEFAULT = new Image("assets/images/characters/NaziZombieDefault.png");
    public final static Image IMAGE_NAZI_ZOMBIE_BATTLE = new Image("assets/images/characters/NaziZombieBattleDefault.PNG");
    public final static Image IMAGE_NAZI_ZOMBIE_OPENING = new Image("assets/images/characters/NaziZombieOpening.GIF");
    public final static Image IMAGE_NAZI_ZOMBIE_DEFEAT_ANIM = new Image("assets/images/characters/NaziZombieLoose.GIF");
    public final static Image IMAGE_NAZI_ZOMBIE_DEFEAT_FIX = new Image("assets/images/characters/NaziZombieLoose.PNG");

    public final static Image IMAGE_BOSS_DEFAULT = new Image("assets/images/characters/BossDefault.png");
    public final static Image IMAGE_BOSS_BATTLE = new Image("assets/images/characters/BossBattleDefault.png");
    public final static Image IMAGE_BOSS_OPENING = new Image("assets/images/characters/BossBattleDefault.png");
    public final static Image IMAGE_BOSS_DEFEAT_ANIM = new Image("assets/images/characters/BossBattleLoose.GIF");
    public final static Image IMAGE_BOSS_DEFEAT_FIX = new Image("assets/images/characters/BossLoose.png");


    // - Objects -
    public final static Image IMAGE_BANANA = new Image("assets/images/objects/Banana.png");
    public final static Image IMAGE_BESCHERELLE = new Image("assets/images/objects/Bescherelle.png");
    public final static Image IMAGE_CAT_BESCHERELLE  = new Image("assets/images/objects/CatBescherelle.png");
    public final static Image IMAGE_TORCH = new Image("assets/images/objects/Torch.gif");
    public final static Image IMAGE_NAZIS_POSTER = new Image("assets/images/objects/NazisPoster.png");
    public final static Image IMAGE_SEXY_POSTER = new Image("assets/images/objects/SexyPoster.png");
    public final static Image IMAGE_FLINT = new Image("assets/images/objects/Flint.png");
    public final static Image IMAGE_STICK = new Image("assets/images/objects/Stick.png");
    public final static Image IMAGE_LOCKER_CLOSED = new Image("assets/images/objects/LockerLock.png");
    public final static Image IMAGE_LOCKER_OPENED = new Image("assets/images/objects/LockerOpen.png");
    public final static Image IMAGE_WALKMAN = new Image("assets/images/objects/Walkman.png");
    public final static Image IMAGE_POTION = new Image("assets/images/objects/Potion.png");


    // - Environment -
    public final static Image IMAGE_HEART = new Image("assets/images/environment/Heart.png");
    public final static Image IMAGE_BACKGROUND_DEFAULT = new Image("assets/images/background/floor.png");
    public final static Image IMAGE_BACKGROUND_CORRIDOR = new Image("assets/images/background/corridor.png");
    public final static Image IMAGE_BACKGROUND_NO_LIGHT = new Image("assets/images/background/floor_no_light.png");


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
