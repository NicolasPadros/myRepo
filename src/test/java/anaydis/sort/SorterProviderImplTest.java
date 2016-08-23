package anaydis.sort;

import anaydis.sort.provider.SorterProviderImpl;

/**
 * Sorter provider test
 */
public class SorterProviderImplTest extends AbstractSorterProviderTest {

    @Override protected SorterProviderImpl createSorterProvider() {
        return new SorterProviderImpl();
    }


}
