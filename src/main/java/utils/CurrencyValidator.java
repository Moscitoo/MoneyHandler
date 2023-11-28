package utils;

import enums.CurrencyID;

public class CurrencyValidator {

    public static String ERROR_MESSAGE = "Invalid currency. Default value set to: HUF";

    public static boolean isCurrencyValid(String currencyId) {
        return currencyId.equalsIgnoreCase(CurrencyID.HUF.toString()) ||
                currencyId.equalsIgnoreCase(CurrencyID.USD.toString()) ||
                currencyId.equalsIgnoreCase(CurrencyID.EUR.toString()) ||
                currencyId.equalsIgnoreCase(CurrencyID.GBP.toString());
    }
}
