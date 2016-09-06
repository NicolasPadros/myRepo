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

}