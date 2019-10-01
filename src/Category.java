/**
 * Author:       INVent.
 * Instructor:   Faith-Michael Uzoka
 * Course:       COMP 2633
 * E-mails:      vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date:         April 3rd 2018
 * Purpose:		 
 * 		- To handle all functionalities and manage categories and subcategories of a product.
 *     
 * Details:		 
 * 		- Each category has a name and can have several sub-categories depending on what types 
 * 		  of products are loaded in and their specifics.
 *     
 */

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<String> subcategories;

	public Category(String name)
	{
		this.name = name;
		this.subcategories = new ArrayList<>();
	}

	public Category(){

	}
	
	/**	Display all sub-categories of a selected main category from the list of products. 
	 *  @param category - the main category
	 * 	       pList - the productList
	 */
	public void displaySubcategories(String category, CategoryList cList)
	{
		int i = 1;
		Category cat = cList.getCategory(category);
		for(String sub : cat.getSubcategories())
		{
			System.out.println(i + ". " + sub);
			i++;
		}
	}
	
	/** add a new sub-category under the main category.
	 *  @param section - the new sub-category to add
	 */
	public void addSub(String section)
	{
		if(!containsSub(section))
			subcategories.add(section);
	}
	
	/** determines if the sub-category already exists within the main category's sub-categories.
	 *  @param subcategoryName - the sub-category to check
	 */
	protected boolean containsSub(String subcategoryName)
	{
		for(String subcategory : subcategories)
			if(subcategory.equals(subcategoryName))
				return true;
		return false;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public ArrayList<String> getSubcategories() 
	{
		return subcategories;
	}
	public void setSubcategories(ArrayList<String> subcategories)
	{
		this.subcategories = subcategories;
	}
	
}
