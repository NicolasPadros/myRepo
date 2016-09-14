package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import org.junit.Test;

/**
 * Created by FliaPadros on 6/9/2016.
 */
public class BottomUpMergeSorterTest extends SorterTest {
    @Test
    public void testBottomUpMergeSorterInteger100() {
        testSorter(new IntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 100);
    }

    @Test
    public void testBottomUpMergeSorterInteger500() {
        testSorter(new IntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 500);
    }

    @Test
    public void testBottomUpMergeSorterInteger1000() {
        testSorter(new IntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 1000);
    }

    @Test
    public void testBottomUpMergeSorterInteger25000() {
        testSorter(new IntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 2500);
    }

    @Test
    public void testBottomUpMergeSorterInteger5000() {
        testSorter(new IntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 5000);
    }
}

