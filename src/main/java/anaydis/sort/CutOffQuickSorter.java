package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/2/16.
 */
public class CutOffQuickSorter extends QuickSorter{

    private static int M;
    final private InsertionSorter insertion;

    //Constructor
    public CutOffQuickSorter() {
        super(SorterType.QUICK_CUT);
        insertion = new InsertionSorter();
    }



    //First part of sorting
    private<T> void quicksort(Comparator<T> comparator, List<T> list, int left, int right) {
        if(right-left <= M) return;
        if ( right <= left) return;
            int i = partition(comparator, list, left, right);
            quicksort(comparator, list, left, i - 1);
            quicksort(comparator, list, i + 1, right);
    }


    //full public method
    private <T> void cutOffSort(Comparator<T> comparator, List<T> list, int left, int right) {
        quicksort(comparator, list, left, right);
        insertion.sort(comparator, list);
    }



    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        cutOffSort(comparator, list, 0, list.size()-1);
        finishListeners();
    }

    public static void setM(int N){ M = N;}
}
