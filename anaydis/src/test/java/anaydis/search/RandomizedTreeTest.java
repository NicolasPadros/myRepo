package anaydis.search;

import anaydis.sort.data.IntegerDataSetGenerator;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by FliaPadros on 13/9/2016.
 */
public class RandomizedTreeTest {

    @Test
    public void TestRandomizedTree() {

        final RandomizedTreeMap<Integer, Integer> map = new RandomizedTreeMap<Integer, Integer>(Comparator.naturalOrder());
        final IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        final List<Integer> list = generator.createRandom(100);
        map.put(2, 32);
        System.out.println(map.put(2, 24));
        for (int i = 0; i < 100; i++) {
            map.put(list.get(i), (int) (Math.random() * 100));
        }
        System.out.println(map.get(list.get(0)));
        for (int i = 0; i < 100; i++) {
            if (map.containsKey(list.get(i))) map.get(list.get(i));
            map.remove(list.get(i));
        }
        map.clear();
        map.put(2, 2);
        Iterator<Integer> iterator = map.keys();
        assertThat(iterator.hasNext() && iterator.next() == 2);
    }
}

