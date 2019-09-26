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
	private String[] section = new String[3];
	private double price;
	private String [] images;
	private double rating;
	private String url;
	
	/**
	 * This constructor is used for tests
	 */
	Product()
	{
		name = "";
		category = "";
		section = null;
		price = 0;
		images = null;
		rating = 0;
		url = "";
		
	}
	/**
	 * Constructor of a Product Object
	 * @param name
	 * @param category
	 * @param section
	 * @param price
	 * @param images
	 * @param rating
	 * @param url
	 */
	Product(String name, String category, String[] section, double price, String[] images, double rating, String url)
	{
		this.name = name;
		this.category = category;
		this.section = section;
		this.price = price;
		this.images = images;
		this.rating = rating;
		this.url = url;
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
                if(compareValue < 0)
                	return -1;
                else if(compareValue == 0)
                	return 0;
                else
                	return 1;
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

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public String[] getSection()
	{
		return section;
	}
	
	public void setSection(String[] section)
	{
		this.section = section;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public String[] getImages()
	{
		return images;
	}
	
	public void setImages(String[] images)
	{
		this.images = images;
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
