package anaydis.sort;

import anaydis.sort.statistics.CountSorterListener;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 8/26/16.
 */
public class ShellSorter extends HSorter{

    public ShellSorter() {
        super(SorterType.SHELL);
    }


    private <T> void sort(Comparator<T> comparator, List<T> list, int left, int right) {
        initListeners();
        lengthListeners(list.size());
        int h;
        for (h = 1; h <= (right - left) / 9; h = 3 * h + 1);
            for (; h > 0; h /= 3) {
               sort(comparator, list, h);
            }

        finishListeners();
    }

    public<T> void sort(Comparator<T> comparator, List<T> list){
        sort(comparator, list, 0, list.size()-1);
    }

    public <T> void sort(Comparator<T> comparator, List<T> list, int[] sequence) {
        initListeners();
        lengthListeners(list.size());
        for(int gap : sequence){
            sort(comparator, list, gap);
        }
        finishListeners();
    }
}


