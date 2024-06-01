package game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.GameTable;
import java.io.FileWriter;
import java.io.IOException;

public class JSONWriter {
    public static void writeGameTableToJSON(GameTable gameTable, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(gameTable, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}