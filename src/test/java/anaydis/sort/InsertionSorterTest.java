package anaydis.sort;

import anaydis.sort.provider.*;
import anaydis.sort.provider.SorterProvider;
import org.junit.Test;

/**
 * Created by isabel on 8/20/16.
 */
public class InsertionSorterTest extends SorterTest {

    @Test
    public void testAscendingInt10(){
        testAscendingOrder(10, SorterType.INSERTION);
    }

    @Test public void testDesdendingInt10(){
        testDescendingOrder(10, SorterType.INSERTION);
    }

    @Test public void testRandomInt10(){
        testRandomOrder(10, SorterType.INSERTION);
    }
    @Test
    public void testAscendingInt50(){
        testAscendingOrder(50, SorterType.INSERTION);
    }

    @Test public void testDesdendingInt50(){
        testDescendingOrder(50, SorterType.INSERTION);
    }

    @Test public void testRandomInt50(){
        testRandomOrder(50, SorterType.INSERTION);

    }    @Test
    public void testAscendingInt500(){
        testAscendingOrder(500, SorterType.INSERTION);
    }

    @Test public void testDesdendingInt500(){
        testDescendingOrder(500, SorterType.INSERTION);
    }

    @Test public void testRandomInt500(){
        testRandomOrder(500, SorterType.INSERTION);

    }    @Test
    public void testAscendingInt1000(){
        testAscendingOrder(1000, SorterType.INSERTION);
    }

    @Test public void testDesdendingInt1000(){
        testDescendingOrder(1000, SorterType.INSERTION);
    }

    @Test public void testRandomInt1000(){
        testRandomOrder(1000, SorterType.INSERTION);

    }
    @Test
    public void testAscendingInt5000(){
        testAscendingOrder(5000, SorterType.INSERTION);
    }

    @Test public void testDesdendingInt5000(){
        testDescendingOrder(5000, SorterType.INSERTION);
    }

    @Test public void testRandomInt5000(){
        testRandomOrder(5000, SorterType.INSERTION);

    }
}

