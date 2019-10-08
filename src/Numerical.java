import java.util.ArrayList;
import java.util.Collections;

public class Numerical implements Sortable {

    public void sort(boolean ascending, ArrayList list) {
        list.sort(Product.price());
        if(!ascending)
            Collections.reverse(list);
    }
}
