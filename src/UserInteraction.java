/**
 * Author: 		INVent.
 * Instructor: 	Faith-Michael Uzoka
 * Course: 		COMP 2633
 * E-mails: 	vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date: 		April 3rd 2018
 * Purpose:
 * 		- The terminal version of the Techr application. Handles all
 * 		  functionality of the software, i.e. this is not the final UI
 * 		  version. 
 * Details:
 * 		- A tester for the back-bone functionality of the Techr application.
 * 		- Does not cover the functionality of choosing multiple items in a given
 * 		- filtered list. Rather one is chosen and the user must go back
 * 		  through the menu to choose another one.
 * 		- Does not cover functionality of choosing multiple subcategories
 * 		- Does not cover functionality of creating a full preference, in other
 * 		  words have a price range, subcategories and ratings set in the preference
 * 		  object
 */

import java.util.Scanner;

public class UserInteraction {

	private String name;
	private Scanner input = new Scanner(System.in);
	private FavoritesList fList = new FavoritesList();
	private DiscardedList dList = new DiscardedList();
	private BrowseList brList = new BrowseList();
	private Category cat = new Category(name);
	private static final boolean ASCENDING = true;
	private static final boolean DESCENDING = false;
	
	public void displayMenu()
	{	
		System.out.println("TECHR \n");

		System.out.println("1. Browse");
		System.out.println("2. Favorites List");
		System.out.println("3. Previously Viewed");
		System.out.println("4. Quit");
		System.out.println();
	}
	
	public void preferenceMenu()
	{
		System.out.println("Choose Preference: \n");
		System.out.println("1. Specify Sub Category");
		System.out.println("2. Specify Price Range");
		System.out.println("3. Specify Rating");
	}
	
	private void favouritesMenu()
	{
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
	
	private void discardedMenu()
	{
		System.out.println("Manage Discarded List: \n");
		System.out.println("1. Clear");
		System.out.println("2. Back");
	}
	
	/**
	 * Handles the browsing functionality of the application.
	 * Provides creating a preference for the user as well by either:
	 *  (1) Choosing a subcategory
	 *  (2) Selecting a price range
	 *  (3) Selecting a rating
	 * @param pList to filter
	 */
	public void browse(ProductList pList)
	{
		pList.displayCategories();
		String mainCategory = " ";
		int sub = 1;
		int prefC = 0;
		System.out.print("\nChoose a Category: ");
		int c = input.nextInt(); 
		Preference pref = new Preference(pList.categories.get(c-1).getName());
		
		System.out.print("Specify product preference (type, price etc.)? Enter (y/n): ");
		String choice = input.next();
		if(choice.equals("y"))
		{
			preferenceMenu();
			prefC = input.nextInt();
			switch(prefC)
			{
				case 1:
					mainCategory = pref.getSection().get(0);
					cat.displaySubcategories(mainCategory, pList);
					sub = input.nextInt();
					pref.addSection(pList.getCategory(mainCategory).getSubcategories().get(sub - 1));
					break;
				case 2:
					pref.selectPriceRange();
					break;
				case 3:
					pref.selectRating();
					break;
					
			}
		}
		brList.setBrowseList(pList.filteredProducts(pref));
		
		if(choice.equals("y") && prefC == 1)
			System.out.println("\nHere is what we found for " + pList.getCategory(mainCategory).getSubcategories().get(sub-1) + " " + pList.chooseCategory(c).getName() + ":\n");
		else if(choice.equals("y") && prefC == 2)
			System.out.println("\nHere is what we found for " + pList.chooseCategory(c).getName() + " between $" + pref.getMinRange() + " and $" + pref.getMaxRange() + ":\n");
		else if(choice.equals("y") && prefC == 3)
			System.out.println("\nHere is what we found for " + pList.chooseCategory(c).getName() + " with a rating of " + pref.getRating() + " or over" + ":\n");
		else if(choice.equals("n"))
			System.out.println("\nHere is what we found for " + pList.chooseCategory(c).getName() + ":\n");

		brList.displayProducts();
		dList.setList(brList.getList());
		chooseAProduct(pList);
	}

	/**
	 * The main function which handles all the terminal application
	 * functionalities
	 * @param pList of all the products
	 */
	public void mainMenu(ProductList pList)
	{
		boolean quit = false;
		while(!quit)
		{
			displayMenu();
			System.out.print("Enter choice: ");
			int choice = input.nextInt();
			System.out.println();
			switch(choice)
			{
				case 1:
					browse(pList);
					break;
				case 2:
					enterFavList();
					break;
				case 3:
					enterDisList(pList);
					break;
				case 4:
					quit = true;
					break;
				default:
					System.out.println("invalid choice");
					break;
			}	
		}
	}
	
	/**
	 * Handles functionality for the discarded list.
	 * @param pList
	 */
	private void enterDisList(ProductList pList)
	{
		boolean quit = false;
		while(!quit)
		{
			System.out.println("Discarded List: ");
			dList.displayProducts();
			discardedMenu();
			
			System.out.print("Enter choice: ");
			int choice = input.nextInt();
			switch(choice)
			{
				case 1:
					dList.clearList();
					break;
				case 2:
					quit = true;
					break;
				default:
					System.out.println("invalid choice");
					break;
			}
		}
	}
	
	/**
	 * Handles functionality for the favourites list.
	 */
	private void enterFavList()
	{
		boolean quit = false;
		while(!quit)
		{
			System.out.println("Favourites List: ");
			fList.displayProducts();
			favouritesMenu();
			System.out.print("Enter choice: ");
			int choice  = input.nextInt();
			switch(choice)
			{
				case 1:
					fList.clearList();
					break;
				case 2:
					fList.alphabeticalSort(ASCENDING);
					break;
				case 3:
					fList.alphabeticalSort(DESCENDING);
					break;
				case 4:
					fList.priceSort(ASCENDING);
					break;
				case 5:
					fList.priceSort(DESCENDING);
					break;
				case 6:
					swapFList();
					break;
				case 7:
					removeFromF();
					break;
				case 8:
					quit = true;
					break;
				default:
					System.out.println("invalid choice");
					break;
			}
		}
	}

	/**
	 * User interaction wrapper function for swapping products in the
	 * favourites list
	 */
	private void swapFList()
	{
		System.out.print("Enter 1st item index: ");
		int first = input.nextInt();
		System.out.print("Enter 2nd item index: ");
		int second = input.nextInt();
		fList.swap(first-1, second-1);
	}
	
	/**
	 * User interaction wrapper function for removing a product from
	 * the favourites list
	 */
	private void removeFromF()
	{
		System.out.print("Enter item index: ");
		int index = input.nextInt();
		fList.removeAt(index-1);
	}
	
	/**
	 * User interaction wrapper function for choosing a product with a given
	 * product list
	 * @param pList to choose a product from
	 */
	private void chooseAProduct(ProductList pList)
	{
		System.out.print("Choose a product: ");
		int choice = input.nextInt();
		Product chosen = brList.getList().get(choice-1);
		fList.addToEnd(chosen);
		pList.removeProduct(chosen);
	}
}
