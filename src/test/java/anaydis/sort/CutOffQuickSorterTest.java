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



}
