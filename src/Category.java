import java.util.UUID;

public class Category {

private final UUID categoryId;
private String categoryName;
private String description;

    public Category(int categoryId, String categoryName, String description) {
        this.categoryId = UUID.randomUUID();
        this.categoryName = categoryName;
        this.description = description;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getCategoryDescription() {
        return null;
    }


    public void setCategoryDescription(String newDescription) {
    }



}
