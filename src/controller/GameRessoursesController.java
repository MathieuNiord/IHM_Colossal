package controller;

import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import view.classes.MyImageView;

import static view.ressources.GameRessources.*;

public class GameRessoursesController {
    private void monkeyDrag(){
        // target
        MONKEY_IM.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getDragboard().getString().equals(BANANA_IM.obj.NAME) &&
                        event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

                }
                event.consume();
            }
        });

        // target
        MONKEY_IM.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
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
        });

        // source
        BANANA_IM.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                objHandleDetected(event, BANANA_IM);
            }
        });
    }

    private void firedStickDrag(){
        //sources
        STICK_IM.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                objHandleDetected(event, STICK_IM);
            }
        });

        FLINT_IM.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                objHandleDetected(event, FLINT_IM);
            }
        });

        // target
        FLINT_IM.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                objHandleOver(event, STICK_IM);
            }
        });

        FLINT_IM.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                firedStickHandleDrop(event);
            }
        });

        STICK_IM.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                objHandleOver(event, FLINT_IM);
            }
        });

        STICK_IM.setOnDragDropped(new EventHandler<DragEvent>() {
             @Override
             public void handle(DragEvent event) {
                 firedStickHandleDrop(event);
             }
         });
    }

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
        }
        event.setDropCompleted(success);

        event.consume();
    }

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

    private FlowPane inventory;

    public GameRessoursesController (FlowPane inventory){
        this.inventory = inventory;
        monkeyDrag();
        firedStickDrag();
    }
}
