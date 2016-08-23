package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by isabel on 8/20/16.
 */
public class BubbleSorterTest extends SorterTest {
    /*
    protected anaydis.sort.provider.SorterProviderImpl getSorterProvider() {
        return new anaydis.sort.provider.SorterProviderImpl();
    }
    */

    @Test
    public void getTypeTest(){
        Sorter sorter = new BubbleSorter();
        assertThat(sorter.getType().compareTo(SorterType.BUBBLE));
    }

    @Test public void testIntegerSorter10(){
        testSorter(new IntegerDataSetGenerator(), SorterType.BUBBLE, 10);
    }
    @Test public void testIntegerSorter50(){
        testSorter(new IntegerDataSetGenerator(), SorterType.BUBBLE, 50);
    }


    @Test public void testIntegerSorter500(){
        testSorter(new IntegerDataSetGenerator(), SorterType.BUBBLE, 500);
    }
    @Test public void testIntegerSorter1000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.BUBBLE, 1000);
    }
    @Test public void testIntegerSorter5000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.BUBBLE, 5000);
    }

    @Test public void testStringSorter10(){
        testSorter(new StringDataSetGenerator(), SorterType.BUBBLE, 10);
    }

    @Test public void testStringSorter50(){
        testSorter(new StringDataSetGenerator(), SorterType.BUBBLE, 50);
    }

    @Test public void testStringSorter100(){
        testSorter(new StringDataSetGenerator(), SorterType.BUBBLE, 100);
    }



}
