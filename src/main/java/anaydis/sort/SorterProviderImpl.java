package anaydis.sort;

import anaydis.sort.provider.SorterProvider;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;

public class SorterProviderImpl implements SorterProvider {

    private final Map<SorterType, Sorter> sorters;

    public SorterProviderImpl() {
        sorters = new EnumMap<SorterType, Sorter>(SorterType.class);
        addSorter(new InsertionSorter());
        addSorter(new BubbleSorter());
        addSorter(new SelectionSorter());
        addSorter(new QuickSorter());
        addSorter(new HSorter());
        addSorter(new ShellSorter());
        addSorter(new CutoffQuickSorter(new InsertionSorter()));
        addSorter(new NRQuickSorter());
        addSorter(new MedianOfThreeQuickSorter(7, new InsertionSorter()));
        addSorter(new ThreeWayPartitionQuickSorter(7, new InsertionSorter()));



    }

    private void addSorter(Sorter sorter) {
        sorters.put(sorter.getType(), sorter);
    }

    @NotNull
    @Override
    public Sorter getSorterForType(@NotNull SorterType type) {
        final Sorter sorter = sorters.get(type);
        if (sorter == null) {
            throw new IllegalArgumentException("Sorter for type " + type + " is not yet implemented");
        }
        return sorter;
    }

    @NotNull
    @Override
    public Iterable<Sorter> getAllSorters() {
        return sorters.values();
    }
}
