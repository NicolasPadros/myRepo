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

    protected <T> void quickSort(Comparator<T> comparator, List<T> list, int left, int right) {
        /*
        if (right <= left) return;
        int i = left;
        int j = left + 1;
        int k = right;

        T pivot = list.get(left);

        while (j <= k) {
            int compare = comparator.compare(list.get(j), pivot);
            if (!greater(list.get(j), pivot, comparator)) swap(list, j++, i++);
            else if (greater(list.get(j), pivot, comparator)) swap(list, j, k--);
            else j++;
        }

        quickSort(comparator, list, left, j - 1);
        quickSort(comparator, list, k + 1, right);
        */
        if (right <= left) return;


        // Note that i and j are passed as reference
        partition(list, left, right, comparator);

        // Recur
        quickSort(comparator, list, left, j);
        quickSort(comparator, list, i, right);

    }

    private <T> void partition(List<T> list, int l, int r, Comparator<T> comparator) {

        i = l - 1;
        j = r;
        int p = l - 1, q = r;
        T v = list.get(r);

        while (true) {
            // From left, find the first element greater than
            // or equal to v. This loop will definitely terminate
            // as v is last element
            while (greater(v, list.get(++i), comparator)) ;

            // From right, find the first element smaller than or
            // equal to v
            while (greater(list.get(--j), v, comparator))
                if (j == l)
                    break;

            // If i and j cross, then we are done
            if (i >= j) break;

            // Swap, so that smaller goes on left greater goes on right
            swap(list, i, j);

            // Move all same left occurrence of pivot to beginning of
            // array and keep count using p
            if (equals(comparator, list.get(i), v)) {
                p++;
                swap(list, p, i);
            }

            // Move all same right occurrence of pivot to end of array
            // and keep count using q
            if (equals(comparator, list.get(j), v)) {
                q--;
                swap(list, j, q);
            }
        }

        // Move pivot element to its correct index
        swap(list, i, r);

        // Move all left same occurrences from beginning
        // to adjacent to arr[i]
        j = i - 1;
        for (int k = l; k < p; k++, j--)
            swap(list, k, j);

        // Move all right same occurrences from end
        // to adjacent to arr[i]
        i = i + 1;
        for (int k = r - 1; k > q; k--, i++)
            swap(list, i, k);

    }

    private <T> void sort(Comparator<T> comparator, List<T> list, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo;

        int i = lo + 1;

        int gt = hi;

        T v = list.get(lo);

        while (i <= gt) {
            {

                int cmp = comparator.compare(list.get(i), v);

                if (cmp < 0) swap(list, lt++, i++);
                else if (cmp > 0) swap(list, i, gt--);

                else i++;

            } // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].

            sort(comparator, list, lo, lt - 1);

            sort(comparator, list, gt + 1, hi);

        }
    }
}
