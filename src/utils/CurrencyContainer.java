package utils;

import enums.CurrencyID;

import java.util.Map;

public class CurrencyContainer {

    public static Map<CurrencyID, Double> currencyMultiplierMap = Map.of(
            CurrencyID.HUF, 1.0,
            CurrencyID.USD, 348.0,
            CurrencyID.EUR, 379.0,
            CurrencyID.GBP, 436.0
    );


}
