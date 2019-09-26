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

import java.util.Collections;

public class FavoritesList extends ProductList{
	
	/**
	 * Swaps 2 items in the list with given indices.
	 * Assumes the list is not empty
	 * @param index1 of 1st item
	 * @param index2 of 2nd item
	 */
	public void swap(int index1, int index2)
	{
		Product p1 = list.get(index1);
		Product p2 = list.get(index2);
		// Swap
		list.set(index1, p2);
		list.set(index2, p1);
	}
	
	/**
	 * Sorts the list alphabetically in either ascending or descending. If the 
	 * given boolean is true, it is sorted ascending, otherwise it is 
	 * sorted descending
	 * @param ascending - specifies if the caller wants an ascending list
	 */
	public void alphabeticalSort(boolean ascending)
	{
		Collections.sort(list, Product.alphabetical());
		if(!ascending)
			Collections.reverse(list);
	}
	
	/**
	 * Sorts the list by price in either ascending or descending. If the 
	 * given boolean is true, it is sorted ascending, otherwise it is 
	 * sorted descending
	 * @param ascending - specifies if the caller wants an ascending list
	 */
	public void priceSort(boolean ascending)
	{	
		Collections.sort(list, Product.price());
		if(!ascending)
			Collections.reverse(list);
	}
	
}
