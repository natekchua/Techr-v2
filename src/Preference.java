/**
 * Author:       INVent.
 * Instructor:   Faith-Michael Uzoka
 * Course:       COMP 2633
 * E-mails:      vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date:         April 3rd 2018
 * Purpose:		 
 * 		- This class handles all functionalities on how user preferences are created,
 * 		  which are ultimately used for filtering products.
 *     
 * Details:		
 * 		- As of the current version, price range, rating, and sub-category filtering
 * 		  are the only preference options.
 *     
 */

import java.util.ArrayList;
import java.util.Scanner;

class Preference {

	private int minRange;
	private int maxRange;
	private ArrayList<String> section = new ArrayList<>();
	private double rating;
	private final Scanner userInput = new Scanner(System.in);

	//this contructor is used in the filtering process and adjusting the preference attributes (for creating new preference objects).
	Preference(int minRange, int maxRange, ArrayList<String> section, double rating) {
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.section = section;
		this.rating = rating;
	}
	
	//this constructor is used at the beginning of the browsing phase (user chooses main category).
	Preference(String mainCategory) {
		minRange = 0;
		maxRange = Integer.MAX_VALUE;
		section.add(mainCategory);
		rating = 0;
	}
	
	//this constructor is used for tests.
	Preference() {
		
	}
	
	/**	adds a sub-category to the existing list of sub-categories
	 *  @param section - the additional sub-category
	 *  details: a "section" is considered to be an attribute of a product which has two or more sub-categories to its name.
	 */
	public void addSection(String section) {
		this.section.add(section);
	}

	/** displays sub categories for the user to choose from.
	 */
	public void selectSubCategory(Category mainCategory, String categoryName, CategoryList cList){
		mainCategory.displaySubcategories(categoryName, cList);
		int subIndex = userInput.nextInt();
		addSection(cList.getCategory(categoryName).getSubcategories().get(subIndex - 1));
	}

	/**	adds to the preference a specified minimum price and maximum price based on user input.
	 */
	public void selectPriceRange() {
		System.out.print("Enter minimum price: ");
		setMinRange(userInput.nextInt()); 
		System.out.print("Enter maximum price: ");
		setMaxRange(userInput.nextInt());
	}

	public int getMinRange()
	{
		return minRange;
	}

	public void setMinRange(int minRange)
	{
		this.minRange = minRange;
	}

	public int getMaxRange()
	{
		return maxRange;
	}

	public void setMaxRange(int maxRange)
	{
		this.maxRange = maxRange;
	}

	public ArrayList<String> getSection()
	{
		return section;
	}

	public double getRating()
	{
		return rating;
	}

	public void setRating(double rating)
	{
		this.rating = rating;
	}
}