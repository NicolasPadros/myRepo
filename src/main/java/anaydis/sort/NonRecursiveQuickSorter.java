package anaydis.sort;

import com.sun.org.apache.xerces.internal.util.IntStack;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/2/16.
 */
public class NonRecursiveQuickSorter extends QuickSorter{

    public NonRecursiveQuickSorter() {
        super(SorterType.QUICK_NON_RECURSIVE);
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
                int i = partition( comparator, list, left, right);
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

