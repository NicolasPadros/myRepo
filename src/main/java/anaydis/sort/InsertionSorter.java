package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 8/20/16.
 */
public class InsertionSorter extends AbstractSorter {
    public InsertionSorter() {
        super(SorterType.INSERTION);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (!greater(list.get(j), list.get(j-1), comparator)) {
                    swap(list, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

}
