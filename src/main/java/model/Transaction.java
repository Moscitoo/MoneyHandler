package model;

import enums.CurrencyID;
import enums.TransactionCategory;
import utils.CurrencyConverter;
import utils.DateFormatter;

import java.util.Date;
import java.util.UUID;

public class Transaction {

    private final String id;
    private final int categoryId;
    private final Date date;
    private final double amount;
    private final CurrencyID currencyId;
    private final double amountInForints;

    public Transaction(int categoryId, double amount, CurrencyID currencyId) {
        this.id = UUID.randomUUID().toString();
        this.categoryId = categoryId;
        this.date = new Date();
        this.amount = amount;
        this.currencyId = currencyId;
        this.amountInForints = CurrencyConverter.convert(amount, currencyId);

    }

    @Override
    public String toString() {
        return String.format("\nTransaction %s: \tcategory: %s, \tdate: %s, \tamount: %s, \tcurrency: %s, \tamount in Forints: %s Ft",
                id, TransactionCategory.getSimpleNameById(categoryId), DateFormatter.dateFormat.format(date), amount, currencyId, amountInForints);
    }
}