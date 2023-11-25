import utils.CurrencyValidator;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.PrintWriter;

public class Menu extends Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final FinanceManager financeManager = new FinanceManager();


    public static void startFinancialApp(FinanceManager financeManager) {
        Map<Integer, Runnable> menuActions = MenuActions();
        System.out.println("Welcome to the financial application!");

        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice();

            if (menuActions.containsKey(choice)) {
                menuActions.get(choice).run();
            } else {
                System.out.println("Invalid choice. Please choose again!");
            }
        }
    }

    private static Map<Integer, Runnable> MenuActions() {
        Map<Integer, Runnable> menuActions = new HashMap<>();
        menuActions.put(1, () -> loadDataFromFile(financeManager));
        menuActions.put(2, () -> saveDataToFile(financeManager));
        menuActions.put(3, () -> createNewCategory(financeManager));
        menuActions.put(4, () -> createNewTransaction(financeManager));
        menuActions.put(5, () -> listTransactions(financeManager));
        menuActions.put(6, () -> listCategories(financeManager));
        menuActions.put(7, () -> editCategory(financeManager));
        menuActions.put(8, () -> convertHUFToOtherCurrency(financeManager));
        menuActions.put(9, () -> System.exit(0));
        return menuActions;
    }

    private static void printMenu() {
        System.out.println("Válasszon a következő lehetőségek közül:");
        System.out.println("1. Adatok betöltése fájlból");
        System.out.println("2. Adatok mentése fájlba");
        System.out.println("3. Új kategória létrehozása");
        System.out.println("4. Új tranzakció létrehozása");
        System.out.println("5. Tranzakciók listázása");
        System.out.println("6. Kategóriák listázása");
        System.out.println("7. Kategória szerkesztése");
        System.out.println("8. Válasszon pénznemet");
        System.out.println("9. Kilépés");
    }

    private static int getUserChoice() {
        System.out.print("Választás: ");
        return scanner.nextInt();
    }

    private static void loadDataFromFile(FinanceManager financeManager) {
        System.out.print("Enter the file name to load data from: ");
        String fileName = scanner.next();
        financeManager.loadDataFromFile(fileName);
    }


    private static void saveDataToFile(FinanceManager financeManager) {
        System.out.print("Enter the file name to save data to: ");
        String fileName = scanner.next();
        File file = new File(fileName);

        try (PrintWriter writer = new PrintWriter(file)) {
            // Implementáció az adatok fájlba írásához
            // Példa: writer.println(transaction.toString());
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    private static int lastCategoryId = 0;

    private static void createNewCategory(FinanceManager financeManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Adja meg a kategória nevét: ");
        String categoryName = scanner.nextLine();

        System.out.print("Adja meg a kategória leírását: ");
        String categoryDescription = scanner.nextLine();

        int categoryId = ++lastCategoryId;

        Category newCategory = new Category(categoryId, categoryName, categoryDescription);
        financeManager.addCategory(newCategory);

        System.out.println("Az új kategória hozzáadva.");
    }


    private static void createNewTransaction(FinanceManager financeManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Adja meg a tranzakció típusát (bevétel/kiadás): ");
        String transactionType = scanner.nextLine().toLowerCase();

        System.out.print("Adja meg a tranzakció nevét: ");
        String transactionName = scanner.nextLine();

        System.out.print("Adja meg a tranzakció időpontját (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();

        Date transactionDate;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            transactionDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Hibás dátum formátum. A helyes formátum: yyyy-MM-dd");
            return;
        }

        System.out.print("Adja meg a tranzakció összegét: ");
        double transactionAmount = scanner.nextDouble();
        scanner.nextLine(); // Consuming the newline character

        System.out.print("Adja meg a pénznem azonosítóját: ");
        String currencyId = scanner.nextLine();

        System.out.print("Adja meg a kategória azonosítóját (ha nincs, hagyja üresen): ");
        String categoryIdInput = scanner.nextLine();
        String categoryId = (categoryIdInput.isEmpty()) ? null : categoryIdInput;

        // Most hozzáadhatod az új tranzakciót a kategóriatípus alapján


        System.out.println("Az új tranzakció hozzáadva.");
    }

    private static void listTransactions(FinanceManager financeManager) {
        List<Transaction> transactions = financeManager.getTransactions();

        if (transactions.isEmpty()) {
            System.out.println("Nincsenek még tranzakciók.");
        } else {
            System.out.println("Tranzakciók:");

            for (Transaction transaction : transactions) {
                System.out.println("ID: " + transaction.getId());
                System.out.println("Név: " + transaction.getName());
                System.out.println("Dátum: " + transaction.getDate());
                System.out.println("Összeg: " + transaction.getAmount());
                System.out.println("Pénznem azonosítója: " + transaction.getCurrencyId());
                System.out.println("Kategória azonosítója: " + transaction.getCategoryId());
                System.out.println("-----------------------");
            }
        }
    }

    private static void listCategories(FinanceManager financeManager) {
        List<Category> categories = financeManager.getCategories();

        if (categories.isEmpty()) {
            System.out.println("Nincsenek még kategóriák.");
        } else {
            System.out.println("Kategóriák:");

            for (Category category : categories) {
                System.out.println("ID: " + category.getCategoryId());
                System.out.println("Név: " + category.getCategoryName());
                System.out.println("Leírás: " + category.getCategoryDescription());
                System.out.println("-----------------------");
            }
        }
    }

    private static void editCategory(FinanceManager financeManager) {
        Scanner scanner = new Scanner(System.in);

        // Kategória azonosítójának bekérése
        System.out.print("Adja meg annak a kategóriának az azonosítóját, amelyet szeretne szerkeszteni: ");
        int categoryId = scanner.nextInt();
        scanner.nextLine(); // Consuming the newline character

        // Kategória keresése az azonosító alapján
        Category selectedCategory = null;
        for (Category category : financeManager.getCategories()) {
            if (category.getCategoryId() == categoryId) {
                selectedCategory = category;
                break;
            }
        }

        System.out.println("Nem található a megadott azonosítójú kategória.");


    }

    public static void setScanner(Scanner scanner) {
        // Scanner beállítása
    }

    private static void convertHUFToOtherCurrency(FinanceManager financeManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Adja meg az összeget HUF-ban: ");
        double amountInHUF = scanner.nextDouble();
        scanner.nextLine(); // Consuming the newline character

        // Kérd meg a felhasználót, hogy válasszon célpénznemet
        System.out.print("Válasszon célpénznemet (GBP, USD, EUR): ");
        String targetCurrencyId = scanner.nextLine().toLowerCase(); // Cél pénznem beolvasása

        Currency targetCurrency = null;
        for (Currency currency : financeManager.getAvailableCurrencies()) {
            if (currency.getCurrencyCode().equals(targetCurrencyId)) {
                targetCurrency = currency;
                break;
            }
        }

    }
}

