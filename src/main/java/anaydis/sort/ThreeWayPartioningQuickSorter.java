package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/3/16.
 */
public class ThreeWayPartioningQuickSorter extends AbstractSorter {
    private InsertionSorter insertion;
    private static int M;

    public ThreeWayPartioningQuickSorter() {
        super(SorterType.QUICK_THREE_PARTITION);
        insertion = new InsertionSorter();
    }

    @Override
    public<T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        quickSort(comparator, list, 0, list.size()-1);
        insertion.sort(comparator, list);
        finishListeners();

    }

    protected <T> void quickSort(Comparator<T> comparator, List<T> list, int left, int right) {
        if (right <= left || (right-left <= M)) return;
        int i = left;
        int j = left + 1;
        int k = right;

        T pivot = list.get(left);

        while (j <= k) {
            int compare = comparator.compare(list.get(j), pivot);
            if (!greater(list.get(j), pivot, comparator)) swap(list, j++, i++);
            else if(greater(list.get(j), pivot, comparator)) swap(list, j, k--);
            else j++;
        }

        quickSort(comparator, list, left, j - 1);
        quickSort(comparator, list, k + 1, right);



    }
    public static void setM(int N){ M = N;}
}
