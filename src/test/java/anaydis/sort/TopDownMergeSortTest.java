package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by isabel on 9/4/16.
 */
public class TopDownMergeSortTest extends SorterTest {
    @Test
    public void testTopDownMergeSorterInteger100(){
        testSorter(new IntegerDataSetGenerator(), SorterType.MERGE, 100);
    }
    @Test
    public void testBottomUpMergeSorterInteger500() {
        testSorter(new IntegerDataSetGenerator(), SorterType.MERGE, 500);
    }

    @Test
    public void testBottomUpMergeSorterInteger1000() {
        testSorter(new IntegerDataSetGenerator(), SorterType.MERGE, 1000);
    }

    @Test
    public void testBottomUpMergeSorterInteger25000() {
        testSorter(new IntegerDataSetGenerator(), SorterType.MERGE, 2500);
    }

    @Test
    public void testBottomUpMergeSorterInteger5000() {
        testSorter(new IntegerDataSetGenerator(), SorterType.MERGE, 5000);
    }

}