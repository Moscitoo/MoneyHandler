package utils;

import enums.TransactionCategory;

public class AmountValidator {

    public static String ERROR_MESSAGE = "Invalid amount, try again!";

    public static boolean isAmountValid(double amount) {
        return amount >= 0;
    }
}
