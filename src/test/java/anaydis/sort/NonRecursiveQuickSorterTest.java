package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import org.junit.Test;

/**
 * Created by isabel on 9/2/16.
 */
public class NonRecursiveQuickSorterTest extends SorterTest {
    @Test
    public void testIntegerSort12500(){
        testSorter(new IntegerDataSetGenerator(),SorterType.QUICK_NON_RECURSIVE, 12500);
    }
    @Test
    public void testIntegerSort25000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 25000);
    }
    @Test
    public void testIntegerSort50000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 50000);
    }
    @Test
    public void testIntegerSort100000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 100000);
    }

}
