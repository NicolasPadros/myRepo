package anaydis.sort.data;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 8/20/16.
 */
public class IntegerDataSetGenerator implements DataSetGenerator<Integer> {
    @NotNull
    @Override
    public List<Integer> createAscending(int length) {
        List<Integer> list = new ArrayList<>(length);
        for(int i = 0; i < length; i++){
            list.add(i);
        }
        return list;
    }

    @NotNull
    @Override
    public List<Integer> createDescending(int length) {
        List<Integer> list = new ArrayList<>(length);
        for(int i = length; i > 0; i--){
            list.add(i);
        }
        return list;
    }

    @NotNull
    @Override
    public List<Integer> createRandom(int length) {
        List<Integer> list = new ArrayList<>(length);
        for( int i = 0; i < length; i++){
            list.add((int)(Math.random() * 100));
        }
        return list;
    }

    @NotNull
    @Override
    public Comparator<Integer> getComparator() {
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2){
                    return -1;
                } else if (o1 > o2){
                    return 1;
                } else return 0;
            }
        };
    }
}
