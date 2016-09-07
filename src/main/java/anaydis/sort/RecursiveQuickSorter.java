package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/2/16.
 */
public class RecursiveQuickSorter extends QuickSorter{
    public RecursiveQuickSorter() {
        super(SorterType.QUICK);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        sort(comparator, list, 0, list.size()-1);
        finishListeners();
    }

    public<T> void sort(Comparator<T> comparator, List<T> list, int left, int right) {
        if (right <= left) return;
        int i = partition(comparator, list, left, right);
        sort(comparator, list, left, i - 1);
        sort(comparator, list, i + 1, right);
    }

}
