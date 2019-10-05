import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestFavoritesList {

	FavoritesList fList = new FavoritesList();
	Product testProduct = new Product("Amazing Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 3000, new String[]{}, 4.0, "url3");
	Product testProduct2 = new Product("Cool Laptop", "Laptop", new String[]{"Laptop", "Gaming"}, 2000, new String[]{}, 3.0, "url3");

	@Test
	void addOneToFavoritesList()
	{
		fList.addToEnd(new Product());
		int fListProds = fList.getList().size();
		assertEquals(1, fListProds);
	}

	@Test
	void addMultipleToFavoritesList()
	{
		fList.addToEnd(new Product());
		fList.addToEnd(new Product());

		int fListProds = fList.getList().size();
		assertEquals(2, fListProds);
	}
	
	@Test
	void removeFromEmptyFavoritesList()
	{
		fList.removeProduct(new Product());

		int fListProds = fList.getList().size();
		assertEquals(0, fListProds);
	}

	@Test
	void removeFromSingletonFavoritesList()
	{
		fList.addToEnd(testProduct);
		fList.removeProduct(testProduct);

		int fListProds = fList.getList().size();
		assertEquals(0, fListProds);
	}
	
	@Test
	void removeFromFavoritesListWithMultipleProds() 
	{
		fList.addToEnd(new Product());
		fList.addToEnd(testProduct);
		fList.addToEnd(testProduct2);

		fList.removeProduct(testProduct2); // 3 - 1 = 2
		
		int fListProds = fList.getList().size();
		
		assertEquals(2, fListProds);
	}
	
	@Test
	void alphabeticalAscendingSortTest()
	{
		boolean isAscending = true;

		fList.addToEnd(new Product("Beta Keyboard", "Keyboard", new String[]{}, 99.99, new String[]{}, 3.0, "url1"));
		fList.addToEnd(new Product("Cool Keyboard", "Keyboard", new String[]{}, 109.99, new String[]{}, 4.0, "url2"));
		fList.addToEnd(new Product("Alpha Keyboard", "Keyboard", new String[]{}, 199.99, new String[]{}, 5.0, "url3"));
		
		fList.alphabeticalSort(isAscending);

		assertEquals("Alpha Keyboard", fList.getList().get(0).getName());
		assertEquals("Beta Keyboard", fList.getList().get(1).getName());
		assertEquals("Cool Keyboard", fList.getList().get(2).getName());
	}
	
	
	@Test
	void alphabeticalDescendingSortTest()
	{
		boolean isAscending = false;
		
		fList.addToEnd(new Product("Alpha Keyboard", "Keyboard", new String[]{}, 199.99, new String[]{}, 5.0, "url3"));
		fList.addToEnd(new Product("Beta Keyboard", "Keyboard", new String[]{}, 99.99, new String[]{}, 3.0, "url1"));
		fList.addToEnd(new Product("Cool Keyboard", "Keyboard", new String[]{}, 109.99, new String[]{}, 4.0, "url2"));
		
		fList.alphabeticalSort(isAscending);

		assertEquals("Cool Keyboard", fList.getList().get(0).getName());
		assertEquals("Beta Keyboard", fList.getList().get(1).getName());
		assertEquals("Alpha Keyboard", fList.getList().get(2).getName());
	}

	@Test
	void priceAscendingSortTest()
	{
		boolean isAscending = true;
		
		fList.addToEnd(new Product("Expensive Mouse", "Mice", new String[]{}, 89.99, new String[]{}, 5.0, "url3"));
		fList.addToEnd(new Product("Cheap Mouse", "Mice", new String[]{}, 15.99, new String[]{}, 3.0, "url1"));
		fList.addToEnd(new Product("Average Mouse", "Mice", new String[]{}, 29.99, new String[]{}, 4.0, "url2"));
		
		fList.priceSort(isAscending);
		
		assertEquals(15.99, fList.getList().get(0).getPrice());
		assertEquals(29.99, fList.getList().get(1).getPrice());
		assertEquals(89.99, fList.getList().get(2).getPrice());
	}
	
	@Test
	void priceDescendingSortTest()
	{
		boolean isAscending = false;
		
		fList.addToEnd(new Product("Cheap Mouse", "Mice", new String[]{}, 15.99, new String[]{}, 3.0, "url1"));
		fList.addToEnd(new Product("Average Mouse", "Mice", new String[]{}, 29.99, new String[]{}, 4.0, "url2"));
		fList.addToEnd(new Product("Expensive Mouse", "Mice", new String[]{}, 89.99, new String[]{}, 5.0, "url3"));

		fList.priceSort(isAscending);
		
		assertEquals(89.99, fList.getList().get(0).getPrice());
		assertEquals(29.99, fList.getList().get(1).getPrice());
		assertEquals(15.99, fList.getList().get(2).getPrice());
	}
	
	@Test
	void productSwapTest()
	{
		Product oldFavePC = new Product("Ultra PC", "PC", new String[]{}, 1399.99, new String[]{}, 3.0, "url1");
		Product newFavePC = new Product("Super PC", "PC", new String[]{}, 1599.99, new String[]{}, 3.0, "url1");

		fList.addToEnd(oldFavePC);
		fList.addToEnd(new Product("Random PC", "PC", new String[]{}, 899.99, new String[]{}, 4.0, "url1"));
		fList.addToEnd(new Product("Random PC 2", "Mice", new String[]{}, 399.99, new String[]{}, 3.0, "url2"));
		fList.addToEnd(newFavePC);
		
		fList.swap(0, 3);
		
		assertEquals(newFavePC, fList.getList().get(0));
		assertEquals(oldFavePC, fList.getList().get(3));
	}
	
}
