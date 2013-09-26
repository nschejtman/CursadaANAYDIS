package anaydis.sort;

import anaydis.sort.data.DataSetGenerator;
import anaydis.sort.data.StringDataSetGenerator;
import anaydis.sort.provider.SorterProvider;
import anaydis.sort.test.AbstractTestPracticaDos;
import anaydis.sort.tester.IntegerDataGenerator;

public class TestPracticaDos extends AbstractTestPracticaDos {

    @Override protected DataSetGenerator<String> getStringDataSetGenerator() {
        return new StringDataSetGenerator();
    }

    @Override protected DataSetGenerator<Integer> getIntegerDataSetGenerator() {
        return new IntegerDataGenerator();
    }

    @Override protected SorterProvider getSorterProvider() {
        return new SorterProviderImpl();
    }
}
