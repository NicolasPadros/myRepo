package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import org.junit.Test;

/**
 * Created by isabel on 8/27/16.
 */
public class QuickSorterTest extends SorterTest {
    @Test
    public void testIntegerSort10(){
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK, 10);
    }
    @Test
    public void testIntegerSort1000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK, 1000);
    }
    @Test
    public void testStringSort100(){
        testSorter(new StringDataSetGenerator(), SorterType.QUICK, 100);
    }
}
