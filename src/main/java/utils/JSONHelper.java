package utils;

import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;

public class JSONHelper {
    public static void writeJSONObjectToFile(JSONArray jsonArray){
        try (FileWriter file = new FileWriter("parsedData.json")) {
            file.write(jsonArray.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
