package model;

public class GameTable {
    private static final int SIZE = 14;
    private final int[][] board;
    private Player player = new Player(3, 0);

    // Tábla létrehozás
    public GameTable() {
        board = new int[SIZE][SIZE];
        initializeBoard();
    }
    public void movePlayer(Direction direction) {
        switch (direction) {
            case UP:
                if (player.getRow() > 0 && board[player.getRow() - 1][player.getCol()] != 1) {
                    player.moveUp();
                }
                break;
            case DOWN:
                if (player.getRow() < SIZE - 1 && board[player.getRow() + 1][player.getCol()] != 1) {
                    player.moveDown();
                }
                break;
            case LEFT:
                if (player.getCol() > 0 && board[player.getRow()][player.getCol() - 1] != 1) {
                    player.moveLeft();
                }
                break;
            case RIGHT:
                if (player.getCol() < SIZE - 1 && board[player.getRow()][player.getCol() + 1] != 1) {
                    player.moveRight();
                }
                break;
        }
    }



    private void initializeBoard() {

        for (int sor = 0; sor < SIZE; sor++) {
            for (int oszlop = 0; oszlop < SIZE; oszlop++) {
                board[sor][oszlop] = 0;
            }
        }

        for (int oszlop = 0; oszlop < SIZE; oszlop++) {
            board[0][oszlop] = 1;
            board[SIZE - 1][oszlop] = 1;
        }

        for (int sor = 0; sor < SIZE; sor++) {
            board[sor][0] = 1;
            board[sor][SIZE - 1] = 1;
        }

        // Falak
        board[2][5] = 1;
        board[2][7] = 1;
        board[1][1] = 1;
        board[5][1] = 1;
        board[12][1] = 1;
        board[8][2] = 1;
        board[10][2] = 1;
        board[3][3] = 1;
        board[7][3] = 1;
        board[10][3] = 1;
        board[4][4] = 1;
        board[11][4] = 1;
        board[8][5] = 1;
        board[5][6] = 1;
        board[6][6] = 1;
        board[11][6] = 1;
        board[1][7] = 1;
        board[5][7] = 1;
        board[9][7] = 1;
        board[8][8] = 1;
        board[11][8] = 1;
        board[2][9] = 1;
        board[3][9] = 1;
        board[6][9] = 1;
        board[11][9] = 1;
        board[4][10] = 1;
        board[10][10] = 1;
        board[6][11] = 1;
        board[1][12] = 1;
        board[8][12] = 1;
        board[12][12] = 1;

        //Start
        board[3][0] = 2;

        //Játék vége
        board[10][13] = 3;

    }


    public void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (player != null && row == player.getRow() && col == player.getCol()) {
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

