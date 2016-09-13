package anaydis.search;


import anaydis.search.Map;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by FliaPadros on 9/9/2016.
 */
public class ArrayMap<K, V> implements Map<K, V> {
    protected K[] keys;
    protected V[] values;
    protected int size;
    protected Comparator<K> comparator;

    public ArrayMap(int maxSize, Comparator<K> comparator) {
        keys =(K[]) new Object[maxSize];
        values =(V[]) new Object[maxSize];
        size = 0;
        this.comparator = comparator;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(@NotNull K key) {
        return (indexOf(key) != -1);
    }

    @Override
    public V get(@NotNull K key) {
        if(indexOf(key) == -1) return null;
        return values[indexOf(key)];
    }

    @Override
    public V put(@NotNull K key, V value) {
        if (indexOf(key) == -1) {
            size++;
            keys[size] = key;
        }
        V result = values[indexOf(key)];
        values[indexOf(key)] = value;
        return result;
    }

    public void remove(K key){
        int index = indexOf(key);
        if(index != -1){
            for(int i = index+1; i < size()-1; i++){
                keys[i-1] = keys[i];
                values[i-1] = values[i];
            }
            size--;
        }
    }

    @Override
    public void clear() {
        keys = (K[])new Object[keys.length];
        values = (V[])new Object[keys.length];
    }

    @Override
    public Iterator<K> keys() {
        return new KeysIterator();
    }

    protected int indexOf(K key){
        for(int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                if (keys[i].equals(key)) return i;
            }
        }
        return -1;
    }

    protected class KeysIterator implements Iterator<K> {
        int count;

        public KeysIterator() {
            count = 0;
        }

        @Override
        public boolean hasNext() {
            for(int i = count; i < keys.length; i++){
                if(keys[i] != null) return true;
            }
            return false;
        }

        @Override
        public K next() {
            return keys[count];
        }
    }
}