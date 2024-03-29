/**
 * Author: 		INVent.
 * Instructor: 	Faith-Michael Uzoka
 * Course: 		COMP 2633
 * E-mails: 	vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date: 		April 3rd 2018
 * Purpose:
 * 		- In the current version, this class handles file parsing of a database 
 * 		  text file and builds the product list with the given text file
 * Details:
 * 		- Assumes the text file is in proper format. Further information
 * 		  on the format of a database text file is in the format.txt file
 * 		  in the project.
 * 		- Files must be a .txt file 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileParser {

	/**
	 * A wrapper function for loading a database text file into a 
	 * given product list
	 * @param pList to build upon with products
	 * @param cList categories of the products
	 * @throws FileNotFoundException
	 */
	public void loadFile(ProductList pList, CategoryList cList) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File("file1.txt"));
		parseFile(fileReader, pList, cList);
	}

	/**
	 * Properly parses a given database text file and adds each product
	 * into the given product list. Since multiple elements can be in
	 * one line of the database text file, the line is fully read then split
	 * by the commas separating them to get each element in that line.
	 * This function adds categories as well as subcategories that each
	 * product provides.
	 * @param file to read from
	 * @param pList - the list to add all the products to
	 * @param cList - list of categories of the products
	 */
	private void parseFile(Scanner file, ProductList pList, CategoryList cList) {
		
		int numProducts = file.nextInt();
		file.nextLine();

		for(int p = 0; p < numProducts; p++) {
			String line = file.nextLine();
			String COMMA = ",";
			String [] lineArr = line.split(COMMA);
			String productName = lineArr[0];
			String productCategory = lineArr[1];
			cList.addCategory(productCategory);

			line = file.nextLine();
			String [] sections = line.split(COMMA);
			for(String section : sections)
				cList.getCategory(productCategory).addSub(section);

			double price = file.nextDouble();
			double rating = file.nextDouble();

			file.nextLine();

			Product product = new Product(productName, productCategory, sections,
								  price, rating);
			pList.addToEnd(product);
		}
	}
}
