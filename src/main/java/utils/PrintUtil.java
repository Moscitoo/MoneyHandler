package utils;

import enums.TransactionCategory;
import model.Transaction;

import java.util.List;

public class PrintUtil {

    public static void printOptions() {
        System.out.println("\nType 0 to print options.");
        System.out.println("Type 1 to check Categories.");
        System.out.println("Type 2 to check Transactions.");
        System.out.println("Type 3 to add a Transaction.");
        System.out.println("Type 4 to save Transactions to file.");
        System.out.println("Type 5 to quit.");
    }

    public static void printCategoriesAndTransactions(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            System.out.println(transaction.toString());
        }
    }

    public static void printCategories() {
        for (TransactionCategory category : TransactionCategory.class.getEnumConstants()) {
            System.out.println(category.toString());
        }
    }

    public static void printTransactions(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            System.out.println(transaction.toString());
        }
    }
}
