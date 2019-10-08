/**
 * Author: 		INVent.
 * Instructor: 	Faith-Michael Uzoka
 * Course: 		COMP 2633
 * E-mails: 	vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date: 		April 3rd 2018
 * Purpose:
 * 		- Adds extended functionality to the Product List class to
 * 		  accommodate for user favourites list needs
 * Details:
 * 		- Features include swapping 2 items and sorting the list either
 * 		  alphabetically or by price
 */

class FavoritesList extends ProductList{

	/**
	 * Swaps 2 items in the list with given indices. Helper for swapFListProducts()
	 * Assumes the list is not empty
	 * @param index1 of 1st item
	 * @param index2 of 2nd item
	 */
	public void swap(int index1, int index2) {
		Product p1 = list.get(index1);
		Product p2 = list.get(index2);
		// Swap
		list.set(index1, p2);
		list.set(index2, p1);
	}

	/**
	 * User interaction wrapper function for swapping products in the
	 * favourites list
	 */
	public void swapFListProducts () {
		System.out.print("Enter 1st product index: ");
		int p1Index = input.nextInt();
		System.out.print("Enter 2nd product index: ");
		int p2Index = input.nextInt();
		swap(p1Index-1,p2Index-1);
	}
}
