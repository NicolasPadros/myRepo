package anaydis.sort;

import anaydis.sort.data.DataSetGenerator;
import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Sorter tests should subclass this abstract implementation
 */
abstract class SorterTest extends AbstractSorterTest {



    @Override protected StringDataSetGenerator createStringDataSetGenerator() {
        return new StringDataSetGenerator();
    }

    @Override protected IntegerDataSetGenerator createIntegerDataSetGenerator() {
        return new IntegerDataSetGenerator();
    }

    @Test
    protected void testAscendingOrder(int size, SorterType type) {

        final List<Integer> list = new IntegerDataSetGenerator().createAscending(size);
        final anaydis.sort.provider.SorterProvider provider = new anaydis.sort.SorterProvider();
        final List<Integer> copy = new ArrayList<>(list);


        final Sorter sorter = provider.getSorterForType(type);
        sorter.sort(Comparator.<Integer>naturalOrder(), copy);


        Collections.sort(list);


        assertThat(copy).containsExactlyElementsOf(list);
    }

    @Test
    protected void testDescendingOrder(int size, SorterType type) {

        final List<Integer> list = new IntegerDataSetGenerator().createDescending(size);
        final anaydis.sort.provider.SorterProvider provider = new anaydis.sort.SorterProvider();
        final List<Integer> copy = new ArrayList<>(list);


        final Sorter sorter = provider.getSorterForType(type);
        sorter.sort(Comparator.<Integer>naturalOrder().reversed(), copy);


        Collections.sort(list);
        Collections.reverse(list);

        assertThat(copy).containsExactlyElementsOf(list);
    }

    protected void testRandomOrder(int size, SorterType type){
        final List<Integer> list = new IntegerDataSetGenerator().createRandom(size);
        final anaydis.sort.provider.SorterProvider provider = new anaydis.sort.SorterProvider();
        final List<Integer> copy = new ArrayList<>(list);


        final Sorter sorter = provider.getSorterForType(type);
        sorter.sort(Comparator.<Integer>naturalOrder(), copy);


        Collections.sort(list);


        assertThat(copy).containsExactlyElementsOf(list);
    }
}
