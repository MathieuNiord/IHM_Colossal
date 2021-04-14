package view.classes;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class MiniMap extends GridPane {

    private final int NB_COLS = 6;
    private final int NB_ROWS = 7;

    private final static Circle indicator = new Circle(10, Color.GREEN);
    private int posx_indicator;
    private int posy_indicator;

    public MiniMap() {
        super();
        this.fillAllCells(NB_COLS, NB_ROWS);
        this.posx_indicator = 2;
        this.posy_indicator = 5;
        /*Integer[] position = {2,5};
        this.setIndicator(position);*/
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

    public void removeCell(int col, int row) {
        ObservableList<Node> childrens = this.getChildren();
        for (Node node : childrens) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                this.getChildren().remove(node);
                break;
            }
        }
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

    public void revealIndicator(HBox cell){
        Node child = cell.getChildren().get(0);
        if(child != null){
            if(child instanceof Circle){
                child.setVisible(true);
            }
        }
    }

    public void hideIndicator(HBox cell){
        Node child = cell.getChildren().get(0);
        if(child != null){
            if(child instanceof Circle){
                child.setVisible(false);
            }
        }
    }

    public void setIndicator(Integer[] position_map){
        int posx = position_map[0];
        int posy = position_map[1];

        Node old_cell = this.getCellFromGridPane(this.posx_indicator, this.posy_indicator);
        Node new_cell = this.getCellFromGridPane(posx, posy);

        this.hideIndicator((HBox)old_cell);
        this.revealIndicator((HBox)new_cell);

        this.posx_indicator = posx;
        this.posy_indicator = posy;
    }

}
