package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import org.junit.Test;

import static anaydis.sort.CutOffQuickSorter.setM;

/**
 * Created by isabel on 9/2/16.
 */
public class CutOffQuickSorterTest extends SorterTest {
    @Test
    public void testIntegerSort10() {
        setM(10);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_CUT, 10);
    }

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
