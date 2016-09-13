package anaydis.search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * Created by FliaPadros on 10/9/2016.
 */
public class BinarySearchMap<K, V> extends ArrayMap<K, V> {

    public BinarySearchMap(int maxSize, Comparator<K> comparator) {
        super(maxSize, comparator);
    }


    protected int indexOf(K key, Comparator<K> comparator) {
        int index = find(key, 0, size()-1);
        if(index < 0) return -1;
        else return index;
    }

    private int find(K key, int low, int high) {
        if(low > high) return -(low +1);
        int middle = (low+ high)/2;
        int compare = comparator.compare(key, keys[middle]);
        if(compare == 0) return middle;
        if(compare < 0) return find(key, 0, middle-1);
        else return find(key, middle+1, high);
    }

    public V put(@NotNull K key, V value) {
        int index = find(key, 0, size -1);
        if(index < 0){
            index = (-index)-1;
            for(int i = size++; i >= index+1; i--){
                keys[i] = keys[i-1];
                values[i] = values[i-1];
            }
            keys[index] = key;
        }
        V result = values[index+1];
        values[index] = value;
        return result;
    }


}
