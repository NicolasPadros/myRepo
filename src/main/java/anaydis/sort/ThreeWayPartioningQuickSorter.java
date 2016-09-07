package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/3/16.
 */
public class ThreeWayPartioningQuickSorter extends QuickSorter {


    public ThreeWayPartioningQuickSorter() {
        super(SorterType.QUICK_THREE_PARTITION);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        sort(comparator, list, 0, list.size() - 1);
        finishListeners();

    }


    private <T> void sort(Comparator<T> comparator, List<T> list, int lo, int hi) {
        if (hi <= lo) return;

        int lt = lo;
        int i = lo+1;
        int gt = hi;

        T v = list.get(lo);
        while (i <= gt)
        {
            int cmp = -1;
            if(greater(list.get(i), v, comparator)){
                cmp = 1;
            }
            //int cmp = comparator.compare(list.get(i), v);
            if(cmp < 0) swap(list, lt++, i++);
            else if (cmp > 0) swap(list, i, gt--);
            else i++;
        } // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(comparator, list, lo, lt - 1);
        sort(comparator, list, gt + 1, hi);
    }
}
