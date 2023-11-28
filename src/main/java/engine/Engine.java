package engine;

import service.TransactionService;
import utils.FileHandler;
import utils.NumberValidator;
import utils.PrintUtil;
import utils.ScannerUtil;

public class Engine  {

    private static int OPTION = 0;

    private static final int QUIT_NUMBER = 5;
    public static String QUIT_MESSAGE = "Bye!";
    private final TransactionService transactionService;

    public Engine() {
        this.transactionService = new TransactionService();
    }

    public void start() {
        PrintUtil.printOptions();
        while (OPTION != QUIT_NUMBER) {
            System.out.print("\nChoose an option: ");
            OPTION = NumberValidator.isIntegerValueValid(ScannerUtil.scanner.nextLine());
            executeOption(OPTION);
        }
    }

    public void executeOption(int button) {
        switch (button) {
            case 0:
                PrintUtil.printOptions();
                break;
            case 1:
                PrintUtil.printCategories();
                break;
            case 2:
                PrintUtil.printTransactions(transactionService.getTransactionList());
                break;
            case 3:
                transactionService.addTransaction();
                break;
            case 4:
                FileHandler.writeTransactionListToJsonFile(transactionService.getTransactionList());
                break;
            case 5:
                FileHandler.writeTransactionListToJsonFile(transactionService.getTransactionList());
                quit();
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }
    }

    public void quit() {
        System.out.println(QUIT_MESSAGE);
        System.exit(0);
    }
}