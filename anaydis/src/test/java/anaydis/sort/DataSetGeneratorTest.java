package anaydis.sort;

import anaydis.sort.data.DataSetGenerator;
import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import org.junit.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * data set generator test
 */
public class DataSetGeneratorTest extends AbstractDataSetGeneratorTest {

    @Override protected StringDataSetGenerator createStringDataSetGenerator() {
        return new StringDataSetGenerator();
    }

    @Override protected IntegerDataSetGenerator createIntegerDataSetGenerator() {
        return new IntegerDataSetGenerator();
    }

    @Test public void IntegerDataSetGeneratorGetComparator(){
        final IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        assertThat(generator.getComparator().equals(Comparator.naturalOrder()));
    }
}
