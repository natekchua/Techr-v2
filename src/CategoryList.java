import java.util.ArrayList;

public class CategoryList {
    private ArrayList<Category> categories;

    CategoryList(){
        categories = new ArrayList<>();
    }

    /**
     * Gets the category at the given index. Similar to a get function
     * for an ArrayList
     * @param index of the category to get
     * @return the category chosen
     */
    public Category chooseCategory(int index)
    {
        return categories.get(index-1);
    }

    /**
     * Adds a category to the categories list. If the category already
     * exists the functions does nothing
     * @param categoryName to add to categories
     */
    public void addCategory(String categoryName) {
        if(!containsCategory(categoryName)) {
            Category cat = new Category(categoryName);
            categories.add(cat);
        }
    }

    public void displayCategories() {
        System.out.println("Categories:");
        for(int i = 0; i < categories.size(); i++)
            System.out.println((i + 1) + ". " + categories.get(i).getName());
    }

    /**
     * Checks if the given category string exists in the categories
     * @param categoryName to check
     * @return true if it exists, false otherwise
     */
    private boolean containsCategory(String categoryName) {
        for(Category category : categories)
            if(category.getName().equals(categoryName))
                return true;
        return false;
    }

    public Category getCategory(String categoryName) {
        for(Category category : categories)
            if(categoryName.equals(category.getName()))
                return category;
        return null;
    }
    public ArrayList<Category> getCategories() { return categories; }
}
