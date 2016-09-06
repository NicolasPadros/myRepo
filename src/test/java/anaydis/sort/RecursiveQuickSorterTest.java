package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import anaydis.sort.exercise3.FullName;
import anaydis.sort.provider.SorterProvider;
import anaydis.sort.provider.SorterProviderImpl;
import org.junit.Test;

import java.util.*;

/**
 * Created by isabel on 8/27/16.
 */
public class RecursiveQuickSorterTest extends SorterTest {
    @Test
    public void testIntegerSort12500(){
        testSorter(new IntegerDataSetGenerator(),SorterType.QUICK, 12500);
    }
    @Test
    public void testIntegerSort25000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK, 25000);
    }
    @Test
    public void testIntegerSort50000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK, 50000);
    }
    @Test
    public void testIntegerSort100000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.QUICK, 100000);
    }


    @Test
    public void testStable() {

        List<FullName> original = Arrays.asList(new FullName("Paula", "Alonso"), new FullName("Diego", "Diaz"),
                new FullName("Diego", "Alonso"), new FullName("Paula", "Abed"));

        final List<FullName> copy = new ArrayList<>(original);
        final SorterProvider provider = new SorterProviderImpl();
        final Sorter quickSorter = provider.getSorterForType(SorterType.QUICK);
        quickSorter.sort(new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getFirstname().compareTo(name2.getFirstname());
            }
        }, copy);

        for (FullName name : copy) {
            System.out.println(name.getFirstname() + " " + name.getLastname());
        }

    }

}
