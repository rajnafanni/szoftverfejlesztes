package model;

import java.util.ArrayList;
import java.util.List;

public class GameTable {
    public static final int SIZE = 14;
    private final int[][] board;
    private final List<String> moveHistory;
    private final Player player;
    private int stepCount;

    public GameTable() {
        board = new int[SIZE][SIZE];
        initializeBoard();
        moveHistory = new ArrayList<>();
        player = new Player(3, 0);
        saveMove(player.getRow(), player.getCol());
        stepCount = 0;
    }

    public void movePlayerTo(int newRow, int newCol) {
        int currentRow = player.getRow();
        int currentCol = player.getCol();


        if (Math.abs(newRow - currentRow) + Math.abs(newCol - currentCol) == 1) {

            if (canMoveTo(newRow, newCol)) {

                player.moveTo(newRow, newCol);
                saveMove(newRow, newCol);
                stepCount++;
                board[currentRow][currentCol] = 4;
            } else {
                System.out.println("Érvénytelen lépés! Fal van az új pozícióban.");
            }
        } else {
            System.out.println("Érvénytelen lépés! Az új pozíció nem szomszédos a jelenlegivel.");
        }
    }

    public boolean canMoveTo(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] != 1 && board[row][col] != 4;
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

        int[][] falak = {
                {2, 5}, {2, 7}, {1, 1}, {5, 1}, {12, 1}, {8, 2}, {10, 2}, {3, 3}, {7, 3},
                {10, 3}, {4, 4}, {11, 4}, {8, 5}, {5, 6}, {6, 6}, {11, 6}, {1, 7}, {5, 7},
                {9, 7}, {8, 8}, {11, 8}, {2, 9}, {3, 9}, {6, 9}, {11, 9}, {4, 10}, {10, 10},
                {6, 11}, {1, 12}, {8, 12}, {12, 12}
        };
        for (int[] fal : falak) {
            board[fal[0]][fal[1]] = 1;
        }

        board[3][0] = 2;
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

    public int getValueAt(int row, int col) {
        return board[row][col];
    }

    public Player getPlayer() {
        return player;
    }

    public int getStepCount() {
        return stepCount;
    }
}
