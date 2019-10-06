/**
 * Author:       INVent.
 * Instructor:   Faith-Michael Uzoka
 * Course:       COMP 2633
 * E-mails:      vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date:         April 3rd 2018
 * Purpose:		 
 * 		- This class contains all the attributes of a product. 
 * 
 * Details:		
 * 		- As of the current version it contains the name, category, section, price, images, rating
 * 		  and url link to the product. It also implements the price and alphabetical comparators which act
 * 		  as a catalyst for sorting of products.
 *     
 */

import java.util.Comparator;

public class Product{
		
	private String name;
	private String category;
	private String[] section;
	private double price;
	private double rating;

	/**
	 * This constructor is used for tests
	 */
	Product()
	{
		name = "";
		category = "";
		section = null;
		price = 0;
		rating = 0;

	}
	/**
	 * Constructor of a Product Object
	 * @param name
	 * @param category
	 * @param section
	 * @param price
	 * @param rating
	 */
	Product(String name, String category, String[] section, double price, double rating)
	{
		this.name = name;
		this.category = category;
		this.section = section;
		this.price = price;
		this.rating = rating;
	}
	
	/**
	 * Comparator of Product objects, based on alphabetical order of their names.
	 * @return 1 if product one goes before product two
	 * 		   0 if product one have the same name as product two 
	 * 		  -1 if product one goes after product two
	 */
    static Comparator<Product> alphabetical() {
        return new Comparator<Product>() {
        	public int compare(Product one, Product two) {
                int compareValue = one.name.compareTo(two.name);
				return Integer.compare(compareValue, 0);
            }
        };
    }
    /**
     * Comparator of Product objects, based on 2 products price attribute
     * @return 1 if product one has higher price than product two
     * 		   0 if product one has same price as product two
     * 		  -1 if product one has lesser price than product two
     */
        static Comparator<Product> price() {
            return new Comparator<Product>() {
            	public int compare(Product one, Product two) {
            		double compareValue = one.price - two.price;
                    if(compareValue < 0)
                    	return -1;
                    else if(compareValue == 0)
                    	return 0;
                    else
                    	return 1;
                }
            };
        }

	public String getName() 
	{
		return name;
	}
	
	public String getCategory()
	{
		return category;
	}

	public String[] getSection()
	{
		return section;
	}

	public double getPrice()
	{
		return price;
	}
	
	public double getRating() 
	{
		return rating;
	}

}
