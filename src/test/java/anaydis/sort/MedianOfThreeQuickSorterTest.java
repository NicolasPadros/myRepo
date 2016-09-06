package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import org.junit.Test;

import static anaydis.sort.MedianOfThreeQuickSorter.setM;

/**
 * Created by isabel on 9/2/16.
 */
public class MedianOfThreeQuickSorterTest extends SorterTest {
    @Test
    public void testIntegerSort10() {
        setM(5);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 10);
    }

    @Test
    public void testIntegerSort1000() {
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 1000);
    }

    @Test
    public void testStringSort100() {
        testSorter(new StringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 100);
    }
}
