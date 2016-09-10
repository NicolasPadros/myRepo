package search;

import org.jetbrains.annotations.NotNull;

/**
 * Created by isabel on 9/10/16.
 */
public class RandomizedTreeMap<K extends Comparable, V> extends RootInsertionTreeMap<K, V> {

    @Override
    public V put(@NotNull K key, V value) {
        if(Math.random() < 0.5) {
            rootPut(head, key, value);
        }
        else{ put(head, key, value); }
        return search(head, key);
    }
}
