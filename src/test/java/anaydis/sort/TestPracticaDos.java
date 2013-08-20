package anaydis.sort;

import anaydis.sort.data.DataSetGenerator;
import anaydis.sort.provider.SorterProvider;
import anaydis.sort.test.AbstractTestPracticaDos;

public class TestPracticaDos extends AbstractTestPracticaDos {

    @Override protected DataSetGenerator<String> getStringDataSetGenerator() {
        throw new IllegalStateException("To be implemented!");
    }

    @Override protected DataSetGenerator<Integer> getIntegerDataSetGenerator() {
        throw new IllegalStateException("To be implemented!");
    }

    @Override protected SorterProvider getSorterProvider() {
        throw new IllegalStateException("To be implemented!");
    }
}
