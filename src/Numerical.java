import java.util.ArrayList;
import java.util.Collections;

public class Numerical implements Sortable {
    private final boolean isAscending;
    private final ArrayList list;

    //constructor with ascending boolean and list to sort
    Numerical(boolean isAscending, ArrayList list){
        this.isAscending = isAscending;
        this.list = list;
    }

    @Override
    public void sort(){
        list.sort(Product.price());
        if(!isAscending)
            Collections.reverse(list);
    }
}
