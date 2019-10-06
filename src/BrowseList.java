/**
 * Author: 		INVent.
 * Instructor: 	Faith-Michael Uzoka
 * Course: 		COMP 2633
 * E-mails: 	vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date: 		April 3rd 2018
 * Purpose:
 * 		- The user-defined list that contains items filtered from the
 * 		  overall product list
 * Details:
 * 		- Takes care of all functions that a browse list should have
 * 		  such as setting the filtered items from the product list
 */

import java.util.ArrayList;

public class BrowseList extends ProductList {
	
	/**
	 * Sets the browse list to the given product list
	 * @param productList to set the browse list to
	 */
	public void setBrowseList(ArrayList<Product> productList)
	{
		list = productList;
	}

	/**
	 * Displays all the products in the browse list
	 */
	public void displayProducts() {
		for (int i = 0; i < list.size(); i++) {
			Product currProd = list.get(i);
			System.out.println((i+1) + ". " + currProd.getName());
		}
	}

}
