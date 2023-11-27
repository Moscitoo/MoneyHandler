package utils;

import com.google.gson.*;
import model.Transaction;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

    public static String source = "src\\main\\java\\resources\\resourcesfile";

    public static FileReader reader;

    public static JsonParser parser = new JsonParser();

    static {
        try {
            reader = new FileReader(source);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Gson gson = new GsonBuilder().create();

    public static void saveTransactions() {

    }

    public static JsonArray convertFileToJSON (){
        return parser.parse(reader).getAsJsonArray();
    }

    public static List<Transaction> convertJsonArrayToTransactionlist(JsonArray jsonArray) {
        List<Transaction> result = Arrays.asList(gson.fromJson(jsonArray, Transaction[].class));
        return result;
    }

}
