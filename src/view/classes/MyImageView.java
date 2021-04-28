package view.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyImageView extends ImageView {

    /*** ATTRIBUTES ***/

    public final int x,y;
    private Image battleDefaultIm = null;
    private Image battleOpeningIm = null;
    private Image battleDefeatIm = null;


    /*** CONSTRUCTOR ***/
    public MyImageView(Image path, int x, int y, Integer fitImage){
        super(path);
        this.x = x;
        this.y = y;
        fitImage(fitImage);
    }

    public MyImageView(Image path, int x, int y){
        super(path);
        this.x = x;
        this.y = y;
    }

    public MyImageView(Image path, Image battle, Image opening, Image defeatAnim, int x, int y){
        super(path);
        this.battleDefaultIm = battle;
        this.battleOpeningIm = opening;
        this.battleDefeatIm = defeatAnim;
        this.x = x;
        this.y = y;
    }


    /*** === METHODS === ***/

    // --- GETTER ---

    // -- Enemies get Images --

    //Battle default Image
    public Image getBattleDefaultIm() {
        return this.battleDefaultIm;
    }

    //Battle opening Image
    public Image getBattleOpeningIm() {
        return this.battleOpeningIm;
    }

    //Battle defeat gif
    public Image getBattleDefeatIm() {
        return this.battleDefeatIm;
    }


    // --- SETTER ---

    // --- DESIGN ---

    // - Fit the height and the width of the ImageView with the given value -
    private void fitImage(Integer val) {
        this.setFitWidth(val);
        this.setFitHeight(val);
    }

}
