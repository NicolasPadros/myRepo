package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/2/16.
 */
public class RecursiveQuickSorter extends AbstractSorter{
    public RecursiveQuickSorter() {
        super(SorterType.QUICK);
    }

    public RecursiveQuickSorter(SorterType quickCut) {
        super(quickCut);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        sort(comparator, list, 0, list.size()-1);
        finishListeners();
    }

    public<T> void sort(Comparator<T> comparator, List<T> list, int left, int right) {
        if (right <= left) return;
        int i = partition(list, left, right, comparator);
        sort(comparator, list, left, i - 1);
        sort(comparator, list, i + 1, right);
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
