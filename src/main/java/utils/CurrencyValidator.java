package utils;

import enums.CurrencyID;

public class CurrencyValidator {

    public static String errorMessage = "Érvénytelen valuta. Alapértelmezett érték: HUF";

    public static boolean validateCurrency(CurrencyID currencyId) {

        switch (currencyId) {
            case HUF, USD, EUR, GBP:
                return true;
            default: {
                System.out.println(errorMessage);
                return false;
            }
        }
    }
}
