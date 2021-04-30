package view.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyImageView extends ImageView {

    /*** ATTRIBUTES ***/

    public final int x,y;
    private Image battleDefaultIm = null;
    private String battleOpening = null;
    private String battleDefeat = null;


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

    public MyImageView(Image path, Image battle, String opening, String defeatAnim, int x, int y){
        super(path);
        this.battleDefaultIm = battle;
        this.battleOpening = opening;
        this.battleDefeat = defeatAnim;
        this.x = x;
        this.y = y;
    }


    /*** === METHODS === ***/

    // --- GETTER ---

    // -- Enemies get Images --

    //Get the battle default Image
    public Image getBattleDefaultIm() {
        return this.battleDefaultIm;
    }

    //Get battle opening gif url
    public String getBattleOpening() {return this.battleOpening;}

    //Get battle defeat gif url
    public String getBattleDefeat() {return this.battleDefeat;}


    // --- SETTER ---

    // --- DESIGN ---

    // - Fit the height and the width of the ImageView with the given value -
    private void fitImage(Integer val) {
        this.setFitWidth(val);
        this.setFitHeight(val);
    }

}
