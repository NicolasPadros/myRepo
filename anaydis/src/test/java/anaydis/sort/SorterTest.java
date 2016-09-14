package anaydis.sort;

import anaydis.sort.data.DataSetGenerator;
import anaydis.sort.provider.SorterProvider;
import anaydis.sort.provider.SorterProviderImpl;
import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Sorter tests should subclass this abstract implementation
 */
abstract class SorterTest extends AbstractSorterTest {

    protected SorterProviderImpl getSorterProvider() {
        return new SorterProviderImpl();
    }


    @Override protected StringDataSetGenerator createStringDataSetGenerator() {
        return new StringDataSetGenerator();
    }

    @Override protected IntegerDataSetGenerator createIntegerDataSetGenerator() {
        return new IntegerDataSetGenerator();
    }


}
