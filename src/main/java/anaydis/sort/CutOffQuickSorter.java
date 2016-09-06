package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/2/16.
 */
public class CutOffQuickSorter extends AbstractSorter{

    private static int M;
    final private InsertionSorter insertion;

    //Constructor
    public CutOffQuickSorter() {
        super(SorterType.QUICK_CUT);
        insertion = new InsertionSorter();
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

    //First part of sorting
    public<T> void quicksort(Comparator<T> comparator, List<T> list, int left, int right) {
        if (right-left <= M || right <= left) return;
            int i = partition(list, left, right, comparator);
            quicksort(comparator, list, left, i - 1);
            quicksort(comparator, list, i + 1, right);
    }


    //full public method
    public<T> void cutOffSort(Comparator<T> comparator, List<T> list, int l, int r) {
        quicksort(comparator, list, l, r);
        insertion.sort(comparator, list, l, r);
    }



    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        cutOffSort(comparator, list, 0, list.size()-1);
        finishListeners();
    }

    public static void setM(int N){ M = N;}
}
