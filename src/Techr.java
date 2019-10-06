import java.io.FileNotFoundException;

class Techr {
	
	private final UserInteraction user = new UserInteraction();
	private final FileParser file = new FileParser();
	private final ProductList pList = new ProductList();
	private final CategoryList cList = new CategoryList();

	private void run() throws FileNotFoundException {
		file.loadFile(pList, cList);
		user.options(pList, cList);
	}

	public static void main(String[] args) {
	
		Techr prg = new Techr();
		try {
			prg.run();	
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}	
}
