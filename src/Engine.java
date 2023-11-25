import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.UUID;

//ennek kéne hajtania az egészet, ez a motor.

public class Engine {

    private List<Transaction> transactions;
    private List<Currency> currencies;
    private List<Category> categories;

    public Engine() {
        this.transactions = new ArrayList<>();
        this.currencies = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public void addTransaction (Transaction transaction) {
        transactions.add(transaction);
    }

    public void removeTransaction (UUID id) {
        transactions.removeIf(transaction -> transaction.getId().equals(id));
    }

    List<Transaction> getTransaction() {
        return new ArrayList<>(transactions);
    }

}
