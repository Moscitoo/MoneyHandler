import enums.CurrencyID;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    public static int idCounter = 1;

    public static CurrencyID defaultCurrency = CurrencyID.HUF;
    private UUID id;
    private TransactionType name;
    private Date date;
    private double amount;
    private CurrencyID currencyId;
    private String categoryId;

    public Transaction(TransactionType name, double amount, String categoryId) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.date = new Date();
        this.amount = amount;
        this.currencyId = defaultCurrency;
    }

    public Transaction(TransactionType name, double amount, CurrencyID currencyId, String categoryId) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.date = new Date();
        this.amount = amount;
        this.currencyId = currencyId;
    }

    public UUID getId() {
        return id;
    }

    public TransactionType getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public CurrencyID getCurrencyId() {
        return currencyId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", currencyId='" + currencyId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }

}