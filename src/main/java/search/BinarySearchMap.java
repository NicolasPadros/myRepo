package search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * Created by FliaPadros on 10/9/2016.
 */
public class BinarySearchMap<K, V> extends ArrayMap<K, V> {
    public BinarySearchMap(int maxSize) {
        super(maxSize);
    }


    protected int indexOf(K key, Comparator<K> comparator) {
        int index = find(key, 0, size()-1, comparator);
        if(index < 0) return -1;
        else return index;
    }

    private int find(K key, int low, int high, Comparator<K> comparator) {
        if(low < high) return -(low +1);
        int middle = (low+ high)/2;
        int compare = comparator.compare(key, keys[middle]);
        if(compare == 0) return middle;
        if(compare < 0) return find(key, 0, middle-1, comparator);
        else return find(key, middle, high, comparator);
    }

    public V put(@NotNull K key, V value, Comparator<K> comparator) {
        int index = find(key, 0, size -1, comparator);
        if(index < 0){
            index = (-index)-1;
            for( int i = size++; i > index+1; i--){
                keys[i] = keys[i-1];
                values[i] = values[i-1];
            }
            keys[index] = key;
        }
        V result = values[index];
        values[index] = value;
        return result;
    }


}
