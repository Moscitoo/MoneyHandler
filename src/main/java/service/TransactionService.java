package service;

import enums.CurrencyID;
import enums.TransactionCategory;
import model.Transaction;
import utils.*;

import java.util.List;

public class TransactionService {

    public List<Transaction> transactionList;

    public static String SUCCESS_MESSAGE = "Transaction saved successfully.";

    public TransactionService() {
        transactionList = FileHandler.readTransactionListFromJsonFile();
    }

    public void addTransaction() {
        System.out.print("Type the name of the transaction you would like to initiate: ");
        String transactionName = ScannerUtil.scanner.nextLine();

        System.out.print("Type in currency: ");
        String currencyInput = ScannerUtil.scanner.nextLine();
        CurrencyID currencyID = CurrencyContainer.DEFAULT_CURRENCY;

        if (CurrencyValidator.isCurrencyValid(currencyInput)) {
            currencyID = CurrencyID.getByName(currencyInput);

        } else {
            System.out.println(CurrencyValidator.ERROR_MESSAGE);
        }

        System.out.print("Type in amount: ");
        double amount = NumberValidator.isDoubleValueValid(ScannerUtil.scanner.nextLine());

        if (AmountValidator.isAmountValid(amount)) {
            if (transactionName.equalsIgnoreCase(TransactionCategory.CREDITING.getName())) {
                transactionList.add(new Transaction(TransactionCategory.CREDITING.getCategoryId(), amount, currencyID));

            } else if (transactionName.equalsIgnoreCase(TransactionCategory.DEBITING.getName())) {
                amount = amount * -1;
                transactionList.add(new Transaction(TransactionCategory.DEBITING.getCategoryId(), amount, currencyID));
                System.out.println(SUCCESS_MESSAGE);

            } else {
                System.out.println("Invalid transaction, try again!");
                addTransaction();
            }

        } else {
            System.out.println(AmountValidator.ERROR_MESSAGE);
            addTransaction();
        }
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}
