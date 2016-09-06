package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by FliaPadros on 6/9/2016.
 */
public class BottomUpMergeSort extends MergeSorter {
    public BottomUpMergeSort() {
        super(SorterType.MERGE_BOTTOM_UP);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        lengthListeners(list.size());
        sort(comparator, list, 0, list.size()-1);
        finishListeners();
    }

    private <T> void sort(Comparator<T> comparator, List<T> list, int left, int right) {
        List<T> aux = new ArrayList<T>();
        for(int middle = 1; middle <= right - left; middle *= 2) {
            final int middle2 = middle * 2;
            for (int left1 = left; left1 <= right - middle; left1 += middle2) {
                final int high1 = Math.min(left1 - left + middle2 - 1, right);
                merge(comparator, list, left1, left1 + middle - 1, high1, aux);
            }
        }
    }

}

