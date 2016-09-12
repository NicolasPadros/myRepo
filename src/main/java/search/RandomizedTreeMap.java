package search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * Created by isabel on 9/10/16.
 */
public class RandomizedTreeMap<K, V> extends RootInsertionTreeMap<K, V> {

    public RandomizedTreeMap(Comparator<K> comparator) {
        super(comparator);
    }

    @Override
    public V put(@NotNull K key, V value) {
        if(Math.random() < 0.5) {
            head = rootPut(head, key, value);
        }
        else { head = put(head, key, value); }
        return search(head, key);
    }
}
