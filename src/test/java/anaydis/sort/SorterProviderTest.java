package anaydis.sort;

import anaydis.sort.provider.SorterProvider;
import org.junit.Test;

import java.util.List;

/**
 * Sorter provider test
 */
public class SorterProviderTest extends AbstractSorterProviderTest {

    @Override protected SorterProvider createSorterProvider() {
        return new anaydis.sort.SorterProvider();
    }


}
