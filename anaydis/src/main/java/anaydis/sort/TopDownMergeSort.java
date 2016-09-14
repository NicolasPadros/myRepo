package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/4/16.
 */
public class TopDownMergeSort extends MergeSorter {
    public TopDownMergeSort() {
        super(SorterType.MERGE);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        initListeners();
        lengthListeners(list.size());
        List<T> aux = new ArrayList<T>();
        sort(comparator, list, 0, list.size() - 1, aux);
        finishListeners();
    }

    private <T> void sort(Comparator<T> comparator, List<T> list, int left, int right, List<T> aux) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(comparator, list, left, mid, aux);
            sort(comparator, list, mid + 1, right, aux);
            merge(comparator, list, left, mid, right, aux);
        }
    }






/*

    private <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list,int lo,int hi,List<T> aux){
        if(hi<=lo) return;
        int m=lo +(hi-lo)/2;
        sort(comparator,list,lo,m,aux);
        sort(comparator,list,m+1,hi,aux);
        merge(comparator,list,lo,m,hi,aux);

    }
    */
}

