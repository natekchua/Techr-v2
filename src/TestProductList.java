
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestProductList {

	private ProductList prodList = new ProductList();
	Preference pref = new Preference();


	@Test
	void emptyProdList() {
		int output = prodList.getList().size();
		assertEquals(0, output);
	}
	
	@Test
	void oneProductInList() {
		prodList.addToEnd(new Product());
		int output = prodList.getList().size();
		assertEquals(1, output);
	}
	
	@Test
	void moreThanOneProductInList() {
		prodList.addToEnd(new Product());
		prodList.addToEnd(new Product());
		
		int output = prodList.getList().size();
		assertEquals(2, output);
	}
	
	@Test
	void oneProdAndNoPreferenceFound() {
		String [] section = {"Laptop", "Office"};
		String [] images = {"img1match", "img2match"};
		prodList.addToEnd(new Product("Cool Laptop", "Laptop", section, 9.99, images, 5.0, "url1"));
		Preference pref = new Preference("PC");

		int filteredProds = prodList.filteredProducts(pref).size();
		
		assertEquals(0, filteredProds);
	}
	
	@Test
	void oneProdAndPreferenceFound() {
		prodList.addToEnd(new Product("Cool Laptop", "Laptop", new String[]{"Laptop", "Office"}, 9.99, new String[]{"img1match", "img2match"}, 5.0, "url1"));
		Preference pref = new Preference("Laptop");

		int filteredProds = prodList.filteredProducts(pref).size();
		
		assertEquals(1, filteredProds);
	}
	@Test
	void moreThanOneProdAndNoPrefFound() {
		String [] images = {"img1match", "img2match"};
		
		prodList.addToEnd(new Product("Decent Laptop", "Laptop", new String[]{"Laptop", "Office"}, 999.99, images, 1.9, "url1"));
		prodList.addToEnd(new Product("Basic Laptop", "Laptop", new String[]{"Laptop", "Office"}, 799.99, images, 2.6, "url2"));

		Preference pref = preferenceBuilder();

		int filteredProds = prodList.filteredProducts(pref).size();
		
		assertEquals(0, filteredProds);
	}
	
	@Test
	void moreThanOneProdAndOnePrefFound() {
		String [] images = {"img1match", "img2match"};
		
		prodList.addToEnd(new Product("Cool Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 999.99, images, 5.0, "url1"));
		prodList.addToEnd(new Product("Basic Laptop", "Laptop", new String[]{"Laptop", "Office"}, 799.99, images, 3.0, "url2"));

		Preference pref = preferenceBuilder();

		int filteredProds = prodList.filteredProducts(pref).size();
		
		assertEquals(1, filteredProds);
	}
	
	@Test
	void moreThanOneProdAndMultiplePrefFound() {
		String [] images = {"img1match", "img2match"};
		
		prodList.addToEnd(new Product("Amazing Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 1999.99, images, 5.0, "url3"));
		prodList.addToEnd(new Product("Cool Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 999.99, images, 5.0, "url1"));
		prodList.addToEnd(new Product("Basic Laptop", "Laptop", new String[]{"Laptop", "Office"}, 799.99, images, 3.0, "url2"));

		Preference pref = preferenceBuilder();

		int filteredProds = prodList.filteredProducts(pref).size();
		
		assertEquals(2, filteredProds);
	}
	
	@Test
	void prodPriceLessThanMinPref() {
		prodList.addToEnd(new Product("Amazing Laptop", "Laptop", new String[]{}, 199.99, new String[]{}, 3.0, "url3"));
		
		Preference pref = preferenceBuilder();
		
		int filteredProds = prodList.filteredProducts(pref).size();
		assertEquals(0, filteredProds);
	}
	
	@Test
	void prodPriceGreaterThanMinPref() {
		prodList.addToEnd(new Product("Amazing Laptop", "Laptop", new String[]{}, 3999.99, new String[]{}, 3.0, "url3"));
		
		Preference pref = preferenceBuilder();
		
		int filteredProds = prodList.filteredProducts(pref).size();
		assertEquals(0, filteredProds);
	}
	
	@Test
	void prodPriceInPrefRange() {
		prodList.addToEnd(new Product("Amazing Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 999.99, new String[]{}, 5.0, "url3"));
		
		Preference pref = preferenceBuilder();
		
		int filteredProds = prodList.filteredProducts(pref).size();
		assertEquals(1, filteredProds);
	}
	
	@Test
	void prodPriceIsMinRange() {
		prodList.addToEnd(new Product("Amazing Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 500, new String[]{}, 5.0, "url3"));
		
		Preference pref = preferenceBuilder();
		
		int filteredProds = prodList.filteredProducts(pref).size();
		assertEquals(1, filteredProds);
	}
	
	@Test
	void prodPriceIsMaxRange() {
		prodList.addToEnd(new Product("Amazing Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 3000, new String[]{}, 5.0, "url3"));
		
		Preference pref = preferenceBuilder();
		
		int filteredProds = prodList.filteredProducts(pref).size();
		assertEquals(1, filteredProds);
	}
	
	@Test
	void prodRatingIsRatingPref() {
		prodList.addToEnd(new Product("Amazing Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 3000, new String[]{}, 4.0, "url3"));
		
		Preference pref = preferenceBuilder();
		
		int filteredProds = prodList.filteredProducts(pref).size();
		assertEquals(1, filteredProds);
	}
	
	@Test
	void prodRatingIsGreaterThanRatingPref() {
		prodList.addToEnd(new Product("Best Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 3000, new String[]{}, 5.0, "url3"));
		
		Preference pref = preferenceBuilder();
		
		int filteredProds = prodList.filteredProducts(pref).size();
		assertEquals(1, filteredProds);
	}
	
	@Test
	void prodRatingIsLessThanRatingPref() {
		prodList.addToEnd(new Product("Slow Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 2000, new String[]{}, 3.0, "url3"));
		
		Preference pref = preferenceBuilder();
		
		int filteredProds = prodList.filteredProducts(pref).size();
		assertEquals(0, filteredProds);
	}

	Preference preferenceBuilder() {
		Preference pref = new Preference();
		pref.setMinRange(500);
		pref.setMaxRange(3000);
		pref.addSection("Laptop");
		pref.addSection("Gaming");
		pref.setRating(4.0);
		return pref;
	}
}
