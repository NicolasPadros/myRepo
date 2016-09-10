package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/3/16.
 */
public class ThreeWayPartioningQuickSorter extends QuickSorter {
    int i;
    int j;

    public ThreeWayPartioningQuickSorter() {
        super(SorterType.QUICK_THREE_PARTITION);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        sort(comparator, list, 0, list.size() - 1);
        finishListeners();
    }

    protected <T> void sort(Comparator<T> comparator, List<T> list, int left, int right) {
        if (right <= left) return;
        int i = left;
        int j = left + 1;
        int k = right;

        T pivot = list.get(left);

        while (j <= k) {
            if (greater(pivot, list.get(j), comparator)) swap(list, j++, j++);
            else if (!greater(pivot, list.get(j), comparator)) swap(list, j, k--);
            else j++;
        }

        sort(comparator, list, left, j - 1);
        sort(comparator, list, k + 1, right);
    }
}
