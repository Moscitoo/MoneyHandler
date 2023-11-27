package enums;

public enum TransactionCategory {

    CREDITING(1, "Crediting", "This is when you get money..."),
    DEBITING(2,"Debiting", "This is when you turn poor...");


    private int categoryId;

    private String name;
    private final String description;


    TransactionCategory(int categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static String getSimpleNameById(int id) {
        for (TransactionCategory category : TransactionCategory.class.getEnumConstants()) {
            if (category.getCategoryId() == id)
                return category.getName();
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s: \tid : %s, description : %s", name, categoryId, description);
    }
}
