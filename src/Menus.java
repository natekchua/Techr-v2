
class Menus {

    public void displayMenu() {
        System.out.println("TECHR \n");
        System.out.println("1. Browse");
        System.out.println("2. Favorites List");
        System.out.println("3. Previously Viewed");
        System.out.println("4. Quit");
        System.out.println();
    }

    public void preferenceMenu() {
        System.out.println("Choose Preference: \n");
        System.out.println("1. Specify Sub Category");
        System.out.println("2. Specify Price Range");
        System.out.println("3. Specify Rating");
    }

    public void favouritesMenu() {
        System.out.println("Managing Favourites List: \n");
        System.out.println("1. Clear");
        System.out.println("2. Sort Alphabetical Ascending");
        System.out.println("3. Sort Alphabetical Descending");
        System.out.println("4. Sort Price Ascending");
        System.out.println("5. Sort Price Descending");
        System.out.println("6. Swap");
        System.out.println("7. Remove");
        System.out.println("8. Back");
    }

    public void discardedMenu() {
        System.out.println("Manage Discarded List: \n");
        System.out.println("1. Clear");
        System.out.println("2. Back");
    }
}
