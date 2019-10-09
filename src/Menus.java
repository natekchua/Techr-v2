
class Menus {
    //Menu to display main menu options
    public void displayMenu() {
        System.out.println("\n*****");
        System.out.println("TECHR");
        System.out.println("*****\n");

        System.out.println("1. Browse");
        System.out.println("2. Favorites List");
        System.out.println("3. View Previous History");
        System.out.println("4. Quit\n");
    }

    //Menu to display preference filter options
    public void preferenceMenu() {
        System.out.println("\nChoose Preference: ");
        System.out.println("1. Specify Sub Category");
        System.out.println("2. Specify Price Range");
        System.out.println("3. Specify Rating");
    }

    //Menu for managing favorites list
    public void favouritesMenu() {
        System.out.println("\nManaging Favorites List:");
        System.out.println("1. Clear");
        System.out.println("2. Sort List");
        System.out.println("3. Swap");
        System.out.println("4. Remove");
        System.out.println("5. Back");
    }

    //menu for sorting options
    public void sortOptions(){
        System.out.println("\nSort:");
        System.out.println("1. Alphabetical in Ascending Order");
        System.out.println("2. Alphabetical in Descending Order");
        System.out.println("3. Price in Ascending Order");
        System.out.println("4. Price in Descending Order");

    }
    
    //menu for history options
    public void historyMenu() {
        System.out.println("\nManage History: ");
        System.out.println("1. Clear");
        System.out.println("2. Back");
    }
}
