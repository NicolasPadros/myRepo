package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 8/20/16.
 */
public class BubbleSorter extends AbstractSorter {

    public BubbleSorter() {
        super(SorterType.BUBBLE);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
            boolean swap = true;
            int j = 0;
            T t;
            while (swap) {
                swap = false;
                j++;
                for (int i = 0; i < list.size() - j; i++) {
                    if (greater(list.get(i), list.get(i + 1), comparator)) {
                        swap(list, i, i+1);
                        swap = true;
                    }
                }
            }
        }
}
