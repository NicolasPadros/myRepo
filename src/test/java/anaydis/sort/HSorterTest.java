package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import anaydis.sort.provider.SorterProvider;
import anaydis.sort.provider.SorterProviderImpl;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by isabel on 8/27/16.
 */
public class HSorterTest extends SorterTest {

    @Test
    public void testIntegerSort(){
            final SorterProvider provider = new SorterProviderImpl();
            final List<Integer> original = Arrays.asList(3, 2, 4, 5, 1, 11, 9, 17, 23, 0, -2, -1);

            // Sort copy with selection sorter
            final Sorter hSorter = provider.getSorterForType(SorterType.H);
            hSorter.sort(Comparator.<Integer>naturalOrder(), original);

            // Assert correctly sorted
            assertThat(original.get(original.size()-1).equals(3) && original.get(0).equals(-1));
            }
    }


