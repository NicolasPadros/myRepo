package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import anaydis.sort.provider.SorterProvider;
import anaydis.sort.provider.SorterProviderImpl;
import org.junit.Test;

import java.util.*;

import static anaydis.sort.CutOffQuickSorter.setM;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by isabel on 9/2/16.
 */
public class CutOffQuickSorterTest extends SorterTest {
    @Test
    public void testIntegerSort10() {
        setM(8);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_CUT, 10);
    }

    /*
    @Test
    public void testBestM() {
        for (int i = 0; i < 9999; i++) {
            setM(i);
            final SorterProvider provider = new SorterProviderImpl();
            final IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
            final List<Integer> original = generator.createRandom(10000);
            final List<Integer> copy = new ArrayList<Integer>(original);


            final Sorter quickSorter = provider.getSorterForType(SorterType.QUICK_CUT);
            quickSorter.sort(Comparator.<Integer>naturalOrder(), copy);

        }
    }
    */


    @Test
    public void testIntegerSort1000() {
        setM(10);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_CUT, 1000);
    }

    @Test
    public void testStringSort100() {
        setM(10);
        testSorter(new StringDataSetGenerator(), SorterType.QUICK_CUT, 100);
    }
}
