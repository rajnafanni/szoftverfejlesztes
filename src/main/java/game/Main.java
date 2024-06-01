package game;

import model.Direction;
import model.GameTable;

public class Main {

    public static void main(String[] args) {

        GameTable gameTable = new GameTable();
        gameTable.printBoard();

        // Példa a játékos mozgatására felfelé
        gameTable.movePlayer(Direction.UP);
        gameTable.movePlayer(Direction.UP);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.printBoard();



        /*if (args.length != 1) {
            System.err.printf("Usage: java %s <name>%n", Main.class.getName());
            System.exit(1);
        }
        var client = NationalizeClient.newInstance();
        var nationality = client.getNationality(args[0]);
        System.out.println(nationality);*/
    }


}
