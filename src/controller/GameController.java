package controller;

import javafx.scene.layout.FlowPane;
import model.doors.BurnableDoor;
import model.objects.Banana;
import model.objects.ElectricityMeter;
import model.others.Game;
import model.others.Place;
import model.others.Script;
import view.classes.MyPlace;

import static view.ressources.GameResources.*;
import static view.ressources.ImageResources.BACKGROUND_DEFAULT;

public class GameController {
    /** === ATTRIBUTES === **/
    private final FlowPane inventory;

    /** === CONSTRUCTEUR === **/
    public GameController(FlowPane inventory){
        this.inventory = inventory;
    }


    /** === METHODS === **/

    // --- ---------------- --- //
    // --- Banana to monkey --- //
    // --- ---------------- --- //

    public void giveBananaToMonkey(){
        MONKEY_IM.monkey.setHungry(false);
        HERO_IM.hero.getObjs().remove(BANANA_IM.obj.NAME);
        inventory.getChildren().remove(BANANA_IM);
    }

    // --- ------------------- --- //
    // --- FiredStick to Flint --- //
    // --- Flint to FiredStick --- //
    // --- ------------------- --- //

    public void makeFiredStick(){
        HERO_IM.hero.getObjs().remove(FLINT_IM.obj.NAME);
        HERO_IM.hero.getObjs().remove(STICK_IM.obj.NAME);
        HERO_IM.hero.getObjs().put(FIREDSTICK_IM.obj.NAME, FIREDSTICK_IM.obj);
        this.inventory.getChildren().remove(FLINT_IM);
        this.inventory.getChildren().remove(STICK_IM);
        this.inventory.getChildren().add(FIREDSTICK_IM);
        FIREDSTICK_IM.obj.setDraggableTrue();
    }

    // --- -------------------------- --- //
    // --- FiredStick to BurnableDoor --- //
    // --- -------------------------- --- //

    public void burnDoor(){
        BurnableDoor door =(BurnableDoor) SECRET_PASSAGE_IM.door;
        Game.printLetterByLetter("Congrats ! You can now pass !\n", Script.DEFAULT_NARRATOR);
        door.unlock();
        door.open();
        HERO_IM.hero.getObjs().remove(Script.DEFAULT_FIREDSTICK_NAME);
        this.inventory.getChildren().remove(FIREDSTICK_IM);
    }

    // --- --------------------- --- //
    // --- Fuse to ElectricMeter --- //
    // --- --------------------- --- //

    private void lightUpRoom(MyPlace my_place) {
        Place place = obtainPlace(my_place);
        if (place != null) {
            if (place.isEnlightened()) {
                my_place.setBackgroundImage(BACKGROUND_DEFAULT);
                my_place.setImagesVisible();
            }
        }
    }

    public void putFuzeIntoElectricMeter(){
        HERO_IM.hero.getObjs().remove(Script.DEFAULT_FUSE_NAME);
        inventory.getChildren().remove(FUSE_IM);
        ((ElectricityMeter) ELECTRICITY_METER_IM.obj).setHasFuse();
        Game.printLetterByLetter("You just added the missing " + Script.DEFAULT_FUSE_NAME + "\n", Script.DEFAULT_NARRATOR);
        ((ElectricityMeter) ELECTRICITY_METER_IM.obj).place.setEnlightened();
        lightUpRoom(MY_COLD_ROOM);
    }

}
