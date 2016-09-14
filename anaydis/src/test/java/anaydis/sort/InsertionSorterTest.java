package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import org.junit.Test;

/**
 * Created by isabel on 8/20/16.
 */
public class InsertionSorterTest extends SorterTest {
  /*
    @Test public void testIntegerSorter10(){
        testSorter(new IntegerDataSetGenerator(), SorterType.INSERTION, 10);
    }
    @Test public void testIntegerSorter50(){
        testSorter(new IntegerDataSetGenerator(), SorterType.INSERTION, 50);
    }
*/
    @Test public void testIntegerSorter500(){
        testSorter(new IntegerDataSetGenerator(), SorterType.INSERTION, 500);
    }
    @Test public void testIntegerSorter1000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.INSERTION, 1000);
    }
    /*
    @Test public void testIntegerSorter5000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.INSERTION, 5000);
    }
*/
    @Test public void testStringSorter10(){
        testSorter(new StringDataSetGenerator(), SorterType.INSERTION, 10);
    }

    @Test public void testStringSorter50(){
        testSorter(new StringDataSetGenerator(), SorterType.INSERTION, 50);
    }



}

