package anaydis.sort;

import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by NicolasPadros on 8/20/16.
 */
public class SelectionSorter extends AbstractSorter {

    public SelectionSorter() {
        super(SorterType.SELECTION);
    }

    @Override
    public <T>  void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        int N = list.size();
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (!greater(list.get(j), list.get(min), comparator) && !list.get(j).equals(list.get(min))) {
                    min = j;
                }
            }
            swap(list, i, min);
        }
        finishListeners();
    }


}
