package anaydis.sort;

import anaydis.sort.data.DataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;

/**
 * Data set generator test
 */
public class DataSetGeneratorTest extends AbstractDataSetGeneratorTest {

    @Override protected StringDataSetGenerator createStringDataSetGenerator() {
        return new StringDataSetGenerator();
    }

    @Override protected DataSetGenerator<Integer> createIntegerDataSetGenerator() {
        throw new IllegalStateException("To be implemented!");
    }
}
