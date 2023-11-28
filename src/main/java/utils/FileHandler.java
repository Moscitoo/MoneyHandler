package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import model.Transaction;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

    public static String source = "src\\main\\java\\resources\\resourcefile";

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

    public static List<Transaction> readTransactionListFromJsonFile() {
        JsonArray jsonArray = convertFileToJsonArray();
        return convertJsonArrayToTransactionlist(jsonArray);
    }

    public static List<Transaction> convertJsonArrayToTransactionlist(JsonArray jsonArray) {
        return new ArrayList<>(Arrays.asList(gson.fromJson(jsonArray, Transaction[].class)));
    }

    public static JsonArray convertFileToJsonArray() {
        return parser.parse(reader).getAsJsonArray();
    }
}
