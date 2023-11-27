package model;

import enums.CurrencyID;
import enums.TransactionCategory;
import utils.CurrencyConverter;

import java.util.Date;
import java.util.UUID;

public class Transaction {

    public static CurrencyID defaultCurrency = CurrencyID.HUF;
    private String id;
    private int categoryId;
    private Date date;
    private double amount;
    private CurrencyID currencyId;
    private double amountInForints;

    public Transaction(int categoryId, double amount) {
        this.id = UUID.randomUUID().toString();
        this.categoryId = categoryId;
        this.date = new Date();
        this.amount = amount;
        this.currencyId = defaultCurrency;
        this.amountInForints = CurrencyConverter.convert(amount, currencyId);
    }

    public Transaction(int categoryId, double amount, CurrencyID currencyId) {
        this.id = UUID.randomUUID().toString();
        this.categoryId = categoryId;
        this.date = new Date();
        this.amount = amount;
        this.currencyId = currencyId;
        this.amountInForints = CurrencyConverter.convert(amount, currencyId);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CurrencyID getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(CurrencyID currencyId) {
        this.currencyId = currencyId;
    }

    public double getAmountInForints() {
        return amountInForints;
    }

    public void setAmountInForints(double amountInForints) {
        this.amountInForints = amountInForints;
    }

    @Override
    public String toString() {
        return String.format("\nTransaction %s: \tcategory: %s, \tdate: %s, \tamount: %s, \tcurrency: %s, \tamount in Forints: %s Ft",
                id, TransactionCategory.getSimpleNameById(categoryId), date, amount, currencyId, amountInForints);
    }
}