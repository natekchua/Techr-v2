import java.util.ArrayList;
import java.util.Collections;

public class Numerical implements Sortable {
    private boolean isAscending;
    private ArrayList list;

    Numerical(boolean isAscending, ArrayList list){
        this.isAscending = isAscending;
        this.list = list;
    }

    public void sort(){
        list.sort(Product.price());
        if(!isAscending)
            Collections.reverse(list);
    }
}
