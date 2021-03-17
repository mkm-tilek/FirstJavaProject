package Model;

public class Board {
    public final int ROWS = 10, COLS = 11; // number of rows and columns
    private char[][] board = new char[ROWS][COLS];

    public void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = ' ';
            }
            for (int z = 0; z < ROWS; z++) {
                board[z][0] = 'x';
                board[z][COLS - 1] = 'x';
            }
            for (int l = 0; l < COLS; l++) {
                board[0][l] = 'x';
                board[ROWS - 1][l] = 'x';
            }

            board[4][5] = 'x';
            board[5][5] = 'x';
        }
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            System.out.print(" /" + "   \\     /".repeat(COLS / 2) + (COLS % 2 != 0 ? "   \\" : ""));
            System.out.println();

            for (int j = 0; j < COLS; j++) {
                System.out.print("/  " + board[i][j] + "  \\");
                j++;
                if (j < COLS)
                    System.out.print("_ _");
            }
            System.out.println();

            System.out.print("\\" + "     /   \\".repeat(COLS / 2) + (COLS % 2 != 0 ? "     /" : ""));
            System.out.println();

            System.out.print(" \\");
            for (int j = 0; j < COLS; j++) {
                System.out.print("_ _/");
                j++;
                if (j < COLS) {
                    System.out.print("  " + board[i][j] + "  \\");
                }
            }
            System.out.println();
        }
    }

    public void ClearLocation(int x, int y) {
        this.board[y][x] = ' ';
    }

    public char getObjectOnLocation(int x, int y) {
        return this.board[y][x];
    }

    public void setObjectOnLocation(int x, int y, Point point) {
        this.board[y][x] = point.getSymbol();
    }

    public boolean WIN() {
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if ((board[i][j] != '♕') && (board[i][j] != '$')) {
                    count += 1;
                }
            }
        }
        return count == 110;
    }
}

