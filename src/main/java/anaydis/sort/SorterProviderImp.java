package anaydis.sort;

import anaydis.sort.provider.SorterProvider;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 19/09/13
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class SorterProviderImp implements SorterProvider {

    @NotNull
    @Override
    public Sorter getSorterForType(@NotNull SorterType type) {
        return null;
    }

    @NotNull
    @Override
    public Iterable<Sorter> getAllSorters() {
        return null;
    }
}
