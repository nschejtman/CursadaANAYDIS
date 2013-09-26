package anaydis.sort;

import anaydis.sort.provider.SorterProvider;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 19/09/13
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class SorterProviderImpl implements SorterProvider {

    private final Map<SorterType, Sorter> sorters;

    public SorterProviderImpl() {
        sorters = new EnumMap<SorterType, Sorter>(SorterType.class);
        addSorter(new InsertionSorter());
        addSorter(new BubbleSorter());
        addSorter(new SelectionSorter());
        addSorter(new QuickSorter());

            }

    private void addSorter(Sorter sorter) {
        sorters.put(sorter.getType(), sorter);
    }

    @NotNull
    @Override
    public Sorter getSorterForType(@NotNull SorterType type) {
        final Sorter sorter = sorters.get(type);
        if(sorter==null){
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
