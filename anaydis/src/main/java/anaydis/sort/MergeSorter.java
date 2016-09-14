package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by FliaPadros on 6/9/2016.
 */
public abstract class MergeSorter extends AbstractSorter{

    protected MergeSorter(@NotNull SorterType type) {
        super(type);
    }

    protected<T> void merge(Comparator<T> comparator, List<T> list, int lo, int m, int hi, List<T> aux) {
        for(int i=lo;i<=m;i++){
            copy(list,i,i,aux,true);
        }
        for(int j=m+1;j<=hi;j++){
            copy(list,hi-j+m+1,j,aux,true);
        }
        int i=lo,j=hi;
        for(int k=lo;k<=hi;k++) {
            if (greater(aux.get(i), aux.get(j), comparator))
                copy(aux, j--, k, list, false);
            else{
                copy(aux, i++, k, list, false);
            }
        }
    }

}
