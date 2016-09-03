package anaydis.sort;

import com.sun.org.apache.xerces.internal.util.IntStack;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 8/26/16.
 */
public abstract class QuickSorter extends AbstractSorter {
    public QuickSorter(SorterType type) {
        super(type);
    }






    protected <T> int partition(List<T> list, int lo, int hi, Comparator<T> comparator) {
        int i = lo - 1;
        int j = hi;
        while(true) {
            while(greater(list.get(hi), list.get(++i ), comparator)); //find item left to swap
                if (i == hi) break;
            while(greater(list.get(j), list.get(hi), comparator )); //find item right to swap
                if (j == lo) break;
            if (i >= j) break; //check if pointers cross
            swap(list, i, j); //swap
        }
        swap(list, i, hi); //swap with partitioning item
        return i; //return index of item now known to be in place
    }
}

