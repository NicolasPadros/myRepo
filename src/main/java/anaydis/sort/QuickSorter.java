package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 8/26/16.
 */
public class QuickSorter extends AbstractSorter {
    public QuickSorter() {
        super(SorterType.QUICK);
    }

    @Override
    public<T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
    quicksort(comparator, list, 0, list.size()-1);
    }

    private<T> void quicksort(Comparator<T> comparator, List<T> list, int left, int right) {

        T pivot = list.get(left+ (right-left)/2);
        int i = left;
        int j = right;
        T aux;

        while (i <= j) {
            while (comparator.compare(list.get(i), pivot) < 0) i++;
            while (comparator.compare(list.get(j), pivot) > 0) j--;
            if (i <= j) {
                aux = list.get(i);
                list.set(i, list.set(j, aux));
                i++;
                j--;
            }
        }
        //list.set(left, list.set(j, pivot));
        if (left < j)
            quicksort(comparator, list, left, j);

        if (i < right)
            quicksort(comparator, list, i, right);
    }
}

