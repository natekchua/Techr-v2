
class Menus {

    public void displayMenu() {
        System.out.println("\n*****");
        System.out.println("TECHR");
        System.out.println("*****\n");

        System.out.println("1. Browse");
        System.out.println("2. Favorites List");
        System.out.println("3. Previously Viewed");
        System.out.println("4. Quit");
        System.out.println();
    }

    public void preferenceMenu() {
        System.out.println("\nChoose Preference: ");
        System.out.println("1. Specify Sub Category");
        System.out.println("2. Specify Price Range");
        System.out.println("3. Specify Rating");
    }

    public void favouritesMenu() {
        System.out.println("\nManaging Favourites List:");
        System.out.println("1. Clear");
        System.out.println("2. Sort List");
        System.out.println("3. Swap");
        System.out.println("4. Remove");
        System.out.println("5. Back");
    }

    public void sortOptions(){
        System.out.println("\nSort:");
        System.out.println("1. Alphabetical in Ascending Order");
        System.out.println("2. Alphabetical in Descending Order");
        System.out.println("3. Price in Ascending Order");
        System.out.println("4. Price in Descending Order");

    }
    public void discardedMenu() {
        System.out.println("Manage Discarded List: \n");
        System.out.println("1. Clear");
        System.out.println("2. Back");
    }
}
