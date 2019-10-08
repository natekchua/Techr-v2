import java.util.ArrayList;
import java.util.Collections;

public class Alphabetical implements Sortable {
    public void sort(boolean ascending, ArrayList list) {
        list.sort(Product.alphabetical());
        if(!ascending)
            Collections.reverse(list);
    }
}
