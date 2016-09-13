package anaydis.search;

import anaydis.sort.data.IntegerDataSetGenerator;
import org.junit.Test;
import org.junit.experimental.max.MaxHistory;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by isabel on 9/12/16.
 */
public class ArrayMapTest {
    @Test
    public void ArrayMapTest(){
        final ArrayMap<Integer, Integer> map = new ArrayMap<Integer, Integer>(100, Comparator.naturalOrder());
        final IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        final List<Integer> list = generator.createRandom(100);
        for(int i = 0; i < 100; i++){
            System.out.println(list.get(i));
            map.put(list.get(i), (int)(Math.random()*100));
        }
        for(int i = 0; i< 100; i++){
            if(map.containsKey(list.get(i))) map.get(list.get(i));
            map.remove(list.get(i));
        }
        Iterator<Integer> iterator = map.keys();
        assertThat(!iterator.hasNext());
        map.clear();
        map.put(2, 2);
        iterator = map.keys();
        assertThat(iterator.next() == 2);

    }
}
