package anaydis.sort;

import anaydis.sort.statistics.CountSorterListener;
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

    protected AbstractSorter(@NotNull final SorterType type) {
        listeners = new ArrayList<>();
        this.type = type;
        addSorterListener(new CountSorterListener());
    }

    @NotNull
    @Override
    public SorterType getType() {
        return type;
    }


    protected boolean greater(T v, T w, Comparator<T> comp) {
        dataTypeListeners(v.getClass());
        greaterListeners();
        return comp.compare(v,w) > 0;
    }

    protected void swap(List<T> list, int i, int j) {
        lengthListeners(list.size());
        swapListeners(i, j);

        //list.set(i, list.set(i, list.get(j)));

        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);

    }

    protected void greaterListeners(){
        for(SorterListener listener: listeners){
            listener.greater(0, 0);
        }
    }

    protected void swapListeners(int i, int j) {
        for(SorterListener listener: listeners){
            listener.swap(i, j);
        }
    }

    protected void initListeners(){
        for(SorterListener listener: listeners) {
            if (listener.getClass().equals(CountSorterListener.class)) {
                ((CountSorterListener) listener).init();
            }
        }
    }

    protected void lengthListeners(int length){
        for(SorterListener listener: listeners) {
            if (listener.getClass().equals(CountSorterListener.class)) {
                ((CountSorterListener) listener).length(length);
            }
        }
    }

    private void dataTypeListeners(Class dataType) {
        for(SorterListener listener: listeners) {
            if (listener.getClass().equals(CountSorterListener.class)) {
                ((CountSorterListener) listener).setDataType(dataType);
            }
        }
    }

    protected void finishListeners() {
        for (SorterListener listener : listeners) {
            if (listener.getClass().equals(CountSorterListener.class)) {
                ((CountSorterListener) listener).finish();
            }
        }
    }


    public void addSorterListener(SorterListener listener){
        if (listener.getClass().equals(CountSorterListener.class)) {
            ((CountSorterListener)listener).setSorterType(type);
        }
        listeners.add(listener);
    }

    public void removeSorterListener(SorterListener listener){
        listeners.remove(listener);
    }
    public void removeLastSorterListener(){listeners.remove(listeners.size()-1);}
    public List<SorterListener> getListeners(){
        return listeners;
    }
}
