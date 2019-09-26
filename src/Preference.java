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

public class Preference {

	private int minRange;
	private int maxRange;
	private ArrayList<String> section = new ArrayList<>();
	private double rating;
	private Scanner userInput = new Scanner(System.in);

	//this contructor is used in the filtering process and adjusting the preference attributes (for creating new preference objects).
	Preference(int minRange, int maxRange, ArrayList<String> section, double rating)
	{
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.section = section;
		this.rating = rating;
	}
	
	//this constructor is used at the beginning of the browsing phase (user chooses main category).
	Preference(String mainCategory)
	{
		minRange = 0;
		maxRange = Integer.MAX_VALUE;
		section.add(mainCategory);
		rating = 0;
	}
	
	//this constructor is used for tests.
	Preference()
	{
		
	}
	
	/**	initializes a preference object containing the main category.
	 *  @param category - the main category
	 */
	public Preference createPreference(String category)
	{
		ArrayList<String> updatedSection = section;
		updatedSection.add(0,category);
		return new Preference (minRange, maxRange, updatedSection, rating);
	}
	
	/**	creates a preference object with a sub-category filter.
	 *  @param subcategory - the sub-category
	 */
	public Preference chooseSubcategory(String subcategory)
	{
		ArrayList<String> updatedSection = section;
		updatedSection.add(1,subcategory);
		return new Preference (minRange, maxRange, updatedSection, rating);	
	}
	
	/**	adds a sub-category to the existing list of sub-categories
	 *  @param section - the additional sub-category
	 *  details: a "section" is considered to be an attribute of a product which has two or more sub-categories to its name.
	 */
	public void addSection(String section)
	{
		this.section.add(section);
	}
	
	/**	displays the all of the sections.
	 */
	public void displaySections()
	{
		for(String sect : section)
			System.out.println(sect);
	}
	
	/**	adds to the preference a specified minimum price and maximum price based on user input.
	 */
	public void selectPriceRange()
	{	
		System.out.print("Enter minimum price: ");
		setMinRange(userInput.nextInt()); 
		System.out.print("Enter maximum price: ");
		setMaxRange(userInput.nextInt());
	}
	
	/**	adds to the preference a specified rating based on user input.
	 */
	public void selectRating()
	{		
		System.out.print("Enter preferred rating: ");
		setRating(userInput.nextDouble());
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

	public void setSection(ArrayList<String> section)
	{
		this.section = section;
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
	