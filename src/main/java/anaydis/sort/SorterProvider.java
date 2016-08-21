package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by isabel on 8/20/16.
 */
public class SorterProvider implements anaydis.sort.provider.SorterProvider {
    private Map<SorterType, Sorter> sorters;

    public SorterProvider() {
        sorters = new EnumMap(SorterType.class);
        sorters.put(SorterType.INSERTION, new InsertionSorter());
        sorters.put(SorterType.SELECTION, new SelectionSorter());
        sorters.put(SorterType.BUBBLE, new BubbleSorter());
    }

    @NotNull
    @Override
    public Iterable<Sorter> getAllSorters() {
        ArrayList<Sorter> list = new ArrayList<>();
        for (Map.Entry<SorterType, Sorter> entry : sorters.entrySet())
        {
            list.add(entry.getValue());
        }
        return list;
    }

    @NotNull
    @Override
    public Sorter getSorterForType(@NotNull SorterType type) {
        if(!sorters.containsKey(type)) throw new IllegalArgumentException("No sorter for that type");
        return sorters.get(type);
    }
}
