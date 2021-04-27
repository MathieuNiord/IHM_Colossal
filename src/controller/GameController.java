package controller;

import controller.entities.MyEntity;
import javafx.scene.control.TextInputDialog;
import model.characters.Hero;
import model.doors.BurnableDoor;
import model.doors.DestructableDoor;
import model.doors.SecretCodeDoor;
import model.objects.ElectricityMeter;
import model.others.Place;
import model.others.Script;
import controller.entities.MyPlace;
import view.classes.MyDialog;
import view.fxmlController.AnimalScript;
import view.fxmlController.Main;
import view.ressources.ImageResources;

import static controller.entities.EntitiesDatas.*;
import static view.ressources.GameResources.*;
import static view.ressources.ImageResources.BACKGROUND_DEFAULT;
import static view.ressources.ImageResources.IMAGE_ELECTRIC_METER_FIXED;

public class GameController {

    /** === ATTRIBUTES === **/

    private final Main main;

    /** === CONSTRUCTOR === **/

    public GameController(Main main){ this.main = main; }

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
        MY_HERO.addObj(MY_FIREDSTICK, main, "Great you create a firedstick !", false);
        MY_HERO.removeObj(MY_FLINT);
        MY_HERO.removeObj(MY_STICK);
    }

    // --- -------------------------- --- //
    // --- FiredStick to BurnableDoor --- //
    // --- -------------------------- --- //

    public void burnDoor(){
        BurnableDoor door = (BurnableDoor) MY_SECRET_PASSAGE.door_model;
        door.unlock();
        door.open();
        MY_HERO.removeObj(MY_FIREDSTICK);
        MY_SECRET_PASSAGE.view.setImage(ImageResources.IMAGE_SECRET_PASSAGE_OPENED);
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
        ((ElectricityMeter) MY_ELECTRICITY_METER.obj_model).place.setEnlightened();
        lightUpRoom(MY_COLD_ROOM);
        MY_ELECTRICITY_METER.view.setImage(IMAGE_ELECTRIC_METER_FIXED);
    }

    // --- ------------------- --- //
    // --- Player Interactions --- //
    // --- ------------------- --- //

    // - This function regroups all interaction's constraints of the player -
    public void heroInteractWithIm(MyEntity entity) {

        Hero hero = MY_HERO.getModel();

        // -- Animals --
        if (entity.animal_model != null || entity.monkey_model != null){

            //Dialog
            AnimalScriptController.setAnimal(entity);
            new AnimalScript();
            MyDialog myStage = new MyDialog("../fxml/animal_script.fxml");
            myStage.showAndWait();
        }

        // -- Objects --
        if (entity.obj_model != null) {
            this.interactWitObj(entity);
        }

        // -- Doors --
        if (entity.door_model != null) {
            this.interactWithDoor(entity, hero);
        }
    }

    // --- -------------------------------- --- //
    // --- Player Interactions with objects --- //
    // --- -------------------------------- --- //

    private void interactWitObj(MyEntity entity){
        // If the object is a key (specific take() method)
        if (entity.obj_model.NAME.equals(Script.DEFAULT_KEY1_NAME) || entity.obj_model.NAME.equals(Script.DEFAULT_KEY2_NAME)) {
            MY_HERO.takeKey(main, entity);
        }

        // Else if the object isn't the electric meter or the locker or a corpse, the player can take it in his inventory
        else if (!entity.obj_model.NAME.equals(Script.DEFAULT_ELECTRICMETER_NAME) &&
                !entity.obj_model.NAME.equals(Script.DEFAULT_LOCKER_NAME) &&
                !entity.obj_model.NAME.equals(Script.DEFAULT_CORPSE_NAME)) {

            //Banana case when the cold room is unlighted
            if (!entity.view.isVisible()) entity.view.setVisible(true);

            if (entity.obj_model.NAME.equals(Script.DEFAULT_CLUB_NAME))
                MY_HERO.remClub(main);

            else
                MY_HERO.addObj(entity, main, "You found a " + entity.obj_model.NAME, true);
        }

        // Else if it is the locker
        else if (entity.obj_model.NAME.equals(Script.DEFAULT_LOCKER_NAME)) {

            MY_HERO.addObj(MY_WALKMAN, main, "You found a walkman", false);
            LOCKER_IM.setImage(ImageResources.IMAGE_LOCKER_OPENED);
        }
    }

    // --- ------------------------------ --- //
    // --- Player Interactions with doors --- //
    // --- ------------------------------ --- //

    private void interactWithDoor(MyEntity entity, Hero hero){

        //SecretCodeDoor case
        if (entity.door_model instanceof SecretCodeDoor) {

            SecretCodeDoor d = (SecretCodeDoor) entity.door_model;

            if (!d.isUnlock()) {

                // TextInputDialog Component
                TextInputDialog code = new TextInputDialog();
                code.setHeaderText("NEED A CODE");
                code.getEditor().setPromptText("CODE");
                code.showAndWait();

                // Unlock and open the door
                d.unlock(code.getResult());
            }

            if (d.isUnlock()) {
                heroCrossDoor(entity, hero);
                main.setOnGameLabel(hero.getPlace().getName());
                main.refreshMap();
            }
            else
                main.setOnGameLabel(entity.door_model.getDescription());
        }

        else {

            // To not have the same description of the door after destroying it
            if (entity.door_model instanceof DestructableDoor && MY_HERO.getModel().getObjs().containsKey(Script.DEFAULT_CLUB_NAME))
                entity.door_model.setDescription("");

            heroCrossDoor(entity, hero);

            main.setOnGameLabel(entity.door_model.getDescription());
            main.setOnGameTitle(hero.getPlace().getName());
            main.refreshMap();
        }
    }

    // --- ----- --- //
    // --- Doors --- //
    // --- ----- --- //

    // - This function permits the player to cross doors -
    private void heroCrossDoor(MyEntity entity, Hero hero) {

        String dest = null;

        //First we get the good place
        for(String s : entity.door_model.getPlaces().keySet()) {
            if(!s.equals(hero.getPlace().getName())){
                dest = s;
                break;
            }
        }

        if(dest != null) {

            entity.door_model.cross(hero,dest);

            if (hero.getPlace().getName().equals(dest)) {

                MyPlace newPlace = PLACE_TO_MY_PLACE.get(hero.getPlace());
                main.setNewPlace(newPlace);

                main.setOnGameLabel("You entered in the " + hero.getPlace().getName());

                //If the new place is the archive room by passing through the secret passage, we set a position to the player
                if (dest.equals("archives room") && entity.door_model instanceof BurnableDoor) {
                    HERO_IM.x.setValue(4);
                    HERO_IM.y.setValue(1);
                }

                //Else we check if the hero is in the last room
                else if (dest.equals("exit")) {
                    if (hero.isAlive() && !hero.isQuit()) {
                        main.exitGame();
                    }
                }

                //Else we compute the new position of the player in the room
                else main.heroPosDoor(newPlace, entity);
            }
        }
    }

    // --- ---------- --- //
    // --- Use object --- //
    // --- ---------- --- //

    // When you double click on your inventory's object
    public void useObj(MyEntity entity){
        if (entity.obj_model != null) {

            if((entity.obj_model.NAME.equals(Script.DEFAULT_SEXYPOSTER_1_NAME) ||
                    entity.obj_model.NAME.equals(Script.DEFAULT_SEXYPOSTER_2_NAME)) &&
                    MY_HERO.getModel().getHP() >= Hero.DEFAULT_HP){
                main.setOnGameLabel("Your life is already full");
            }
            else if(!entity.obj_model.SIMPLE_USE.equals(""))
                main.setOnGameLabel(entity.obj_model.SIMPLE_USE);


            entity.obj_model.use(MY_HERO.getModel());

            if (entity.obj_model.NAME.equals(Script.DEFAULT_POTION_NAME) ||
                    entity.obj_model.NAME.equals(Script.DEFAULT_NAZIPOSTER_NAME) ||
                    entity.obj_model.NAME.equals(Script.DEFAULT_SEXYPOSTER_1_NAME) ||
                    entity.obj_model.NAME.equals(Script.DEFAULT_SEXYPOSTER_2_NAME)
            ) MY_HERO.getView().getInvView().getChildren().remove(entity.view);

            main.setOnDescObj("","");

        }
    }
}
