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
        setM(25);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 100);
    }


    @Test
    public void testStringSort100() {
        setM(25);
        testSorter(new StringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 100);
    }


}
