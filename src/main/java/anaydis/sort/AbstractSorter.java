package anaydis.sort;

import anaydis.sort.gui.CountSorterListener;
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
    protected List<CountSorterListener> listeners;
    private SorterType type;

    public AbstractSorter(SorterType type) {
        listeners = new ArrayList<>();
        this.type = type;
        addSorterListener(new CountSorterListener());
    }

    @NotNull
    @Override
    public SorterType getType() {
        return type;
    }

    protected void initListeners(){
        for(CountSorterListener listener: listeners){
            listener.init();
        }
    }

    protected void finishListeners(){
        /*
        for(int i = 0; i < listeners.size(); i++){
            listeners.get(i).finish();
            listeners.remove(i);
        }
        */
        for(CountSorterListener listener: listeners){
            listener.finish();
        }


    }

    protected boolean greater(T v, T w, Comparator<T> comp) {
        for(CountSorterListener listener: listeners){
            listener.greater(0, 0);
        }
        return comp.compare(v,w) > 0;
    }

    protected void swap(List<T> list, int i, int j) {
        for(CountSorterListener listener: listeners){
            listener.swap(0, 0);
        }
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }


    public void addSorterListener(SorterListener listener){
        listeners.add((CountSorterListener)listener);
    }

    public void removeSorterListener(SorterListener listener){
        listeners.remove(listener);
    }

    public List<CountSorterListener> getListeners(){
        return listeners;
    }
}
