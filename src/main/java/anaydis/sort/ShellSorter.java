package anaydis.sort;

import anaydis.sort.statistics.CountSorterListener;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 8/26/16.
 */
public class ShellSorter extends AbstractSorter {
    private HSorter hSorter;

    public ShellSorter() {
        super(SorterType.SHELL);
        hSorter = new HSorter();
    }


    private <T> void sort(Comparator<T> comparator, List<T> list, int left, int right) {
        initListeners();
        int h;
        for (h = 1; h <= (right - left) / 9; h = 3 * h + 1);
            for (; h > 0; h /= 3) {
                hSorter.sort(comparator, list, h);
            }

        finishListeners();
    }

    public<T> void sort(Comparator<T> comparator, List<T> list){
        sort(comparator, list, 0, list.size()-1);
    }

}


