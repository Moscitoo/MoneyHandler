package enums;

public enum CurrencyID {

    HUF("HUF"),
    USD("USD"),
    EUR("EUR"),
    GBP("GBP");

    private String name;

    CurrencyID(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CurrencyID getByName(String name) {
        for (CurrencyID currency : CurrencyID.class.getEnumConstants()) {
            if (currency.getName().equalsIgnoreCase(name))
                return currency;
        }

        return null;
    }
}
