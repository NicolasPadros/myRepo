package anaydis.sort;

import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.provider.*;
import anaydis.sort.provider.SorterProvider;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by isabel on 8/20/16.
 */
public class SelectionSorterTest extends SorterTest {

    @Override
    protected SorterProvider getSorterProvider() {
        return new anaydis.sort.SorterProvider();
    }

    @Test
    public void testAscendingInt10(){
        testAscendingOrder(10, SorterType.SELECTION);
    }

    @Test public void testDesdendingInt10(){
            testDescendingOrder(10, SorterType.SELECTION);
    }

    @Test public void testRandomInt10(){
            testRandomOrder(10, SorterType.SELECTION);

    }

    }

