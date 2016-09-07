package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 9/2/16.
 */
public class MedianOfThreeQuickSorter extends QuickSorter {

    private  static int M;
    private InsertionSorter insertion;


    private<T> void quicksort(Comparator<T> comparator, List<T> list, int left, int right) {
        if (right-left <= M) return;
        swap(list, (left+right)/2, right-1);
        if (greater(list.get(left), list.get(right-1), comparator)) swap(list, left, right-1);
        if (greater(list.get(left), list.get(right), comparator)) swap(list, left, right);
        if (greater(list.get(right-1), list.get(right), comparator)) swap(list, right-1, right);

        int i = partition(comparator, list, left+1, right-1);
        quicksort(comparator, list, left, i-1);
        quicksort(comparator, list, i+1, right);
    }

    private<T> void hybridsort(Comparator<T> comparator, List<T> list, int lo, int hi) {
        initListeners();
        quicksort(comparator, list, lo, hi);
        insertion.sort(comparator, list, lo, hi);
        finishListeners();
    }

    public MedianOfThreeQuickSorter() {
        super(SorterType.QUICK_MED_OF_THREE);
        insertion = new InsertionSorter();
        M = 5;
    }

    @Override
    public<T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        hybridsort(comparator, list, 0, list.size()-1);
    }

    public static void setM(int N){ M = N;}

    private<T>  void quickSort(Comparator<T> comparator, List<T> list, int low, int high ) {
        //if( low + M > high )
          //  insertion.sort( comparator, list, low, high);
        //else {
            // Sort low, middle, high
            int middle = ( low + high ) / 2;
            if(greater(list.get(low), list.get(middle), comparator))
                swap( list, low, middle );
            if( greater(list.get(low), list.get(high), comparator))
                swap(list, low, high );
            if(greater(list.get(middle), list.get(high), comparator))
                swap(list, middle, high );

            // Place pivot at position high - 1
            swap( list, middle, high - 1 );
            T pivot = list.get(high - 1);

            // Begin partitioning
            int i, j;
            for( i = low, j = high - 1; ; ) {
                while( greater(pivot, list.get(++i), comparator))
                    ;
                while( greater(list.get(--j), pivot, comparator))
                    ;
                if( i >= j )
                    break;
                swap(list, i, j );
            }

            // Restore pivot
            swap(list, i, high - 1 );

            quickSort(comparator, list, low, i - 1 );    // Sort small elements
            quickSort(comparator, list, i + 1, high);   // Sort large elements
        }
    }

//}
