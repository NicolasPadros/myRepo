package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import org.junit.Test;

/**
 * Created by isabel on 9/2/16.
 */
public class NonRecursiveQuickSorterTest extends SorterTest {
    @Test
    public void testIntegerSort10(){
        testSorter(new IntegerDataSetGenerator(),SorterType.QUICK_NON_RECURSIVE, 10);
    }
    @Test
    public void testIntegerSort1000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 1000);
    }
    @Test
    public void testStringSort100(){
        testSorter(new StringDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 100);
    }

}
