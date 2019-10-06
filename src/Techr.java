import java.io.FileNotFoundException;

public class Techr {
	
	private UserInteraction user = new UserInteraction();
	private FileParser file = new FileParser();
	private ProductList pList = new ProductList();
	private CategoryList cList = new CategoryList();

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
