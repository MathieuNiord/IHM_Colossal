package view.classes;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.others.Game;

import java.util.ArrayList;

public class MiniMap extends GridPane {

    private final int NB_COLS = 6;
    private final int NB_ROWS = 7;

    public MiniMap() {
        super();
        this.fillAllCells(NB_COLS, NB_ROWS);
    }

    public void fillAllCells(int cols, int rows){

        BackgroundFill background = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, new Insets(0));

        for(int i=0; i<cols; i++){
            for(int j=0; j<rows; j++){
                HBox cell = new HBox();
                cell.setBackground(new Background(background));
                this.add(cell, i, j);
            }
        }
    }

    private Node getCellFromGridPane(int col, int row) {
        for (Node cell : this.getChildren()) {
            if (GridPane.getColumnIndex(cell) == col && GridPane.getRowIndex(cell) == row) {
                return cell;
            }
        }
        return null;
    }

    public void revealCell(int col, int row){
        Node cell = this.getCellFromGridPane(col, row);
        if(cell != null){
            if(cell instanceof HBox){
                ((HBox) cell).setBackground(null);
            }
        }
    }
    
    public void revealPlace(MyPlace place){
        Integer[][] positions = place.getPositions_map();
        for (Integer[] position : positions) {
            this.revealCell(position[0], position[1]);
        }
    }

}
