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


    private <T> void sort(Comparator<T> comparator, List<T> list, int low, int high) {
        if (high <= low) return;

        int lt = low;
        int i = low+1;
        int gt = high;

        T v = list.get(low);
        while (i <= gt)
        {
            int cmp = -1;
            if(greater(list.get(i), v, comparator)){
                cmp = 1;
            }
            //int cmp = comparator.compare(list.get(i), v);
            if(cmp < 0) swap(list, lt++, i++);
            else if (cmp > 0) swap(list, i, gt--);

        } // Now a[low..lt-1] < v = a[lt..gt] < a[gt+1..high].
        sort(comparator, list, low, lt - 1);
        sort(comparator, list, gt + 1, high);
    }
}
