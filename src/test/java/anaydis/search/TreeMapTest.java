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
public class TreeMapTest {

    @Test
    public void testTreeMap() {

        final TreeMap<Integer, Integer> map = new TreeMap<Integer,  Integer>(Comparator.naturalOrder());
        final IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        final TreeMap.Node node  = map.new Node<Integer, Integer>();
        node.key = 2;
        node.value = 3;
        System.out.println(node.toString());
        final List<Integer> list = generator.createRandom(100);
        for (int i = 0; i < 100; i++) {
            System.out.println(list.get(i));
            map.put(list.get(i), (int) (Math.random() * 100));
        }
        assertThat(map.size() == 100);
        for (int i = 0; i < 100; i++) {
            if (map.containsKey(list.get(i))) System.out.println(map.get(list.get(i)));
            map.remove(list.get(i));
        }
        map.clear();
        map.put(2, 2);
        Iterator<Integer> iterator = map.keys();
        assertThat(iterator.hasNext() && iterator.next() == 2);
    }



}
