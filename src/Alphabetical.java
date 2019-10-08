import java.util.ArrayList;
import java.util.Collections;

public class Alphabetical implements Sortable {
    private boolean isAscending;
    private ArrayList list;

    Alphabetical(boolean isAscending, ArrayList list){
        this.isAscending = isAscending;
        this.list = list;
    }

    public void sort(){
        list.sort(Product.alphabetical());
        if(!isAscending)
            Collections.reverse(list);
    }
}
