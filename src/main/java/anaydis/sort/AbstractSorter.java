package anaydis.sort;

import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Abstract sorter: all sorter implementations should subclass this class.
 */
abstract class AbstractSorter<T> implements Sorter, ObservableSorter{
    protected List<SorterListener> listeners;
    private SorterType type;

    public AbstractSorter(SorterType type) {
        listeners = new ArrayList<>(3);
        this.type = type;
    }

    @NotNull
    @Override
    public SorterType getType() {
        return type;
    }

    protected boolean greater(T v, T w, Comparator<T> comp) {
        return comp.compare(v,w) > 0;
    }

    protected void swap(List<T> list, int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    public void addSorterListener(SorterListener listener){
        listeners.add(listener);
    }

    public void removeSorterListener(SorterListener listener){
        listeners.remove(listener);
    }

}
