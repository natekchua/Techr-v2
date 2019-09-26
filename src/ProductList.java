/**
 * Author: 		INVent.
 * Instructor: 	Faith-Michael Uzoka
 * Course: 		COMP 2633
 * E-mails: 	vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date: 		April 3rd 2018
 * Purpose:
 * 		- Defines the product database as a list where it can be manipulated
 * 		  to filter products out by user preferences and a list can be built
 * 		  with functions to add a product and categories
 * Details:
 * 		- It is assumed that categories is built along with building the 
 * 		  ArrayList of products. In other words, adding in products should 
 * 		  also add their category. The addCategory function already takes 
 *        care if it is going to add a duplicate category.
 *      - The same goes for adding sub-categories, they must be added
 *        if there are any products with sub-categories that are being added
 * 		- Contains functions in filtering product lists according to
 * 		  its given user preference object
 * 		- Note section is interchangeable with sub-category
 */

import java.util.ArrayList;

public class ProductList {

	protected ArrayList<Product> list;
	protected ArrayList<Category> categories;
	
	ProductList()
	{
		list = new ArrayList<>();
		categories = new ArrayList<>();
	}

	/**
	 * Get each and every subcategory from the list of categories
	 * @return an ArrayList of Strings containing all subcategories
	 */
	public ArrayList<String> getSubcategories()
	{
		ArrayList<String> subcategories = new ArrayList<>();
		for(Category category : categories)
		{
			for(String subCategory : category.getSubcategories())
			{
				subcategories.add(subCategory);
			}
		}
		return subcategories;
	}
	
	public void addToEnd(Product prod) //favorites
	{
		list.add(prod);
	}
	
	public void addToFront(Product prod) //discarded
	{
		list.add(0, prod);
	}
	public void removeAt(int index)
	{
		list.remove(index);
	}
	public void clearList()
	{
		list.clear();
	}
	public void sendToOtherList(int index, ArrayList <Product> list)
	{
		Product p = this.list.get(index);
		list.add(p);
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

	public void removeProduct(Product prod)
	{
		list.remove(prod);
	}
	
	public void displayCategories()
	{
		System.out.println("Categories");
		for(int i = 0; i < categories.size(); i++)
			System.out.println((i+1) + ". " + categories.get(i).getName());
	}
	
	public void displayProducts()
	{
		for(int i = 0; i < list.size(); i++)
		{
			Product currProd = list.get(i);
			System.out.println((i+1) + ". " + currProd.getName());
		}
	}
	
	/**
	 * Adds a category to the categories list. If the category already
	 * exists the functions does nothing
	 * @param categoryName to add to categories
	 */
	public void addCategory(String categoryName)
	{
		if(!containsCategory(categoryName))
		{
			Category cat = new Category(categoryName);
			categories.add(cat);
		}
	}
	
	/**
	 * Checks if the given category string exists in the categories
	 * @param categoryName to check
	 * @return true if it exists, false otherwise
	 */
	protected boolean containsCategory(String categoryName)
	{
		for(Category category : categories)
			if(category.getName().equals(categoryName))
				return true;
		return false;
	}
	
	/**
	 * Adds a subcategory string to a given category name.
	 * Takes care of duplicate adding
	 * @param categoryName to add a subcategory to
	 * @param section to be added to the category
	 */
	public void addSubcat(String categoryName, String section)
	{
		Category cat = getCategory(categoryName);
		cat.addSub(section);
	}
	
	protected Category getCategory(String categoryName)
	{
		for(Category category : categories)
		{
			if(categoryName.equals(category.getName()))
			{
				return category;
			}
		}
		return null;
	}
	
	/**
	 * filters out a list of products into a new list of products
	 * using a preference given by a user.
	 * 	(1)	- Checks if a product's sections matches
	 *  (2) - Checks if a product's price is in preference range
	 *  (3) - Checks if a product's rating is greater than or equal to preference's rating
	 * @param p	- preferences of the user
	 * @return 	the new filtered list
	 */
	public ArrayList<Product> filteredProducts(Preference p)
	{
		ArrayList<Product> filteredList = new ArrayList<>();
		for (Product pr : list)
		{
			if(filterCheck(pr.getCategory(), pr.getSection(), p.getSection()) &&
			   pr.getCategory().equals(p.getSection().get(0)) &&
			   priceRangeCheck(pr.getPrice(), p.getMinRange(), p.getMaxRange()) &&
			   ratingCheck(pr.getRating(), p.getRating()))
				filteredList.add(pr);
		}

		return filteredList;
	}
	
	/**
	 * is there at least one section in the product's sections
	 * that matches with the preference's sections
	 * @param category		- main category
	 * @param sections		- of the product
	 * @param preferences	- preference sections
	 * @return true if at least one section matches
	 */
	private boolean filterCheck(String category, String[] sections, ArrayList<String> preferences)
	{
		if(preferences.size() > 1)
		{
			for(String section : sections)
				for(String pref : preferences)
					if(section.equals(pref))
						return true;
		}
		else if(preferences.get(0).equals(category))
			return true;
		
		return false;
	}
	
	/**
	 * is the product's price in the preference's range
	 * @param price			- of the product
	 * @param prefMinRange	- minimum preference price range
	 * @param prefMaxRange  - maximum preference price range
	 * @return	whether or not it is in range, true if it is
	 */
	private boolean priceRangeCheck(double price, int prefMinRange, int prefMaxRange)
	{
		if(price >= (double) prefMinRange && price <= (double) prefMaxRange)
			return true;
		else
			return false;
	}
	
	/**
	 * is the product's rating >= preference's rating
	 * @param rating		- of the product
	 * @param prefRating	- rating of the preference
	 * @return true if product rating >= preference rating
	 */
	private boolean ratingCheck(double rating, double prefRating)
	{
		if(rating >= prefRating)
			return true;
		else
			return false;
	}
	
	public ArrayList<Product> getList()
	{
		return list;
	}

	public void setList(ArrayList<Product> list)
	{
		this.list = list;
	}

	public ArrayList<Category> getCategories()
	{
		return categories;
	}

	public void setCategories(ArrayList<Category> categories)
	{
		this.categories = categories;
	}

}
