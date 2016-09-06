package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/2/16.
 */
public class MedianOfThreeQuickSorter extends AbstractSorter {
    private  static int M;
    private InsertionSorter insertion;

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

    private<T> void quicksort(Comparator<T> comparator, List<T> list, int left, int right) {
        if (right-left <= M) return;
        swap(list, (left+right)/2, right-1);
        if (greater(list.get(left), list.get(right-1), comparator)) swap(list, left, right-1);
        if (greater(list.get(left), list.get(right), comparator)) swap(list, left, right);
        if (greater(list.get(right-1), list.get(right), comparator)) swap(list, right-1, right);

        int i = partition(list, left+1, right-1, comparator);
        quicksort(comparator, list, left, i-1);
        quicksort(comparator, list, i+1, right);
    }

    private<T> void hybridsort(Comparator<T> comparator, List<T> list, int lo, int hi) {
        initListeners();
        quicksort(comparator, list, lo, hi);
        insertion.sort(comparator, list, lo, hi);
        finishListeners();
    }

    public MedianOfThreeQuickSorter() {
        super(SorterType.QUICK_MED_OF_THREE);
        insertion = new InsertionSorter();
    }

    @Override
    public<T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        hybridsort(comparator, list, 0, list.size()-1);
    }

    public static void setM(int N){ M = N;}

}
