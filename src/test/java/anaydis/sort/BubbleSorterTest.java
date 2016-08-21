package anaydis.sort;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by isabel on 8/20/16.
 */
public class BubbleSorterTest extends SorterTest {
    /*
    protected anaydis.sort.provider.SorterProvider getSorterProvider() {
        return new anaydis.sort.SorterProvider();
    }
    */
    @Test
    public void getTypeTest(){
        Sorter sorter = new BubbleSorter();
        assertThat(sorter.getType().compareTo(SorterType.BUBBLE));
    }

    public void testAscendingInt10(){
        testAscendingOrder(10, SorterType.BUBBLE);
    }

    @Test
    public void testDesdendingInt10(){
        testDescendingOrder(10, SorterType.BUBBLE);
    }

    @Test public void testRandomInt10() {
        testRandomOrder(10, SorterType.BUBBLE);
    }



    @Test
    public void testAscendingInt50(){
        testAscendingOrder(50, SorterType.BUBBLE);
    }

    @Test public void testDesdendingInt50(){
        testDescendingOrder(50, SorterType.BUBBLE);
    }

    @Test public void testRandomInt50(){
        testRandomOrder(50, SorterType.BUBBLE);

    }    @Test
    public void testAscendingInt500(){
        testAscendingOrder(500, SorterType.BUBBLE);
    }

    @Test public void testDesdendingInt500(){
        testDescendingOrder(500, SorterType.BUBBLE);
    }

    @Test public void testRandomInt500(){
        testRandomOrder(500, SorterType.BUBBLE);

    }    @Test
    public void testAscendingInt1000(){
        testAscendingOrder(1000, SorterType.BUBBLE);
    }

    @Test public void testDesdendingInt1000(){
        testDescendingOrder(1000, SorterType.BUBBLE);
    }

    @Test public void testRandomInt1000(){
        testRandomOrder(1000, SorterType.BUBBLE);

    }
    @Test
    public void testAscendingInt5000(){
        testAscendingOrder(5000, SorterType.BUBBLE);
    }

    @Test public void testDesdendingInt5000(){
        testDescendingOrder(5000, SorterType.BUBBLE);
    }

    @Test public void testRandomInt5000(){
        testRandomOrder(5000, SorterType.BUBBLE);
    }
}
