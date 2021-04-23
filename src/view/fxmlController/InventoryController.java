package view.fxmlController;

import controller.GameController;
import controller.entities.MyEntity;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import model.others.Place;
import controller.entities.MyPlace;

import static controller.entities.EntitiesDatas.*;
import static view.ressources.ImageResources.*;
import static view.ressources.GameResources.*;


public class InventoryController {

    /** === ATTRIBUTES === **/
    private GameController gameController;

    /** === METHODS === **/

    // --- ------------------------------------- --- //
    // --- Sub-function for manage drag and drop --- //
    // --- ------------------------------------- --- //

    private void objHandleOver(DragEvent event, MyEntity target){
        if ((event.getDragboard().getString().equals(target.obj_model.NAME)) &&
                event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    private void objHandleDetected(MouseEvent event, MyEntity source){
        if(source.obj_model.getDraggable()){
            Dragboard db = source.view.startDragAndDrop(TransferMode.ANY);

            /* Put a string on a dragboard */
            ClipboardContent content = new ClipboardContent();
            content.putString(source.obj_model.NAME);
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
            this.gameController.giveBananaToMonkey();
        }

        event.setDropCompleted(success);
        event.consume();
    }

    private void monkeyDrag(){
        // source
        BANANA_IM.setOnDragDetected(event -> objHandleDetected(event, MY_BANANA));

        // target
        MONKEY_IM.setOnDragOver(event -> objHandleOver(event, MY_BANANA));

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
            this.gameController.makeFiredStick();
        }

        event.setDropCompleted(success);
        event.consume();
    }

    private void firedStickDrag(){
        //sources
        STICK_IM.setOnDragDetected(event -> objHandleDetected(event, MY_STICK));

        FLINT_IM.setOnDragDetected(event -> objHandleDetected(event, MY_FLINT));

        // target
        FLINT_IM.setOnDragOver(event -> objHandleOver(event, MY_STICK));

        FLINT_IM.setOnDragDropped(event -> firedStickHandleDrop(event));

        STICK_IM.setOnDragOver(event -> objHandleOver(event, MY_FLINT));

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
            this.gameController.burnDoor();
        }
        event.setDropCompleted(success);
        event.consume();
    }

    private void burnedDoor(){
        // source
        FIREDSTICK_IM.setOnDragDetected(event -> objHandleDetected(event, MY_FIREDSTICK));

        // target
        SECRET_PASSAGE_IM.setOnDragOver(event -> objHandleOver(event, MY_FIREDSTICK));

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
            this.gameController.putFuzeIntoElectricMeter();

        }

        event.setDropCompleted(success);
        event.consume();
    }

    private void putFuseElectricMeter(){
        // source
        FUSE_IM.setOnDragDetected(event -> objHandleDetected(event, MY_FUSE));

        // target
        ELECTRICITY_METER_IM.setOnDragOver(event -> objHandleOver(event, MY_FUSE));

        ELECTRICITY_METER_IM.setOnDragDropped(event -> electricityMeterHandleDrop(event));
    }


    // --- Final --- //

    public InventoryController(FlowPane inventory){
        this.gameController = new GameController(inventory);
        monkeyDrag();
        firedStickDrag();
        burnedDoor();
        putFuseElectricMeter();
    }
}
