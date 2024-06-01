package model;

public class Player {
    private int row;
    private int col;

    public Player(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void moveTo(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
