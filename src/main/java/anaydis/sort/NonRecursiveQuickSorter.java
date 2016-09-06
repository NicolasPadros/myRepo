package anaydis.sort;

import com.sun.org.apache.xerces.internal.util.IntStack;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/2/16.
 */
public class NonRecursiveQuickSorter extends AbstractSorter{

    public NonRecursiveQuickSorter() {
        super(SorterType.QUICK_NON_RECURSIVE);
    }
    protected <T> int partition(List<T> list, int lo, int hi, Comparator<T> comparator) {
        int i = lo - 1;
        int j = hi;
        while(true) {
            while(greater(list.get(hi), list.get(++i ), comparator)); //find item left to swap
            if (i == hi) break;
            while(greater(list.get(j), list.get(hi), comparator )); //find item right to swap
            if (j == lo) break;
            if (i >= j) break; //check if pointers cross
            swap(list, i, j); //swap
        }
        swap(list, i, hi); //swap with partitioning item
        return i; //return index of item now known to be in place
    }



    private<T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int left, int right) {

            IntStack S = new IntStack();
            S.push(left);
            S.push(right);
            while (S.size() != 0) {
                right = S.pop();
                left = S.pop();
                if (right <= left) {
                    continue;
                }
                int i = partition(list, left, right, comparator);
                if (i - left > right - i) {
                    S.push(left);
                    S.push(i - 1);
                }
                S.push(i + 1);
                S.push(right);
                if (right - i >= i-left) {
                    S.push(left);
                    S.push(i - 1);
                }
            }
        }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        sort(comparator, list, 0, list.size()-1);
        finishListeners();
    }
}

