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
    public void testIntegerSort12500(){
        setM(25);
        testSorter(new IntegerDataSetGenerator(),SorterType.QUICK_MED_OF_THREE, 12500);
    }

    @Test
    public void testIntegerSort25000(){
        setM(25);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 25000);
    }

    @Test
    public void testIntegerSort50000(){
        setM(25);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 50000);
    }

    @Test
    public void testIntegerSort100000(){
        setM(10000);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 100000);
    }

}
