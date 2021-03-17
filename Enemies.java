package Model.Objects;

import Model.Board;
import Model.Point;

// -- lives
public class Enemies extends Point {
    private int number;

    //setters and getters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    //methods

    public void SetNRandomEnemies(Board board) {
        setNRandomObjects(board, number);
    }
}