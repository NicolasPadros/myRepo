package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import anaydis.sort.exercise3.FullName;
import anaydis.sort.exercise3.FullNameSortTest;
import anaydis.sort.provider.SorterProvider;
import anaydis.sort.provider.SorterProviderImpl;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by isabel on 8/27/16.
 */
public class ShellSorterTest extends SorterTest {
    @Test
    public void testIntegerSort10(){
        testSorter(new IntegerDataSetGenerator(), SorterType.SHELL, 10);
    }
    @Test
    public void testIntegerSort1000(){
        testSorter(new IntegerDataSetGenerator(), SorterType.SHELL, 1000);
    }
    @Test
    public void testStringSort100(){
        testSorter(new StringDataSetGenerator(), SorterType.SHELL, 100);
    }

    @Test
    public void testRandomSequences100(){
            final SorterProvider provider = new SorterProviderImpl();
            final IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
            final List<Integer> original = generator.createRandom(100);
            int[] sequence1 = {1, 8, 23, 77, 281, 1073, 4193, 16577};
            int[] sequence2 = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841};
            final ShellSorter shellSorter = (ShellSorter)provider.getSorterForType(SorterType.SHELL);
            shellSorter.sort(Comparator.<Integer>naturalOrder(), original, sequence1);
            shellSorter.sort(Comparator.<Integer>naturalOrder(), original, sequence2);
        }

    @Test
    public void testStable() {

        List<FullName> original = Arrays.asList(new FullName("Paula", "Alonso"), new FullName("Diego", "Diaz"),
                new FullName("Diego", "Alonso"), new FullName("Paula", "Abed"));

        final List<FullName> copy = new ArrayList<>(original);
        final SorterProvider provider = new SorterProviderImpl();
        final Sorter shellSorter = provider.getSorterForType(SorterType.SHELL);
        shellSorter.sort(new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getFirstname().compareTo(name2.getFirstname());
            }
        }, copy);

        for (FullName name : copy) {
            System.out.println(name.getFirstname() + " " + name.getLastname());
        }

    }

    @Test
    public void testRandomSequences1000(){
        final SorterProvider provider = new SorterProviderImpl();
        final IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        final List<Integer> original = generator.createRandom(1000);
        int[] sequence1 = {1, 8, 23, 77, 281, 1073, 4193, 16577};
        int[] sequence2 = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841};
        final ShellSorter shellSorter = (ShellSorter)provider.getSorterForType(SorterType.SHELL);
        shellSorter.sort(Comparator.<Integer>naturalOrder(), original, sequence1);
        shellSorter.sort(Comparator.<Integer>naturalOrder(), original, sequence2);
    }
    @Test
    public void testRandomSequences10000(){
        final SorterProvider provider = new SorterProviderImpl();
        final IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        final List<Integer> original = generator.createRandom(10000);
        int[] sequence1 = {1, 8, 23, 77, 281, 1073, 4193, 16577};
        int[] sequence2 = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841};
        final ShellSorter shellSorter = (ShellSorter)provider.getSorterForType(SorterType.SHELL);
        shellSorter.sort(Comparator.<Integer>naturalOrder(), original, sequence1);
        shellSorter.sort(Comparator.<Integer>naturalOrder(), original, sequence2);
    }
    }

