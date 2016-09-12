package search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * Created by isabel on 9/10/16.
 */
public class RootInsertionTreeMap<K, V> extends TreeMap<K, V> {

    public RootInsertionTreeMap(Comparator<K> comparator) {
        super(comparator);
    }

    @Override
    public V put(@NotNull K key, V value) {
        head = rootPut(head, key, value);
        return search(head, key);
    }

    protected Node<K,V> rootPut(Node<K, V> node, K key, V value) {
        if(node == null){
            size++;
            return new Node<K, V>(key, value);
        } else{
            int cmp = comparator.compare(key, node.key);
            if(cmp < 0) {
                node.left = rootPut(node.left, key, value);
                return rotateRight(node);
            }
            if (cmp > 0){
                node.right = rootPut(node.right, key, value);
                return rotateLeft(node);
            }
            else {
                node.value = value;
                return node;
            }
        }
    }

    protected Node<K,V> rotateLeft(Node<K, V> node) {
        Node<K, V> result = node.right;
        if(node.right == null) throw new NullPointerException("Node.right is null");
        node.right = result.left;
        result.left = node;
        return result;
    }

    protected Node<K, V> rotateRight(Node<K, V> node) {
        Node<K, V> result = node.left;
        if(result == null ) throw new NullPointerException("Node. left is null");
        node.left = result.right;
        result.right = node;
        return result;
    }
}
