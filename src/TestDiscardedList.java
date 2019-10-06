
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDiscardedList {

	private final DiscardedList dList = new DiscardedList();
	
	@Test
	void clearEmptyDiscardedList() {
		dList.clearList();
		int dListProds = dList.getList().size();
		
		assertEquals(0, dListProds);
	}
	
	@Test
	void clearDiscardedListWithProds() {
		dList.addToFront(new Product());
		dList.addToFront(new Product());
		dList.addToFront(new Product());
		dList.addToFront(new Product());
		dList.addToFront(new Product());

		dList.clearList();
		int dListProds = dList.getList().size();
		
		assertEquals(0, dListProds);
	}

}
