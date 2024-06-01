package model;

import com.google.gson.Gson;
import model.GameTable;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    public static GameTable readGameTableFromJSON(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, GameTable.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}