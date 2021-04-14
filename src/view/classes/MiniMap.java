package view.classes;

import javafx.scene.Node;
import javafx.scene.layout.*;

public class MiniMap extends GridPane {

    private int posx_hero;
    private int posy_hero;

    public MiniMap() {
        super();
        int NB_COLS = 6;
        int NB_ROWS = 7;
        this.fillAllCells(NB_COLS, NB_ROWS);
    }

    // fill all the mini-map with MiniMapCells
    public void fillAllCells(int cols, int rows){
        for(int i=0; i<cols; i++){
            for(int j=0; j<rows; j++){
                MiniMapCell cell = new MiniMapCell();
                this.add(cell, i, j);
            }
        }
    }

    // return a cell of the Mini-map
    private Node getCellFromMiniMap(int col, int row) {
        for (Node cell : this.getChildren()) {
            if (GridPane.getColumnIndex(cell) == col && GridPane.getRowIndex(cell) == row) {
                return cell;
            }
        }
        return null;
    }

    // return a cell with a cast of MiniMapCell
    private MiniMapCell getMiniMapCell(int col, int row) {
        Node cell = this.getCellFromMiniMap(col, row);
        if (cell != null) {
            if (cell instanceof MiniMapCell) {
                return (MiniMapCell) cell;
            }
        }
        return null;
    }

    // reveal a hidden cell of the map
    public void revealCell(int col, int row) {
        MiniMapCell cell = this.getMiniMapCell(col, row);
        if(cell!= null) {
            cell.removeBackground();
        }
    }

    // reveal all cells which represent a same place
    public void revealPlace(MyPlace place) {
        if (!place.isVisited()) {
            Integer[][] positions = place.getPositions_map();
            for (Integer[] position : positions) {
                this.revealCell(position[0], position[1]);
            }
            place.makeVisited();
        }
    }

    // place an indicator where is the hero
    public void setPositionHero(MyPlace place){
        this.hideIndicator(this.posx_hero, this.posy_hero);

        Integer[] position = place.getPositions_map()[0];
        this.posx_hero = position[0];
        this.posy_hero = position[1];

        this.showIndicator(this.posx_hero, this.posy_hero);
    }

    // hide the hero-indicator
    public void hideIndicator(int col, int row){
        MiniMapCell cell = this.getMiniMapCell(col, row);
        if(cell != null){
            cell.hideIndicator();
        }
    }

    // show the hero-indicator
    public void showIndicator(int col, int row){
        MiniMapCell cell = this.getMiniMapCell(col, row);
        if(cell != null){
            cell.showIndicator();
        }
    }

    public void refreshMap(MyPlace place){
        this.revealPlace(place);
        this.setPositionHero(place);
    }
}
