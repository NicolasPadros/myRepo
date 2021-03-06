package anaydis.sort.provider;

import anaydis.sort.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static anaydis.sort.SorterType.H;

/**
 * Created by isabel on 8/20/16.
 */
public class SorterProviderImpl implements SorterProvider {
    private Map<SorterType, Sorter> sorters;

    public SorterProviderImpl() {
        sorters = new EnumMap(SorterType.class);
        sorters.put(SorterType.INSERTION, new InsertionSorter());
        sorters.put(SorterType.SELECTION, new SelectionSorter());
        sorters.put(SorterType.BUBBLE, new BubbleSorter());
        sorters.put(SorterType.SHELL, new ShellSorter());
        sorters.put(H, new HSorter(H));
        sorters.put(SorterType.QUICK, new RecursiveQuickSorter());
        sorters.put(SorterType.QUICK_NON_RECURSIVE, new NonRecursiveQuickSorter());
        sorters.put(SorterType.QUICK_CUT, new CutOffQuickSorter());
        sorters.put(SorterType.QUICK_MED_OF_THREE, new MedianOfThreeQuickSorter());
        sorters.put(SorterType.QUICK_THREE_PARTITION, new ThreeWayPartioningQuickSorter());
        sorters.put(SorterType.MERGE, new TopDownMergeSort());
        sorters.put(SorterType.MERGE_BOTTOM_UP, new BottomUpMergeSort());
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
