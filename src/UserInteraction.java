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

import java.util.ArrayList;
import java.util.Scanner;

class UserInteraction {

	private final Scanner input = new Scanner(System.in);
	private final FavoritesList fList = new FavoritesList();
	private final ProductList dList = new ProductList();
	private final BrowseList brList = new BrowseList();
	private final Category cat = new Category();
	private final Menus menu = new Menus();
	private static final boolean ASCENDING = true;
	private static final boolean DESCENDING = false;

	/**
	 * Handles the browsing functionality of the application.
	 * User is able to choose the main category of products to browse and apply filters.
	 * @param pList to filter
	 */
	private void browse(ProductList pList, CategoryList cList) {
		cList.displayCategories();
		int filterIndex = 0;	//preference choice

		System.out.print("\nChoose a Category: ");
		int cIndex = input.nextInt(); //index of category

		Preference pref = new Preference(cList.getCategories().get(cIndex-1).getName());
		String mainCategory = pref.getSection().get(0);

		System.out.print("Specify product preference (type, price etc.)? Enter (y/n): ");
		String choice = input.next();

		if(choice.equals("y")){
			menu.preferenceMenu();
			filterIndex = input.nextInt();
			chooseFilter(filterIndex, pref, mainCategory, cList);
		}

		brList.setBrowseList(pList.filteredProducts(pref));
		filteredResults(filterIndex, cIndex, mainCategory, cList, pref);

		brList.displayProducts();
		dList.setList(brList.getList());
		chooseAProduct(pList);
	}

	/**
	 * Handles the filter functionality of the application. Helper class of browse()
	 * User chooses one of the 3 filters:
	 *  (1) Choosing a subcategory
	 *  (2) Selecting a price range
	 *  (3) Selecting a rating
	 * @param choice to determine what case statement is chosen
	 * @param pref Preference object
	 * @param main name of the main category
	 * @param cList list of product categories
	 *
	 */
	private void chooseFilter(int choice, Preference pref, String main, CategoryList cList){
		switch(choice) {
			case 1:
				pref.selectSubCategory(cat, main, cList);
				break;
			case 2:
				pref.selectPriceRange();
				break;
			case 3:
				System.out.print("Enter preferred rating: ");
				pref.setRating(input.nextDouble());
				break;
		}
	}

	/*
	 * displays the filtered results according to the user's entered preferences. Helper class of browse()
	 * @param filterIndex used to choose which filter to apply
	 * @param categoryIndex used to choose the main category
	 * @param main name of the main category
	 * @param pList list of products
	 * @param pref
	 */
	private void filteredResults(int filterIndex, int categoryIndex, String main, CategoryList cList, Preference pref){
		String subcatName = cList.getCategory(main).getSubcategories().get(0);//name of sub category
		String maincatName = cList.chooseCategory(categoryIndex).getName(); //name of main category

		if(filterIndex == 1)
			System.out.println("\nHere is what we found for " +  subcatName + " " + maincatName + ":\n");
		else if(filterIndex == 2)
			System.out.println("\nHere is what we found for " + maincatName + " between $" + pref.getMinRange() + " and $" + pref.getMaxRange() + ":\n");
		else if(filterIndex == 3)
			System.out.println("\nHere is what we found for " + maincatName + " with a rating of " + pref.getRating() + " or over" + ":\n");
	}

		/**
	 * The main function which handles all the terminal application
	 * functionalities
	 * @param pList of all the products
	 */
	public void options(ProductList pList, CategoryList cList) {
		boolean quit = false;
		while (!quit) {
			menu.displayMenu();
			System.out.print("Enter choice: ");
			int choice = input.nextInt();
			System.out.println();
			switch (choice) {
				case 1:
					browse(pList, cList);
					break;
				case 2:
					enterFavList();
					break;
				case 3:
					enterDisList();
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
	 */
	private void enterDisList() {
		boolean proceed = true;
		while(proceed) {
			System.out.println("Discarded List: ");
			dList.displayProducts();
			menu.discardedMenu();
			
			System.out.print("Enter choice: ");
			int choice = input.nextInt();
			if(choice == 2)	proceed = false;
			else if(choice == 1) dList.clearList();
			else System.out.println("Invalid choice.\n");
		}
	}

		/**
		 * Handles functionality for the favourites list.
		 */
		private void enterFavList() {
			Alphabetical alphabetical = new Alphabetical();
			Numerical numerical = new Numerical();

			boolean quit = false;
			while (!quit) {
				System.out.println("Favourites List: ");
				fList.displayProducts();
				menu.favouritesMenu();
				System.out.print("\nEnter choice: ");
				int choice = input.nextInt();

				switch (choice) {
					case 1:
						fList.clearList();
						break;
					case 2:
						alphabetical.sort(ASCENDING, fList.getList());
						break;
					case 3:
						alphabetical.sort(DESCENDING, fList.getList());
						break;
					case 4:
						numerical.sort(ASCENDING, fList.getList());
						break;
					case 5:
						numerical.sort(DESCENDING, fList.getList());
						break;
					case 6:
						fList.swapFListProducts();
						break;
					case 7:
						fList.removeProductAtIndex();
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

//	private Sortable createSortBuilder(int choice) {
//	}

		/**
		 * User interaction wrapper function for choosing a product with a given
		 * product list
		 * @param pList to choose a product from
		 */
		private void chooseAProduct (ProductList pList) {
			System.out.print("\nChoose a product: ");
			int choice = input.nextInt();
			Product chosen = brList.getList().get(choice - 1);
			fList.addToEnd(chosen);
			pList.removeProduct(chosen);
		}
	}
