import java.util.ArrayList;
import java.util.Collections;

public class Alphabetical implements Sortable {
    private final boolean isAscending;
    private final ArrayList list;

    //constructor with ascending boolean and list to sort
    Alphabetical(boolean isAscending, ArrayList list){
        this.isAscending = isAscending;
        this.list = list;
    }

    @Override
    public void sort(){
        list.sort(Product.alphabetical());
        if(!isAscending)
            Collections.reverse(list);
    }
}
