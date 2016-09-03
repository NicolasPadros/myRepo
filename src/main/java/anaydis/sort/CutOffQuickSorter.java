package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/2/16.
 */
public class CutOffQuickSorter extends RecursiveQuickSorter {

    private static int M;
    final private InsertionSorter insertion;

    //Constructor
    public CutOffQuickSorter() {
        super(SorterType.QUICK_CUT);
        insertion = new InsertionSorter();
        insertion.removeLastSorterListener();
    }

    //First part of sorting
    public<T> void quicksort(Comparator<T> comparator, List<T> list, int l, int r) {
        if (r-l <= M) return;
        sort(comparator, list, l, r);
    }

    //full public method
    public<T> void sort(Comparator<T> comparator, List<T> list, int l, int r) {
        //quicksort(comparator, list, l, r);
        insertion.sort(comparator, list, l, r);
    }



    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size()-1);
    }

    public static void setM(int N){ M = N;}
}
