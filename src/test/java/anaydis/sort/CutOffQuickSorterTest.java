package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import anaydis.sort.provider.SorterProvider;
import anaydis.sort.provider.SorterProviderImpl;
import org.junit.Test;

import java.util.*;

import static anaydis.sort.CutOffQuickSorter.setM;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by isabel on 9/2/16.
 */
public class CutOffQuickSorterTest extends SorterTest {
    @Test
    public void testIntegerSort10() {
        setM(8);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_CUT, 10);
    }


    @Test
    public void testBestM() {
        CutOffQuickSorter quick = new CutOffQuickSorter();
        IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        for (int j = 0; j < 10; j++) {
            long recordTime = 1000000000;
            int index = 0;
            for (int i = 5; i <= 25; i++) {
                List<Integer> list = generator.createRandom(100000);
                setM(i);
                long time = System.nanoTime();
                quick.sort(Comparator.naturalOrder(), list);
                time = (System.nanoTime() - time);
                //System.out.println("N=" + 1000 + " M= " + i + " " + time + " ms");
                if (time < recordTime) {
                    recordTime = time;
                    index = i;
                }
            }
            System.out.println("For N: " + 100000 + ", best M= " + index + " with " + recordTime + " ms");

        }
    }
    @Test
    public void testIntegerSort12500(){
        setM(25);
        testSorter(new IntegerDataSetGenerator(),SorterType.QUICK_CUT, 12500);
    }
    @Test
    public void testIntegerSort25000(){
        setM(25);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_CUT, 25000);
    }
    @Test
    public void testIntegerSort50000(){
        setM(25);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_CUT, 50000);
    }
    @Test
    public void testIntegerSort100000(){
        setM(25);
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK_CUT, 100000);
    }

}
