package service;

import com.google.gson.JsonArray;
import model.Transaction;
import utils.FileHandler;
import utils.ScannerUtil;

import java.util.List;

public class TransactionService {

    public List<Transaction> transactionList;

    public TransactionService() {
        JsonArray jsonArray = FileHandler.convertFileToJSON();
        transactionList = FileHandler.convertJsonArrayToTransactionlist(jsonArray);
    }

    public void addTransaction() {
        System.out.println("Type the name of the transaction you would like to initiate:");
        String transactionName = ScannerUtil.scanner.nextLine();
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}
