package model;
import java.util.ArrayList;
import java.util.List;



public class GameTable {
    private static final int SIZE = 14;
    private final int[][] board;
    private Player player = new Player(3, 0);
    private List<String> moveHistory;

    // Tábla létrehozás
    public GameTable() {
        board = new int[SIZE][SIZE];
        initializeBoard();
        moveHistory = new ArrayList<>();
        saveMove(player.getRow(), player.getCol());
    }


    public void movePlayer(Direction direction) {
        switch (direction) {
            case UP:
                if (player.getRow() > 0 && board[player.getRow() - 1][player.getCol()] != 1) {
                    player.moveUp();
                } else {
                    System.err.println("Érvénytelen lépés! Fal vagy táblán kívüli mező.");
                }
                break;
            case DOWN:
                if (player.getRow() < SIZE - 1 && board[player.getRow() + 1][player.getCol()] != 1) {
                    player.moveDown();
                } else {
                    System.err.println("Érvénytelen lépés! Fal vagy táblán kívüli mező.");
                }
                break;
            case LEFT:
                if (player.getCol() > 0 && board[player.getRow()][player.getCol() - 1] != 1) {
                    player.moveLeft();
                } else {
                    System.err.println("Érvénytelen lépés! Fal vagy táblán kívüli mező.");
                }
                break;
            case RIGHT:
                if (player.getCol() < SIZE - 1 && board[player.getRow()][player.getCol() + 1] != 1) {
                    player.moveRight();
                } else {
                    System.err.println("Érvénytelen lépés! Fal vagy táblán kívüli mező.");
                }
                break;
        }
        saveMove(player.getRow(), player.getCol());

        if (board[player.getRow()][player.getCol()] == board[10][13]) {
            System.out.println("Ügyes fickó vagy! Eljutottál a célba!");
        }
    }


    private void saveMove(int row, int col) {
        moveHistory.add("Player moved to (" + row + ", " + col + ")");
    }

    public void printMoveHistory() {
        for (String move : moveHistory) {
            System.out.println(move);
        }
    }


    private void initializeBoard() {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = 0;
            }
        }

        for (int col = 0; col < SIZE; col++) {
            board[0][col] = 1;
            board[SIZE - 1][col] = 1;
        }


        for (int row = 0; row < SIZE; row++) {
            board[row][0] = 1;
            board[row][SIZE - 1] = 1;
        }

        // Falak
        int[][] falak = {
                {2, 5}, {2, 7}, {1, 1}, {5, 1}, {12, 1}, {8, 2}, {10, 2}, {3, 3}, {7, 3},
                {10, 3}, {4, 4}, {11, 4}, {8, 5}, {5, 6}, {6, 6}, {11, 6}, {1, 7}, {5, 7},
                {9, 7}, {8, 8}, {11, 8}, {2, 9}, {3, 9}, {6, 9}, {11, 9}, {4, 10}, {10, 10},
                {6, 11}, {1, 12}, {8, 12}, {12, 12}
        };
        for (int[] fal : falak) {
            board[fal[0]][fal[1]] = 1;
        }

        //Start
        board[3][0] = 2;

        //Játék vége
        board[10][13] = 3;

    }


    public void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (player.getRow() == row && player.getCol() == col) {
                    System.out.print("+ ");
                } else {
                    System.out.print(board[row][col] + " ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        GameTable gameTable = new GameTable();
        gameTable.printBoard();
    }
}

