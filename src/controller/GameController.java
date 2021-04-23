package controller;

import javafx.scene.layout.FlowPane;
import model.doors.BurnableDoor;
import model.objects.ElectricityMeter;
import model.others.Game;
import model.others.Place;
import model.others.Script;
import controller.entities.MyPlace;

import static controller.entities.EntitiesDatas.*;
import static view.ressources.GameResources.*;
import static view.ressources.ImageResources.BACKGROUND_DEFAULT;
import static view.ressources.ImageResources.IMAGE_ELECTRIC_METER_FIXED;

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
        MY_MONKEY.monkey_model.setHungry(false);
        MY_HERO.removeObj(MY_BANANA);
    }

    // --- ------------------- --- //
    // --- FiredStick to Flint --- //
    // --- Flint to FiredStick --- //
    // --- ------------------- --- //

    public void makeFiredStick(){
        // the object isn't on the board
        MY_HERO.addObj(MY_FIREDSTICK, null);
        MY_HERO.removeObj(MY_FLINT);
        MY_HERO.removeObj(MY_STICK);
    }

    // --- -------------------------- --- //
    // --- FiredStick to BurnableDoor --- //
    // --- -------------------------- --- //

    public void burnDoor(){
        BurnableDoor door =(BurnableDoor) MY_SECRET_PASSAGE.door_model;
        Game.printLetterByLetter("Congrats ! You can now pass !\n", Script.DEFAULT_NARRATOR);
        door.unlock();
        door.open();
        MY_HERO.removeObj(MY_FIREDSTICK);
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
        MY_HERO.removeObj(MY_FUSE);
        ((ElectricityMeter) MY_ELECTRICITY_METER.obj_model).setHasFuse();
        Game.printLetterByLetter("You just added the missing " + Script.DEFAULT_FUSE_NAME + "\n", Script.DEFAULT_NARRATOR);
        ((ElectricityMeter) MY_ELECTRICITY_METER.obj_model).place.setEnlightened();
        lightUpRoom(MY_COLD_ROOM);
        MY_ELECTRICITY_METER.view.setImage(IMAGE_ELECTRIC_METER_FIXED);
    }

}
