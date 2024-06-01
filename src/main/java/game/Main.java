package game;

import model.GameTable;
import model.JSONReader;
import model.JSONWriter;

public class Main {

    public static void main(String[] args) {
        JavaFX.main(args);
    }
   /* public static void main(String[] args) {
        GameTable gameTable = new GameTable();
        gameTable.printBoard();
        JavaFX.main(args);*/

        /* Példa a játékos mozgatására felfelé

        // Például a játékos mozgatása


        // Például a játékos mozgatása
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.DOWN);
        gameTable.movePlayer(Direction.DOWN);
        gameTable.movePlayer(Direction.DOWN);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.DOWN);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.DOWN);
        gameTable.movePlayer(Direction.DOWN);
        gameTable.movePlayer(Direction.DOWN);
        gameTable.movePlayer(Direction.RIGHT);
        gameTable.movePlayer(Direction.RIGHT);*/



        /*gameTable.printBoard();
        gameTable.printMoveHistory();

        // Adatok mentése JSON-be

        JSONWriter.writeGameTableToJSON(gameTable, "gameTable.json");

        // Adatok beolvasása JSON-ből
        GameTable loadedGameTableJson = JSONReader.readGameTableFromJSON("gameTable.json");
        if (loadedGameTableJson != null) {
            loadedGameTableJson.printBoard();
            loadedGameTableJson.printMoveHistory();
        }/*


        /*if (args.length != 1) {
            System.err.printf("Usage: java %s <name>%n", Main.class.getName());
            System.exit(1);
        }
        var client = NationalizeClient.newInstance();
        var nationality = client.getNationality(args[0]);
        System.out.println(nationality);
    }*/


}
