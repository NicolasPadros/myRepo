package anaydis.sort;

import anaydis.sort.statistics.CountSorterListener;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 8/26/16.
**/
 public class HSorter extends AbstractSorter {
     private SorterType type;
    public HSorter(SorterType type) {
        super(type);
        this.type = type;
    }

    public <T> void sort(Comparator<T> comparator, List<T> list) {
        sort(comparator, list, 11, 0, list.size()-1);
    }

    private <T> void sort(Comparator<T> comparator, List<T> list, int h, int left, int right) {
        int n = list.size();
        initListeners();
        for (int i = h; i < n; i++) {
            for (int j = i-h; j >= 0; j-=h) {
                if (greater(list.get(j), list.get(j+h), comparator) && !equals(comparator, list, j, j+h)) {
                    swap(list, j, j+h);
                } else {
                    break;
                }
            }
        }
        if(type.equals(SorterType.H)) finishListeners();
    }

    public<T> void sort(Comparator<T> comparator, List<T> list, int h){
        sort(comparator, list, h, 0, list.size()-1);
    }
}
