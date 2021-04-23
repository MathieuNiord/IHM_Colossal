package controller;

import controller.entities.MyEntity;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.classes.MyImageView;

import java.util.Locale;

import static controller.entities.EntitiesDatas.*;

public class AnimalScriptController {

    /*** === ATTRIBUTES === ***/

    private static MyEntity animal;

    /*** === CONSTRUCTOR === ***/
    public AnimalScriptController(ImageView im, Label name, Label script) {
        im.setImage(getAnimalImage());
        im.setFitHeight(128);
        im.setFitWidth(128);
        name.setText(getAnimalName());
        script.setText(getAnimalScript());
    }

    /*** === METHODS === ***/

    public static Image getAnimalImage() {

        MyImageView im = null;

        if (animal != null)
            im = animal.view;

        assert im != null;

        return im.getImage();
    }

    public static String getAnimalName() {

        String name = "";

        if (animal != null) {

            if (animal.monkey_model != null)
                name = animal.monkey_model.NAME;

            else
                name = animal.animal_model.NAME;
        }

        return name.toUpperCase();
    }

    public static String getAnimalScript() {

        String res = "";

        if (animal != null) {

            if (animal.monkey_model != null)
                res = animal.monkey_model.dialog(MY_HERO.getModel());

            else
                res = animal.animal_model.dialog(MY_HERO.getModel());
        }

        return res;
    }

    public static void setAnimal(MyEntity im) {
        animal = im;
    }
}
