package utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import model.Transaction;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FileHandler {

    public static String source = "src\\main\\java\\resources\\resourcefile";
    public static FileReader reader;
    private static FileWriter writer;
    public static JsonParser parser = new JsonParser();
    public static Gson gson = new GsonBuilder().create();
    public static String SUCCESSFUL_SAVE_MESSAGE = "Transactions saved.";
    static {
        try {
            reader = new FileReader(source);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Transaction> readTransactionListFromJsonFile() {
        JsonArray jsonArray = parser.parse(reader).getAsJsonArray();
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Unsuccessful file-reading!" + e.getMessage());
        }
        return new ArrayList<>(Arrays.asList(gson.fromJson(jsonArray, Transaction[].class)));
    }

    public static void writeTransactionListToJsonFile(List<Transaction> transactionList) {
        String json = gson.toJson(transactionList);
        try {
            writer = new FileWriter(source);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            System.out.println("Unsuccessful file-writing!" + e.getMessage());
        }
        System.out.println(SUCCESSFUL_SAVE_MESSAGE);
    }
}

