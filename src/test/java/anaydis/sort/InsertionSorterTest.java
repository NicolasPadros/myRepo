package anaydis.sort;

import anaydis.sort.provider.*;
import anaydis.sort.provider.SorterProvider;
import org.junit.Test;

/**
 * Created by isabel on 8/20/16.
 */
public class InsertionSorterTest extends SorterTest {
    protected anaydis.sort.provider.SorterProvider getSorterProvider() {
        return new anaydis.sort.SorterProvider();
    }
    public void testAscendingInt10(){
        testAscendingOrder(10, SorterType.INSERTION);
    }

    @Test
    public void testDesdendingInt10(){
        testDescendingOrder(10, SorterType.INSERTION);
    }

    @Test public void testRandomInt10(){
        testRandomOrder(10, SorterType.INSERTION);
    }
}
