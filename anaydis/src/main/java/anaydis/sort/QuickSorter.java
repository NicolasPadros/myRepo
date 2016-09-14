package anaydis.sort;

/**
 * Created by FliaPadros on 6/9/2016.
 */
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

    protected <T> int partition(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (greater(list.get(lo), list.get(++i) , comparator)) if (i == hi) break;
            while (greater(list.get(--j), list.get(lo), comparator)) if (j == lo) break;
            if (i >= j) break;
            swap(list, i, j);
        }
        swap(list, lo, j);
        return j;
    }
}

