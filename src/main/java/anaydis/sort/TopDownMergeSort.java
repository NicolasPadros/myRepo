package anaydis.sort;

import anaydis.sort.gui.SorterListener;
import anaydis.sort.statistics.CountSorterListener;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.Marshaller;
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


    protected <T> void merge(@NotNull Comparator<T> comparator, @NotNull List<T> list, int left, int mid, int right){
        int i = left;
        int j = mid+1;
        List<T> pivotList = new ArrayList<T>();

        for(int k = left; k<= right; k++){
            pivotList.set(k, list.get(k));
        }

        for(int k=left; k<=right; k++){
            if( i>mid) list.set(k, pivotList.get(j++));
            else if(j>right) list.set(k, pivotList.get(i++));
            else if(greater(pivotList.get(i), pivotList.get(j), comparator)) list.set(k, pivotList.get(j++));
            else list.set(k, pivotList.get(i++));
        }
    }



    private<T> List<T> merge(List<T> listA, List<T> listB, Comparator<T> comparator) {
        List<T> result = new ArrayList<T>(listA.size()+ listB.size() -2);
        for (int i = 0, j = 0, k = 0; k < result.size(); k++) {
            if(i >= listA.size()) {
                result.set(k, listB.get(i++));
            }
            else if (j >= listB.size()) {
                result.set(k, listA.get(j++));
            }
            else {
                if (greater(listB.get(j), listA.get(i), comparator)){
                    result.set(k, listA.get(i++));
                } else{
                    result.set(k, listB.get(j++));
                }
            }
        }
        return result;
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

