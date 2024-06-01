package model;

import com.google.gson.Gson;

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

    public static Direction readDirectionFromJSON(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, Direction.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
