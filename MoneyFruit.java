package Model.Objects;

import Model.Board;
import Model.Point;

// fruits ++money and score
public class MoneyFruit extends Point {
    private int number;

    //settersandgetters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //methods
    // setting N enemies on board
    public void SetNRandomFood(Board board) {
        setNRandomObjects(board, number);

    }
}
