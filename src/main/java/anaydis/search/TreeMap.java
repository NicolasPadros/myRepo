package anaydis.search;

import anaydis.search.Map;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by isabel on 9/10/16.
 */
public class TreeMap<K, V> implements Map<K, V> {
    protected Node<K, V> head;
    protected int size;
    protected Comparator<K> comparator;

    public TreeMap(Comparator<K> comparator) {
        size = 0;
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(@NotNull K key) {
        return find(head, key) != null;
    }



    public V get(@NotNull K key) {
        Node<K, V> node = find(head, key);
        return node.value;
    }

    private Node<K,V> find(Node<K, V> node, K key) {
        if (node == null) return null;
        int cmp = comparator.compare(key, node.key);
        if(cmp == 0) return node;
        else if(cmp < 0) return find(node.left, key);
        else return find(node.right, key);
    }

    @Override
    public V put(@NotNull K key, V value) {
        head = put(head, key, value);
        return search(head, key);
    }

    protected V search(Node<K, V> node, K key) {
        if(node == null){
            return null;
        } else{
            int cmp = comparator.compare(key, node.key);
            if(cmp < 0) search(node.left, key);
            if(cmp> 0) search(node.right, key);
            else {
                 return node.value;
            }
        }
        return null;
    }

    public ArrayList<K> keySet(){
        ArrayList<K> list = new ArrayList<K>();
        inOrder(head, list);
        return list;
    }

    private void inOrder(Node<K, V> node, ArrayList<K> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.key);
            inOrder(node.right, list);
        }
    }

    protected Node<K,V> put(Node<K, V> node, K key, V value) {

        if(node == null){
            size++;
            return new Node<K, V>(key, value);
        } else{
            int cmp = comparator.compare(key, node.key);
            if(cmp < 0) node.left = put(node.left, key, value);
            if(cmp> 0) node.right = put(node.right, key, value);
            else {
                node.value = value;
            }
        }
        return node;
    }

    public void remove(K key){
        head = remove(head, key);
    }


    private Node<K,V> remove(Node<K, V> node, K key) {
        if(node == null) return null;
        int cmp = comparator.compare(key, node.key);
        if (cmp < 0){
            node.left = remove(node.left, key);
            return node;
        }
        if (cmp < 0){
            node.right = remove(node.right, key);
            return node;
        } else{
            size--;
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            else{
                Node<K, V> next = first(node.right);
                node.key = next.key;
                node.value = next.value;
                next.key = key;
                node.right =  remove(node.right, key);
                return node;
            }
        }
    }

    private Node<K,V> first(Node<K, V> node) {
        if(node == null || node.left == null) return node;
        else return first(node.left);
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public Iterator<K> keys() {
        return new TreeKeysIterator();
    }

    protected class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        public Node() {
            left = null;
            right = null;
            key = null;
            value = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "[" + value + "]";
        }
    }

    private class TreeKeysIterator implements Iterator<K> {
        private ArrayList<K> keySet;
        private int count;

        public TreeKeysIterator() {
            keySet = keySet();
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return (count < keySet.size());
        }

        @Override
        public K next() {
            return keySet.get(count++);
        }
    }
}
