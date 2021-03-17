package Model;

public class Point {


    /**
     * It represents a value in the axis x of the coordinated plane.
     */
    private int x;
    /**
     * It represents a value in the axis y of the coordinated plane.
     */
    private int y;

    private char symbol;

    // Getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    // Setters
    public void setX(int newLocation) {
        this.x = newLocation;
    }

    public void setY(int newLocation) {
        this.y = newLocation;
    }

    //Methods:
    public void addOneRandomObject(Board board) {
        while (true) {
            int x = (int) (Math.random() * (board.COLS - 1));
            int y = (int) (Math.random() * (board.ROWS - 1));
            if (board.getObjectOnLocation(x, y) == ' ') {
                board.setObjectOnLocation(x, y, this);
                return;
            }
        }
    }

    public void setNRandomObjects(Board board, int number) {
        for (int i = 0; i < number; i++) {
            addOneRandomObject(board);
        }
    }

}


