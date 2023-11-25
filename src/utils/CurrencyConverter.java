package utils;

import enums.CurrencyID;



public class CurrencyConverter {

    public static double convert(double amount, CurrencyID from) {
        return amount * CurrencyContainer.currencyMultiplierMap.get(from);
    }

}
