package controller;

import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import model.doors.BurnableDoor;
import model.objects.ElectricityMeter;
import model.others.Game;
import model.others.Place;
import model.others.Script;
import view.classes.MyImageView;
import view.classes.MyPlace;
import static view.ressources.ImageRessources.*;
import static view.ressources.GameRessources.*;


public class GameResourcesController {

    /** === ATTRIBUTES === **/
    private final FlowPane inventory;

    /** === METHODS === **/

    // --- ------------------------------------- --- //
    // --- Sub-function for manage drag and drop --- //
    // --- ------------------------------------- --- //

    private void objHandleOver(DragEvent event, MyImageView target){
        if ((event.getDragboard().getString().equals(target.obj.NAME)) &&
                event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    private void objHandleDetected(MouseEvent event, MyImageView source){
        if(source.obj.getDraggable()){
            Dragboard db = source.startDragAndDrop(TransferMode.ANY);

            /* Put a string on a dragboard */
            ClipboardContent content = new ClipboardContent();
            content.putString(source.obj.NAME);
            db.setContent(content);
        }
        event.consume();
    }


    // --- ---------------- --- //
    // --- Banana to monkey --- //
    // --- ---------------- --- //

    private void monkeyHandleDrop(DragEvent event){
        // data dropped
        Dragboard db = event.getDragboard();
        boolean success = false;

        if(db.hasString()){
            success = true;
            MONKEY_IM.monkey.setHungry(false);
            HERO_IM.hero.getObjs().remove(BANANA_IM.obj.NAME);
            inventory.getChildren().remove(BANANA_IM);
        }

        event.setDropCompleted(success);
        event.consume();
    }

    private void monkeyDrag(){
        // source
        BANANA_IM.setOnDragDetected(event -> objHandleDetected(event, BANANA_IM));

        // target
        MONKEY_IM.setOnDragOver(event -> objHandleOver(event, BANANA_IM));

        MONKEY_IM.setOnDragDropped(event -> monkeyHandleDrop(event));
    }


    // --- ------------------- --- //
    // --- FiredStick to Flint --- //
    // --- Flint to FiredStick --- //
    // --- ------------------- --- //

    private void firedStickHandleDrop(DragEvent event){
        // data dropped
        Dragboard db = event.getDragboard();
        boolean success = false;

        if (db.hasString()) {
            success = true;
            HERO_IM.hero.getObjs().remove(FLINT_IM.obj.NAME);
            HERO_IM.hero.getObjs().remove(STICK_IM.obj.NAME);
            HERO_IM.hero.getObjs().put(FIREDSTICK_IM.obj.NAME, FIREDSTICK_IM.obj);
            this.inventory.getChildren().remove(FLINT_IM);
            this.inventory.getChildren().remove(STICK_IM);
            this.inventory.getChildren().add(FIREDSTICK_IM);
            FIREDSTICK_IM.obj.setDraggableTrue();
        }

        event.setDropCompleted(success);
        event.consume();
    }

    private void firedStickDrag(){
        //sources
        STICK_IM.setOnDragDetected(event -> objHandleDetected(event, STICK_IM));

        FLINT_IM.setOnDragDetected(event -> objHandleDetected(event, FLINT_IM));

        // target
        FLINT_IM.setOnDragOver(event -> objHandleOver(event, STICK_IM));

        FLINT_IM.setOnDragDropped(event -> firedStickHandleDrop(event));

        STICK_IM.setOnDragOver(event -> objHandleOver(event, FLINT_IM));

        STICK_IM.setOnDragDropped(event -> firedStickHandleDrop(event));
    }


    // --- -------------------------- --- //
    // --- FiredStick to BurnableDoor --- //
    // --- -------------------------- --- //

    private void secretPassageHandleDrop(DragEvent event){
        // data dropped
        Dragboard db = event.getDragboard();
        boolean success = false;
        if(db.hasString()){
            success = true;
            BurnableDoor door =(BurnableDoor) SECRET_PASSAGE_IM.door;
            Game.printLetterByLetter("Congrats ! You can now pass !\n", Script.DEFAULT_NARRATOR);
            door.unlock();
            door.open();
            HERO_IM.hero.getObjs().remove(Script.DEFAULT_FIREDSTICK_NAME);
            this.inventory.getChildren().remove(FIREDSTICK_IM);
        }
        event.setDropCompleted(success);
        event.consume();
    }

    private void burnedDoor(){
        // source
        FIREDSTICK_IM.setOnDragDetected(event -> objHandleDetected(event, FIREDSTICK_IM));

        // target
        SECRET_PASSAGE_IM.setOnDragOver(event -> objHandleOver(event, FIREDSTICK_IM));

        SECRET_PASSAGE_IM.setOnDragDropped(event -> secretPassageHandleDrop(event));
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
    private void electricityMeterHandleDrop(DragEvent event){
        // data dropped
        Dragboard db = event.getDragboard();
        boolean success = false;

        if(db.hasString()){
            success = true;
            HERO_IM.hero.getObjs().remove(Script.DEFAULT_FUSE_NAME);
            inventory.getChildren().remove(FUSE_IM);
            ((ElectricityMeter) ELECTRICITY_METER_IM.obj).setHasFuse();
            Game.printLetterByLetter("You just added the missing " + Script.DEFAULT_FUSE_NAME + "\n", Script.DEFAULT_NARRATOR);
            ((ElectricityMeter) ELECTRICITY_METER_IM.obj).place.setEnlightened();
            lightUpRoom(MY_COLD_ROOM);

        }

        event.setDropCompleted(success);
        event.consume();
    }

    private void putFuseElectricMeter(){
        // source
        FUSE_IM.setOnDragDetected(event -> objHandleDetected(event, FUSE_IM));

        // target
        ELECTRICITY_METER_IM.setOnDragOver(event -> objHandleOver(event, FUSE_IM));

        ELECTRICITY_METER_IM.setOnDragDropped(event -> electricityMeterHandleDrop(event));
    }


    // --- Final --- //

    public GameResourcesController(FlowPane inventory){
        this.inventory = inventory;
        monkeyDrag();
        firedStickDrag();
        burnedDoor();
        putFuseElectricMeter();
    }
}
