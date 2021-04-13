package controller;

import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import model.objects.Banana;
import view.classes.MyImageView;
import view.ressources.GameRessources;
import static view.ressources.GameRessources.*;

public class GameRessoursesController {
    private void monkeyDrag(){
        // target
        monkeyIm.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getDragboard().getString().equals(bananaIm.obj.NAME) &&
                        event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

                }
                event.consume();
            }
        });

        // target
        monkeyIm.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data dropped
                Dragboard db = event.getDragboard();
                boolean success = false;
                if(db.hasString()){
                    success = true;
                    monkeyIm.monkey.setHungry(false);
                    heroIm.hero.getObjs().remove(bananaIm.obj.NAME);
                    inventory.getChildren().remove(bananaIm);
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });

        // source
        bananaIm.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                objHandleDetected(event, bananaIm);
            }
        });
    }

    private void firedStickDrag(){
        //sources
        stickIm.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                objHandleDetected(event, stickIm);
            }
        });

        flintIm.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                objHandleDetected(event, flintIm);
            }
        });

        // target
        flintIm.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                objHandleOver(event, stickIm);
            }
        });

        flintIm.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                firedStickHandleDrop(event);
            }
        });

        stickIm.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                objHandleOver(event, flintIm);
            }
        });

        stickIm.setOnDragDropped(new EventHandler<DragEvent>() {
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
            heroIm.hero.getObjs().remove(flintIm.obj.NAME);
            heroIm.hero.getObjs().remove(stickIm.obj.NAME);
            heroIm.hero.getObjs().put(firedstickIm.obj.NAME, firedstickIm.obj);
            this.inventory.getChildren().remove(flintIm);
            this.inventory.getChildren().remove(stickIm);
            this.inventory.getChildren().add(firedstickIm);
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
