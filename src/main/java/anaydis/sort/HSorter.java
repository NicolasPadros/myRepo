package anaydis.sort;

import anaydis.sort.statistics.CountSorterListener;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 8/26/16.
**/
 public class HSorter extends AbstractSorter {
    public HSorter() {
        super(SorterType.H);
    }

    public <T> void sort(Comparator<T> comparator, List<T> list) {
        sort(comparator, list, 11, 0, list.size()-1);
    }

    private <T> void sort(Comparator<T> comparator, List<T> list, int h, int left, int right) {
        initListeners();
        for (int i = left+h; i <= right; i++) {
            T v = list.get(i);
            int j = i;
            while (j >= left+h && !greater(v, list.get(j-h), comparator) && !v.equals(list.get(j-h))) {
                list.set(j, list.get(j-h));
                j -= h;
            }
            list.set(j, v);
        }
        finishListeners();
    }

    public<T> void sort(Comparator<T> comparator, List<T> list, int h){
        sort(comparator, list, h, 0, list.size()-1);
    }
}
